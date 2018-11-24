package com.example.ilidosha.dnd.pages;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

import com.example.ilidosha.dnd.R;
import com.example.ilidosha.dnd.Utils.RandomUtils;
import com.example.ilidosha.dnd.enities.Specialization;
import com.example.ilidosha.dnd.services.LevelUpService;
import com.example.ilidosha.dnd.services.ValidatorServiceCharacter;
import com.example.ilidosha.dnd.services.ValidatorServicePaladin;

import java.util.zip.Inflater;

public class LayoutPage extends FragmentActivity {
    public static com.example.ilidosha.dnd.enities.Character character = new com.example.ilidosha.dnd.enities.Character();
    public static LevelUpService levelUpService = new LevelUpService();
    public static ValidatorServiceCharacter validatorServiceCharacter = new ValidatorServicePaladin();//TODO: нужный валидатор сервис присваивать после проверки рассы

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(RandomUtils.getNextTheme());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abstract_layout);
        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, R.string.app_exit, Toast.LENGTH_LONG).show();
    }

    protected BottomNavigationView navigation;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_dices:
                    fragment = new Dices();
                    break;
                case R.id.navigation_inventory:
                    fragment = new Inventory();
                    break;
                case R.id.navigation_skills:
                    fragment = new Skills();
                    break;
                case R.id.navigation_spells:
                    fragment = new Spells();
                    break;
                case R.id.navigation_character:
                    fragment = new Character();
                    break;
            }
            if (fragment == null)
                return false;
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.content_frame, fragment);
            transaction.commit();
            return true;
        }
    };

    public void onButtonItemAddClickCall(View v) {
        LayoutInflater li = LayoutInflater.from(this);
        View promptsView = li.inflate(R.layout.alert_dialog_item_add, null);
        AlertDialog.Builder mDialogBuilder = new AlertDialog.Builder(this);
        mDialogBuilder.setView(promptsView);
        final EditText editTextItemAdd = promptsView.findViewById(R.id.editTextItemAdd);
        mDialogBuilder
                .setCancelable(true)
                .setPositiveButton("Добавить",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //Вводим текст и отображаем в строке ввода на основном экране:
                                editTextItemAdd.setText(editTextItemAdd.getText());
                            }
                        })
                .setNegativeButton("Отмена",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        //Создаем AlertDialog:
        AlertDialog alertDialog = mDialogBuilder.create();

        //и отображаем его:
        alertDialog.show();

    }

    public void onExpBoostButton(final View view) {
        LayoutInflater li = LayoutInflater.from(this);
        View dialog_window = li.inflate(R.layout.dialog_boost_exp, null);
        final EditText userInput = (EditText) dialog_window.findViewById(R.id.input_boost_lvl);
        final Button button = (Button) view;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false)
                .setView(dialog_window)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //Вводим текст и отображаем в строке ввода на основном экране:
                                levelUpService.boostExp(userInput);
                                button.setText(String.valueOf(character.getExperience()));
                                TextView textViewLVL = findViewById(R.id.textViewLVL);
                                textViewLVL.setText("Уровень: "+String.valueOf(character.getLevel()));
                            }
                        })
                .setNegativeButton("Отмена",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void onCreateCharacterButton(final View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true)
                .setTitle("Вы уверены, что всё правильно заполнено?")
                .setPositiveButton("Создать",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                com.example.ilidosha.dnd.enities.Character testCharacter =
                                        new com.example.ilidosha.dnd.enities.Character();
                                if (!validatorServiceCharacter.validationCreateCharacter(testCharacter)) {
                                    Toast.makeText(LayoutPage.this, R.string.validation_failed, Toast.LENGTH_LONG)
                                            .show();
                                }
                                navigation.setSelectedItemId(R.id.navigation_character);
                            }
                        })
                .setNegativeButton("Отмена",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void onChangeSpecializationButton(final View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Выбор класса");

        final String [] specializations = new String[Specialization.values().length];

        for (int i=0;i<Specialization.values().length;++i){
            specializations[i]=Specialization.values()[i].getName();
        }

        builder.setItems(specializations, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                ((Button)findViewById(R.id.buttonSpecialization)).setText(specializations[item]);
                Toast.makeText(getApplicationContext(),
                        "Выбранный класс: " + specializations[item],
                        Toast.LENGTH_SHORT).show();
            }
        });
        builder.setCancelable(false);
        builder.create().show();
    }

    public void onChangeTextColorButton(final View view){
        recreate();
    }


}

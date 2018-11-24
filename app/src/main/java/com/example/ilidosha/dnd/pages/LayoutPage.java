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
import android.widget.Button;
import android.widget.EditText;
import com.example.ilidosha.dnd.R;
import com.example.ilidosha.dnd.services.LevelUpService;


public class LayoutPage extends FragmentActivity {
    public static com.example.ilidosha.dnd.enities.Character character = new com.example.ilidosha.dnd.enities.Character();
    public static LevelUpService levelUpService = new LevelUpService();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abstract_layout);
        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
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
}

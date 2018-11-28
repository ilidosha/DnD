package com.example.ilidosha.dnd.pages;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
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
import com.example.ilidosha.dnd.database.DatabaseHelper;
import com.example.ilidosha.dnd.enities.*;
import com.example.ilidosha.dnd.services.LevelUpService;
import com.example.ilidosha.dnd.services.ValidatorServiceCharacter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LayoutPage extends FragmentActivity {
    public BottomNavigationView navigation;
    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;
    public static com.example.ilidosha.dnd.enities.Character character;
    public static LevelUpService levelUpService = new LevelUpService();
    public static ValidatorServiceCharacter validatorServiceCharacter = new ValidatorServiceCharacter();//TODO: нужный валидатор сервис присваивать после проверки рассы
    public static List<Spell> spells = new ArrayList<>();
    public static Spell currentSpell;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(RandomUtils.getNextTheme());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abstract_layout);
        trySetImage();
        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        mDBHelper = new DatabaseHelper(this);
        try {
            mDBHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }
        mDb = mDBHelper.getWritableDatabase();
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, R.string.app_exit, Toast.LENGTH_LONG).show();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            if (character == null) {
                onOpenCreateCharacterButton(null);
            } else {
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
                        fragment = new MySpells();
                        break;
                    case R.id.navigation_character:
                        fragment = new Character();
                        break;
                }
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

    private void trySetImage(){
        try {
            ((ImageView)(findViewById(R.id.imageView)))
                    .setImageBitmap(MediaStore.Images.Media.getBitmap(getContentResolver(), character.getPhoto()));
        } catch (Exception ignored) {
        }
    }

    public void onButtonItemAddClickCall(View v) {
        LayoutInflater li = LayoutInflater.from(this);
        View promptsView = li.inflate(R.layout.alert_dialog_item_add, null);
        AlertDialog.Builder mDialogBuilder = new AlertDialog.Builder(this);
        mDialogBuilder.setView(promptsView);
        final EditText editTextItemName = promptsView.findViewById(R.id.editTextItemName);
        mDialogBuilder
                .setCancelable(true)
                .setPositiveButton("Добавить",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //Вводим текст и отображаем в строке ввода на основном экране:
                                editTextItemName.setText(editTextItemName.getText());


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

    public void onChangeCurentHPButton(final View view) {
        LayoutInflater li = LayoutInflater.from(this);
        View dialog_window = li.inflate(R.layout.dialog_change_hp, null);
        final EditText userInput = (EditText) dialog_window.findViewById(R.id.dialog_change_hp);
        final Button button = (Button) view;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true)
                .setView(dialog_window)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                character.getHealth().setCurrentHP(character.getHealth().getCurrentHP() + Integer.parseInt(userInput.getText().toString()));
                                if (character.getHealth().getCurrentHP()>character.getHealth().getMaxHP()){
                                    character.getHealth().setCurrentHP(character.getHealth().getMaxHP());
                                }
                                button.setText(String.valueOf(character.getHealth().getCurrentHP()));
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

    public void onChangeMaxHPButton(final View view) {
        LayoutInflater li = LayoutInflater.from(this);
        View dialog_window = li.inflate(R.layout.dialog_change_hp, null);
        final EditText userInput = (EditText) dialog_window.findViewById(R.id.dialog_change_hp);
        final Button button = (Button) view;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true)
                .setView(dialog_window)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                character.getHealth().setMaxHP(character.getHealth().getMaxHP() + Integer.parseInt(userInput.getText().toString()));
                                button.setText(String.valueOf(character.getHealth().getMaxHP()));
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

    public void onChangeTemporaryHPButton(final View view) {
        LayoutInflater li = LayoutInflater.from(this);
        View dialog_window = li.inflate(R.layout.dialog_change_hp, null);
        final EditText userInput = (EditText) dialog_window.findViewById(R.id.dialog_change_hp);
        final Button button = (Button) view;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true)
                .setView(dialog_window)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                character.getHealth().setTemporaryHP(character.getHealth().getTemporaryHP() + Integer.parseInt(userInput.getText().toString()));
                                button.setText(String.valueOf(character.getHealth().getTemporaryHP()));
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

    public void onExpBoostButton(View view) {
        LayoutInflater li = LayoutInflater.from(this);
        View dialog_window = li.inflate(R.layout.dialog_boost_exp, null);
        final EditText userInput = (EditText) dialog_window.findViewById(R.id.input_boost_lvl);
        final Button button = (Button) view;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true)
                .setView(dialog_window)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //Вводим текст и отображаем в строке ввода на основном экране:
                                levelUpService.boostExp(userInput);
                                button.setText(String.valueOf(character.getExperience()));
                                TextView textViewLVL = findViewById(R.id.textViewLVL);
                                textViewLVL.setText("Уровень: " + String.valueOf(character.getLevel()));
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
                                    return;
                                }
                                character = new com.example.ilidosha.dnd.enities.Character();
                                fillCharacterInfoFromView(character);
                                character.getRace().applyClassBonusOnCharacter(character);
                                setAllSkills(spells);
                                navigation.setVisibility(View.VISIBLE);
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

    public void onChangeSpecializationButton(final View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Выбор класса");
        final String[] specializations = new String[Specialization.values().length];
        for (int i = 0; i < Specialization.values().length; ++i) {
            specializations[i] = Specialization.values()[i].getName();
        }
        builder.setItems(specializations, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                ((Button) findViewById(R.id.buttonSpecialization)).setText(specializations[item]);
                Toast.makeText(getApplicationContext(),
                        "Выбранный класс: " + specializations[item],
                        Toast.LENGTH_SHORT).show();
                Button buttonChooseArchetype = findViewById(R.id.buttonChooseArchetype);
                reRenderBonusPerformance(Specialization.getSpecializationFromString(specializations[item]));
                buttonChooseArchetype.setText("Выберите архетип");
                buttonChooseArchetype.setVisibility(View.VISIBLE);
            }
        });
        builder.setCancelable(true);
        builder.create().show();
    }

    public void onChangeArchetypeButton(final View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Выбор архетипа");
        String specialization = ((Button) findViewById(R.id.buttonSpecialization)).getText().toString();
        Archetype[] enumArchetypes = Specialization.getSpecializationFromString(specialization).getArchetypes();
        final String[] archetypes = new String[enumArchetypes.length];
        for (int i = 0; i < enumArchetypes.length; ++i) {
            archetypes[i] = enumArchetypes[i].getName();
        }
        builder.setItems(archetypes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                ((Button) findViewById(R.id.buttonChooseArchetype)).setText(archetypes[item]);
                Toast.makeText(getApplicationContext(),
                        "Выбранный класс: " + archetypes[item],
                        Toast.LENGTH_SHORT).show();
            }
        });
        builder.setCancelable(true);
        builder.create().show();
    }

    public void onChangeRaceButton(final View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Выбор расы");

        final String[] races = new String[Race.values().length];
        for (int i = 0; i < Race.values().length; ++i) {
            races[i] = Race.values()[i].getName();
        }
        builder.setItems(races, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                ((Button) findViewById(R.id.buttonChooseRace)).setText(races[item]);
                Toast.makeText(getApplicationContext(),
                        "Выбранная расса: " + races[item],
                        Toast.LENGTH_SHORT).show();
            }
        });
        builder.setCancelable(true);
        builder.create().show();
    }

    public void onOpenCreateCharacterButton(final View view) {
        Fragment fragment = new CreateCharacter();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content_frame, fragment);
        navigation.setVisibility(View.GONE);
        transaction.commit();
    }

    public void onChangeTextColorButton(final View view) {
        recreate();
    }

    private void reRenderBonusPerformance(Specialization specialization) {
        List<CheckBox> checkBoxList = new ArrayList<>();
        checkBoxList.add((CheckBox) findViewById(R.id.checkBoxAthletics));
        checkBoxList.add((CheckBox) findViewById(R.id.checkBoxAcrobatics));
        checkBoxList.add((CheckBox) findViewById(R.id.checkBoxSleightOfHand));
        checkBoxList.add((CheckBox) findViewById(R.id.checkBoxStealth));
        checkBoxList.add((CheckBox) findViewById(R.id.checkBoxArcana));
        checkBoxList.add((CheckBox) findViewById(R.id.checkBoxHistory));
        checkBoxList.add((CheckBox) findViewById(R.id.checkBoxInvestigation));
        checkBoxList.add((CheckBox) findViewById(R.id.checkBoxNature));
        checkBoxList.add((CheckBox) findViewById(R.id.checkBoxReligion));
        checkBoxList.add((CheckBox) findViewById(R.id.checkBoxAnimalHandling));
        checkBoxList.add((CheckBox) findViewById(R.id.checkBoxInsight));
        checkBoxList.add((CheckBox) findViewById(R.id.checkBoxMedicine));
        checkBoxList.add((CheckBox) findViewById(R.id.checkBoxPerception));
        checkBoxList.add((CheckBox) findViewById(R.id.checkBoxSurvival));
        checkBoxList.add((CheckBox) findViewById(R.id.checkBoxDeception));
        checkBoxList.add((CheckBox) findViewById(R.id.checkBoxIntimidation));
        checkBoxList.add((CheckBox) findViewById(R.id.checkBoxPerformance));
        checkBoxList.add((CheckBox) findViewById(R.id.checkBoxPersuasion));

        TextView textView = findViewById(R.id.textViewChooseNumber);

        for (CheckBox checkBox : checkBoxList) {
            if (Arrays.asList(specialization.getPossiblePerfomance()).contains(Performance.getPerformanceFromString(checkBox.getText().toString()))) {
                checkBox.setVisibility(View.VISIBLE);
                textView.setVisibility(View.VISIBLE);
                textView.setText("Выберите навыков: " + specialization.getSkillsNumber());
            } else {
                checkBox.setVisibility(View.GONE);
                checkBox.setChecked(false);
            }
        }
    }

    private static final int GALLERY_REQUEST = 1;

    public void onUploadImageButton(final View view) {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, GALLERY_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        Bitmap bitmap = null;
        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        switch(requestCode) {
            case GALLERY_REQUEST:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    try {
                        bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImage);
                        character.setPhoto(selectedImage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    imageView.setImageBitmap(bitmap);
                }
        }
    }

    private void fillCharacterInfoFromView(com.example.ilidosha.dnd.enities.Character character) {

        EditText name = findViewById(R.id.editTextName);

        Button race = findViewById(R.id.buttonChooseRace);
        Button archetype = findViewById(R.id.buttonChooseArchetype);
        Button specialization = findViewById(R.id.buttonSpecialization);

        EditText intelligence = findViewById(R.id.editTextIntelligence);
        EditText agility = findViewById(R.id.editTextAgility);
        EditText strength = findViewById(R.id.editTextStrength);
        EditText charisma = findViewById(R.id.editTextCharisma);
        EditText body = findViewById(R.id.editTextBody);
        EditText wisdom = findViewById(R.id.editTextWisdom);

        EditText armoryClass = findViewById(R.id.editTextArmoryClass);

        character.setName(name.getText().toString());

        character.setRace(Race.getRaceFromString(race.getText().toString()));
        character.setArchetype(Archetype.getArchetypeFromString(archetype.getText().toString()));
        character.setSpecialization(Specialization.getSpecializationFromString(specialization.getText().toString()));

        Stat.INTELLIGENCE.setValue(Integer.parseInt(intelligence.getText().toString()));
        Stat.AGILITY.setValue(Integer.parseInt(agility.getText().toString()));
        Stat.STRENGTH.setValue(Integer.parseInt(strength.getText().toString()));
        Stat.CHARISMA.setValue(Integer.parseInt(charisma.getText().toString()));
        Stat.BODY.setValue(Integer.parseInt(body.getText().toString()));
        Stat.WISDOM.setValue(Integer.parseInt(wisdom.getText().toString()));

        character.setStats(Arrays.asList(
                Stat.INTELLIGENCE,
                Stat.AGILITY,
                Stat.STRENGTH,
                Stat.CHARISMA,
                Stat.BODY,
                Stat.WISDOM));

        character.setArmoryClass(Integer.parseInt(armoryClass.getText().toString()));
    }

    public void toAllSpells(View view){
        Fragment fragment = new Spells();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content_frame, fragment);
        navigation.setVisibility(View.GONE);
        transaction.commit();
    }

    public void toMySpells(View view){
        Fragment fragment = new MySpells();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content_frame, fragment);
        navigation.setVisibility(View.VISIBLE);
        transaction.commit();
    }

    public void addSpellToCharacter(View view){
        character.getSpells().add(currentSpell);
        toMySpells(view);
    }

    public void deleteSpellFromCharacter(View view){
        character.getSpells().remove(currentSpell);
        toMySpells(view);
    }

    private void setAllSkills(List<Spell> spells){
        Cursor cursor = mDb.rawQuery("select NAME, LEVEL, SCHOOL, OVERLAY_TIME, DISTANCE, COMPONENTS, DURATION, CLASSES, DESCRIPTION from skills", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            spells.add(
                    new Spell(
                            cursor.getString(0),
                            cursor.getInt(1),
                            cursor.getString(2),
                            cursor.getString(3),
                            cursor.getInt(4),
                            cursor.getString(5),
                            cursor.getString(6),
                            cursor.getString(7),
                            cursor.getString(8)));
            cursor.moveToNext();
        }
        cursor.close();
    }

    private void setBonusStats() {
        List<CheckBox> checkBoxList = new ArrayList<>();
        checkBoxList.add((CheckBox) findViewById(R.id.checkBoxAthletics));
        checkBoxList.add((CheckBox) findViewById(R.id.checkBoxAcrobatics));
        checkBoxList.add((CheckBox) findViewById(R.id.checkBoxSleightOfHand));
        checkBoxList.add((CheckBox) findViewById(R.id.checkBoxStealth));
        checkBoxList.add((CheckBox) findViewById(R.id.checkBoxArcana));
        checkBoxList.add((CheckBox) findViewById(R.id.checkBoxHistory));
        checkBoxList.add((CheckBox) findViewById(R.id.checkBoxInvestigation));
        checkBoxList.add((CheckBox) findViewById(R.id.checkBoxNature));
        checkBoxList.add((CheckBox) findViewById(R.id.checkBoxReligion));
        checkBoxList.add((CheckBox) findViewById(R.id.checkBoxAnimalHandling));
        checkBoxList.add((CheckBox) findViewById(R.id.checkBoxInsight));
        checkBoxList.add((CheckBox) findViewById(R.id.checkBoxMedicine));
        checkBoxList.add((CheckBox) findViewById(R.id.checkBoxPerception));
        checkBoxList.add((CheckBox) findViewById(R.id.checkBoxSurvival));
        checkBoxList.add((CheckBox) findViewById(R.id.checkBoxDeception));
        checkBoxList.add((CheckBox) findViewById(R.id.checkBoxIntimidation));
        checkBoxList.add((CheckBox) findViewById(R.id.checkBoxPerformance));
        checkBoxList.add((CheckBox) findViewById(R.id.checkBoxPersuasion));

        for (CheckBox checkBox : checkBoxList) {
            if (checkBox.isChecked()) {
                character.getPerformances().add(Performance.getPerformanceFromString(checkBox.getText().toString()));
            }
        }

    }
}

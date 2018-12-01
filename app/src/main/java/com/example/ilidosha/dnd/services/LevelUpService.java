package com.example.ilidosha.dnd.services;

import android.content.Context;
import android.text.Editable;
import android.widget.EditText;
import com.example.ilidosha.dnd.enities.Character;

import static com.example.ilidosha.dnd.pages.LayoutPage.character;

public class LevelUpService {
    private Context context;

    public LevelUpService(Context context) {
        this.context = context;
    }

    public void boostExp(int number) {
        character.setExperience(character.getExperience() + number);
    }

    public void boostExp(EditText editText) {
        Editable text = editText.getText();
        if (text == null) {
            return;
        }
        String string = text.toString().trim();
        if (string.equals("")) {
            return;
        }
        int number = parseIntOrZero(string);
        character.setExperience(character.getExperience() + number);
        setLevelFromExperience(character.getExperience());
    }

    private void setLevelFromExperience(int experience) {
        while (getLevelByExperience(experience)>character.getLevel()){
            levelUp(character);
        }
    }

    private void levelUp(Character character){
        int nextLevel = character.getLevel()+1;
        character.getArchetype().applyArchetypeLevelBonusOnCharacter(character, context, nextLevel);
        character.getSpecialization().applySpecializationLevelBonusOnCharacter(character, context, nextLevel);
        character.setLevel(nextLevel);
    }

    private int getLevelByExperience(int experience){
        if (experience >= 14000) {
            return 6;
        } else if (experience >= 6500) {
            return 5;
        } else if (experience >= 2700) {
            return 4;
        } else if (experience >= 900) {
            return 3;
        } else if (experience >= 300) {
            return 2;
        } else {
            return 1;
        }
    }

    private int parseIntOrZero(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}

package com.example.ilidosha.dnd.services;

import android.text.Editable;
import android.widget.EditText;

import static com.example.ilidosha.dnd.pages.LayoutPage.character;

public class LevelUpService {
    public void boostExp(int number){
        character.setExperience(character.getExperience()+number);
    }

    public void boostExp(EditText editText){
        Editable text = editText.getText();
        if (text==null){
            return;
        }
        String string = text.toString().trim();
        if (string.equals("")){
            return;
        }
        int number = parseIntOrZero(string);
        character.setExperience(character.getExperience()+number);
        setLevelFromExperience(character.getExperience());
    }

    private void setLevelFromExperience(int experience){
        if (experience>=14000){
            character.setLevel(6);
        } else if (experience>=6500){
            character.setLevel(5);
        } else if (experience>=2700){
            character.setLevel(4);
        } else if (experience>=900){
            character.setLevel(3);
        } else if (experience>=300){
            character.setLevel(2);
        } else character.setLevel(1);

    }

    private int parseIntOrZero(String string){
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e){
            return 0;
        }
    }
}

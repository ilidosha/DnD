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
    }

    private int parseIntOrZero(String string){
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e){
            return 0;
        }
    }
}

package com.example.ilidosha.dnd.Utils;

import android.text.Editable;
import android.widget.EditText;

public class ValidationUtils {

    public static boolean validateStat(EditText editText){
        return validateStat(editText.getText());
    }

    public static boolean validateStat(Editable editable){
        return validateStat(editable.toString());
    }

    public static boolean validateStat(String string){
        if("".equals(string)){
            return false;
        }
        try {
            int stat = Integer.parseInt(string);
            return stat > 0;
        } catch (NumberFormatException e){
            return false;
        }
    }
}

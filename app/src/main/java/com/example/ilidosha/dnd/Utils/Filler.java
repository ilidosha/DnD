package com.example.ilidosha.dnd.Utils;

import android.widget.EditText;
import android.widget.TextView;
import com.example.ilidosha.dnd.R;
import android.view.View;
import com.example.ilidosha.dnd.enities.Archetype;
import com.example.ilidosha.dnd.enities.Character;

public class Filler {
    public static void fillCharacterInfoFromView(Character character, View view){
        String archetype =((EditText)view.findViewById(R.id.editTextArchetype)).getText().toString();
        character.setArchetype(Archetype.getArchetypeFromString(archetype));
    }
}

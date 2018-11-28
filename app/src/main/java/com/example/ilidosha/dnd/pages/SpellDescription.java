package com.example.ilidosha.dnd.pages;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.example.ilidosha.dnd.R;

import static com.example.ilidosha.dnd.pages.LayoutPage.character;
import static com.example.ilidosha.dnd.pages.LayoutPage.currentSpell;

public class SpellDescription extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.spell_description, container,
                false);
        renderSkillDescription(view);
        return view;
    }



    private void renderSkillDescription(View view){
        FloatingActionButton button = view.findViewById(R.id.buttonItemDeleteSpellFromCharacter);
        if (character.getSpells().contains(currentSpell)){
            button.setVisibility(View.VISIBLE);
        } else {
            button.setVisibility(View.GONE);
        }
        TextView name = view.findViewById(R.id.textViewNameSD);
        TextView level = view.findViewById(R.id.textViewLevelSD);
        TextView school = view.findViewById(R.id.textViewSchoolSD);
        TextView overlayTime = view.findViewById(R.id.textViewOverlayTimeSD);
        TextView distance = view.findViewById(R.id.textViewDistanceSD);
        TextView components = view.findViewById(R.id.textViewComponentsSD);
        TextView duration = view.findViewById(R.id.textViewDurationSD);
        TextView classes = view.findViewById(R.id.textViewClassesSD);
        TextView description = view.findViewById(R.id.textViewDescriptionSD);

        name.setText(currentSpell.getName());
        level.setText(String.valueOf(currentSpell.getLevel()));
        school.setText(currentSpell.getSchool());
        overlayTime.setText(currentSpell.getOverlayTime());
        distance.setText(String.valueOf(currentSpell.getDistance()));
        components.setText(currentSpell.getComponents());
        duration.setText(currentSpell.getDuration());
        classes.setText(currentSpell.getClasses());
        description.setText(currentSpell.getDescription());
    }
}

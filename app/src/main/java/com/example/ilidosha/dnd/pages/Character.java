package com.example.ilidosha.dnd.pages;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.ilidosha.dnd.R;
import com.example.ilidosha.dnd.enities.Stat;

import static com.example.ilidosha.dnd.Utils.RandomUtils.*;
import static com.example.ilidosha.dnd.enities.Performance.*;
import static com.example.ilidosha.dnd.pages.LayoutPage.character;

public class Character extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_character, container,
                false);
        renderCharacterView(view);
        return view;
    }


    private void renderCharacterView(View view) {
        EditText charName = view.findViewById(R.id.editTextCharacterName);
        EditText specialization = view.findViewById(R.id.editTextSpecialization);
        EditText race = view.findViewById(R.id.editTextRace);
        EditText archetype = view.findViewById(R.id.editTextArchetype);

        Button currentHP = view.findViewById(R.id.buttonCurrentHP);
        Button maxHP = view.findViewById(R.id.buttonMaxHP);
        Button hpDices = view.findViewById(R.id.buttonDicesHP);
        Button temporaryHP = view.findViewById(R.id.buttonTemporaryHP);

        TextView LVL = view.findViewById(R.id.textViewLVL);
        Button exp = view.findViewById(R.id.buttonExperience);

        EditText strength = view.findViewById(R.id.editTextStrength);
        EditText agility = view.findViewById(R.id.editTextAgility);
        EditText intelligence = view.findViewById(R.id.editTextIntelligence);
        EditText wisdom = view.findViewById(R.id.editTextWisdom);
        EditText body = view.findViewById(R.id.editTextBody);
        EditText charisma = view.findViewById(R.id.editTextCharisma);

        Button armoryClass = view.findViewById(R.id.buttonArmorClass);
        Button initiative = view.findViewById(R.id.buttonInitiative);
        Button speed = view.findViewById(R.id.buttonSpeed);

        TextView athletics = view.findViewById(R.id.textViewAthletics);
        TextView acrobatics = view.findViewById(R.id.textViewAcrobatics);
        TextView sleightOfHand = view.findViewById(R.id.textViewSleightOfHand);
        TextView stealth = view.findViewById(R.id.textViewStealth);
        TextView arcana = view.findViewById(R.id.textViewArcana);
        TextView history = view.findViewById(R.id.textViewHistory);
        TextView investigation = view.findViewById(R.id.textViewInvestigation);
        TextView nature = view.findViewById(R.id.textViewNature);
        TextView religion = view.findViewById(R.id.textViewReligion);
        TextView animalHandling = view.findViewById(R.id.textViewAnimalHandling);
        TextView insight = view.findViewById(R.id.textViewInsight);
        TextView medicine = view.findViewById(R.id.textViewMedicine);
        TextView perception = view.findViewById(R.id.textViewPerception);
        TextView survival = view.findViewById(R.id.textViewSurvival);
        TextView deception = view.findViewById(R.id.textViewDeception);
        TextView intimidation = view.findViewById(R.id.textViewIntimidation);
        TextView performance = view.findViewById(R.id.textViewPerformance);
        TextView persuasion = view.findViewById(R.id.textViewPersuasion);




        charName.setText(character.getName());
        specialization.setText(character.getSpecialization().getName());
        race.setText(character.getRace().getName());
        archetype.setText(character.getArchetype().getName());

        currentHP.setText(String.valueOf(character.getHealth().getCurrentHP()));
        maxHP.setText(String.valueOf(character.getHealth().getMaxHP()));
        hpDices.setText("1к"+character.getSpecialization().getDicesHP());
        temporaryHP.setText(String.valueOf(character.getHealth().getTemporaryHP()));

        LVL.setText("Уровень: "+character.getLevel());
        exp.setText(String.valueOf(character.getExperience()));


        for (Stat stat : character.getStats()) {
            switch (stat) {
                case STRENGTH:
                    strength.setText(stat.getValue()+" ("+factStat(stat.getValue())+")");
                    break;
                case AGILITY:
                    agility.setText(stat.getValue()+" ("+factStat(stat.getValue())+")");
                    break;
                case INTELLIGENCE:
                    intelligence.setText(stat.getValue()+" ("+factStat(stat.getValue())+")");
                    break;
                case WISDOM:
                    wisdom.setText(stat.getValue()+" ("+factStat(stat.getValue())+")");
                    break;
                case BODY:
                    body.setText(stat.getValue()+" ("+factStat(stat.getValue())+")");
                    break;
                case CHARISMA:
                    charisma.setText(stat.getValue()+" ("+factStat(stat.getValue())+")");
                    break;
            }
        }
        armoryClass.setText(String.valueOf(character.getArmoryClass()));
        initiative.setText(String.valueOf(factStat(character.getStats().get(character.getStats().indexOf(Stat.AGILITY)).getValue())));
        speed.setText(String.valueOf(character.getSpeed()));

        athletics.setText(String.valueOf(calculatePerformance(ATHLETICS)));
        acrobatics.setText(String.valueOf(calculatePerformance(ACROBATICS)));
        sleightOfHand.setText(String.valueOf(calculatePerformance(SLEIGHT_OF_HAND)));
        stealth.setText(String.valueOf(calculatePerformance(STEALTH)));
        arcana.setText(String.valueOf(calculatePerformance(ARCANA)));
        history.setText(String.valueOf(calculatePerformance(HISTORY)));
        investigation.setText(String.valueOf(calculatePerformance(INVESTIGATION)));
        nature.setText(String.valueOf(calculatePerformance(NATURE)));
        religion.setText(String.valueOf(calculatePerformance(RELIGION)));
        animalHandling.setText(String.valueOf(calculatePerformance(ANIMAL_HANDLING)));
        insight.setText(String.valueOf(calculatePerformance(INSIGHT)));
        medicine.setText(String.valueOf(calculatePerformance(MEDICINE)));
        perception.setText(String.valueOf(calculatePerformance(PERCEPTION)));
        survival.setText(String.valueOf(calculatePerformance(SURVIVAL)));
        deception.setText(String.valueOf(calculatePerformance(DECEPTION)));
        intimidation.setText(String.valueOf(calculatePerformance(INTIMIDATION)));
        performance.setText(String.valueOf(calculatePerformance(PERFORMANCE)));
        persuasion.setText(String.valueOf(calculatePerformance(PERSUASION)));
    }
}

package com.example.ilidosha.dnd.Utils;

import com.example.ilidosha.dnd.R;
import com.example.ilidosha.dnd.enities.Performance;
import com.example.ilidosha.dnd.enities.Specialization;
import com.example.ilidosha.dnd.enities.Spell;
import com.example.ilidosha.dnd.enities.Stat;

import java.util.List;

import static com.example.ilidosha.dnd.pages.LayoutPage.character;

public class RandomUtils {
    private static int changeTextColor = 1;

    public static int getNextTheme() {
        switch (changeTextColor) {
            case 0:
                changeTextColor++;
                return R.style.whiteText;
            default:
                changeTextColor = 0;
                return R.style.blackText;

        }
    }

    public static int calculatePerformance(Performance performance) {
        int result = 0;
        for (Stat stat : character.getStats()) {
            if (stat == performance.getStat()) {
                result += stat.getValue();
                break;
            }
        }
        result = factStat(result);
        if (character.getPerformances().contains(performance)) {
            result += character.getMasteryLevel();
        }
        return result;
    }

    public static int factStat(int stat) {
        if (stat - 10 >= 0) {
            return (stat - 10) / 2;
        } else {
            return (stat - 11) / 2;
        }
    }

    public static String[] getSpecializationsNameArray(){
        final String[] specializations = new String[Specialization.values().length];
        for (int i = 0; i < Specialization.values().length; ++i) {
            specializations[i] = Specialization.values()[i].getName();
        }
        return specializations;
    }

    public static Spell findSpellByName(List<Spell> spells, String name){
        for (Spell spell:spells){
            if (spell.getName().equals(name)){
                return spell;
            }
        }
        throw new RuntimeException("Способность не найдена!");
    }
}

package com.example.ilidosha.dnd.enities;

import android.content.res.Resources;

public enum Race {
    HALF_ORC("Полуорк"),
    HALF_ELF("Полуэльф"),
    HIGH_ELD("Высший эльф"),
    FOREST_ELD("Лесной эльф"),
    DARK_ELF("Тёмный эльф"),
    HALFLING("Полурослик"),
    GNOME("Гном"),
    HUMAN("Человек"),
    TIEFLING("Тифлинг");

    public static Race getRaceFromString(String string){
        for (Race race: Race.values()){
            if (race.getName().equals(string)){
                return race;
            }
        }
        throw new Resources.NotFoundException("Раса не найдена");
    }

    public String getName() {
        return name;
    }

    String name;

    Race(String name) {
        this.name = name;
    }

}

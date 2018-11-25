package com.example.ilidosha.dnd.enities;

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

    public String getName() {
        return name;
    }

    String name;

    Race(String name) {
        this.name = name;
    }

}

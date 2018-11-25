package com.example.ilidosha.dnd.enities;

public enum Performance {
    ATHLETICS("Атлетика"),
    ACROBATICS("Акробатика"),
    SLEIGHT_OF_HAND("Ловкость рук"),
    STEALTH("Скрытность"),
    ARCANA("Магия"),
    HISTORY("История"),
    INVESTIGATION("Анализ"),
    NATURE("Природа"),
    RELIGION("Религия"),
    ANIMAL_HANDLING("Уход за животными"),
    INSIGHT("Проницательность"),
    MEDICINE("Медицина"),
    PERCEPTION("Внимательность"),
    SURVIVAL("Выживание"),
    DECEPTION("Обман"),
    INTIMIDATION("Запугивание"),
    PERFORMANCE("Выступление"),
    PERSUASION("Убеждение");

    private String name;

    Performance(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

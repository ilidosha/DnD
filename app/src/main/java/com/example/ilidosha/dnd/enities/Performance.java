package com.example.ilidosha.dnd.enities;

public enum Performance {

    ATHLETICS("Атлетика", Stat.STRENGTH),
    ACROBATICS("Акробатика", Stat.AGILITY),
    SLEIGHT_OF_HAND("Ловкость рук", Stat.AGILITY),
    STEALTH("Скрытность", Stat.AGILITY),
    ARCANA("Магия", Stat.INTELLIGENCE),
    HISTORY("История", Stat.INTELLIGENCE),
    INVESTIGATION("Анализ", Stat.INTELLIGENCE),
    NATURE("Природа", Stat.INTELLIGENCE),
    RELIGION("Религия", Stat.INTELLIGENCE),
    ANIMAL_HANDLING("Уход за животными", Stat.WISDOM),
    INSIGHT("Проницательность", Stat.WISDOM),
    MEDICINE("Медицина", Stat.WISDOM),
    PERCEPTION("Внимательность", Stat.WISDOM),
    SURVIVAL("Выживание", Stat.WISDOM),
    DECEPTION("Обман", Stat.CHARISMA),
    INTIMIDATION("Запугивание", Stat.CHARISMA),
    PERFORMANCE("Выступление", Stat.CHARISMA),
    PERSUASION("Убеждение", Stat.CHARISMA);

    private String name;
    private Stat stat;

    Performance(String name, Stat stat) {
        this.name = name;
        this.stat = stat;
    }

    public String getName() {
        return name;
    }

    public Stat getStat() {
        return stat;
    }
}

package com.example.ilidosha.dnd.enities;

public enum Specialization {
    BARD("Бард"),
    BARBARIAN("Варвар"),
    FIGHTER("Воин"),
    WIZARD("Волшебник"),
    DRUID("Друид"),
    CLERIC("Жрец"),
    WARLOCK("Колдун"),
    MONK("Монах"),
    PALADIN("Паладин"),
    ROGUE("Плут"),
    RANGER("Следопыт"),
    SORCERER("Чародей");

    public String getName() {
        return name;
    }

    private String name;

    Specialization(String name){
        this.name=name;
    }
}

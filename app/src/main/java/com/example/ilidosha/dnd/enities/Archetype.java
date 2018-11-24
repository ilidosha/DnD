package com.example.ilidosha.dnd.enities;

import android.content.res.Resources;

public enum Archetype {
    PALADIN_DEVOTION("Клятва преданности"),
    PALADIN_ANCIENTS("Клятва древних"),
    PALADIN_VENGEANCE("Клятва отмщения");

    public String getFancyName() {
        return fancyName;
    }

    String fancyName;

    Archetype(String string){
        this.fancyName=string;
    }

    public static Archetype getArchetypeFromString(String string){
        for (Archetype archetype: Archetype.values()){
            if (archetype.getFancyName().equals(string)){
                return archetype;
            }
        }
        throw new Resources.NotFoundException("Архетип не найден");
    }
}

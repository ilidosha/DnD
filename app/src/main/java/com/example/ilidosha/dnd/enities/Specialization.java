package com.example.ilidosha.dnd.enities;

import android.content.res.Resources;

import static com.example.ilidosha.dnd.enities.Archetype.*;

public enum Specialization {
    BARD("Бард") {
        @Override
        public Archetype[] getArchetypes() {
            return new Archetype[]{BARD_ANCIENTS, BARD_LORE, BARD_VALOR};
        }
    },
    BARBARIAN("Варвар") {
        @Override
        public Archetype[] getArchetypes() {
            return null;
        }
    },
    FIGHTER("Воин") {
        @Override
        public Archetype[] getArchetypes() {
            return null;
        }
    },

    WIZARD("Волшебник") {
        @Override
        public Archetype[] getArchetypes() {
            return null;
        }
    },

    DRUID("Друид") {
        @Override
        public Archetype[] getArchetypes() {
            return null;
        }
    },

    CLERIC("Жрец") {
        @Override
        public Archetype[] getArchetypes() {
            return new Archetype[]{CLERIC_TRICKERY, CLERIC_KNOWLEDGE, CLERIC_LIFE, CLERIC_LIGHT, CLERIC_NATURE, CLERIC_STORM, CLERIC_WAR};
        }
    },

    WARLOCK("Колдун") {
        @Override
        public Archetype[] getArchetypes() {
            return new Archetype[]{WARLOCK_ARCHYFAIRY, WARLOCK_FIEND, WARLOCK_GREAT_ANCIENT};
        }
    },

    MONK("Монах") {
        @Override
        public Archetype[] getArchetypes() {
            return null;
        }
    },

    PALADIN("Паладин") {
        @Override
        public Archetype[] getArchetypes() {
            return new Archetype[]{PALADIN_ANCIENTS, PALADIN_DEVOTION, PALADIN_VENGEANCE};
        }
    },

    ROGUE("Плут") {
        @Override
        public Archetype[] getArchetypes() {
            return new Archetype[]{ROGUE_KILLER, ROGUE_MYSTICAL_TRICKSTER, ROGUE_THIEF};
        }
    },

    RANGER("Следопыт") {
        @Override
        public Archetype[] getArchetypes() {
            return new Archetype[]{RANGER_BEASTMASTER, RANGER_FLORAMASTER, RANGER_HUNTER};
        }
    },

    SORCERER("Чародей") {
        @Override
        public Archetype[] getArchetypes() {
            return new Archetype[]{SORCERER_DECAY, SORCERER_DRAGON_BLOOD, SORCERER_WILD_MAGIC};
        }
    };

    public abstract Archetype[] getArchetypes();

    public String getName() {
        return name;
    }

    private String name;

    Specialization(String name) {
        this.name = name;
    }

    public static Specialization getSpecializationFromString(String string){
        for (Specialization specialization: Specialization.values()){
            if (specialization.getName().equals(string)){
                return specialization;
            }
        }
        throw new Resources.NotFoundException("Архетип не найден");
    }
}

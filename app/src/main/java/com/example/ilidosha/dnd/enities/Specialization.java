package com.example.ilidosha.dnd.enities;

import android.content.res.Resources;

import static com.example.ilidosha.dnd.enities.Archetype.*;
import static com.example.ilidosha.dnd.enities.Performance.*;

public enum Specialization {
    BARD("Бард") {
        @Override
        public Archetype[] getArchetypes() {
            return new Archetype[]{BARD_ANCIENTS, BARD_LORE, BARD_VALOR};
        }

        @Override
        public int getSkillsNumber() {
            return 0;
        }

        @Override
        public Stat[] getBonusSavingThrowStats() {
            return new Stat[0];
        }

        @Override
        public String getPossibleEquipment() {
            return null;
        }

        @Override
        public Performance[] getPossiblePerfomance() {
            return new Performance[0];
        }

        @Override
        public Stat getMainStat() {
            return null;
        }

        @Override
        public int getDicesHP() {
            return 0;
        }
    },
    BARBARIAN("Варвар") {
        @Override
        public Archetype[] getArchetypes() {
            return null;
        }

        @Override
        public int getSkillsNumber() {
            return 0;
        }

        @Override
        public Stat[] getBonusSavingThrowStats() {
            return new Stat[0];
        }

        @Override
        public String getPossibleEquipment() {
            return null;
        }

        @Override
        public Performance[] getPossiblePerfomance() {
            return new Performance[0];
        }

        @Override
        public Stat getMainStat() {
            return null;
        }

        @Override
        public int getDicesHP() {
            return 0;
        }
    },
    FIGHTER("Воин") {
        @Override
        public Archetype[] getArchetypes() {
            return null;
        }

        @Override
        public int getSkillsNumber() {
            return 0;
        }

        @Override
        public Stat[] getBonusSavingThrowStats() {
            return new Stat[0];
        }

        @Override
        public String getPossibleEquipment() {
            return null;
        }

        @Override
        public Performance[] getPossiblePerfomance() {
            return new Performance[0];
        }

        @Override
        public Stat getMainStat() {
            return null;
        }

        @Override
        public int getDicesHP() {
            return 0;
        }
    },

    WIZARD("Волшебник") {
        @Override
        public Archetype[] getArchetypes() {
            return null;
        }

        @Override
        public int getSkillsNumber() {
            return 0;
        }

        @Override
        public Stat[] getBonusSavingThrowStats() {
            return new Stat[0];
        }

        @Override
        public String getPossibleEquipment() {
            return null;
        }

        @Override
        public Performance[] getPossiblePerfomance() {
            return new Performance[0];
        }

        @Override
        public Stat getMainStat() {
            return null;
        }

        @Override
        public int getDicesHP() {
            return 0;
        }
    },

    DRUID("Друид") {
        @Override
        public Archetype[] getArchetypes() {
            return null;
        }

        @Override
        public int getSkillsNumber() {
            return 0;
        }

        @Override
        public Stat[] getBonusSavingThrowStats() {
            return new Stat[0];
        }

        @Override
        public String getPossibleEquipment() {
            return null;
        }

        @Override
        public Performance[] getPossiblePerfomance() {
            return new Performance[0];
        }

        @Override
        public Stat getMainStat() {
            return null;
        }

        @Override
        public int getDicesHP() {
            return 0;
        }
    },

    CLERIC("Жрец") {
        @Override
        public Archetype[] getArchetypes() {
            return new Archetype[]{CLERIC_TRICKERY, CLERIC_KNOWLEDGE, CLERIC_LIFE, CLERIC_LIGHT, CLERIC_NATURE, CLERIC_STORM, CLERIC_WAR};
        }

        @Override
        public int getSkillsNumber() {
            return 2;
        }

        @Override
        public Stat[] getBonusSavingThrowStats() {
            return new Stat[]{Stat.WISDOM,Stat.CHARISMA};
        }

        @Override
        public String getPossibleEquipment() {
            return "Доспехи: Лёгкие доспехи, средние доспехи, щиты\n" +
                    "Оружие: Простое оружие\n" +
                    "Инструменты: Нет";
        }

        @Override
        public Performance[] getPossiblePerfomance() {
            return new Performance[]{HISTORY, MEDICINE, INSIGHT, RELIGION, PERSUASION};
        }

        @Override
        public Stat getMainStat() {
            return Stat.WISDOM;
        }

        @Override
        public int getDicesHP() {
            return 8;
        }
    },

    WARLOCK("Колдун") {
        @Override
        public Archetype[] getArchetypes() {
            return new Archetype[]{WARLOCK_ARCHYFAIRY, WARLOCK_FIEND, WARLOCK_GREAT_ANCIENT};
        }

        @Override
        public int getSkillsNumber() {
            return 2;
        }

        @Override
        public Stat[] getBonusSavingThrowStats() {
            return new Stat[]{Stat.WISDOM, Stat.CHARISMA};
        }

        @Override
        public String getPossibleEquipment() {
            return "Доспехи: Лёгкие доспехи\n" +
                    "Оружие: Простое оружие\n" +
                    "Инструменты: Нет";
        }

        @Override
        public Performance[] getPossiblePerfomance() {
            return new Performance[]{INVESTIGATION,INTIMIDATION, HISTORY, ARCANA, DECEPTION, NATURE, RELIGION};
        }

        @Override
        public Stat getMainStat() {
            return Stat.CHARISMA;
        }

        @Override
        public int getDicesHP() {
            return 8;
        }
    },

    MONK("Монах") {
        @Override
        public Archetype[] getArchetypes() {
            return null;
        }

        @Override
        public int getSkillsNumber() {
            return 0;
        }

        @Override
        public Stat[] getBonusSavingThrowStats() {
            return new Stat[0];
        }

        @Override
        public String getPossibleEquipment() {
            return null;
        }

        @Override
        public Performance[] getPossiblePerfomance() {
            return new Performance[0];
        }

        @Override
        public Stat getMainStat() {
            return null;
        }

        @Override
        public int getDicesHP() {
            return 0;
        }
    },

    PALADIN("Паладин") {
        @Override
        public Archetype[] getArchetypes() {
            return new Archetype[]{PALADIN_ANCIENTS, PALADIN_DEVOTION, PALADIN_VENGEANCE};
        }

        @Override
        public int getSkillsNumber() {
            return 2;
        }

        @Override
        public Stat[] getBonusSavingThrowStats() {
            return new Stat[]{Stat.WISDOM,Stat.CHARISMA};
        }

        @Override
        public String getPossibleEquipment() {
            return "Доспехи: Все виды доспехов, щиты\n" +
                    "Оружие: Простое оружие, воинское оружие\n" +
                    "Инструменты: нет";
        }

        @Override
        public Performance[] getPossiblePerfomance() {
            return new Performance[]{ATHLETICS,INTIMIDATION, MEDICINE, INSIGHT, RELIGION, PERSUASION};
        }

        @Override
        public Stat getMainStat() {
            return Stat.STRENGTH;
        }

        @Override
        public int getDicesHP() {
            return 10;
        }
    },

    ROGUE("Плут") {
        @Override
        public Archetype[] getArchetypes() {
            return new Archetype[]{ROGUE_KILLER, ROGUE_MYSTICAL_TRICKSTER, ROGUE_THIEF};
        }

        @Override
        public int getSkillsNumber() {
            return 4;
        }

        @Override
        public Stat[] getBonusSavingThrowStats() {
            return new Stat[]{Stat.AGILITY,Stat.INTELLIGENCE};
        }

        @Override
        public String getPossibleEquipment() {
            return "Доспехи: Лёгкие доспехи\n" +
                    "Оружие: Простое оружие, ручные арбалеты, длинные мечи, рапиры, короткие мечи\n" +
                    "Инструменты: Воровские инструменты";
        }

        @Override
        public Performance[] getPossiblePerfomance() {
            return new Performance[]{ACROBATICS,INVESTIGATION, ATHLETICS, PERCEPTION, PERFORMANCE, INTIMIDATION, SLEIGHT_OF_HAND, DECEPTION, INSIGHT, STEALTH, PERSUASION};
        }

        @Override
        public Stat getMainStat() {
            return Stat.AGILITY;
        }

        @Override
        public int getDicesHP() {
            return 8;
        }
    },

    RANGER("Следопыт") {
        @Override
        public Archetype[] getArchetypes() {
            return new Archetype[]{RANGER_BEASTMASTER, RANGER_FLORAMASTER, RANGER_HUNTER};
        }

        @Override
        public int getSkillsNumber() {
            return 3;
        }

        @Override
        public Stat[] getBonusSavingThrowStats() {
            return new Stat[]{Stat.AGILITY};
        }

        @Override
        public String getPossibleEquipment() {
            return "Доспехи: Лёгкие доспехи, средние доспехи, щиты\n" +
                    "Оружие: Простое оружие, воинское оружие\n" +
                    "Инструменты: Нет";
        }

        @Override
        public Performance[] getPossiblePerfomance() {
            return new Performance[]{INVESTIGATION, ATHLETICS, PERCEPTION, SURVIVAL, NATURE, INSIGHT, STEALTH, ANIMAL_HANDLING};
        }

        @Override
        public Stat getMainStat() {
            return Stat.AGILITY;
        }

        @Override
        public int getDicesHP() {
            return 10;
        }
    },

    SORCERER("Чародей") {
        @Override
        public Archetype[] getArchetypes() {
            return new Archetype[]{SORCERER_DECAY, SORCERER_DRAGON_BLOOD, SORCERER_WILD_MAGIC};
        }

        @Override
        public int getSkillsNumber() {
            return 2;
        }

        @Override
        public Stat[] getBonusSavingThrowStats() {
            return new Stat[]{Stat.BODY,Stat.CHARISMA};
        }

        @Override
        public String getPossibleEquipment() {
            return "Доспехи: нет\n" +
                    "Оружие: Боевые посохи, дротики, кинжалы, лёгкие арбалеты, пращи (Праща́ — метательное холодное оружие, представляющее собой верёвку или ремень, один конец которого свёрнут в петлю, в которую продевается кисть пращника.)\n" +
                    "Инструменты: нет";
        }

        @Override
        public Performance[] getPossiblePerfomance() {
            return new Performance[]{INTIMIDATION,ARCANA, DECEPTION, INSIGHT, RELIGION, PERSUASION};
        }

        @Override
        public Stat getMainStat() {
            return Stat.CHARISMA;
        }

        @Override
        public int getDicesHP() {
            return 6;
        }
    };

    public abstract Archetype[] getArchetypes();

    public abstract int getSkillsNumber();

    public abstract Stat[] getBonusSavingThrowStats();

    public abstract String getPossibleEquipment();

    public abstract Performance[] getPossiblePerfomance();

    public abstract Stat getMainStat();

    public abstract int getDicesHP();

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

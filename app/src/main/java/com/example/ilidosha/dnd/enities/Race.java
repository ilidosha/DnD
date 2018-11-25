package com.example.ilidosha.dnd.enities;

import android.content.res.Resources;

public enum Race {
    HALF_ORC("Полуорк") {
        @Override
        public void applyClassBonusOnCharacter(Character character) {
            for (Stat stat : character.getStats()) {
                switch (stat) {
                    case BODY:
                        stat.setValue(stat.getValue() + 1);
                        break;
                    case STRENGTH:
                        stat.setValue(stat.getValue() + 2);
                        break;
                }
            }
            character.setSpeed(30);
        }
    },
    HALF_ELF("Полуэльф") {
        @Override
        public void applyClassBonusOnCharacter(Character character) {
            for (Stat stat : character.getStats()) {
                switch (stat) {//TODO: Я хз, тут этим чертам надо дать ещё 2 статы на выбор поднять, а делать это мне влом
                    case CHARISMA://TODO: Ещё и по 2 навыка(Performance) на выбор дополнительных имеют (любых)
                        stat.setValue(stat.getValue() + 2);
                        break;
                }
            }
            character.setSpeed(30);
        }
    },
    HIGH_ELD("Высший эльф") {
        @Override
        public void applyClassBonusOnCharacter(Character character) {

        }
    },
    FOREST_ELD("Лесной эльф") {
        @Override
        public void applyClassBonusOnCharacter(Character character) {
            for (Stat stat : character.getStats()) {
                switch (stat) {
                    case WISDOM:
                        stat.setValue(stat.getValue() + 1);
                        break;
                    case AGILITY:
                        stat.setValue(stat.getValue() + 2);
                        break;
                }
            }
            character.setSpeed(30);
        }
    },
    DARK_ELF("Тёмный эльф") {
        @Override
        public void applyClassBonusOnCharacter(Character character) {

        }
    },
    HALFLING("Полурослик") {
        @Override
        public void applyClassBonusOnCharacter(Character character) {
            for (Stat stat : character.getStats()) {
                switch (stat) {
                    case AGILITY:
                        stat.setValue(stat.getValue() + 2);
                        break;
                    case CHARISMA:
                        stat.setValue(stat.getValue() + 1);
                        break;
                }
            }
            character.setSpeed(25);
        }
    },
    GNOME("Гном") {
        @Override
        public void applyClassBonusOnCharacter(Character character) {

        }
    },
    HUMAN("Человек") {
        @Override
        public void applyClassBonusOnCharacter(Character character) {

        }
    },
    TIEFLING("Тифлинг") {
        @Override
        public void applyClassBonusOnCharacter(Character character) {
            for (Stat stat : character.getStats()) {
                switch (stat) {
                    case INTELLIGENCE:
                        stat.setValue(stat.getValue() + 1);
                        break;
                    case CHARISMA:
                        stat.setValue(stat.getValue() + 2);
                        break;
                }
            }
            character.setSpeed(30);
        }
    };

    public static Race getRaceFromString(String string) {
        for (Race race : Race.values()) {
            if (race.getName().equals(string)) {
                return race;
            }
        }
        throw new Resources.NotFoundException("Раса не найдена");
    }

    public abstract void applyClassBonusOnCharacter(Character character);

    public String getName() {
        return name;
    }

    String name;

    Race(String name) {
        this.name = name;
    }

}

package com.example.ilidosha.dnd.enities;

import static com.example.ilidosha.dnd.enities.Performance.*;

public enum Stat {
    WISDOM {
        @Override
        public Performance[] getDependencedPerformance() {
            return new Performance[]{PERCEPTION, SURVIVAL, MEDICINE, INSIGHT, ANIMAL_HANDLING};
        }
    },
    BODY {
        @Override
        public Performance[] getDependencedPerformance() {
            return new Performance[]{};
        }
    },
    AGILITY {
        @Override
        public Performance[] getDependencedPerformance() {
            return new Performance[]{ACROBATICS, SLEIGHT_OF_HAND, STEALTH};
        }
    },
    INTELLIGENCE {
        @Override
        public Performance[] getDependencedPerformance() {
            return new Performance[]{INVESTIGATION, HISTORY, ARCANA, NATURE, RELIGION};
        }
    },
    CHARISMA {
        @Override
        public Performance[] getDependencedPerformance() {
            return new Performance[]{PERFORMANCE, INTIMIDATION, DECEPTION, PERSUASION};
        }
    },
    STRENGTH {
        @Override
        public Performance[] getDependencedPerformance() {
            return new Performance[]{ATHLETICS};
        }
    };

    int value;

    public abstract Performance[] getDependencedPerformance();

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}

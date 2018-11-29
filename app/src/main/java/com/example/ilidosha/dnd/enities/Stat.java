package com.example.ilidosha.dnd.enities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

import static com.example.ilidosha.dnd.enities.Performance.*;

public enum Stat implements Serializable {
    WISDOM("Мудрость") {
        @Override
        public Performance[] getDependencedPerformance() {
            return new Performance[]{PERCEPTION, SURVIVAL, MEDICINE, INSIGHT, ANIMAL_HANDLING};
        }
    },
    BODY("Телосложение") {
        @Override
        public Performance[] getDependencedPerformance() {
            return new Performance[]{};
        }
    },
    AGILITY("Ловкость") {
        @Override
        public Performance[] getDependencedPerformance() {
            return new Performance[]{ACROBATICS, SLEIGHT_OF_HAND, STEALTH};
        }
    },
    INTELLIGENCE("Интеллект") {
        @Override
        public Performance[] getDependencedPerformance() {
            return new Performance[]{INVESTIGATION, HISTORY, ARCANA, NATURE, RELIGION};
        }
    },
    CHARISMA("Харизма") {
        @Override
        public Performance[] getDependencedPerformance() {
            return new Performance[]{PERFORMANCE, INTIMIDATION, DECEPTION, PERSUASION};
        }
    },
    STRENGTH("Сила") {
        @Override
        public Performance[] getDependencedPerformance() {
            return new Performance[]{ATHLETICS};
        }
    };
    int value;

    String name;

    Stat(String name) {
        this.name=name;
    }

    public abstract Performance[] getDependencedPerformance();

    @JsonValue
    public String getName() {
        return name;
    }
    @JsonValue
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}

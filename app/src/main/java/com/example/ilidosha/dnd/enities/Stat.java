package com.example.ilidosha.dnd.enities;

import android.content.res.Resources;
import com.example.ilidosha.dnd.jackson.StatDeserializer;
import com.example.ilidosha.dnd.jackson.StatSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import static com.example.ilidosha.dnd.enities.Performance.*;

@JsonSerialize(using = StatSerializer.class)
@JsonDeserialize(using = StatDeserializer.class)
public enum Stat {
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

    public static Stat getStatFromString(String string){
        for (Stat stat: Stat.values()){
            if (stat.toString().equals(string)){
                return stat;
            }
        }
        throw new Resources.NotFoundException("Стата не найдена");
    }

    Stat(String name) {
        this.name=name;
    }

    public abstract Performance[] getDependencedPerformance();

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}

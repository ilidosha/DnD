package com.example.ilidosha.dnd.enities;

import android.content.Context;
import android.content.res.Resources;
import com.example.ilidosha.dnd.database.SkillsConstants;

import static com.example.ilidosha.dnd.enities.Archetype.*;
import static com.example.ilidosha.dnd.enities.Performance.*;

public enum Specialization implements SkillsConstants {
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

        @Override
        public void applySpecializationBonusOnCharacter(Character character, Context context) {

        }

        @Override
        public void applySpecializationLevelBonusOnCharacter(Character character, Context context, int level) {

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

        @Override
        public void applySpecializationBonusOnCharacter(Character character, Context context) {

        }

        @Override
        public void applySpecializationLevelBonusOnCharacter(Character character, Context context, int level) {

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

        @Override
        public void applySpecializationBonusOnCharacter(Character character, Context context) {

        }

        @Override
        public void applySpecializationLevelBonusOnCharacter(Character character, Context context, int level) {

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

        @Override
        public void applySpecializationBonusOnCharacter(Character character, Context context) {

        }

        @Override
        public void applySpecializationLevelBonusOnCharacter(Character character, Context context, int level) {

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

        @Override
        public void applySpecializationBonusOnCharacter(Character character, Context context) {

        }

        @Override
        public void applySpecializationLevelBonusOnCharacter(Character character, Context context, int level) {

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
            return new Stat[]{Stat.WISDOM, Stat.CHARISMA};
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

        @Override
        public void applySpecializationBonusOnCharacter(Character character, Context context) {
            character.getSpellCells().setMax(1, character.getSpellCells().getMax(1) + 2);
            character.getSpellCells().setCurrent(1, character.getSpellCells().getCurrent(1) + 2);
            character.getSkills().add(RITUAL_WITCHCRAFT);
            character.getSkills().add(SKILL_FOCUS);
        }

        @Override
        public void applySpecializationLevelBonusOnCharacter(Character character, Context context, int level) {
            switch (level) {
                case 2:
                    character.getSkills().add(DIVINE_CHANNEL_CLERIC);
                    character.getSkills().add(DIVINE_CHANNEL_EXILE_UNDEAD);
                    character.getSpellCells().setMax(1, 3);
                    character.getSpellCells().setCurrent(1, character.getSpellCells().getCurrent(1) + 1);
                    break;
                case 3:
                    character.getSpellCells().setMax(1, 4);
                    character.getSpellCells().setCurrent(1, character.getSpellCells().getCurrent(1) + 1);
                    character.getSpellCells().setMax(2, 2);
                    character.getSpellCells().setCurrent(2, character.getSpellCells().getCurrent(2) + 2);
                    break;
                case 4:
                    //TODO бонус 2 статам по 1 или 1 на 2
                    character.getSpellCells().setMax(2, 3);
                    character.getSpellCells().setCurrent(2, character.getSpellCells().getCurrent(2) + 1);
                    break;
                case 5:
                    character.setMasteryLevel(3);
                    character.getSkills().add(UNDEAD_DESTROING);
                    character.getSpellCells().setMax(3, 2);
                    character.getSpellCells().setCurrent(3, character.getSpellCells().getCurrent(3) + 2);
                    break;
                case 6:
                    break;
                case 7:
                    break;
            }
        }
    },

    WARLOCK("Колдун") { //TODO По умолчанию скилл "Поиск фамильяра"

        @Override
//TODO Skill DECEPTIVE_INFLUENCE = new Skill("Обманчивое влияние","Вы получаете владение навыками Обман и Убеждение.")
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
            return new Performance[]{INVESTIGATION, INTIMIDATION, HISTORY, ARCANA, DECEPTION, NATURE, RELIGION};
        }

        @Override
        public Stat getMainStat() {
            return Stat.CHARISMA;
        }

        @Override
        public int getDicesHP() {
            return 8;
        }

        @Override
        public void applySpecializationBonusOnCharacter(Character character, Context context) {
            character.getSpellCells().setMax(1, character.getSpellCells().getMax(1) + 1);
            character.getSpellCells().setCurrent(1, character.getSpellCells().getCurrent(1) + 1);
            character.getSkills().add(MAGIC_OF_THE_CONTRACT);
        }

        @Override
        public void applySpecializationLevelBonusOnCharacter(Character character, Context context, int level) {
            switch (level) {
                case 2:
                    character.getSkills().add(MYSTERIOUS_APPEAL);
                    character.getSpellCells().setMax(1, 2);
                    character.getSpellCells().setCurrent(1, 2);
                    break;
                case 3:
                    //TODO: на выбор 1 из 3 договоров ДОГОВОР ГРИМУАРА, ДОГОВОР КЛИНКА, ДОГОВОР ЦЕПИ
                    character.getSpellCells().setMax(1, 0);
                    character.getSpellCells().setCurrent(1, 0);
                    character.getSpellCells().setMax(2, 2);
                    character.getSpellCells().setCurrent(2, 2);
                    break;
                case 4:
                    //TODO бонус 2 статам по 1 или 1 на 2
                    break;
                case 5:
                    //TODO +1 воззвание
                    character.setMasteryLevel(3);
                    character.getSpellCells().setMax(2, 0);
                    character.getSpellCells().setCurrent(2, 0);
                    character.getSpellCells().setCurrent(3, 2);
                    break;
                case 6:
                    break;
                case 7:
                    break;
            }
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

        @Override
        public void applySpecializationBonusOnCharacter(Character character, Context context) {

        }

        @Override
        public void applySpecializationLevelBonusOnCharacter(Character character, Context context, int level) {

        }
    },

    PALADIN("Паладин") { //TODO выбор боевого стиля

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
            return new Stat[]{Stat.WISDOM, Stat.CHARISMA};
        }

        @Override
        public String getPossibleEquipment() {
            return "Доспехи: Все виды доспехов, щиты\n" +
                    "Оружие: Простое оружие, воинское оружие\n" +
                    "Инструменты: нет";
        }

        @Override
        public Performance[] getPossiblePerfomance() {
            return new Performance[]{ATHLETICS, INTIMIDATION, MEDICINE, INSIGHT, RELIGION, PERSUASION};
        }

        @Override
        public Stat getMainStat() {
            return Stat.STRENGTH;
        }

        @Override
        public int getDicesHP() {
            return 10;
        }

        @Override
        public void applySpecializationBonusOnCharacter(Character character, Context context) {
            character.getSkills().add(DIVINE_FEELING);
            character.getSkills().add(IMPOSITION_OF_HANDS);
        }

        @Override
        public void applySpecializationLevelBonusOnCharacter(Character character, Context context, int level) {
            //TODO выбор боевого стиля
            switch (level) {
                case 2:
                    character.getSpellCells().setMax(1, 2);
                    character.getSkills().add(DIVINE_PUNISHMENT);
                    break;
                case 3:
                    character.getSpellCells().setMax(1, 3);
                    character.getSpellCells().setCurrent(1, 3);
                    character.getSkills().add(DIVINE_HEALTH);
                    character.getSkills().add(SACRED_OATH);
                    character.getSkills().add(SPELLS_OF_THE_OATH);
                    break;
                case 4:
                    //TODO повысить статы
                    break;
                case 5:
                    character.setMasteryLevel(3);
                    character.getSpellCells().setMax(2, 2);
                    character.getSpellCells().setMax(1, 4);
                    character.getSpellCells().setCurrent(2, 2);
                    character.getSpellCells().setCurrent(1, 4);
                    character.getSkills().add(ADDITIONAL_ATTACK);
                    break;
                case 6:
                    character.getSkills().add(AURA_OF_PROTECTION);
                    break;
            }
        }
    },

    ROGUE("Плут") {
        /*
        КОМПЕТЕНТНОСТЬ
На 1 уровне выберите два ваших владения в навыках или одно владение навыком и владение воровскими инструментами. Ваш бонус мастерства удваивается для всех проверок характеристик, которые вы совершаете, используя любое из выбранных владений.

На 6 уровне вы можете выбрать ещё два владения (навыки или воровские инструменты), чтобы получить эту же выгоду.
         */
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
            return new Stat[]{Stat.AGILITY, Stat.INTELLIGENCE};
        }

        @Override
        public String getPossibleEquipment() {
            return "Доспехи: Лёгкие доспехи\n" +
                    "Оружие: Простое оружие, ручные арбалеты, длинные мечи, рапиры, короткие мечи\n" +
                    "Инструменты: Воровские инструменты";
        }

        @Override
        public Performance[] getPossiblePerfomance() {
            return new Performance[]{ACROBATICS, INVESTIGATION, ATHLETICS, PERCEPTION, PERFORMANCE, INTIMIDATION, SLEIGHT_OF_HAND, DECEPTION, INSIGHT, STEALTH, PERSUASION};
        }

        @Override
        public Stat getMainStat() {
            return Stat.AGILITY;
        }

        @Override
        public int getDicesHP() {
            return 8;
        }

        @Override
        public void applySpecializationBonusOnCharacter(Character character, Context context) {
            character.getSkills().add(HIDDEN_ATTACK);
            character.getSkills().add(JARGON_OF_THIEVES);
            character.getSkills().add(COMPETENCE);
        }

        @Override
        public void applySpecializationLevelBonusOnCharacter(Character character, Context context, int level) {
            switch (level) {
                case 2:
                    character.getSkills().add(CUNNING_ACTION);
                    break;
                case 3:
                    for (Skill skill:character.getSkills()){
                        if(skill.getName().contains("Скрытая атака")){
                            skill.setName("Скрытая атака 2d6");
                            break;
                        }
                    }
                    break;
                case 4:
                    //TODO повышение характеристик
                    break;
                case 5:
                    for (Skill skill:character.getSkills()){
                        if(skill.getName().contains("Скрытая атака")){
                            skill.setName("Скрытая атака 2d6");
                            break;
                        }
                    }
                    character.getSkills().add(INCREDIBLE_DODGING);
                    character.setMasteryLevel(3);
                    break;
                case 6:
                    break;
            }
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

        @Override
        public void applySpecializationBonusOnCharacter(Character character, Context context) {
            character.getSkills().add(ELECTED_THE_ENEMY);
            character.getSkills().add(THE_RESEARCHER_OF_THE_NATURE);
        }

        @Override
        public void applySpecializationLevelBonusOnCharacter(Character character, Context context, int level) {
            switch (level) {
                case 2:
                    //TODO боевой стиль
                    character.getSpellCells().setMax(1,2);
                    character.getSpellCells().setCurrent(1,2);
                    break;
                case 3:
                    character.getSpellCells().setMax(1,3);
                    character.getSpellCells().setCurrent(1,3);
                    character.getSkills().add(PRISTINE_AWARENESS);
                    break;
                case 4:
                    //TODO повышение характеристик
                    break;
                case 5:
                    character.getSpellCells().setMax(1,4);
                    character.getSpellCells().setCurrent(1,4);
                    character.getSpellCells().setMax(2,2);
                    character.getSpellCells().setCurrent(2,2);
                    character.getSkills().add(ADDITIONAL_ATTACK);
                    character.setMasteryLevel(3);
                    break;
                case 6:
                    break;
            }
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
            return new Stat[]{Stat.BODY, Stat.CHARISMA};
        }

        @Override
        public String getPossibleEquipment() {
            return "Доспехи: нет\n" +
                    "Оружие: Боевые посохи, дротики, кинжалы, лёгкие арбалеты, пращи (Праща́ — метательное холодное оружие, представляющее собой верёвку или ремень, один конец которого свёрнут в петлю, в которую продевается кисть пращника.)\n" +
                    "Инструменты: нет";
        }

        @Override
        public Performance[] getPossiblePerfomance() {
            return new Performance[]{INTIMIDATION, ARCANA, DECEPTION, INSIGHT, RELIGION, PERSUASION};
        }

        @Override
        public Stat getMainStat() {
            return Stat.CHARISMA;
        }

        @Override
        public int getDicesHP() {
            return 6;
        }

        @Override
        public void applySpecializationBonusOnCharacter(Character character, Context context) {
            character.getSkills().add(SKILL_FOCUS_SORCERER);
            character.getSkills().add(WAVE_OF_WILD_MAGIC);
            character.getSpellCells().setMax(1,2);
            character.getSpellCells().setCurrent(1,2);
        }

        @Override
        public void applySpecializationLevelBonusOnCharacter(Character character, Context context, int level) {
            switch (level) {
                case 2:
                    character.getSkills().add(SOURCE_OF_THE_MAGIC);
                    character.getSpellCells().setMax(1,3);
                    character.getSpellCells().setCurrent(1,3);
                    break;
                case 3:
                    character.getSpellCells().setMax(1,4);
                    character.getSpellCells().setCurrent(1,4);
                    character.getSpellCells().setMax(2,2);
                    character.getSpellCells().setCurrent(2,2);
                    //TODO 2 варианта из возможных метамагий
                    break;
                case 4:
                    character.getSpellCells().setMax(2,3);
                    character.getSpellCells().setCurrent(2,3);
                    //TODO повышение характеристик
                    break;
                case 5:
                    character.getSpellCells().setMax(3,2);
                    character.getSpellCells().setCurrent(3,2);
                    character.setMasteryLevel(3);
                    break;
                case 6:
                    character.getSpellCells().setMax(3,3);
                    character.getSpellCells().setCurrent(3,3);
                    break;
            }
        }
    };

    public abstract Archetype[] getArchetypes();

    public abstract int getSkillsNumber();

    public abstract Stat[] getBonusSavingThrowStats();

    public abstract String getPossibleEquipment();

    public abstract Performance[] getPossiblePerfomance();

    public abstract Stat getMainStat();

    public abstract int getDicesHP();

    public abstract void applySpecializationBonusOnCharacter(Character character, Context context);

    public abstract void applySpecializationLevelBonusOnCharacter(Character character, Context context, int level);

    public String getName() {
        return name;
    }

    private String name;

    Specialization(String name) {
        this.name = name;
    }

    public static Specialization getSpecializationFromString(String string) {
        for (Specialization specialization : Specialization.values()) {
            if (specialization.getName().equals(string)) {
                return specialization;
            }
        }
        throw new Resources.NotFoundException("Архетип не найден");
    }
}

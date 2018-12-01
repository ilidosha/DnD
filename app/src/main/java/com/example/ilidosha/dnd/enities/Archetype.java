package com.example.ilidosha.dnd.enities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import com.example.ilidosha.dnd.database.SkillsConstants;

public enum Archetype implements SkillsConstants {
    PALADIN_DEVOTION("Клятва преданности") {
        @Override
        public void applyArchetypeBonusOnCharacter(Character character, Context context) {

        }

        @Override
        public void applyArchetypeLevelBonusOnCharacter(Character character, Context context, int level) {

        }
    },
    PALADIN_ANCIENTS("Клятва древних") {
        @Override
        public void applyArchetypeBonusOnCharacter(Character character, Context context) {

        }

        @Override
        public void applyArchetypeLevelBonusOnCharacter(Character character, Context context, int level) {

        }
    },
    PALADIN_VENGEANCE("Клятва отмщения") {
        @Override
        public void applyArchetypeBonusOnCharacter(Character character, Context context) {

        }

        @Override
        public void applyArchetypeLevelBonusOnCharacter(Character character, Context context, int level) {
            switch (level) {
                case 3:
                    character.getSkills().add(VOWS_REVENGE_SPELLS);
                    character.getSkills().add(TENETS_OF_REVENGE);
                    character.getSkills().add(CENSURE_ENEMY);
                    character.getSkills().add(VOW_OF_ENMITY);
                    break;
            }
        }
    },/*ЗАКЛИНАНИЯ КЛЯТВЫ МЕСТИ
Уровень паладина	Заклинания
3	метка охотника, порча
5	туманный шаг, удержание личности
9	защита от энергии, ускорение
13	изгнание, переносящая дверь
17	наблюдение, удержание чудовища
*/

    BARD_VALOR("Коллегия доблести") {
        @Override
        public void applyArchetypeBonusOnCharacter(Character character, Context context) {

        }

        @Override
        public void applyArchetypeLevelBonusOnCharacter(Character character, Context context, int level) {

        }
    },
    BARD_LORE("Коллегия знаний") {
        @Override
        public void applyArchetypeBonusOnCharacter(Character character, Context context) {

        }

        @Override
        public void applyArchetypeLevelBonusOnCharacter(Character character, Context context, int level) {

        }
    },
    BARD_ANCIENTS("Коллегия древних") {
        @Override
        public void applyArchetypeBonusOnCharacter(Character character, Context context) {

        }

        @Override
        public void applyArchetypeLevelBonusOnCharacter(Character character, Context context, int level) {

        }
    },
    CLERIC_TRICKERY("Домен обмана") {
        @Override
        public void applyArchetypeBonusOnCharacter(Character character, Context context) {
            character.getSkills().add(CHEATING_DOMAIN);
            character.getSkills().add(BLESS_OF_CHEATER);
        }

        @Override
        public void applyArchetypeLevelBonusOnCharacter(Character character, Context context, int level) {
            switch (level) {
                case 2:
                    character.getSkills().add(DIVINE_CHANNEL_DUPLICITY);
                    break;
                case 6:
                    character.getSkills().add(DIVINE_CHANNEL_CLOAK_OF_SHADOWS);
                    break;
                case 7:
                    break;
            }
        }
    },
    CLERIC_STORM("Домен бури") {
        @Override
        public void applyArchetypeBonusOnCharacter(Character character, Context context) {

        }

        @Override
        public void applyArchetypeLevelBonusOnCharacter(Character character, Context context, int level) {

        }
    },
    CLERIC_WAR("Домен войны") {
        @Override
        public void applyArchetypeBonusOnCharacter(Character character, Context context) {

        }

        @Override
        public void applyArchetypeLevelBonusOnCharacter(Character character, Context context, int level) {

        }
    },
    CLERIC_KNOWLEDGE("Домен знания") {
        @Override
        public void applyArchetypeBonusOnCharacter(Character character, Context context) {

        }

        @Override
        public void applyArchetypeLevelBonusOnCharacter(Character character, Context context, int level) {

        }
    },
    CLERIC_NATURE("Домен природы") {
        @Override
        public void applyArchetypeBonusOnCharacter(Character character, Context context) {

        }

        @Override
        public void applyArchetypeLevelBonusOnCharacter(Character character, Context context, int level) {

        }
    },
    CLERIC_LIGHT("Домен света") {
        @Override
        public void applyArchetypeBonusOnCharacter(Character character, Context context) {

        }

        @Override
        public void applyArchetypeLevelBonusOnCharacter(Character character, Context context, int level) {

        }
    },
    CLERIC_LIFE("Домен жизни") {
        @Override
        public void applyArchetypeBonusOnCharacter(Character character, Context context) {

        }

        @Override
        public void applyArchetypeLevelBonusOnCharacter(Character character, Context context, int level) {

        }
    },

    WARLOCK_ARCHYFAIRY("Архифея") {
        @Override
        public void applyArchetypeBonusOnCharacter(Character character, Context context) {
            character.getSkills().add(ARCHYFAIRY_ADDITIONAL_SPELLS);
            character.getSkills().add(FAIRY_APPEARANCE);
        }

        @Override
        public void applyArchetypeLevelBonusOnCharacter(Character character, Context context, int level) {
            switch (level) {
                case 6:
                    character.getSkills().add(MISTYS_DISAPPEARANCE);
                    break;
            }
        }
    },
    WARLOCK_FIEND("Исчадие") {
        @Override
        public void applyArchetypeBonusOnCharacter(Character character, Context context) {

        }

        @Override
        public void applyArchetypeLevelBonusOnCharacter(Character character, Context context, int level) {

        }
    },
    WARLOCK_GREAT_ANCIENT("Великий древний") {
        @Override
        public void applyArchetypeBonusOnCharacter(Character character, Context context) {

        }

        @Override
        public void applyArchetypeLevelBonusOnCharacter(Character character, Context context, int level) {

        }
    },

    ROGUE_THIEF("Вор") {
        @Override
        public void applyArchetypeBonusOnCharacter(Character character, Context context) {

        }

        @Override
        public void applyArchetypeLevelBonusOnCharacter(Character character, Context context, int level) {

        }
    },
    ROGUE_KILLER("Убийца") {
        @Override
        public void applyArchetypeBonusOnCharacter(Character character, Context context) {

        }

        @Override
        public void applyArchetypeLevelBonusOnCharacter(Character character, Context context, int level) {
            switch (level) {
                case 3:
                    character.getSkills().add(ADDITIONAL_POSSESSIONS);
                    character.getSkills().add(ELIMINATION);
                    break;
            }
        }
    },
    ROGUE_MYSTICAL_TRICKSTER("Мистический ловкач") {
        @Override
        public void applyArchetypeBonusOnCharacter(Character character, Context context) {

        }

        @Override
        public void applyArchetypeLevelBonusOnCharacter(Character character, Context context, int level) {

        }
    },

    RANGER_HUNTER("Охотник") {
        @Override
        public void applyArchetypeBonusOnCharacter(Character character, Context context) {

        }

        @Override
        public void applyArchetypeLevelBonusOnCharacter(Character character, Context context, int level) {
            switch (level) {
                case 3:
                    character.getNotifications().add(bootyHunter(character,context));
                    break;
            }
        }

        private CustomBuilder bootyHunter(final Character character, final Context context) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(context);
            final CustomBuilder customBuilder = new CustomBuilder(builder, "Добыча охотника");
            final Skill[] styles = new Skill[]{DESTROYER_OF_HORDES, GIANT_SLAYER, KILLER_OF_GIANTS};
            final String[] strings = new String[styles.length];
            for (int i = 0; i < styles.length; ++i) {
                strings[i] = styles[i].getName();
            }
            builder.setItems(strings, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int item) {
                    character.getSkills().add(styles[item]);
                    character.getNotifications().remove(customBuilder);
                }
            });
            builder.setCancelable(true);
            return customBuilder;
        }
    },
    RANGER_BEASTMASTER("Повелитель зверей") {
        @Override
        public void applyArchetypeBonusOnCharacter(Character character, Context context) {

        }

        @Override
        public void applyArchetypeLevelBonusOnCharacter(Character character, Context context, int level) {

        }
    },
    RANGER_FLORAMASTER("Повелитель растений") {
        @Override
        public void applyArchetypeBonusOnCharacter(Character character, Context context) {

        }

        @Override
        public void applyArchetypeLevelBonusOnCharacter(Character character, Context context, int level) {

        }
    },

    SORCERER_DRAGON_BLOOD("Наследие драконьей крови") {
        @Override
        public void applyArchetypeBonusOnCharacter(Character character, Context context) {

        }

        @Override
        public void applyArchetypeLevelBonusOnCharacter(Character character, Context context, int level) {

        }
    },
    SORCERER_WILD_MAGIC("Дикая магия") {
        @Override
        public void applyArchetypeBonusOnCharacter(Character character, Context context) {
            character.getSkills().add(SkillsConstants.FLOW_OF_CHAOS);
        }

        @Override
        public void applyArchetypeLevelBonusOnCharacter(Character character, Context context, int level) {
            switch (level) {
                case 6:
                    character.getSkills().add(DISCIPLINE_GOOD_LUCK);
                    break;
            }
        }
    },
    SORCERER_DECAY("Отмеченный порчей") {
        @Override
        public void applyArchetypeBonusOnCharacter(Character character, Context context) {

        }

        @Override
        public void applyArchetypeLevelBonusOnCharacter(Character character, Context context, int level) {

        }
    };


    public String getName() {
        return name;
    }

    String name;

    Archetype(String string) {
        this.name = string;
    }

    public abstract void applyArchetypeBonusOnCharacter(Character character, Context context);

    public abstract void applyArchetypeLevelBonusOnCharacter(Character character, Context context, int level);

    public static Archetype getArchetypeFromString(String string) {
        for (Archetype archetype : Archetype.values()) {
            if (archetype.getName().equals(string)) {
                return archetype;
            }
        }
        throw new Resources.NotFoundException("Архетип не найден");
    }
}

package com.example.ilidosha.dnd.enities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.widget.Button;
import android.widget.Toast;
import com.example.ilidosha.dnd.R;
import com.example.ilidosha.dnd.Utils.RandomUtils;
import com.example.ilidosha.dnd.database.SkillsConstants;
import com.example.ilidosha.dnd.pages.LayoutPage;

import static com.example.ilidosha.dnd.enities.Performance.PERCEPTION;

public enum Race implements SkillsConstants {
    HALF_ORC("Полуорк") {
        @Override
        public void applyRaceBonusOnCharacter(Character character, Context context) {
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
            character.getSkills().add(DARK_VISION);
            character.getSkills().add(FRIGHTINING_VIEW);
            character.getSkills().add(UNWAVERING_DURABILITY);
            character.getSkills().add(FURY_ATTACKS);
        }
    },
    HALF_ELF("Полуэльф") {

        @Override
        public void applyRaceBonusOnCharacter(final Character character, Context context) {
            for (Stat stat : character.getStats()) {
                switch (stat) {
                    case CHARISMA:
                        stat.setValue(stat.getValue() + 2);
                        break;
                }
            }

            setAdditionalStats(character, context);
            character.getNotifications().add(getHalfElfBonusPerformances(character, context));
            character.setSpeed(30);
            character.getSkills().add(DARK_VISION);
            character.getSkills().add(FARIES_LEGACY);
        }

        private void setAdditionalStats(final Character character, Context context) {
            String[] stats = new String[Stat.values().length];

            for (int i=0;i<Stat.values().length;++i){
                stats[i]=Stat.values()[i].name;
            }

            final boolean[] choose = new boolean[Stat.values().length];

            final AlertDialog.Builder builder = new AlertDialog.Builder(context);
            final CustomBuilder customBuilder = new CustomBuilder(builder,"2 дополнительных характеристики");
            builder.setCancelable(true)
                    .setMultiChoiceItems(stats,null, new DialogInterface.OnMultiChoiceClickListener(){
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i, boolean isChecked) {
                            choose[i]=isChecked;
                        }
                    })
                    .setTitle("Выберите 2 дополнительных характеристики")
                    .setPositiveButton("Применить",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    for (int i=0;i<choose.length;++i){
                                        if(choose[i]) {
                                            character.getStats().get(i).setValue(character.getStats().get(i).getValue()+1);
                                        }
                                    }
                                    character.getNotifications().remove(customBuilder);
                                }
                            })
                    .setNegativeButton("Отмена",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
            character.getNotifications().add(customBuilder);
        }

        @NonNull
        private CustomBuilder getHalfElfBonusPerformances(final Character character, Context context) {
            final String[] performances = new String[Performance.values().length - character.getSpecialization().getSkillsNumber()];
            int i=0;
            for (Performance performance: Performance.values()){
                if (!character.getPerformances().contains(performance)){
                    performances[i++] = performance.getName();
                }
            }

            final boolean[] choose = new boolean[Performance.values().length - character.getSpecialization().getSkillsNumber()];

            final AlertDialog.Builder builder = new AlertDialog.Builder(context);
            final CustomBuilder customBuilder = new CustomBuilder(builder,"2 дополнительных умения");
            builder.setCancelable(true)
                    .setMultiChoiceItems(performances,null, new DialogInterface.OnMultiChoiceClickListener(){
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i, boolean isChecked) {
                            choose[i]=isChecked;
                        }
                    })
                    .setTitle("Выберите 2 дополнительных умения")
                    .setPositiveButton("Применить",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    for (int i=0;i<choose.length;++i){
                                        if(choose[i]) {
                                            character.getPerformances().add(Performance.getPerformanceFromString(performances[i]));
                                        }
                                    }
                                    character.getNotifications().remove(customBuilder);
                                }
                            })
                    .setNegativeButton("Отмена",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
            return customBuilder;
        }
    },
    HIGH_ELD("Высший эльф") {
        @Override
        public void applyRaceBonusOnCharacter(Character character, Context context) {

        }
    },
    FOREST_ELD("Лесной эльф") {
        @Override
        public void applyRaceBonusOnCharacter(Character character, Context context) {
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
            character.getPerformances().remove(PERCEPTION);
            character.getPerformances().add(PERCEPTION);
            character.setSpeed(35);
            character.getSkills().add(DARK_VISION);
            character.getSkills().add(HIGH_SENSITIVITY);
            character.getSkills().add(FARIES_LEGACY);
            character.getSkills().add(TRANCE);
            character.getSkills().add(POSSESSION_OF_ELVEN_WEAPONS);
            character.getSkills().add(FAST_LEGS);
            character.getSkills().add(CAMOUFLAGE);
        }
    },
    DARK_ELF("Тёмный эльф") {
        @Override
        public void applyRaceBonusOnCharacter(Character character, Context context) {

        }
    },
    HALFLING("Полурослик") {
        @Override
        public void applyRaceBonusOnCharacter(Character character, Context context) {
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
            character.getSkills().add(LUCKY);
            character.getSkills().add(BRAVE);
            character.getSkills().add(HALFLING_AGILITY);
            character.getNotifications().add(getHalflingType(character,context));
        }

        private CustomBuilder getHalflingType(final Character character, Context context){
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            final CustomBuilder customBuilder = new CustomBuilder(builder,"Разновидность полурослика");
            final String[] types = new String[]{STOCKY_DURABILITY.getName(), NATURE_STEALTH.getName()};
            builder.setItems(types, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int item) {
                    switch (item){
                        case 0:
                            character.getSkills().add(STOCKY_DURABILITY);

                            Stat body = character.getStats().get(character.getStats().indexOf(Stat.BODY));
                            body.setValue(body.getValue()+1);
                            break;
                        case 1:
                            character.getSkills().add(NATURE_STEALTH);

                            Stat charisma = character.getStats().get(character.getStats().indexOf(Stat.CHARISMA));
                            charisma.setValue(charisma.getValue()+1);
                            break;
                    }
                    character.getNotifications().remove(customBuilder);
                }
            });
            builder.setCancelable(true);
            return customBuilder;
        }
    },
    GNOME("Гном") {
        @Override
        public void applyRaceBonusOnCharacter(Character character, Context context) {

        }
    },
    HUMAN("Человек") {
        @Override
        public void applyRaceBonusOnCharacter(Character character, Context context) {

        }
    },
    TIEFLING("Тифлинг") {
        @Override
        public void applyRaceBonusOnCharacter(Character character, Context context) {
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
            character.getSkills().add(DARK_VISION);
            character.getSkills().add(HELL_RESISTANCE);
            character.getSkills().add(DEVILS_LEGACY);
            character.getSpells().add(RandomUtils.findSpellByName(LayoutPage.spells,"Чудотворство"));
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

    public abstract void applyRaceBonusOnCharacter(Character character, Context context);

    public String getName() {
        return name;
    }

    String name;

    Race(String name) {
        this.name = name;
    }

}

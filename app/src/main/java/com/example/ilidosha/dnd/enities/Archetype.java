package com.example.ilidosha.dnd.enities;

import android.content.res.Resources;

public enum Archetype {
    PALADIN_DEVOTION("Клятва преданности"),
    PALADIN_ANCIENTS("Клятва древних"),
    PALADIN_VENGEANCE("Клятва отмщения"),/*ЗАКЛИНАНИЯ КЛЯТВЫ МЕСТИ
Уровень паладина	Заклинания
3	метка охотника, порча
5	туманный шаг, удержание личности
9	защита от энергии, ускорение
13	изгнание, переносящая дверь
17	наблюдение, удержание чудовища
*/

    BARD_VALOR("Коллегия доблести"),
    BARD_LORE("Коллегия знаний"),
    BARD_ANCIENTS("Коллегия древних"),

    CLERIC_TRICKERY("Домен обмана"),
    CLERIC_STORM("Домен бури"),
    CLERIC_WAR("Домен войны"),
    CLERIC_KNOWLEDGE("Домен знания"),
    CLERIC_NATURE("Домен природы"),
    CLERIC_LIGHT("Домен света"),
    CLERIC_LIFE("Домен жизни"),

    WARLOCK_ARCHYFAIRY("Архифея"),/*РАСШИРЕННЫЙ СПИСОК ЗАКЛИНАНИЙ
Архифея позволяет вам при изучении заклинаний колдуна выбирать из более широкого списка. В ваш список заклинаний колдуна добавляются следующие заклинания.

ДОПОЛНИТЕЛЬНЫЕ ЗАКЛИНАНИЯ АРХИФЕИ
Уровень
заклинания	Заклинания
1	огонь фей, усыпление
2	воображаемая сила, умиротворение
3	мерцание, рост растений
4	высшая невидимость, подчинение зверя
5	подчинение личности, притворство
*/
    WARLOCK_FIEND("Исчадие"),
    WARLOCK_GREAT_ANCIENT("Великий древний"),

    ROGUE_THIEF("Вор"),
    ROGUE_KILLER("Убийца"),
    ROGUE_MYSTICAL_TRICKSTER("Мистический ловкач"),

    RANGER_HUNTER("Охотник"),
    RANGER_BEASTMASTER("Повелитель зверей"),
    RANGER_FLORAMASTER("Повелитель растений"),

    SORCERER_DRAGON_BLOOD("Наследие драконьей крови"),
    SORCERER_WILD_MAGIC("Дикая магия"),
    SORCERER_DECAY("Отмеченный порчей");


    public String getName() {
        return name;
    }

    String name;

    Archetype(String string){
        this.name =string;
    }

    public static Archetype getArchetypeFromString(String string){
        for (Archetype archetype: Archetype.values()){
            if (archetype.getName().equals(string)){
                return archetype;
            }
        }
        throw new Resources.NotFoundException("Архетип не найден");
    }
}

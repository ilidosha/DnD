package com.example.ilidosha.dnd.enities;

import android.app.AlertDialog;
import android.net.Uri;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Character {
    private String name;
    private Race race;
    private Specialization specialization;
    private int level;
    private int masteryLevel = 2;
    private Archetype archetype;
    private List<Item> items=new ArrayList<>();
    private List<Spell> spells=new ArrayList<>();
    private List<Performance> performances = new ArrayList<>();
    private int adult;
    private List<Stat> stats = Arrays.asList(Stat.CHARISMA,Stat.WISDOM,Stat.BODY,Stat.INTELLIGENCE,Stat.AGILITY,Stat.STRENGTH);
    private Health health = new Health();
    private int armoryClass;
    private int initiative;
    private int speed;
    private int experience;
    private boolean inspiration;
    private Personality personality = new Personality();
    private List<String> languages=new ArrayList<>();
    private List<Skill> skills=new ArrayList<>();
    @JsonIgnore
    private Money money = new Money();
    private List<Weapon> weapons=new ArrayList<>();
    private Uri photo;
    @JsonIgnore
    private List<CustomBuilder> notifications = new ArrayList<>();



    public List<CustomBuilder> getNotifications() {
        return notifications;
    }

    public Uri getPhoto() {
        return photo;
    }

    public void setPhoto(Uri photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Race getRace() {
        return race;
    }

    public List<Performance> getPerformances() {
        return performances;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMasteryLevel() {
        return masteryLevel;
    }

    public void setMasteryLevel(int masteryLevel) {
        this.masteryLevel = masteryLevel;
    }

    public Archetype getArchetype() {
        return archetype;
    }

    public void setArchetype(Archetype archetype) {
        this.archetype = archetype;
    }

    public List<Item> getItems() {
        return items;
    }

    public List<Spell> getSpells() {
        return spells;
    }

    public int getAdult() {
        return adult;
    }

    public void setAdult(int adult) {
        this.adult = adult;
    }

    public Health getHealth() {
        return health;
    }

    public int getArmoryClass() {
        return armoryClass;
    }

    public void setArmoryClass(int armoryClass) {
        this.armoryClass = armoryClass;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public boolean isInspiration() {
        return inspiration;
    }

    public void setInspiration(boolean inspiration) {
        this.inspiration = inspiration;
    }

    public Personality getPersonality() {
        return personality;
    }

    public void setPersonality(Personality personality) {
        this.personality = personality;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public Money getMoney() {
        return money;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public List<Stat> getStats() {
        return stats;
    }

    public void setStats(List<Stat> stats) {
        this.stats = stats;
    }
}

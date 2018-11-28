package com.example.ilidosha.dnd.enities;

public class Spell {
    String name;
    int level;
    String school;
    String overlayTime;
    int distance;
    String components;
    String duration;
    String classes;
    String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getOverlayTime() {
        return overlayTime;
    }

    public void setOverlayTime(String overlayTime) {
        this.overlayTime = overlayTime;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getComponents() {
        return components;
    }

    public void setComponents(String components) {
        this.components = components;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Spell(String name, int level, String school, String overlayTime, int distance, String components, String duration, String classes, String description) {
        this.name = name;
        this.level = level;
        this.school = school;
        this.overlayTime = overlayTime;
        this.distance = distance;
        this.components = components;
        this.duration = duration;
        this.classes = classes;
        this.description = description;
    }
}

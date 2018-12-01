package com.example.ilidosha.dnd.enities;

public class Skill {
    private String name;
    private String description;

    public Skill(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Skill() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

package com.example.ilidosha.dnd.enities;

public class Health {
    int currentHP;
    int maxHP;
    int hpDices;
    int temporaryHP;

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getHpDices() {
        return hpDices;
    }

    public void setHpDices(int hpDices) {
        this.hpDices = hpDices;
    }

    public int getTemporaryHP() {
        return temporaryHP;
    }

    public void setTemporaryHP(int temporaryHP) {
        this.temporaryHP = temporaryHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }
}

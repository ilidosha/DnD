package com.example.ilidosha.dnd.enities;

public class SpellCells {
    private int[] maxLevel = new int[9];
    private int[] level = new int[9];

    public int[] getMaxLevel() {
        return maxLevel;
    }

    public int[] getLevel() {
        return level;
    }

    public void setMax(int lvl, int value){
        maxLevel[lvl-1]=value;
    }

    public void setCurrent(int lvl, int value){
        level[lvl-1]=value;
    }

    public int getMax(int lvl){
        return maxLevel[lvl-1];
    }

    public int getCurrent(int lvl){
        return level[lvl-1];
    }
}

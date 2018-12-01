package com.example.ilidosha.dnd.enities;

public class Item {
    String name;
    Money cost;

    public Item() {
    }

    public Item(String name, Money cost) {
        this.name = name;
        this.cost = cost;
    }

    public void setItemName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    public void setCost(Money cost){
        this.cost=cost;
    }
    public  Money getCost(){
        return this.cost;
    }
}

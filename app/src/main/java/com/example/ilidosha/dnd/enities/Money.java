package com.example.ilidosha.dnd.enities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

public class Money implements Serializable {

    int money;
    int cooperGold=100;
    int cooperPlatinum=1000;
    int cooperCooper=1;
    int cooperSilver=10;
    int cooperElectrum=50;

    public Money() {
    }

    @JsonIgnore
    public int getCooper(){
        return (money/cooperCooper)%10;
    }
    @JsonIgnore
    public int getSilver(){
        return (money/cooperCooper)%5;
    }
    @JsonIgnore
    public int getElectrum(){
        return (money/cooperElectrum)%2;
    }
    @JsonIgnore
    public int getGold(){
        return (money/cooperGold)%10;
    }
    @JsonIgnore
    public int getPlatinum(){
        return money/cooperPlatinum;
    }
    @JsonValue
    public int getMoney(){
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Money getMoneyFromInt(int money){
        Money result = new Money();
        result.setMoney(money);
        return result;
    }

}

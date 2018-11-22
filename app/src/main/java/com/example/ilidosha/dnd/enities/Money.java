package com.example.ilidosha.dnd.enities;

public class Money {
    int money;
    int cooperGold=100;
    int cooperPlatinum=1000;
    int cooperCooper=1;
    int cooperSilver=10;
    int cooperElectrum=50;

    public int getCooper(){
        return (money/cooperCooper)%10;
    }

    public int getSilver(){
        return (money/cooperCooper)%5;
    }

    public int getElectrum(){
        return (money/cooperElectrum)%2;
    }

    public int getGold(){
        return (money/cooperGold)%10;
    }

    public int getPlatinum(){
        return money/cooperPlatinum;
    }

    public int getMoney(){
        return money;
    }

}

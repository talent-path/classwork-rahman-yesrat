package com.tp.rpg.weapons;

public class Fist extends Weapon {
    public Fist(){
        super();
    }
    @Override
    public String getComLine(){
        return "Attack with Fist";
    }

    @Override
    public String getComEffectiveLine(){
        return "Uses strength to power the attack of the fist";
    }
}

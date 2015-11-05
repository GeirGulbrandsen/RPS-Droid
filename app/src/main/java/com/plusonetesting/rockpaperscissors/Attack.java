package com.plusonetesting.rockpaperscissors;

/**
 * Created by geirgulabrandsen on 05/11/15.
 */
public class Attack {

    private String weapon = "generic";
    private String winsOver = "all";

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getWinsOver() {
        return winsOver;
    }

    public void setWinsOver(String winsOver) {
        this.winsOver = winsOver;
    }
}

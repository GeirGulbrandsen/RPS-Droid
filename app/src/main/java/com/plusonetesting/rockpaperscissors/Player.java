package com.plusonetesting.rockpaperscissors;

public class Player {

    private String name;
    private Attack attack;

    public void setAttack(String weapon) {

        switch (weapon) {
            case "Rock":
                this.attack = new AttackRock();
                break;
            case "Paper":
                this.attack = new AttackPaper();
                break;
            case "Scissors":
                this.attack = new AttackScissors();
                break;
            default:
                break;
        }
    }

    public String getAttack() {
        return attack.getWeapon();
    }

    public String getWinsOver() {
        return attack.getWinsOver();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

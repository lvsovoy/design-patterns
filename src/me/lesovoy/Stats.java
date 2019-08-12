package me.lesovoy;

public class Stats {
    int health;
    int energy;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public Stats(int health, int energy) {
        this.health = health;
        this.energy = energy;
    }
}

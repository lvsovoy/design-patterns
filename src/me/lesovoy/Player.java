package me.lesovoy;

public class Player {
    String name;
    PlayerClass playerClass;
    Stats stats;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerClass getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(PlayerClass playerClass) {
        this.playerClass = playerClass;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public String playerInfo(){
        return this.playerClass + " " + this.name + "|| \thealth:" + this.getStats().health + " \t || energy:" + this.getStats().energy;
    }
}

package me.lesovoy;

public class Player {
    private String name;
    private PlayerClass playerClass;
    private Stats stats;

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
        return this.playerClass + " \t" + this.name + " || \thealth:" + this.getStats().health + " \t|| energy:" + this.getStats().energy;
    }

    public boolean hasPassedOut() {
        return this.stats.health <= 0;
    }

    public boolean canCast(Ability ability) {
        return this.stats.energy >= ability.consumption;
    }
}

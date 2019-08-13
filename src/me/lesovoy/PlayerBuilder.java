package me.lesovoy;

//creational - builder
public class PlayerBuilder {
    String name;
    PlayerClass playerClass;
    Stats stats;

    public PlayerBuilder() {
    }

    public PlayerBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public PlayerBuilder withClass(PlayerClass playerClass) {
        this.playerClass = playerClass;
        return this;
    }

    public PlayerBuilder withStats(Stats stats) {
        this.stats = stats;
        return this;
    }

    public Player build() {
        Player player = new Player();
        player.setName(name);
        player.setPlayerClass(playerClass);
        player.setStats(new Stats(30, 2));
        return player;
    }
}

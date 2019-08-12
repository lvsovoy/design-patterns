package me.lesovoy;

import java.util.Optional;

public class PlayerBuilder {
    String name;
    PlayerClass playerClass;
    Optional<Stats> stats = Optional.empty();

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
        this.stats = Optional.of(stats);
        return this;
    }

    public Player build() {
        Player player = new Player();
        player.setName(name);
        player.setPlayerClass(playerClass);
        player.setStats(Optional.ofNullable(stats)
                .orElse(Optional.of(new Stats(100,5))).get());
        return player;
    }


}

package me.lesovoy.gamemode;

import me.lesovoy.player.Ability;
import me.lesovoy.player.Player;

import java.util.ArrayList;
import java.util.List;

public interface Fight {

    void init();

    void fight();

    default void drawConclusion(List<Player> players) {
        Player defeated = players.stream()
                .filter(player -> player.hasPassedOut())
                .findFirst()
                .orElse(null);
        Player victor = players.stream()
                .filter(player -> !player.hasPassedOut())
                .findFirst()
                .orElse(null);
        System.out.println("The battle has concluded.");
        try {
            System.out.println("Victor: \t" + victor.playerInfo());
            System.out.println("Defeated: \t" + defeated.playerInfo());
        } catch (Exception e) {
            System.out.println("It seems that none were left standing.");
        }
    }

    default boolean noonePassedOut(List<Player> players) {
        return players.stream()
                .noneMatch(player -> player.hasPassedOut());
    }

    default void castRandomAbility(Player player, Player victim) {
        Ability ability = player.getPlayerClass().getRandomAbility();
        if (player.canCast(ability)) {
            ability.castAbility(player, victim);
        } else {
            System.out.println(player.getName() + " tried to cast " + ability.name + " but had not enough energy");
        }
    }

    default void castAbility(Player player, Player victim, Ability ability) {
        if (player.canCast(ability)) {
            ability.castAbility(player, victim);
        } else {
            System.out.println(player.getName() + " tried to cast " + ability.name + " but had not enough energy");
        }
    }

    default void regenEnergy(Player player) {
        player.getStats().energy += player.getPlayerClass().regen;
    }
}

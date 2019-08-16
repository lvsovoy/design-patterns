package me.lesovoy.gamemode;

import me.lesovoy.player.Player;
import me.lesovoy.player.PlayerBuilder;
import me.lesovoy.player.PlayerClass;
import me.lesovoy.utility.GUI;

import java.util.List;

//structural - facade? /behavioral - command
public class AutoFight implements Fight {
    List<Player> players;

    GUI gui = new GUI();

    public AutoFight(List<Player> players) {
        this.players = players;
    }

    public void init() {
        System.out.println("Initializing players...");

        players.add(new PlayerBuilder()
                .withName("Vasiliy")
                .withClass(PlayerClass.getRandomClass())
                .build());

        players.add(new PlayerBuilder()
                .withName("Mihanya")
                .withClass(PlayerClass.getRandomClass())
                .build());

        players.forEach(player ->
                System.out.println(player.playerInfo()));

    }

    public void fight() {
        System.out.println("The battle commences!");
        while (noonePassedOut(players)) {
            castRandomAbility(players.get(0), players.get(1));
            castRandomAbility(players.get(1), players.get(0));
            gui.hr();
            players.forEach(player -> {
                regenEnergy(player);
                System.out.println(player.playerInfo());
            });
        }
    }


}

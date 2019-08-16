package me.lesovoy.gamemode;

import me.lesovoy.player.Player;
import me.lesovoy.player.PlayerBuilder;
import me.lesovoy.player.PlayerClass;
import me.lesovoy.utility.GUI;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Scanner;

public class ManualFight implements Fight {
    List<Player> players;

    GUI gui = new GUI();
    Scanner sc = new Scanner(System.in);

    public ManualFight(List<Player> players) {
        this.players = players;
    }

    public void init() {
        Player realPlayer = new Player();
        System.out.print("Name your character: ");
        realPlayer.setName(StringUtils.lowerCase(sc.next()));
        System.out.println("Choose a class:");
        realPlayer.setPlayerClass(PlayerClass.getClassByNumber(gui.buttons("WARRIOR", "SORCERER", "PALADIN")));

        players.add(new PlayerBuilder()
                .withName(StringUtils.capitalize(realPlayer.getName()))
                .withClass(realPlayer.getPlayerClass())
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
            castAbility(players.get(0), players.get(1), players.get(0).getPlayerClass().selectAbility());
            castRandomAbility(players.get(1), players.get(0));
            gui.hr();
            players.forEach(player -> {
                regenEnergy(player);
                System.out.println(player.playerInfo());
            });
        }
    }
}


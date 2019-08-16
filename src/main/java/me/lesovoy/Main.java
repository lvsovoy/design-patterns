package me.lesovoy;

import me.lesovoy.gamemode.AutoFight;
import me.lesovoy.gamemode.Fight;
import me.lesovoy.gamemode.ManualFight;
import me.lesovoy.player.Player;
import me.lesovoy.utility.GUI;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static GUI gui = new GUI();
    static List<Player> players = new ArrayList();


    public static void main(String[] args) {
        System.out.println("Welcome to the tournament!");
        gameLoop();
    }

    private static Fight chooseGamemode() {
        System.out.println("Choose a gamemode:");
        switch (gui.buttons("MANUAL", "AUTOMATIC")) {
            case 1:
                return new ManualFight(players);
            case 2:
                return new AutoFight(players);
            default:
                System.out.println("something happened, but we started an automatic mode tho");
                return new AutoFight(players);
        }
    }

    private static void gameLoop() {
        Fight fight = chooseGamemode();
        fight.init();
        fight.fight();
        fight.drawConclusion(players);

        System.out.println("Play again?");
        if (gui.buttons("YES", "NO") == 1) {
            players.clear();
            gameLoop();
        } else {
            System.out.println("Farewell!");
        }
    }
}


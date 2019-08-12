package me.lesovoy;

import java.util.ArrayList;
import java.util.List;

public class Fight {
    static List<Player> players = new ArrayList();

    public static void init() {
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




}

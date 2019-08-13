package me.lesovoy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//structural - facade? /behavioral - command
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

    public static void autoFight() {
        System.out.println("The battle commences!");
        while (noonePassedOut()) {
            castAbility(players.get(0), players.get(1));
            castAbility(players.get(1), players.get(0));
            players.forEach(player -> {
                regenEnergy(player);
                System.out.println(player.playerInfo());
            });
        }
    }

    // behavioral - iterator
    public static void drawConclusion() {
        Iterator<Player> iterator = players.iterator();
        Player victor = null;
        Player defeated = null;
        while (iterator.hasNext()) {
            Player player = iterator.next();
            if (player.hasPassedOut()) {
                defeated = player;
            } else {
                victor = player;
            }
        }
//        Player defeated = players.stream()
//                .filter(player -> player.hasPassedOut())
//                .findFirst()
//                .orElse(null);
//        Player victor = players.stream()
//                .filter(player -> !player.hasPassedOut())
//                .findFirst()
//                .orElse(null);
        System.out.println("The battle has concluded.");
        try {
            System.out.println("Victor: \t" + victor.playerInfo());
            System.out.println("Defeated: \t" + defeated.playerInfo());
        } catch (Exception e) {
            System.out.println("It seems that none were left standing.");
        }
    }

    private static boolean noonePassedOut() {
        return !players.stream()
                .anyMatch(player -> player.hasPassedOut());
    }

    private static void castAbility(Player player, Player victim) {
        Ability ability = player.getPlayerClass().getRandomAbility();
        if (player.canCast(ability)) {
            ability.castAbility(player, victim);
        } else {
            System.out.println(player.getName() + " tried to cast " + ability.name + " but had not enough energy");
        }
    }

    private static void regenEnergy(Player player) {
        player.getStats().energy += player.getPlayerClass().regen;
    }
}

package me.lesovoy.utility;

import me.lesovoy.player.Ability;

import java.util.List;
import java.util.Scanner;

public class GUI {
    Scanner sc = new Scanner(System.in);

    public int buttons(String... buttons) {
        //draw
        for (int i = 0; i < buttons.length; i++) {
            System.out.print(String.format("[%d.%s]", i + 1, buttons[i]));
        }
        // read, validate and return
        return readUserInput(0, buttons.length);
    }

    public int buttons(List<Ability> abilities) {
        //draw
        for (int i = 0; i < abilities.size(); i++) {
            System.out.println(String.format("[%d.%s || %S: %d COST: %d]", i + 1, abilities.get(i).name, abilities.get(i).type.name(), abilities.get(i).effect, abilities.get(i).consumption));
        }
        // read, validate and return
        return readUserInput(0, abilities.size());
    }

    public void hr() {
        System.out.println("-------------------------------------------");
    }

    private int readUserInput(int min, int max) {
        String input = sc.next();
        if (isValid(input, min, max)) {
            return Integer.parseInt(input);
        } else {
            return readUserInput(min, max);
        }
    }

    private boolean isValid(String input, int min, int max) {
        int intInput = 0;
        try {
            intInput = Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println("not a number!");
            return false;
        }
        if (intInput > min && intInput <= max) {
            return true;
        } else {
            System.out.println("out of input range!");
            return false;
        }
    }


}

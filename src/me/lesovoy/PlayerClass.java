package me.lesovoy;

import java.util.Arrays;
import java.util.List;

public enum PlayerClass {
    WARRIOR(2, Arrays.asList(
            new Ability("Kick", 3,1),
            new Ability("Smash", 5, 3),
            new Ability("Obliterate", 8, 5))),
    MAGE(5, Arrays.asList(
            new Ability("Fireball", 3,3),
            new Ability("Fire Storm", 6, 5),
            new Ability("Throw Magma", 9, 8))),
    PALADIN(4, Arrays.asList(
            new Ability("Prayer", 4,1),
            new Ability("Holy Hammer", 5, 3),
            new Ability("Inquisition", 7, 5)));

    int regen;
    List<Ability> abilities;

    PlayerClass(int regen, List<Ability> abilities) {
        this.regen = regen;
        this.abilities = abilities;
    }
}

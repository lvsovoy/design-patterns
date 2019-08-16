package me.lesovoy.player;

import me.lesovoy.utility.GUI;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static me.lesovoy.player.AbilityType.*;


// creational - singleton
public enum PlayerClass {
    WARRIOR(2, Arrays.asList(
            new Ability("Kick", 3, 1, DAMAGE),
            new Ability("Smash", 5, 3, DAMAGE),
            new Ability("Obliterate", 8, 5, DAMAGE),
            new Ability("Rage", 4, 2, ENERGY_REGEN))),
    SORCERER(4, Arrays.asList(
            new Ability("Fireball", 3, 3, DAMAGE),
            new Ability("Fire Storm", 6, 5, DAMAGE),
            new Ability("Throw Magma", 9, 8, DAMAGE),
            new Ability("Sacrifice Soul", 5, 3, ENERGY_REGEN))),
    PALADIN(3, Arrays.asList(
            new Ability("Prayer", 2, 1, HEAL),
            new Ability("Holy Hammer", 5, 3, DAMAGE),
            new Ability("Inquisition", 7, 5, DAMAGE),
            new Ability("Martyrdom", 3, 3, ENERGY_REGEN)));

    public int regen;
    public List<Ability> abilities;

    private static Random random = new Random();
    GUI gui = new GUI();

    PlayerClass(int regen, List<Ability> abilities) {
        this.regen = regen;
        this.abilities = abilities;
    }

    public static PlayerClass getRandomClass() {
        return values()[random.nextInt(values().length)];
    }

    public static PlayerClass getClassByNumber(int number) {
        return values()[number - 1];
    }

    public Ability getRandomAbility() {
        return abilities.get(random.nextInt(abilities.size()));
    }

    public Ability selectAbility() {
        return abilities.get(gui.buttons(this.abilities) - 1);
    }
}

package me.lesovoy;

public class Ability {
    String name;
    int effect;
    int consumption;
    AbilityType type;

    public Ability(String name, int effect, int consumption, AbilityType type) {
        this.name = name;
        this.effect = effect;
        this.consumption = consumption;
        this.type = type;
    }

    public void castAbility(Player player, Player victim) {
        this.type.cast(this, player, victim);
    }
}

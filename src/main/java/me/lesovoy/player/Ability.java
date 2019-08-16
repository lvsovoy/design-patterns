package me.lesovoy.player;

public class Ability {
    public String name;
    public int effect;
    public int consumption;
    public AbilityType type;

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

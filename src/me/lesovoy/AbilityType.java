package me.lesovoy;

//behavioral - state
public enum AbilityType {
    DAMAGE {
        public void cast(Ability ability, Player player, Player victim) {
            victim.getStats().health -= ability.effect;
            player.getStats().energy -= ability.consumption;
            System.out.println(player.getName() + " cast " + ability.name + " for " + ability.effect + " damage.");
        }
    },
    HEAL {
        public void cast(Ability ability, Player player, Player victim) {
            player.getStats().health += ability.effect;
            player.getStats().energy -= ability.consumption;
            System.out.println(player.getName() + " cast " + ability.name + " for " + ability.effect + " healing.");
        }
    },
    ENERGY_REGEN { // deal damage to yourself to get more energy
        public void cast(Ability ability, Player player, Player victim) {
            player.getStats().health -= ability.consumption;
            player.getStats().energy += ability.effect;
            System.out.println(player.getName() + " cast " + ability.name + " for " + ability.consumption + " damage to themselves and regenerated " + ability.effect + " energy");
        }
    };

    abstract void cast(Ability ability, Player player, Player victim);

    AbilityType() {
    }
}

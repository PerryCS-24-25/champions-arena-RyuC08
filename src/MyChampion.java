import java.util.List;
import java.util.ArrayList;

/**
 * Your champion. Change the class name, the name field, and make it yours!
 */
public class MyChampion extends Champion {
    public static final String NAME = "LeBron";

    public MyChampion() {
        // Create a champion with an attack of 5, a defense of 5, and max health of 40
        super("My Champion", 100, 100, 400);
    }

    @Override
    public List<Action> getActions() {
        List<Action> actions = new ArrayList<>(super.getActions());
        actions.add(new Jab()); // Replace with your custom actions
        return actions;
    }


}

class Dunk extends Action{
    public Dunk(){
        super("Dunk");
    }
    /**
     * Executes the Headbutt action.
     * This action deals 8 damage to the opponent.
     * @param context The context of the battle, including the wielder and enemy.
     */
    @Override
    public void execute(BattleContext context) {
        final int baseDamage = 8;
        final int actualDamage = context.enemy.takeDamage(baseDamage, context);

        context.getLog().addEntry(
            context.wielder, context.enemy, getName(),
            context.wielder.getName() + " dunks on " + context.enemy.getName() + " for " + actualDamage + " damage!",
            context.round, BattleLog.EntryType.ACTION
        );
    }
}
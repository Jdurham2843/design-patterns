package behavioral.strategy;

public class MeleeStrategy implements DragonSlayerStrategy {
    @Override
    public void execute() {
        System.out.println("Hack slash slash. You die!");
    }
}

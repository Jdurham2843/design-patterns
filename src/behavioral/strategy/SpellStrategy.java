package behavioral.strategy;

public class SpellStrategy implements DragonSlayerStrategy {
    @Override
    public void execute() {
        System.out.println("Whoosh Whoosh Whoosh! You die!");
    }
}

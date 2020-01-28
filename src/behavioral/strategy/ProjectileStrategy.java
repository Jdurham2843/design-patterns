package behavioral.strategy;

public class ProjectileStrategy implements DragonSlayerStrategy {
    @Override
    public void execute() {
        System.out.println("Pew pew pew. You die!");
    }
}

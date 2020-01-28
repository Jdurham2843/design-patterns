package behavioral.strategy;

public class DragonSlayer {
    private DragonSlayerStrategy dragonSlayerStrategy;

    public DragonSlayer(DragonSlayerStrategy dragonSlayerStrategy) {
        this.dragonSlayerStrategy = dragonSlayerStrategy;
    }

    public void changeStrategy(DragonSlayerStrategy dragonSlayerStrategy) {
        this.dragonSlayerStrategy = dragonSlayerStrategy;
    }

    public void goToBattle() {
        dragonSlayerStrategy.execute();
    }
}

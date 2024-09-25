package strategy;

import java.util.List;

public class strategyCreateVegetable implements StrategyCreateCollection {
    @Override
    public List<?> createCollectionFromFile(String fileName) {
        return List.of();
    }

    @Override
    public List<?> createCollectionRandom(String fileName) {
        return List.of();
    }
}

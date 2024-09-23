package strartegy;

import java.util.List;

public class StrategyCreateBook implements StrategyCreateCollection {
    @Override
    public List<?> createCollectionFromFile(String fileName) {
        return List.of();
    }

    @Override
    public List<?> createCollectionRandom(String fileName) {
        return List.of();
    }
}

package strategy;

import java.util.List;

public interface StrategyCreateCollection {
    List<?> createCollectionFromFile(String fileName);
    List<?> createCollectionRandom(String fileName);

}

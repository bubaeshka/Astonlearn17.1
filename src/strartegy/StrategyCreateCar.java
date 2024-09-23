package strartegy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class StrategyCreateCar implements StrategyCreateCollection {
    private BufferedReader br;

    @Override
    public List<?> createCollectionFromFile(String fileName) {
        return List.of();
    }

    @Override
    public List<?> createCollectionRandom(String fileName) {
        return List.of();
    }
}

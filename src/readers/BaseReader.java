package readers;

import java.util.List;

import domain.Thing;
import readingstrategy.BaseReadingStrategy;

public abstract class BaseReader<T extends Thing> {
    BaseReadingStrategy strategy;

    public BaseReader(BaseReadingStrategy strategy) {
        this.strategy = strategy;
    }
    public abstract List<T> read();

}

package readers;

import java.util.List;

import ReadingStrategy.BaseReadingStrategy;
import domain.Thing;

public abstract class BaseReader<T extends Thing> {
    BaseReadingStrategy strategy;

    public BaseReader(BaseReadingStrategy strategy) {
        this.strategy = strategy;
    }
    public abstract List<T> read();

}

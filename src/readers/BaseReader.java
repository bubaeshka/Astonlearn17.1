package readers;

import java.util.List;
import domain.Thing;

import ReadingStrategy.BaseReadingStrategy;

public abstract class BaseReader<T extends Thing> {
    BaseReadingStrategy<T> strategy;

    public BaseReader(BaseReadingStrategy<T> strategy) {
        this.strategy = strategy;
    }

    public abstract List<T> read();

}

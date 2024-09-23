package readers;

import java.util.List;

import ReadingStrategy.BaseReadingStrategy;
import domain.Thing;

public abstract class BaseReader {
    BaseReadingStrategy strategy;

    public BaseReader(BaseReadingStrategy strategy) {
        this.strategy = strategy;
    }
    public abstract List<Thing>  read();   

}

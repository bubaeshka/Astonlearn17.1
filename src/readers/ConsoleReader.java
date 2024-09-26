package readers;

import ReadingStrategy.BaseReadingStrategy;

import java.util.ArrayList;
import java.util.List;

public class ConsoleReader <T> extends BaseReader{

    public ConsoleReader(BaseReadingStrategy strategy) {
        super(strategy);
    }

    public List<T> read() {
        return null;
    }
}

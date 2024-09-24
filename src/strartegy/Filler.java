package strartegy;

import domain.Thing;

import java.util.List;

public interface Filler{
    List<?> fillCollection(String fileName, List<?> list);

}

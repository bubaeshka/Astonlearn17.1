package strartegy;


import readingStrategy.CarReadingStrategy;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileFiller implements Filler {

    //Читает из файла и создаёт масив строк
    //парсит полученную строку
    //получаетя три поля, для создания экземпляра
    //создаёт экземпляр и добавляет в коллекцию.И так пока не кончится массив полученых строк
    // метод не доделан, нужно всё собрать и можно будет дальше пытатсья собрать и доделать его 

    @Override
    public List<?> fillCollection(String fileName, List<?> list) {
        List<String> strings = readFile(fileName);
        for (int i = 0; i < strings.size(); i++) {
            String[] fieldValue = parsingString(strings.get(i));
            String field0 = fieldValue[0];
            String field1 = fieldValue[1];
            String field2 = fieldValue[2];
            //Создание экземпляры класса
            // добавление его в коллекцию
        }
        return list;
    }

    public List<String> readFile(String fileName) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Path.of(fileName), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }

    public String[] parsingString(String lines) {
        String[] parsingString = lines.split(",");
        return parsingString;
    }


}

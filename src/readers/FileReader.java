package readers;

import domain.Thing;
import readingstrategy.BaseReadingStrategy;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader<T extends Thing> extends BaseReader<T> {
    private final int count;

    public FileReader(BaseReadingStrategy strategy, int count) {
        super(strategy);
        this.count = count;
    }

    @Override
    public List<T> read() {
        List<String> fileStrings = null;
        do {
            try {
                System.out.println("Введите имя файла (относительно папки пользователя): ");
                String relativePath = new Scanner(System.in).next();
                String absoluteFilePath = System.getProperty("user.home")
                        + FileSystems.getDefault().getSeparator()
                        + relativePath;
                fileStrings = readFile(absoluteFilePath);
            } catch (RuntimeException e) {
                System.out.println("Файл не найден. Попробуйте еще раз");
            }
        } while (fileStrings == null);

        ArrayList<Thing> collection = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String[] fields = parsingString(fileStrings.get(i));
            if (!strategy.validate(fields).isValid) {
                i--;
                continue;
            }

            collection.add(strategy.createThing(fields));

        }
        return (List<T>) collection;
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

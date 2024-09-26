package controller;

import ReadingStrategy.BookReadingStrategy;
import ReadingStrategy.CarReadingStrategy;
import ReadingStrategy.VegetableReadingStrategy;
import domain.Car;
import domain.Vegetable;
import readers.BaseReader;
import readers.ConsoleReader;
import readers.RandomReader;
import utility.Utility;

import java.awt.print.Book;
import java.util.*;
import java.util.stream.Collectors;

public class MainController {
    private List container;
    private BaseReader reader;

    private static final class Holder {
        private static final MainController INSTANCE = new MainController();
    }

    public static MainController getInstance() {
        return Holder.INSTANCE;
    }

    public void run() {
        System.out.println("НАЧАЛО\n");

        while (true) {
            CollectionType collectionType;
            do {
                collectionType = enterCollectionType();
            } while (collectionType == null);

            Integer elementsNum;
            do {
                elementsNum = enterElementsNumber();
            } while (elementsNum == null);

            CreationType creationType;
            do {
                creationType = enterCreationType();
            } while (creationType == null);

            defineReader(collectionType, creationType, elementsNum);
            if (reader != null) container = reader.read();

            System.out.println("\nИсходная коллекция: \n" + container);
            Utility.sort(container);
            System.out.println("\nОтсортированная коллекция: \n" + container);

            String exit = exit();
            if (!exit.equalsIgnoreCase("y")) {
                System.out.println("КОНЕЦ");
                System.exit(0);
            }
        }

    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.printf(message);
        return in.nextLine();
    }

    private CollectionType enterCollectionType() {
        var options = "\n" + Arrays.stream(CollectionType.values())
                .map(option -> "    %d. %s"
                        .formatted(option.ordinal() + 1,
                                option.getName()))
                .collect(Collectors.joining("\n"));

        String input = prompt("""
                Введите тип объектов: %s
                """.formatted(options));
        for (CollectionType type : CollectionType.values()) {
            for (String pseudonym : type.getPseudonyms()) {
                if (input.equals(pseudonym)) return type;
            }
        }
        System.out.println("Некорректный тип объектов. Попробуйте снова.");
        return null;
    }

    private Integer enterElementsNumber() {
        try {
        return Integer.valueOf(prompt("Введите количество объектов: "));
        } catch (java.lang.NumberFormatException e) {
            System.out.println("Некорректное количество объектов. Попробуйте снова.");
        }
        return null;
    }



    private CreationType enterCreationType() {
        var options = "\n" + Arrays.stream(CreationType.values())
                .map(option -> "    %d. %s"
                        .formatted(option.ordinal() + 1,
                                option.getName()))
                .collect(Collectors.joining("\n"));

        String input = prompt("""
                Введите способ ввода данных: %s
                """.formatted(options));
        for (CreationType type : CreationType.values()) {
            for (String pseudonym : type.getPseudonyms()) {
                if (input.equals(pseudonym)) return type;
            }
        }
        System.out.println("Некорректный способ ввода. Попробуйте снова.");
        return null;
    }

    /*
    private Integer enterCreationType() {
        return Integer.valueOf(prompt("""
                Введите способ ввода данных:
                    1. %s;
                    2. %s;
                    3. %s
                """.formatted(CreationType.MANUAL.getName(),
                    CreationType.FILE.getName(),
                    CreationType.RANDOM.getName()))
        );
    }
    */


    private String exit() {
        Scanner in = new Scanner(System.in);
        System.out.println("\nПродолжить?... (y/n)");
        return in.nextLine();
    }
    /*
    //метод, который будет определять какого типа будет коллекция
    private void defineContainer(CollectionType collectionType) {
        container = switch (collectionType) {
            case CollectionType.CAR -> new ArrayList<Car>();
            case CollectionType.BOOK  -> new ArrayList<Book>();
            case CollectionType.VEGETABLE  -> new ArrayList<Vegetable>();
        };
    }
    */

/*
        if (typeCollection.equals("Book")) {
            return list = new ArrayList<Book>();
        } else if (typeCollection.equals("Car")) {
//            return list = new ArrayList<domain.Car>();
        } else if (typeCollection.equals("Root vegetable")) {
//            return new ArrayList<Vegetable>();
        }
        return null;
    } */

    // определение типа создания коллекции(чтение из файла, рандомное создание, ввод с консоли)
    private void defineReader(CollectionType collectionType, CreationType creationType, int elementsNum) {
        var readingStrategy = switch (collectionType) {
            case CollectionType.CAR -> new CarReadingStrategy();
            case CollectionType.BOOK  -> new BookReadingStrategy();
            case CollectionType.VEGETABLE  -> new VegetableReadingStrategy();
        };
        reader = switch (creationType) {
            case CreationType.MANUAL -> new ConsoleReader<>(readingStrategy);
            //case CreationType.FILE  -> new FileReader<>();
            case CreationType.RANDOM -> new RandomReader<>(readingStrategy, elementsNum);
            default -> null;
        };
        /*
        if (typeCreate.equals("Read file.")) {
            //вызов метода читалки из файла
        } else if (typeCreate.equals("Random creating.")) {
            //вызов метода создания рандомных элементов
        }
        else if (typeCreate.equals("Console input. ")) {
            // читать с консоли
        } */
    }

    //заполняет коллекцию элементами выбранного класса
    private void fillCollection(List list, String typeCollection,int countElement) {

    }




}

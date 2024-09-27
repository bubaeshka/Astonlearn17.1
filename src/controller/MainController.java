package controller;

import domain.Car;
import domain.Book;
import domain.Thing;
import domain.Vegetable;
import readers.BaseReader;
import readers.ConsoleReader;
import readers.FileReader;
import readers.RandomReader;
import readingstrategy.BookReadingStrategy;
import readingstrategy.CarReadingStrategy;
import readingstrategy.VegetableReadingStrategy;
import utility.Utility;

import java.util.*;
import java.util.stream.Collectors;

public class MainController {
    private final int SORTING_COMMON = 1;
    private final int SORTING_STRANGE = 2;

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

            CreationType creationType;
            do {
                creationType = enterCreationType();
            } while (creationType == null);

            defineReader(collectionType, creationType);
            if (reader != null) container = reader.read();

            System.out.println("\nИсходная коллекция: \n" + container);

            int mode = selectSortingMode();
            switch (mode) {
                case SORTING_COMMON -> callKeySortController(collectionType);
                case SORTING_STRANGE -> callStrangeSortController(collectionType);
                }

            System.out.println("\nОтсортированная коллекция: \n" + container);
            boolean isSucceed;
            do {
                isSucceed = searchQuery(collectionType);

            } while (!isSucceed);

            do {
                isSucceed = continueQuery();
            } while (!isSucceed);
        }

    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.printf(message);
        return in.nextLine();
    }

    private int selectSortingMode() {
        int mode = 0;
        do {
            try {
                mode = Integer.valueOf(prompt("""
                           Выберите режим сортировки:
                            1. Обычный
                            2. "Странный"
                           """));
                if (mode < SORTING_COMMON || mode > SORTING_STRANGE) {
                    System.out.println("Некорректное числовое значение. Попробуйте снова.");
                }
            } catch (java.lang.NumberFormatException e) {
                System.out.println("Некорректный формат данных. Попробуйте снова.");
            }
        } while (mode == 0);

        return mode;
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

    private boolean searchQuery(CollectionType collectionType) {
        Scanner in = new Scanner(System.in);
        System.out.println("\nВыполнить поиск объекта?... (y/n)");

        if (handleQuery(in.nextLine(), false)) {
            CreationType creationType = enterCreationType();
            defineReader(collectionType, creationType);

            if (reader == null)  {
                System.out.println("Проблема с выбором способа ввода");
                return false;
            }

            List elementsToSearch = reader.read();
            for (var element : elementsToSearch) {
                int elementIndex = switch (collectionType) {
                    case CollectionType.CAR -> Utility.binarySearch(container, (Car) element);
                    case CollectionType.BOOK -> Utility.binarySearch(container, (Book) element);
                    case CollectionType.VEGETABLE -> Utility.binarySearch(container, (Vegetable) element);
                };
                if (elementIndex == Integer.MAX_VALUE) {
                    System.out.println("Коллекция не содержит элемент " + element);
                    return true;
                }
                System.out.println("Индекс элемента " + element + " в коллекции: " + elementIndex);
            }

        }
        in.close();
        return true;
    }

    private boolean continueQuery() {
        Scanner in = new Scanner(System.in);
        System.out.println("\nПродолжить?... (y/n)");
        return handleQuery(in.nextLine(), true);
    }

    private boolean handleQuery(String answer, boolean exitIfNo) {
        final String[] posAnsSynonyms = new String[]{"д", "да", "y", "yes"};
        final String[] negAnsSynonyms = new String[]{"н", "нет", "n", "no"};

        if (!List.of(posAnsSynonyms).contains(answer)
                && !List.of(negAnsSynonyms).contains(answer)) {
            return false;
        } else if (!List.of(posAnsSynonyms).contains(answer)) {
            if (exitIfNo) {
                System.out.println("КОНЕЦ");
                System.exit(0);
            } else return false;
        }
        return true;
    }

    private Integer getValidElementsNumber() {
        Integer elementsNum;
        do {
            elementsNum = enterElementsNumber();
        } while (elementsNum == null);
        return elementsNum;
    }

    private void callKeySortController(CollectionType collectionType) {
		switch (collectionType) {
        case CollectionType.CAR : new SortingCtrl<Car>(container).run();break;
		case CollectionType.BOOK : new SortingCtrl<Book>(container).run();break;
		case CollectionType.VEGETABLE : new SortingCtrl<Vegetable>(container).run();break;
		}
	}

    private void callStrangeSortController(CollectionType collectionType) {
		switch (collectionType) {
        case CollectionType.CAR : new ControllerStrangeSort<Car>(container).run();break;
		case CollectionType.BOOK : new ControllerStrangeSort<Book>(container).run();break;
		case CollectionType.VEGETABLE : new ControllerStrangeSort<Vegetable>(container).run();break;
		}
	}

    // определение типа создания коллекции(чтение из файла, рандомное создание, ввод с консоли)
    private void defineReader(CollectionType collectionType, CreationType creationType) {
        var readingStrategy = switch (collectionType) {
            case CollectionType.CAR -> new CarReadingStrategy();
            case CollectionType.BOOK -> new BookReadingStrategy();
            case CollectionType.VEGETABLE -> new VegetableReadingStrategy();
        };
        reader = switch (creationType) {
            case CreationType.MANUAL -> new ConsoleReader<>(readingStrategy);

            case CreationType.FILE -> new FileReader<>(readingStrategy);

            case CreationType.RANDOM -> new RandomReader<>(readingStrategy, getValidElementsNumber());
        };
    }

}

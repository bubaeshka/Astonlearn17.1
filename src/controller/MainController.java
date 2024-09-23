package controller;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    List<?> list;

    public void run() {
        System.out.println("Hello my friend\n");
        while (true) {
            String typeCollection = enterTypeCollection();
            int countElement = enterCountElement();
            int typeofCreating = enterTypeOfCreating();
            List listElement = definitionTypeCollection(typeCollection);



            String exit = exit();
            if (!exit.equalsIgnoreCase("y")) {
                System.exit(0);
            }
        }

    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.printf(message);
        return in.nextLine();
    }

    private String enterTypeCollection() {
        return prompt("Enter type element  : \n" +
                "1.Сar\n" +
                "2.Book\n" +
                "3.Root vegetable \n");
    }

    private Integer enterCountElement() {
        return Integer.valueOf(prompt("Enter count element: "));
    }

    private Integer enterTypeOfCreating() {
        return Integer.valueOf(prompt("Enter type creating: \n" +
                "1.Read file.\n " +
                "2.Random creating.\n" +
                "3.Console input. "));
    }

    private String exit() {
        Scanner in = new Scanner(System.in);
        System.err.println("Continue?... (y/n)");
        return in.nextLine();
    }

    //метод, который будет определять какого типа будет коллекция
    private List definitionTypeCollection(String typeCollection) {
        if (typeCollection.equals("Book")) {
            return list = new ArrayList<Book>();
        } else if (typeCollection.equals("Car")) {
//            return list = new ArrayList<domain.Car>();
        } else if (typeCollection.equals("Root vegetable")) {
//            return new ArrayList<Vegetable>();
        }
        return null;
    }

    // определение типа создания коллекции(чтение из файла, рандомное создание, ввод с консоли)
    private void definitionTypeCreateCollection(String typeCreate) {
        if (typeCreate.equals("Read file.")) {
            //вызов метода читалки из файла
        } else if (typeCreate.equals("Random creating.")) {
            //вызов метода создания рандомных элементов
        }
        else if (typeCreate.equals("Console input. ")) {
            // читать с консоли
        }
    }
    //заполняет коллекцию элементами выбранного класса
    private void fillCollection(List list, String typeCollection,int countElement) {

    }




}

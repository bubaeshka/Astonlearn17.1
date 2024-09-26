package ReadingStrategy;

import domain.Book;
import domain.Thing;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BookReadingStrategy extends BaseReadingStrategy {

    public BookReadingStrategy() {
        fieldsDescriptions = new FieldDescription[] {
                new FieldDescription("название", FieldDescription.Type.STRING,
                        new Validators.StringLengthValidator(64)),
                new FieldDescription("количество страниц", FieldDescription.Type.INT,
                        new Validators.IntBoundsValidator(2, 2024)),
                new FieldDescription("автор", FieldDescription.Type.STRING,
                        new Validators.StringLengthValidator(45)) };
    }

    @Override
    public FieldDescription[] getNeededFields() {
        return fieldsDescriptions;
    }

    @Override
    public Thing createThing(String[] inputfields) {

        return switch (inputfields.length) {
            case 1 -> new Book.Builder(inputfields[0]).build();
            case 2 -> new Book.Builder(inputfields[0]).setPages(Integer.parseInt(inputfields[1])).build();
            case 3 -> new Book.Builder(inputfields[0])
                    .setPages(Integer.parseInt(inputfields[1]))
                    .setAuthor(inputfields[2]).build();
            default -> null;
        };
    }

    public Thing createThing(Map<String,String> inputfields) {
        switch (inputfields.size()) {
            case 1 : return new Book.Builder(inputfields.get("название")).build();
            case 2 :
            {
                if (inputfields.containsKey("количество страниц"))
                 return new Book.Builder(inputfields.get("название")).setPages(Integer.parseInt(inputfields.get("количество страниц"))).build();
                else return new Book.Builder(inputfields.get("название")).setAuthor(inputfields.get("автор")).build();
            }
            case 3 : return new Book.Builder(inputfields.get("название"))
                    .setPages(Integer.parseInt(inputfields.get("количество страниц")))
                    .setAuthor(inputfields.get("автор")).build();
        };
        return null;
    }

}

package readingstrategy;

import domain.Book;
import domain.Thing;

public class BookReadingStrategy extends BaseReadingStrategy {

    public BookReadingStrategy() {
        fieldsDescriptions = new FieldDescription[] {
                new FieldDescription("название", FieldDescription.Type.STRING,
                        new validators.StringLengthValidator(64)),
                new FieldDescription("количество страниц", FieldDescription.Type.INT,
                        new validators.IntBoundsValidator(2, 2024)),
                new FieldDescription("автор", FieldDescription.Type.STRING,
                        new validators.StringLengthValidator(45)) };
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

}

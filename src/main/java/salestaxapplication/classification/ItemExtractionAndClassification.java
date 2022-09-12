package salestaxapplication.classification;

import java.util.Objects;

import static salestaxapplication.classification.Category.*;


/**
 * Helper class to extract relevant item from the item description
 * or item details and classifying the items into different subgroups for
 * sales tax calculations
 */
public record ItemExtractionAndClassification(String itemDescription) {

    /**
     * Checks whether 'this' String is imported or not.
     * Checks by reading the string and verifying if it contains the keyword 'import'.
     *
     * @return The result of the check.
     */
    public boolean isImported() {
        return itemDescription.toLowerCase().contains("imported");
    }

    /**
     * Checks whether 'this' String is exempt or not.
     *
     * @return The check result.
     */
    public boolean isExempt() {
        return switch (Objects.requireNonNull(mapItemToCategory())) {
            case BOOK, FOOD, MEDICAL_PRODUCTS -> true;
            default -> false;
        };
    }

    /**
     * Maps 'this' item to  enum Categories.
     *
     * @return The enum Category relevant to the String. null if item is irrelevant
     */
    private Category mapItemToCategory() {
        return switch (Objects.requireNonNull(extractItemFromDetails())) {
            case "book" -> BOOK;
            case "chocolate" -> FOOD;
            case "headache pills" -> MEDICAL_PRODUCTS;
            case "cd", "perfume" -> OTHERS;
            default -> null;
        };
    }

    /**
     * Extracts relevant item names from 'this' item description String and store in a variable.
     *
     * @return The variable containing the relevant item name. Null if no relevant name is found.
     */
    private String extractItemFromDetails() {
        if (itemDescription.toLowerCase().contains("book"))
            return "book";
        if (itemDescription.toLowerCase().contains("cd"))
            return "cd";
        if (itemDescription.toLowerCase().contains("chocolate"))
            return "chocolate";
        if (itemDescription.toLowerCase().contains("perfume"))
            return "perfume";
        if (itemDescription.toLowerCase().contains("headache pills"))
            return "headache pills";

        return null;
    }
}

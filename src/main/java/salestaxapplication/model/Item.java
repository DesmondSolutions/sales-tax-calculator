package salestaxapplication.model;


/**
 * Represents an Item
 */
public record Item(int numberOfItems, String description, double price) {

    /**
     * Gets the price of the item based on the number of items
     *
     * @return the price
     */
    public double itemPrice() {
        return price * numberOfItems;
    }
}

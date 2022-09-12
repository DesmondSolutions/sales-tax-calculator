package salestaxapplication.shopping;

import salestaxapplication.calculations.SalesTaxCalculation;
import salestaxapplication.model.Item;
import salestaxapplication.util.TaxUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a shopping cart.
 * items can be added into the cart as input and the receipts printed as output.
 */
public class Cart {

    private final List<Item> cartItems = new ArrayList<>();
    private final SalesTaxCalculation salesTaxCalculation = new SalesTaxCalculation();

    /**
     * Adds items to the cart.
     *
     * @param item The item to be added.
     */
    public void addItemToCart(Item item) {
        cartItems.add(item);
    }

    /**
     * Gets the items in the cart.
     *
     * @return A List used for holding cart items.
     */
    public List<Item> getItems() {
        return cartItems;
    }

    /**
     * prints the input.
     */
    public void printInput() {
        cartItems.forEach(list -> System.out.println(String.format("%d %s at %.2f",
                list.numberOfItems(), list.description(), list.price())
        ));
    }

    /**
     * Prints the receipt of the purchase.
     * The receipt contains the cart items, the sales tax and the total amount.
     */
    public void printReceipt() {
        double salesTaxes = 0.0;
        double total = 0.0;

        for (Item item : cartItems) {
            System.out.println(String.format("%d %s: %.2f", item.numberOfItems(), item.description(),
                    TaxUtils.totalAmountRoundup(
                            (item.price() + salesTaxCalculation.getSalesTax(item) * item.numberOfItems()))));
            total += salesTaxCalculation.itemTotalPriceAfterTax(item);
            salesTaxes += salesTaxCalculation.totalSalesTaxPaid(item);

        }
        System.out.println(String.format("Sales Taxes : %.2f", TaxUtils.taxRoundup(salesTaxes)));
        System.out.println(String.format("Total : %.2f", TaxUtils.totalAmountRoundup(total)));

    }
}

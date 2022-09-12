package salestaxapplication.calculations;


import salestaxapplication.classification.ItemExtractionAndClassification;
import salestaxapplication.model.Item;
import salestaxapplication.util.TaxUtils;

/**
 * Represents all calculations for sales tax.
 */
public class SalesTaxCalculation {

    /**
     * Calculates sales tax from an item.
     *
     * @param item The item.
     * @return The calculated sales tax.
     */
    public double getSalesTax(Item item) {
        double importDuty;
        double basicTax;
        ItemExtractionAndClassification itemClassification
                = new ItemExtractionAndClassification(item.description());

        importDuty = itemClassification.isImported() ? importDuty(item.price()) : 0;
        basicTax = itemClassification.isExempt() ? 0 : basicSalesTax(item.price());

        return TaxUtils.taxRoundup(importDuty + basicTax);
    }

    /**
     * Calculates the basic sales tax.
     *
     * @param shelfPrice The shelf price or pre-tax price.
     * @return The calculated basic sales tax.
     */
    private double basicSalesTax(double shelfPrice) {
        double basicTaxRate = 0.10;
        return TaxUtils.taxRoundup(shelfPrice * basicTaxRate);
    }

    /**
     * Calculates the import duty of an item.
     *
     * @param shelfPrice The pre-tax price
     * @return The calculated import duty.
     */
    private double importDuty(double shelfPrice) {
        double importDutyRate = 0.05;
        return TaxUtils.taxRoundup(shelfPrice * importDutyRate);
    }

    /**
     * Calculates the total price of an item (with respect to quantity) after tax.
     *
     * @param item The item.
     * @return The after tax amount.
     */
    public double itemTotalPriceAfterTax(Item item) {
        return TaxUtils.totalAmountRoundup((item.price() + getSalesTax(item)) * item.numberOfItems());
    }

    /**
     * Calculates the total sales tax of an item (with respect to quality) paid.
     *
     * @param item The item.
     * @return The total sales tax.
     */
    public double totalSalesTaxPaid(Item item) {
        return TaxUtils.totalAmountRoundup(itemTotalPriceAfterTax(item) - item.itemPrice());
    }

}

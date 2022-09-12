package salestaxapplication.calculations;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import salestaxapplication.model.Item;


class SalesTaxCalculationTest {

    private Item item;
    private SalesTaxCalculation taxCalculation;

    @BeforeEach
    void setUp() {
        item = new Item(2, "imported bottle of perfume", 47.50);
        taxCalculation = new SalesTaxCalculation();
    }

    @Test
    void shouldGetSalesTax() {
        Assertions.assertThat(taxCalculation.getSalesTax(item)).isEqualTo(7.15);
    }

    @Test
    void shouldGetPriceAfterTax() {
        Assertions.assertThat(taxCalculation.itemTotalPriceAfterTax(item)).isEqualTo(109.30);
    }

    @Test
    void shouldTestTotalSalesTaxPaid() {
        Assertions.assertThat(taxCalculation.totalSalesTaxPaid(item)).isEqualTo(14.30);
    }
}
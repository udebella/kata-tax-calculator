package model.taxes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TVATaxesTest {
    @Test
    public void should_calculate_taxes_amount() {
        ITaxes taxes = new TVATaxes();
        assertEquals(10, taxes.calculateTaxesFromHt(100));
    }

    @Test
    public void should_not_return_half_cents_amount() throws Exception {
        ITaxes taxes = new TVATaxes();
        assertEquals(5, taxes.calculateTaxesFromHt(45));
    }
}

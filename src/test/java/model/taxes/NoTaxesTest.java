package model.taxes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NoTaxesTest {
    @Test
    public void should_return_0_for_every_ht_amount() throws Exception {
        ITaxes taxes = new NoTaxes();
        assertEquals(0, taxes.calculateTaxesFromHt(35));
    }
}

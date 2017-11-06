package model.taxes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoundedTaxesDecoratorTest {
    @Test
    public void should_round_up_taxes_amount_to_5_multiplier() {
        ITaxes taxes = new RoundedTaxesDecorator(new FakeTaxes());
        assertEquals(105, taxes.calculateTaxesFromHt(101));

        taxes = new RoundedTaxesDecorator(new FakeTaxes());
        assertEquals(100, taxes.calculateTaxesFromHt(99));
    }
}

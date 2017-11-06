package model.taxes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ImportedTaxesDecoratorTest {
    @Test
    public void should_add_5_purcent_to_calculated_taxes() {
        ITaxes taxes = new ImportedTaxesDecorator(new FakeTaxes());
        assertEquals(105, taxes.calculateTaxesFromHt(100));

        taxes = new ImportedTaxesDecorator(new FakeTaxes());
        assertEquals(35, taxes.calculateTaxesFromHt(33));
    }
}

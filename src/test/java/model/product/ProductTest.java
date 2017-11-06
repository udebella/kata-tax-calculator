package model.product;

import model.taxes.FakeTaxes;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductTest {
    @Test
    public void should_have_ht_amount() {
        IProduct product = new Product(100, new FakeTaxes());
        assertEquals(100, product.getHtAmount());

        product = new Product(35, new FakeTaxes());
        assertEquals(35, product.getHtAmount());
    }

    @Test
    public void should_have_ttc_amount() {
        IProduct product = new Product(100, new FakeTaxes());
        assertEquals(200, product.getTtcAmount());

        product = new Product(30, new FakeTaxes());
        assertEquals(60, product.getTtcAmount());
    }

    @Test
    public void should_calculate_taxes_amount() throws Exception {
        IProduct product = new Product(100, new FakeTaxes());
        assertEquals(100, product.getTaxesAmount());

        product = new Product(30, new FakeTaxes());
        assertEquals(30, product.getTaxesAmount());
    }
}

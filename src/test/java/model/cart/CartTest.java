package model.cart;

import model.product.IProduct;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CartTest {
    private static final int EXPECTED_HT_AMOUNT = 100;
    private static final int EXPECTED_TTC_AMOUNT = 200;
    private static final int EXPECTED_TAXES_AMOUNT = 100;

    private List<IProduct> productList = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        productList.add(new FakeIProduct());
        productList.add(new FakeIProduct());
    }

    @Test
    public void should_calculate_total_ht_amount() {
        Cart cart = new Cart(productList);
        assertEquals(EXPECTED_HT_AMOUNT, cart.getHtAmount());
    }

    @Test
    public void should_calculate_total_ttc_amount() {
        Cart cart = new Cart(productList);
        assertEquals(EXPECTED_TTC_AMOUNT, cart.getTtcAmount());
    }

    @Test
    public void should_allow_to_add_new_products_in_cart() throws Exception {
        Cart cart = new Cart();
        cart.addProduct(new FakeIProduct());
        cart.addProduct(new FakeIProduct());
        assertEquals(EXPECTED_HT_AMOUNT, cart.getHtAmount());
        assertEquals(EXPECTED_TTC_AMOUNT, cart.getTtcAmount());
    }

    @Test
    public void should_calculate_taxes_amount() throws Exception {
        Cart cart = new Cart(productList);
        assertEquals(EXPECTED_TAXES_AMOUNT, cart.getTaxesAmount());

    }

    private class FakeIProduct implements IProduct {
        public int getHtAmount() {
            return 50;
        }

        public int getTtcAmount() {
            return 100;
        }

        @Override
        public int getTaxesAmount() {
            return 50;
        }
    }
}

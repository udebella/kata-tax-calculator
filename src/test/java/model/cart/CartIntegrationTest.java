package model.cart;

import model.product.IProduct;
import model.product.ProductFactory;
import model.product.ProductType;
import model.taxes.TaxesFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CartIntegrationTest {
    private ProductFactory productFactory;

    @Before
    public void setUp() throws Exception {
        this.productFactory = new ProductFactory(new TaxesFactory());
    }

    @Test
    public void should_return_right_values_for_first_cart() {
        IProduct book = this.productFactory.buildProduct(1249, ProductType.Book);
        IProduct musicDisk = this.productFactory.buildProduct(1499, ProductType.Other);
        IProduct chocolateBar = this.productFactory.buildProduct(85, ProductType.Food);

        Cart cart = new Cart();
        cart.addProduct(book);
        cart.addProduct(musicDisk);
        cart.addProduct(chocolateBar);

        assertEquals(150, cart.getTaxesAmount());
        assertEquals(2983, cart.getTtcAmount());
    }

    @Test
    public void should_return_right_values_for_second_cart() {
        IProduct chocolateBox = this.productFactory.buildImportedProduct(1000, ProductType.Food);
        IProduct musk = this.productFactory.buildImportedProduct(4750, ProductType.Other);

        Cart cart = new Cart();
        cart.addProduct(chocolateBox);
        cart.addProduct(musk);

        assertEquals(765, cart.getTaxesAmount());
        assertEquals(6515, cart.getTtcAmount());
    }

    @Test
    public void should_return_right_values_for_third_cart() {
        IProduct muskImported = this.productFactory.buildImportedProduct(2799, ProductType.Other);
        IProduct musk = this.productFactory.buildProduct(1899, ProductType.Other);
        IProduct pillsBox = this.productFactory.buildProduct(975, ProductType.Medicine);
        IProduct chocolate = this.productFactory.buildImportedProduct(1125, ProductType.Food);

        Cart cart = new Cart();
        cart.addProduct(muskImported);
        cart.addProduct(musk);
        cart.addProduct(pillsBox);
        cart.addProduct(chocolate);

        assertEquals(670, cart.getTaxesAmount());
        assertEquals(7468, cart.getTtcAmount());
    }
}

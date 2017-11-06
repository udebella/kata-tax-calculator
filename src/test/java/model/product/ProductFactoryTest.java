package model.product;

import model.taxes.TaxesFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductFactoryTest {
    private ProductFactory productFactory;

    @Before
    public void setUp() {
        this.productFactory = new ProductFactory(new TaxesFactory());
    }

    @Test
    public void should_build_other_products_with_right_taxes() {
        IProduct musicalDisk = productFactory.buildProduct(1499, ProductType.Other);
        assertEquals(1649, musicalDisk.getTtcAmount());

        IProduct musk = productFactory.buildProduct(1890, ProductType.Other);
        assertEquals(2080, musk.getTtcAmount());
    }

    @Test
    public void should_build_book_with_right_taxes() {
        IProduct book = productFactory.buildProduct(1249, ProductType.Book);
        assertEquals(1249, book.getTtcAmount());
    }

    @Test
    public void should_build_imported_food_with_rigth_taxes() {
        IProduct chocolateBar = productFactory.buildImportedProduct(1000, ProductType.Food);
        assertEquals(1050, chocolateBar.getTtcAmount());
    }

    @Test
    public void should_build_imported_other_products_with_rigth_taxes() {
        IProduct muskImported = productFactory.buildImportedProduct(2799, ProductType.Other);
        assertEquals(3219, muskImported.getTtcAmount());

        muskImported = productFactory.buildImportedProduct(4750, ProductType.Other);
        assertEquals(5465, muskImported.getTtcAmount());
    }
}

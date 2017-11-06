package model.product;

import model.taxes.*;

/**
 * Create products with right taxes calculators
 */
public class ProductFactory {
    private TaxesFactory taxesFactory;

    public ProductFactory(TaxesFactory taxesFactory) {
        this.taxesFactory = taxesFactory;
    }

    public IProduct buildProduct(int htAmount, ProductType type) {
        ITaxes taxes = type.getTaxesAssociated();
        return new Product(htAmount, taxesFactory.buildTaxes(taxes));
    }

    public IProduct buildImportedProduct(int htAmount, ProductType type) {
        ITaxes taxes = type.getTaxesAssociated();
        return new Product(htAmount, taxesFactory.buildImportedTaxes(taxes));
    }
}

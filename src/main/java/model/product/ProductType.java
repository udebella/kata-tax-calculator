package model.product;

import model.taxes.ITaxes;
import model.taxes.NoTaxes;
import model.taxes.TVATaxes;

/**
 * Product types available in the system
 */
public enum ProductType {
    Book(new NoTaxes()),
    Food(new NoTaxes()),
    Medicine(new NoTaxes()),
    Other(new TVATaxes());

    private ITaxes taxesAssociated;

    ProductType(ITaxes taxesAssociated) {
        this.taxesAssociated = taxesAssociated;
    }

    public ITaxes getTaxesAssociated() {
        return taxesAssociated;
    }
}

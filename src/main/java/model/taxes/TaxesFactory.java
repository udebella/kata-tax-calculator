package model.taxes;

/**
 * Adds right decorators to taxes
 */
public class TaxesFactory {
    public ITaxes buildTaxes(ITaxes taxes) {
        return new RoundedTaxesDecorator(taxes);
    }

    public ITaxes buildImportedTaxes(ITaxes taxes) {
        return new RoundedTaxesDecorator(new ImportedTaxesDecorator(taxes));
    }
}

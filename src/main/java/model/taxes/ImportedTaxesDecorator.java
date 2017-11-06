package model.taxes;

public class ImportedTaxesDecorator implements ITaxes {
    private static final double TAX_PURCENTAGE = 5;
    private ITaxes taxes;

    public ImportedTaxesDecorator(ITaxes taxes) {
        this.taxes = taxes;
    }

    public int calculateTaxesFromHt(int htAmount) {
        return (int) Math.ceil(htAmount * TAX_PURCENTAGE / 100) + taxes.calculateTaxesFromHt(htAmount);
    }
}

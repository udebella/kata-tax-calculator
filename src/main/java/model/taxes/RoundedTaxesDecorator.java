package model.taxes;

/**
 * This decorator allow to round up taxes amount to nearest 5 cents
 */
public class RoundedTaxesDecorator implements ITaxes {
    private static final int PRECISION = 5;
    private ITaxes taxes;

    public RoundedTaxesDecorator(ITaxes taxes) {
        this.taxes = taxes;
    }

    public int calculateTaxesFromHt(int htAmount) {
        return (this.taxes.calculateTaxesFromHt(htAmount) + PRECISION - 1) / PRECISION * PRECISION;
    }
}

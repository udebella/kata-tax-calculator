package model.taxes;

public class TVATaxes implements ITaxes {
    private static final double TAX_PURCENTAGE = 10;

    public int calculateTaxesFromHt(int htAmount) {
        return (int) Math.ceil(htAmount * TAX_PURCENTAGE / 100);
    }
}

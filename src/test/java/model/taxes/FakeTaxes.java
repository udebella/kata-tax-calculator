package model.taxes;

/**
 * Fake used for tests which implements 100% taxes
 */
public class FakeTaxes implements ITaxes {
    public int calculateTaxesFromHt(int htAmount) {
        return htAmount;
    }
}

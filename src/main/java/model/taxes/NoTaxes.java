package model.taxes;

public class NoTaxes implements ITaxes {
    public int calculateTaxesFromHt(int htAmount) {
        return 0;
    }
}

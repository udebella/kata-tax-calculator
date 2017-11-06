package model.product;

import model.taxes.ITaxes;

public class Product implements IProduct {
    private final ITaxes taxes;
    private final int htAmount;

    public Product(int htAmount, ITaxes taxes) {
        this.htAmount = htAmount;
        this.taxes = taxes;
    }

    @Override
    public int getHtAmount() {
        return this.htAmount;
    }

    @Override
    public int getTtcAmount() {
        return this.htAmount + this.getTaxesAmount();
    }

    @Override
    public int getTaxesAmount() {
        return this.taxes.calculateTaxesFromHt(this.htAmount);
    }
}

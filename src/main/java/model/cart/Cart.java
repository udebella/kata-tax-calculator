package model.cart;

import model.product.IProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ToIntFunction;

public class Cart {
    private final List<IProduct> productList;

    public Cart(List<IProduct> productList) {
        this.productList = new ArrayList<>(productList);
    }

    public Cart() {
        this.productList = new ArrayList<>();
    }

    public void addProduct(IProduct product) {
        this.productList.add(product);
    }

    public int getHtAmount() {
        return getSum(IProduct::getHtAmount);
    }

    public int getTtcAmount() {
        return getSum(IProduct::getTtcAmount);
    }

    public int getTaxesAmount() {
        return getSum(IProduct::getTaxesAmount);
    }

    private int getSum(ToIntFunction<IProduct> supplier) {
        return this.productList.stream()
                .mapToInt(supplier)
                .sum();
    }
}

package ru.netology.manager;

import ru.netology.domain.PurchaseItem;

public class CartManager {
    private PurchaseItem[] items = new PurchaseItem[0];
    private int limit;

    public CartManager(int limit) {
        this.limit = limit;
    }

    public CartManager() {
        this.limit = 10;
    }

    public void add(PurchaseItem item) {
        PurchaseItem[] tmp = new PurchaseItem[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public PurchaseItem[] findAll() {
        return items;
    }

    public PurchaseItem[] findLast() {
        int resultLength;
        boolean isLimited = this.limit < findAll().length;

        resultLength = isLimited ? this.limit : findAll().length;
        PurchaseItem[] result = new PurchaseItem[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }
}

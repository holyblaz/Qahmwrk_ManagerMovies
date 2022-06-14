package ru.netology.manager;


import ru.netology.domain.PurchaseItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CartManagerNonEmptyWithSetUp {
    private CartManager manager = new CartManager();
    private PurchaseItem first = new PurchaseItem(1, 1, "first,", 1, 1);
    private PurchaseItem second = new PurchaseItem(1, 1, "second", 1, 1);
    private PurchaseItem third = new PurchaseItem(3, 3, "third", 1, 1);


    @BeforeEach
    void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }

    @Test
    public void ShouldAddAllItems() {
        PurchaseItem[] actual = manager.findAll();
        PurchaseItem[] expected = new PurchaseItem[]{first, second, third};
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void ShouldAddAddExtraItem() {
        PurchaseItem fourth = new PurchaseItem(4,4,"fourth",4,4);
        manager.add(fourth);
        PurchaseItem[] actual = manager.findAll();
        PurchaseItem[] expected = new PurchaseItem[] {first, second, third, fourth};
        Assertions.assertArrayEquals(expected,actual);
    }

}

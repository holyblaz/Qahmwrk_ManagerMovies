package ru.netology.manager;


import ru.netology.domain.PurchaseItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CartManagerTest {
    CartManager manager = new CartManager();
    PurchaseItem first = new PurchaseItem(1, 1, "first,", 1, 1);
    PurchaseItem second = new PurchaseItem(2, 2, "second", 2, 2);
    PurchaseItem third = new PurchaseItem(3, 3, "third", 3, 3);
    PurchaseItem fourth = new PurchaseItem(4, 4, "fourth", 4, 4);
    PurchaseItem fifth = new PurchaseItem(5, 5, "fifth", 5, 5);
    PurchaseItem sixth = new PurchaseItem(6, 6, "sixth", 6, 6);
    PurchaseItem seventh = new PurchaseItem(7, 7, "seventh", 7, 7);
    PurchaseItem eights = new PurchaseItem(8, 8, "eights", 8, 8);
    PurchaseItem ninths = new PurchaseItem(9, 9, "ninth", 9, 9);
    PurchaseItem tenth = new PurchaseItem(10, 10, "tenth", 10, 10);
    PurchaseItem eleventh = new PurchaseItem(11, 11, "eleventh", 11, 11);


    @Test
    public void shouldAddAllItems() {
        CartManager manager = new CartManager();
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        PurchaseItem[] actual = manager.findAll();
        PurchaseItem[] expected = new PurchaseItem[]{first, second, third, fourth, fifth};
        Assertions.assertArrayEquals(expected, actual);
    }

    public void shouldCheckLimitMovieForFiveItems() {
        CartManager manager = new CartManager(5);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);

        PurchaseItem[] actual = manager.findLast();
        PurchaseItem[] expected = {fifth, fourth, third};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCheckItemsOverLimitOfFourItems() {
        CartManager manager = new CartManager(4);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);

        PurchaseItem[] actual = manager.findLast();
        PurchaseItem[] expected = {fifth, fourth, third, second};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCheckItemsOverLimit() {
        CartManager manager = new CartManager();
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eights);
        manager.add(ninths);
        manager.add(tenth);
        manager.add(eleventh);

        PurchaseItem[] actual = manager.findLast();
        PurchaseItem[] expected = {eleventh, tenth, ninths, eights, seventh, sixth, fifth, fourth, third, second};
        Assertions.assertArrayEquals(expected, actual);
    }
}
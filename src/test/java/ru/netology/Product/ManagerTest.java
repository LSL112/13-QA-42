package ru.netology.Product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {
    Repository repo = new Repository();
    Manager manager = new Manager(repo);


    Book book1 = new Book(100, "Aa_1", 101, "Nn_1");
    Book book2 = new Book(200, "Ab_1", 220, "Nn_2");
    Book book3 = new Book(300, "Aa_2", 300, "Nn_3");

    Smartphone smartphone1 = new Smartphone(110, "A_1", 100, "Ai");
    Smartphone smartphone2 = new Smartphone(210, "B_1", 200, "Ai");
    Smartphone smartphone3 = new Smartphone(310, "A_2", 300, "Sa");


    @Test
    public void testNameMatch() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = manager.searchBy("Aa");
        Product[] expected = {book1, book3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testDeleteById() {

        manager.add(book1);
        manager.add(smartphone3);

        manager.removeById(book1.getId());

        Product[] actual = manager.searchBy(smartphone3.getName());
        Product[] expected = {smartphone3};

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void testAddProduct() {

        manager.add(book1);

        Product[] actual = manager.searchBy(book1.getName());
        Product[] expected = {book1};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testEmptyRepo() {

        Product[] actual = manager.searchBy("");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void test() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, smartphone1, smartphone2};

        Assertions.assertArrayEquals(expected, actual);
    }

}

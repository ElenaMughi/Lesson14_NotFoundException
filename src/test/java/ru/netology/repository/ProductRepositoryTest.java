package ru.netology.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;

class ProductRepositoryTest {

    private ProductRepository repository = new ProductRepository();
    private Book coreJava = new Book(2, "Core Java", 200, "Author1", 200, 2021);
    private Book python = new Book(1, "Python", 100, "Author", 100, 2021);

    @Test
    public void shouldSaveOneItem() {
        repository.save(coreJava);
        Product[] expected = new Product[]{coreJava};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveOneItem() {
        repository.save(coreJava);
        repository.save(python);
        repository.removeById(1);
        Product[] expected = new Product[]{coreJava};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveOneItem() {
        repository.save(coreJava);
        repository.save(python);

        assertThrows(NotFoundException.class, () -> { repository.removeById(3);});

//  2      try {
//            repository.removeById(2);
//        } catch (NotFoundException e) {
//
//        } catch (Exception e) {
//            fail();
//        }

//  1      Product[] expected = new Product[]{python};
//        Product[] actual = repository.findAll();
//        assertArrayEquals(expected, actual);

    }

}
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    @Test
    public void testProductExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Куртка", 15_000);
        Product product2 = new Product(2, "Обувь", 9_000);
        Product product3 = new Product(3, "Кепка", 3_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(1);

        Product[] actual = repo.findAll();
        Product[] expected = {product2, product3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testProductNotExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Куртка", 15_000);
        Product product2 = new Product(2, "Обувь", 9_000);
        Product product3 = new Product(3, "Кепка", 3_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);


        Assertions.assertThrows(
                NotFoundException.class,
                () -> repo.remove(11)
        );
    }
}


import java.util.HashMap;
import java.util.Map;

// Общий интерфейс для легковесов
interface ProductFlyweight {
    void display(String name, String description, int price);
}

// Реализация легковесов
class ConcreteProductFlyweight implements ProductFlyweight {
    private final int weight;
    private final int size;

    public ConcreteProductFlyweight(int weight, int size) {
        this.weight = weight;
        this.size = size;
    }

    @Override
    public void display(String name, String description, int price) {
        System.out.println("Имя продукта: " + name);
        System.out.println("Описание: " + description);
        System.out.println("Цена: " + price);
        System.out.println("Вес: " + weight);
        System.out.println("Размер: " + size);
    }
}

// Фабрика легковесов
class ProductFlyweightFactory {
    private static Map<String, ProductFlyweight> productMap = new HashMap<>();

    public static ProductFlyweight getProduct(int weight, int size) {
        String key = weight + "-" + size;
        ProductFlyweight product = productMap.get(key);
        if (product == null) {
            product = new ConcreteProductFlyweight(weight, size);
            productMap.put(key, product);
        }
        return product;
    }
}

// Клиентский код
public class Client {
    public static void main(String[] args) {
        ProductFlyweight product1 = ProductFlyweightFactory.getProduct(10, 20);
        ProductFlyweight product2 = ProductFlyweightFactory.getProduct(10, 20);
        ProductFlyweight product3 = ProductFlyweightFactory.getProduct(15, 25);

        product1.display("Product 1", "Description 1", 100);
        product2.display("Product 2", "Description 2", 200);
        product3.display("Product 3", "Description 3", 300);
    }
}

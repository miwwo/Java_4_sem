class Product {
    private String name;
    private String description;
    private double price;

    public Product(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class ProductBuilder {
    private String name;
    private String description;
    private double price;

    public ProductBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public ProductBuilder withPrice(double price) {
        this.price = price;
        return this;
    }

    public Product build() {
        return new Product(name, description, price);
    }
}

public class Builder {
    public static void main(String[] args) {
        // Создаем объект продукта с помощью Builder
        Product product = new ProductBuilder()
                .withName("Chipseki")
                .withDescription("ochen vkusnie chipseki, ne dorogo")
                .withPrice(99.99)
                .build();

        // Выводим информацию о продукте
        System.out.println("Product: " + product.getName()
                + ", " + product.getDescription()
                + ", $" + product.getPrice());
    }
}

package week06.d02;

public class Product {

    private String name;
    private CategoryOfProduct categoryOfProduct;
    private double price;

    public String getName() {
        return name;
    }

    public CategoryOfProduct getCategoryOfProduct() {
        return categoryOfProduct;
    }

    public double getPrice() {
        return price;
    }

    public Product(String name, CategoryOfProduct categoryOfProduct, double price) {
        this.name = name;
        this.categoryOfProduct = categoryOfProduct;
        this.price = price;
    }
}

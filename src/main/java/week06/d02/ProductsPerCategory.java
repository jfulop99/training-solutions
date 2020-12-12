package week06.d02;

public class ProductsPerCategory {
    private CategoryOfProduct category;
    private int number;

    public ProductsPerCategory(CategoryOfProduct category, int number) {
        this.category = category;
        this.number = number;
    }

    public CategoryOfProduct getCategory() {
        return category;
    }

    public int getNumber() {
        return number;
    }
}

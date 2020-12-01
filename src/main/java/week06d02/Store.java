package week06d02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Store {
    private List<Product> products;


    public Store(List<Product> products) {
        if (products == null) {
            throw new IllegalArgumentException("Products is null");
        }
        this.products = products;
    }

    public List<ProductsPerCategory> getProductsByCategory() {
        List<ProductsPerCategory> productsPerCategories = new ArrayList<>();
        for (CategoryOfProduct category: CategoryOfProduct.values()) {
            int count = countProductByCategory(category);
            if (count > 0) {
                productsPerCategories.add(new ProductsPerCategory(category, count));
            }
        }
        return productsPerCategories;
    }

    private int countProductByCategory(CategoryOfProduct category) {
        int count = 0;
        for (Product product: products) {
            if (category == product.getCategoryOfProduct()) {
                count++;
            }
        }
        return count;
    }
}

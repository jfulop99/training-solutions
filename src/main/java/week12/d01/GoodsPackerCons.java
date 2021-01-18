package week12.d01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoodsPackerCons {

    public static void main(String[] args) {
        System.out.println(new GoodsPackerCons().packGoods(new int[][]{
        {7, 160},
        {3, 90},
        {2, 15}}, 20));
    }



    int packGoods(int[][] types, int capacity) {
        List<ProductType> productTypes = typesToList(types);
        Collections.sort(productTypes);
        Collections.reverse(productTypes);
        int weightSum = 0;
        int priceSum = 0;
        for (ProductType productType : productTypes) {
            while (weightSum + productType.getWeight() <= capacity) {
                weightSum += productType.getWeight();
                priceSum += productType.getPrice();
            }
        }
        return priceSum;
    }



    private List<ProductType> typesToList(int[][] types) {
        if (types == null) {
            throw new IllegalArgumentException("types were null");
        }
        List<ProductType> result = new ArrayList<>();
        for (int[] type : types) {
            result.add(new ProductType(type[0], type[1]));
        }
        return result;
    }



    class ProductType implements Comparable<ProductType> {



        private int weight;
        private int price;



        public ProductType(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }



        public int getWeight() {
            return weight;
        }



        public int getPrice() {
            return price;
        }

        @Override
        public int compareTo(ProductType o) {
            return (int) (((double)this.getPrice() / (double) this.getWeight()) - ((double)o.getPrice() / (double) o.getWeight()));
        }
    }
}


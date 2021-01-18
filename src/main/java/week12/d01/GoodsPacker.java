package week12.d01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GoodsPacker {

    int packGoods(int[][] types, int capacity) {

        List<Good> goods = new ArrayList<>();

        for (int [] type:types){
            goods.add(new Good(type[0],type[1]));
        }
        goods.sort(new Comparator<Good>() {
            @Override
            public int compare(Good o1, Good o2) {
                return (int) (((double)o1.getPrice() / (double) o1.getWeight()) - ((double)o2.getPrice() / (double) o2.getWeight())) ;
            }
        });
        Collections.reverse(goods);
        int remainCapacity = capacity;
        int value = 0;
        int index = 0;
        while (remainCapacity > 0 && index < goods.size()) {
            if (remainCapacity >= goods.get(index).getWeight()) {
                remainCapacity -= goods.get(index).getWeight();
                value += goods.get(index).getPrice();
            }
            else {
                index++;
            }
        }
        return value;
    }

    public static void main(String[] args) {
        GoodsPacker goodsPacker = new GoodsPacker();
        System.out.println(goodsPacker.packGoods(new int[][]{{7, 160}, {3, 90}, {2, 15}}, 20));
        }

}

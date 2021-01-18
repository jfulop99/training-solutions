package week12.d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoodsPackerTest {

    @Test
    void packGoods() {

        assertEquals(555, new GoodsPacker().packGoods(new int[][]{{7, 160}, {3, 90}, {2, 15}}, 20));

    }
}
package collectionslist.collectionsarraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottery {

    public List<Integer> selectWinningNumbers(int lotteryType, int ballCount) {
        if (lotteryType >= ballCount) {
            throw new IllegalArgumentException("Balls must be more then the winning numbers!");
        }
        List<Integer> winNumbers = new ArrayList<>(lotteryType);
        List<Integer> balls = new ArrayList<>(ballCount);

        for (int ballNumber = 1; ballNumber <= ballCount; ballNumber++) {
            balls.add(ballNumber);
        }
        Collections.shuffle(balls);
        for (int i = 0; i < lotteryType; i++) {
            winNumbers.add(balls.get(i));
        }
        Collections.sort(winNumbers);
        return winNumbers;
    }

    public static void main(String[] args) {
        Lottery lottery = new Lottery();
        System.out.println(lottery.selectWinningNumbers(6, 45));
    }
}

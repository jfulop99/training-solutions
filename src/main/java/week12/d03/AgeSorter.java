package week12.d03;

public class AgeSorter {


    public int[] sortAges(int[] ages) {

        int[] lookup = new int[130];
        for (int age: ages ) {
            lookup[age]++;
        }

        int[] result = new int[ages.length];
        int idx = 0;
        for (int num = 0; num < lookup.length; num++) {
            int numCount = lookup[num];
            if (numCount > 0) {
                for (int j = 0; j < numCount; j++) {
                    result[idx] = num;
                    idx++;
                }
            }
        }

        return result;
    }


        public static void main(String[] args) {
        for (int item: new AgeSorter().sortAges(new int[]{5, 4, 8, 6, 2, 3, 1})) {
            System.out.println(item);
        }
    }
}

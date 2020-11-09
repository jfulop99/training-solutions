package typeconversion.dataloss;

public class DataLoss {
    public static void dataLoss(){
        int resultCounter = 0;
        for (long i = 0; i < Long.MAX_VALUE; i++){
            float temp1 = i;
            long temp2 = (long)temp1;
            if (i != temp2){
                System.out.println(i + ", " + Long.toBinaryString(i) + " - " + temp2 + ", " + Long.toBinaryString(temp2));
                resultCounter++;
            }
            if (resultCounter >=3){
                break;
            }
        }
    }

    public static void main(String[] args) {
        DataLoss.dataLoss();
        // 1 a különbség és 25 bináris számjegynél kezdődik
    }
}

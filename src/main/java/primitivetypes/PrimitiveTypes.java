package primitivetypes;

public class PrimitiveTypes {
    String toBinaryString(int decimal){
        String binaryNumber = "";
        int numberOfPadZero = 32;
        while (decimal > 0){
            binaryNumber = (decimal % 2) + binaryNumber;
            decimal /= 2;
        }
        numberOfPadZero = numberOfPadZero - binaryNumber.length();
        for (int i = 0; i < numberOfPadZero ; i++){
            binaryNumber = '0' + binaryNumber;
        }
        return  binaryNumber;
    }
}

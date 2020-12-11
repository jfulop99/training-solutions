package exceptionmulticatch.converter;

public class BinaryStringConverter {

    boolean[] binaryStringToBooleanArray(String binaryString){
        if (binaryString == null) {
            throw new NullPointerException("binaryString null");
        }
        try {
            Integer.parseInt(binaryString, 2);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("binaryString not valid");
        }
        boolean[] result = new boolean[binaryString.length()];
        for (int i = 0; i < binaryString.length(); i++) {
            result [i] = binaryString.substring(i, i+1).equals("1");
        }
        return result;
    }

    public String booleanArrayToBinaryString(boolean[] booleanArray) {
        if (booleanArray.length == 0) {
            throw new IllegalArgumentException("Empty array");
        }
        String result = "";
        for (boolean bit:booleanArray) {
            result += bit ? "1" : "0";
        }
        return result;
    }

}

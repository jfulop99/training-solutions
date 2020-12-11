package exceptionmulticatch.converter;

public class AnswerStat {

    BinaryStringConverter binaryStringConverter;

    public AnswerStat(BinaryStringConverter binaryStringConverter) {
        this.binaryStringConverter = binaryStringConverter;
    }

    public boolean[] convert(String binaryString) {
        boolean[] result;
        try {
            result = binaryStringConverter.binaryStringToBooleanArray(binaryString);
        }catch (NullPointerException | IllegalArgumentException e) {
            throw new InvalidBinaryStringException(e);
        }
        return result;
    }

    public int answerTruePercent(String answers) {
        boolean [] result = convert(answers);
        double counter = 0.0;
        for (boolean bit:result) {
            if (bit){
                counter++;
            }
        }
        return (int) ((counter / result.length) * 100);
    }
}

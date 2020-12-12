package week03.d05;

public class Operation {
    private int leftValue;
    private int rightValue;

    public Operation(String string) {
        this.leftValue = Integer.parseInt(string.substring(0, string.indexOf('+')));
        this.rightValue = Integer.parseInt(string.substring(string.indexOf('+')+1));
    }
    public int getResult() {
        return leftValue+rightValue;
    }
}

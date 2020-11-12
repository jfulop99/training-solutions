package stringbasic.stringbasic;

public class StringCreator {
    public String createStringForPool() {
        return "John Doe";
    }

    public String createStringForHeap() {
        return new String("John Doe");
    }
}

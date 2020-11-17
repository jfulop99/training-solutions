package schoolrecords;

public enum MarkType {

    A(5,"excellent"), B(4,"good"), C(3,"medium"), D(2,"adequate"), F(1,"fail");
    private int value;
    private String description;

    MarkType(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}

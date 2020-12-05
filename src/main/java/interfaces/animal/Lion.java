package interfaces.animal;

public class Lion implements Animal{

    private final int numberOfLegs = 4;
    private final String name = "Lion";

    @Override
    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    @Override
    public String getName() {
        return name;
    }

}

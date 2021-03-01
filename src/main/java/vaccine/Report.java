package vaccine;

public class Report {

    private final String postalCode;

    private final int numberOfVaccination;

    private final int numberOfCitizen;

    public Report(String postalCode, int numberOfVaccination, int numberOfCitizen) {
        this.postalCode = postalCode;
        this.numberOfVaccination = numberOfVaccination;
        this.numberOfCitizen = numberOfCitizen;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public int getNumberOfVaccination() {
        return numberOfVaccination;
    }

    public int getNumberOfCitizen() {
        return numberOfCitizen;
    }
}

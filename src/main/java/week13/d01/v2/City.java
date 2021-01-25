package week13.d01.v2;

public class City {

    private final String zipNumber;

    private final String name;

    private final String districtName;

    public City(String zipNumber, String name, String districtName) {
        if (zipNumber == null || name == null || zipNumber.isBlank() || name.isBlank()) {
            throw new IllegalArgumentException("Wrong parameters");
        }
        this.zipNumber = zipNumber;
        this.name = name;
        this.districtName = districtName;
    }

    public static City generateFromCsv(String csvString) {

        if (csvString == null || csvString.isBlank()) {
            throw new IllegalArgumentException("Wrong input");
        }
        String[] parts = csvString.split(";");
        String district = null;
        if (parts.length > 2) {
            district = parts[2];
        }

        return new City(parts[0], parts[1], district);
    }

    public String getZipNumber() {
        return zipNumber;
    }

    public String getName() {
        return name;
    }

    public String getDistrictName() {
        return districtName;
    }

    @Override
    public String toString() {
        return name + ", " + (districtName == null ? "": districtName + ", ") + zipNumber;
    }
}

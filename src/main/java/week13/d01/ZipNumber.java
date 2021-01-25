package week13.d01;

public class ZipNumber {

    private final String name;
    private final String district;
    private final String zipNumber;

    public ZipNumber(String name, String district, String zipNumber) {
        this.name = name;
        this.district = district;
        this.zipNumber = zipNumber;
    }

    public String getName() {
        return name;
    }

    public String getDistrict() {
        return district;
    }

    public String getZipNumber() {
        return zipNumber;
    }

    @Override
    public String toString() {
        return name + ", " + (district == null ? "": district + ", ") + zipNumber;
    }
}

package vaccine;

public class PostalCode {

    private final long id;

    private final String zipNumber;

    private final String city;

    private final String cityPart;

    public PostalCode(long id, String zipNumber, String city, String cityPart) {
        this.id = id;
        this.zipNumber = zipNumber;
        this.city = city;
        this.cityPart = cityPart;
    }

    public long getId() {
        return id;
    }

    public String getZipNumber() {
        return zipNumber;
    }

    public String getCity() {
        return city;
    }

    public String getCityPart() {
        return cityPart;
    }
}

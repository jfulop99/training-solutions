package defaultconstructor.date;

public class SimpleDateFormatter {

    private final CountryCode defaultCountryCode;

    public String formatDateString(SimpleDate simpleDate){

        return formatDateStringByCountryCode(defaultCountryCode, simpleDate);
    }

    public String formatDateStringByCountryCode(CountryCode countryCode, SimpleDate simpleDate) {

        String formattedDate = "";
        int year = simpleDate.getYear();
        int month = simpleDate.getMonth();
        int day = simpleDate.getDay();
        switch (countryCode) {
            case HU:
                formattedDate = String.format("%s-%s-%s", year, month,day);
                break;
            case EN:
                formattedDate = String.format("%s-%s-%s",day, month, year);
                break;
            case US:
                formattedDate = String.format("%s-%s-%s",month, day, year);
                break;
        }
        return formattedDate;
    }

    public SimpleDateFormatter() {
        defaultCountryCode = CountryCode.HU;
    }
}

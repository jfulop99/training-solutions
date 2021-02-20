package xtest.exchangerates;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ExchangeRates {


    public List<Currency> readDataFromBank(BufferedReader reader) throws IOException {

        List<Currency> currencyList = new ArrayList<>();

        String line;

        reader.readLine();
        reader.readLine();

        while ((line = reader.readLine()) != null) {
            currencyList.add(Currency.parse(line));
        }
        return currencyList;
    }


    public static void main(String[] args) {
        ExchangeRates exchangeRates = new ExchangeRates();
        URLConnection connection;
        try {
            URL url = new URL("https://www.otpbank.hu/apps/exchangerate/api/downloads/csv/2010-01-01/" + LocalDate.now().toString() + "?currencies=EUR,USD&lang=HU");
            connection = url.openConnection();
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Wrong URL", e);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot open URL", e);
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {

            List<Currency> currencyList = exchangeRates.readDataFromBank(reader);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");

            currencyList.stream()
                    .filter(currency -> currency.getCurrencyType().equals(CurrencyType.EUR))
                    .filter(currency -> currency.getVersion() == 1)
                    .forEach(c -> {
                        System.out.println(String.format("%s %7.2f %1d %3s", c.getValidAt().format(formatter), c.getForeignCurrencySale(),
                                c.getVersion(), c.getCurrencyType()));
                    });

        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }
}

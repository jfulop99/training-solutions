package practice;

import java.io.BufferedReader;
import java.io.IOException;

public class VowelFilter {

    private static final String VOWELS = "aáeéiíoóöőuúüűAÁEÉIÍOÓÖŐUÚÜŰ";

    public String filterVowels(BufferedReader reader) throws IOException {

        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            sb.append(vowelFilter(line + "\n"));
        }

        return sb.toString();
    }

    private String vowelFilter(String line) {

        String filtered = "";
        for (char c : line.toCharArray()) {
            if (VOWELS.indexOf(c) < 0) {
                filtered = filtered + String.valueOf(c);
            }
        }
        return filtered;
    }

}

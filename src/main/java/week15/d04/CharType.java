package week15.d04;

public enum CharType {

    WOWELS("yxcvbnmsdfghjklqwertzp"),
    CONSOANT("aáeéiíoóöőuúüű"),
    OTHER("");

    private String chars;

    CharType(String chars) {
        this.chars = chars;
    }

    public static CharType getType(int c) {
        if (CharType.CONSOANT.chars.contains(String.valueOf((char) c))) {
            return CharType.CONSOANT;
        }
        if (CharType.WOWELS.chars.contains(String.valueOf((char) c))) {
            return CharType.WOWELS;
        }
        return CharType.OTHER;
    }
}

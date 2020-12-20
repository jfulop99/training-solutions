package isahasa.htmlmarchaller;

public class HtmlText implements TextSource{

    private String plainText;

    public HtmlText(String plainText) {
        if (plainText == null || plainText.isBlank()) {
            throw new IllegalArgumentException("Wrong argument");
        }
        this.plainText = plainText;
    }

    @Override
    public String getPlainText() {
        return plainText;
    }
}

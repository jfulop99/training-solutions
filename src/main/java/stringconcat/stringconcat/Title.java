package stringconcat.stringconcat;

public enum Title {
    MR("Mr."), MRS("Mrs."), MS("Ms.");

    private final String title;

    Title(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

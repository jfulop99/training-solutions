package stringbuilder;

public enum Title {
    MR("Mr."), MS("Ms."), DR("Dr"), PROF("Prof.");
    String title;

    Title(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

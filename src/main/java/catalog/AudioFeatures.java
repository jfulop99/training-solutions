package catalog;

import java.util.ArrayList;
import java.util.List;

public class AudioFeatures implements Feature{

    private final String title;
    private final int length;
    private final List<String> composer;
    private final List<String> performers;

    public AudioFeatures(String title, int length, List<String> performers, List<String> composer) {
        checkParameters(title, length, performers,composer);
        this.title = title;
        this.length = length;
        this.performers = performers;
        this.composer = composer;
    }



    public AudioFeatures(String title, int length, List<String> performers) {
        checkParameters(title, length, performers);
        this.title = title;
        this.length = length;
        this.performers = performers;
        this.composer = new ArrayList<>();
    }


    @Override
    public List<String> getContributors() {
        List<String> contributors = new ArrayList<>();
        if (!Validators.isEmpty(composer)) {
            contributors.addAll(composer);
        }
        contributors.addAll(performers);
        return contributors;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    private void checkParameters(String title, int length, List<String> performers) {

        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("Title is blank");
        }
        if (length < 0) {
            throw new IllegalArgumentException("Length is invalid");
        }
        if (Validators.isEmpty( performers)) {
            throw new IllegalArgumentException("Performers is empty");
        }
    }

    private void checkParameters(String title, int length, List<String> performers, List<String> composer) {

        checkParameters(title, length, performers);
        if (Validators.isEmpty(composer)) {
            throw new IllegalArgumentException("Composer is empty");
        }
    }
}

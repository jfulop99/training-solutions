package catalog;

import java.util.ArrayList;
import java.util.List;

public class AudioFeatures implements Feature{

    private final String title;
    private final int length;
    private final List<String> composer;
    private final List<String> performers;

    @SafeVarargs
    public AudioFeatures(String title, int length, List<String> performers, List<String>... composer) {
        checkParameters(title, length, performers, composer);
        this.title = title;
        this.length = length;
        if (composer.length == 0) {
            this.composer = null;
        }
        else {
            this.composer = composer[0];
        }
        this.performers = performers;
    }

    @Override
    public List<String> getContributors() {
        List<String> contributors = new ArrayList<>();
        if (!Validators.isEmpty((List<Object>)(List<?>) composer)) {
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

    @SafeVarargs
    private boolean checkParameters(String title, int length, List<String> performers, List<String>... composer) {

        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("Title is blank");
        }
        if (length < 0) {
            throw new IllegalArgumentException("Length is invalid");
        }
        if (Validators.isEmpty((List<Object>)(List<?>) performers)) {
            throw new IllegalArgumentException("Composer is empty");
        }
        if (composer.length != 0) {
            if (Validators.isEmpty((List<Object>)(List<?>)composer[0])) {
                throw new IllegalArgumentException("Performers is empty");
            }
        }
        return true;
    }
}

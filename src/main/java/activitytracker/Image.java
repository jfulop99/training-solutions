package activitytracker;

import java.util.Arrays;

public class Image {

    private long id;

    private String fileName;

    private byte[] content;

    private long activity_id;

    public Image(long id, String fileName, byte[] content, long activity_id) {
        this.id = id;
        this.fileName = fileName;
        this.content = Arrays.copyOf(content, content.length);
        this.activity_id = activity_id;
    }

    public long getActivity_id() {
        return activity_id;
    }

    public long getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public byte[] getContent() {
        return content;
    }
}

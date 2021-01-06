package exam02.photo;

import java.util.ArrayList;
import java.util.List;

public class PhotoCollection {

    private List<Photo> photos;

    public PhotoCollection() {
        photos = new ArrayList<>();
    }

    public List<Photo> getPhotos() {
        return new ArrayList<>(photos);
    }

    public void addPhoto(String...names) {
        for (String name: names ) {
            photos.add(new Photo(name));
        }
    }

    public int numberOfStars() {
        int numberOfStars = 0;
        for (Photo photo:photos ) {
            numberOfStars += photo.getQuality().ordinal();
        }
        return numberOfStars;
    }

    public void starPhoto(String name, Quality quality) {
        for (Photo photo:photos) {
            if (photo.getName().equals(name)) {
                photo.setQuality(quality);
                return;
            }
        }
        throw new PhotoNotFoundException("Photo not found");
    }
}

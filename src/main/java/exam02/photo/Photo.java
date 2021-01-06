package exam02.photo;

public class Photo implements Qualified {

    private String name;
    private Quality rate;


    public Photo(String name) {
        this.name = name;
        rate = Quality.NO_STAR;
    }

    public Photo(String name, Quality rate) {
        this.name = name;
        this.rate = rate;
    }

    @Override
    public Quality getQuality() {
        return rate;
    }

    @Override
    public void setQuality(Quality quality) {
        rate = quality;
    }

    public String getName() {
        return name;
    }
}

package week02project;

public class MeetingRoom {
    private String name;
    private int length;
    private int widht;

    public MeetingRoom(String name, int length, int widht) {
        this.name = name;
        this.length = length;
        this.widht = widht;
    }

    public int getArea(){
        return length * widht;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidht() {
        return widht;
    }

    public void setWidht(int widht) {
        this.widht = widht;
    }
}

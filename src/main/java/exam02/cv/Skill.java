package exam02.cv;

public class Skill {

    private String name;
    private int level;

    public Skill(String name, int level) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Cannot be null or blank");
        }
        this.name = name;
        if (level < 1 || level > 5) {
            throw new IllegalArgumentException("Must be between 1 - 5");
        }
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }
}

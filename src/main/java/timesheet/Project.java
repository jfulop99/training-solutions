package timesheet;

public class Project {

    private final String name;

    public Project(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is cannot be blank");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        return name.equals(project.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}

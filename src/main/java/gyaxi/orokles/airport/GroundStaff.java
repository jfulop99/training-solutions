package gyaxi.orokles.airport;

public class GroundStaff extends Person {
    private String job;

    public GroundStaff(String name, int age, String job) {
        super(name, age, PersonType.GROUND_STAFF);
        this.job = job;
    }

    public String getJob() {
        return job;
    }
}

package stringconcat.employee;

public class Employee {
    private String name;
    private String job;
    private int salary;

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public int getSalary() {
        return salary;
    }

    public Employee(String name, String job, int salary) {

        if (name.length() == 0) {
            throw new IllegalArgumentException("Name must not be empty.");
        }
        else {
            this.name = name;
        }
        if (job == null || job.length() == 0){
            throw new IllegalArgumentException("Job must not be empty.");
        }
        else {
            this.job = job;
        }
        if (salary < 1000 || (salary % 1000) != 0){
            throw new IllegalArgumentException("Salary must be positive.");
        }
        else {
            this.salary = salary;
        }
    }

    @Override
    public String toString() {
        return name + " - " + job + " - " + salary + " Ft";
    }
}

package week12.d05;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private int age;
    private int skillLevel;
    private String name;
    private List<String> skills;

    public Employee(int age, int skillLevel, String name, List<String> skills) {
        this.age = age;
        this.skillLevel = skillLevel;
        this.name = name;
        if (skills == null) {
        this.skills = new ArrayList<>();
        }else {
            this.skills = new ArrayList<>(skills);
        }
    }

    public int getAge() {
        return age;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public String getName() {
        return name;
    }

    public List<String> getSkills() {
        return new ArrayList<>(skills);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "skillLevel=" + skillLevel +
                ", name='" + name + '\'' +
                ", skills=" + skills +
                '}';
    }
}

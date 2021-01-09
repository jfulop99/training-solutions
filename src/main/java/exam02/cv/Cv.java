package exam02.cv;

import java.util.ArrayList;
import java.util.List;

public class Cv {

    private String name;
    private List<Skill> skills;

    public Cv(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Cannot be null or blank");
        }
        this.name = name;
        skills = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Skill> getSkills() {
        return new ArrayList<>(skills);
    }

    public void addSkills(String...skill) {
        for (String item:skill) {
            String[] parts = item.split("[()]");
            String name = parts[0].trim();
            int level = Integer.parseInt(parts[1]);
            skills.add(new Skill(name, level));
        }
    }

    public int findSkillLevelByName(String skillName) {
        if (skillName == null || skillName.isBlank()) {
            throw new IllegalArgumentException("Cannot be null or blank");
        }
        for (Skill skill:skills) {
            if (skill.getName().equals(skillName)) {
                return skill.getLevel();
            }
        }
        throw new SkillNotFoundException();
    }
}

package lambdaintro;


import java.util.ArrayList;
import java.util.List;

public class Member {

    private String name;
    private List<String> skills;
    private Sex gender;
    private List<String> messages;

    public Member(String name, List<String> skills, Sex gender) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Invalid name");
        }
        this.name = name;
        if (skills == null) {
            this.skills = new ArrayList<>();
        }
        this.skills = new ArrayList<>(skills);
        this.gender = gender;
        messages = new ArrayList<>();
    }

    public void sendMessage(String message) {
        if (message != null || !message.isBlank()) {
            messages.add(message);
        }
    }

    public String getName() {
        return name;
    }

    public List<String> getSkills() {
        return new ArrayList<>(skills);
    }

    public Sex getGender() {
        return gender;
    }

    public List<String> getMessages() {
        return new ArrayList<>(messages);
    }
}

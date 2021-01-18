package clone.issuetracker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Issue {

    private String name;

    private LocalDateTime time;

    private Status status;

    private List<Comment> comments;

    public Issue(String name, LocalDateTime time, Status status) {
        this.name = name;
        this.time = time;
        this.status = status;
        this.comments = new ArrayList<>();
    }

    public Issue(Issue issue, CopyMode copyMode) {
        this.name = issue.name;
        this.time = issue.time;
        this.status = issue.status;
        this.comments = new ArrayList<>();
        if (copyMode == CopyMode.WITH_COMMENTS) {
            for (Comment item:issue.getComments()) {
                comments.add(new Comment(item));
            }
        }
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Status getStatus() {
        return status;
    }

    public List<Comment> getComments() {
        return comments;
    }
}

package collectionsqueue.collectionspriorityqueue;

public class Job implements Comparable<Job>{

    private final int priority;

    private final String jobDescription;

    private final boolean urgent;

    public Job(int priority, String jobDescription) {
        this.priority = priority;
        this.jobDescription = jobDescription;
        if (priority < 5) {
            urgent = true;
        }
        else {
            urgent = false;
        }
    }

    @Override
    public int compareTo(Job job) {
        return Integer.compare(priority, job.getPriority());
    }

    public int getPriority() {
        return priority;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public boolean isUrgent() {
        return urgent;
    }
}

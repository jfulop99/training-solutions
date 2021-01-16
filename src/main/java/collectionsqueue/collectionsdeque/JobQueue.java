package collectionsqueue.collectionsdeque;

import collectionsqueue.collectionspriorityqueue.Job;
import collectionsqueue.collectionspriorityqueue.NoJobException;

import java.util.ArrayDeque;
import java.util.Deque;

public class JobQueue {

    public Deque<Job> addJobByUrgency(Job... jobs) {
        Deque<Job> jobs1 = new ArrayDeque<>();
        for (Job item:jobs) {
            if (item.isUrgent()){
                jobs1.addFirst(item);
            }
            else {
                jobs1.addLast(item);
            }
        }
        return jobs1;
    }

    public Job dispatchUrgentJob(Deque<Job> jobs) throws NoJobException {
        if (jobs == null || jobs.isEmpty()) {
            throw new NoJobException("No job available, get a rest!");
        }
        return jobs.pollFirst();
    }

    public Job dispatchNotUrgentJob(Deque<Job> jobs) throws NoJobException {
        if (jobs == null || jobs.isEmpty()) {
            throw new NoJobException("No job available, get a rest!");
        }
        return jobs.pollLast();
    }

}

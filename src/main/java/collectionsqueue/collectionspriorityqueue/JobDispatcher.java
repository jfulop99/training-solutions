package collectionsqueue.collectionspriorityqueue;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class JobDispatcher {


    Queue<Job> addJob(Job... jobs) {
        PriorityQueue<Job> jobs1 = new PriorityQueue<>(Arrays.asList(jobs));
        return jobs1;
    }

    Job dispatchNextJob(Queue<Job> jobs) throws NoJobException {
        if (jobs == null || jobs.isEmpty()) {
            throw new NoJobException("No job available, get a rest!");
        }
        return jobs.poll();
    }
}

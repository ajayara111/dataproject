package hello;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;


public class ForkJoinExample extends RecursiveTask<Long> {

    private long workLoad = 0;

    public ForkJoinExample(long workLoad) {
        this.workLoad = workLoad;
    }

    @Override
    protected Long compute() {

        //if work is above threshold, break tasks up into smaller tasks
        if(this.workLoad > 16) {
            System.out.println("Splitting workLoad : " + this.workLoad);

            List<ForkJoinExample> subtasks =
                    new ArrayList<ForkJoinExample>();
            subtasks.addAll(createSubtasks());

            for(ForkJoinExample subtask : subtasks){
                subtask.fork();
            }

            long result = 0;
            for(ForkJoinExample subtask : subtasks) {
                result += subtask.join();
            }
            return result;

        } else {
            System.out.println("Doing workLoad myself: " + this.workLoad);
            return workLoad * 3;
        }
    }

    private List<ForkJoinExample> createSubtasks() {
        List<ForkJoinExample> subtasks =
                new ArrayList<ForkJoinExample>();

        ForkJoinExample subtask1 = new ForkJoinExample(this.workLoad / 2);
        ForkJoinExample subtask2 = new ForkJoinExample(this.workLoad / 2);

        subtasks.add(subtask1);
        subtasks.add(subtask2);

        return subtasks;
    }

    public static void main (String [] v){
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        ForkJoinExample forkJoinExample = new ForkJoinExample(128);

        long mergedResult = forkJoinPool.invoke(forkJoinExample);

        System.out.println("mergedResult = " + mergedResult);
    }
}
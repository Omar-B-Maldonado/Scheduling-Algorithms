import java.util.ArrayList;

/* This class selects task in the order of highest priority to lowest
 * while allocating each task a timeSlice of 10 to run.
 * If the task is incomplete after running for its alloted time, it gets added to the back of the queue.
 */
public class PriorityRR implements Algorithm
{
    private ArrayList<Task> queue;
    private ArrayList<ArrayList<Task>> multilevelQueue; //each level is an array list of tasks;
    private int timeSlice = 10;

    public PriorityRR(ArrayList<Task> queue)
    {
        this.queue = queue;
        //sort queue by priority
        //split queue into levels (sorted by priority)
        multilevelQueue = new ArrayList<>();
        
        //add 10 "mini queues" to the multi level queue (one for each priority level)
        for (int i = 0; i < 10; i++) 
        {
            multilevelQueue.add(new ArrayList<Task>());
        }

        //add each Task to its corresponding mini queue (queue index = priority - 1)
        for (Task T : queue) 
        {
             multilevelQueue.get(T.getPriority() - 1).add(T);
        }
    }

    @Override
    public void schedule()
    {
        //RR through each queue level from highest to lowest
        for (int i = 9; i >= 0; i--)
        {
            new RR(multilevelQueue.get(i)).schedule();
        }
    }

    @Override
    public Task pickNextTask()
    {
        //Do nothing, RR does it for us!
        return null;
    }
    
}

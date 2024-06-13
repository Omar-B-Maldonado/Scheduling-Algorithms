import java.util.ArrayList;

/* This class uses a multilevel qeueue to schedule tasks in order of priority
 * and uses round-robin scheduling for tasks with equal priority.
 * The multilevel queue is an ArrayList of 10 ArrayLists, where each inner ArrayList
 * corresponds to a level their indices 0-9 correspond 1:1 with priorities 1-10.
 */
public class PriorityRR implements Algorithm
{
    private ArrayList<ArrayList<Task>> multilevelQueue; //each level is an ArrayList of tasks;

    public PriorityRR(ArrayList<Task> queue)
    {
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
        //RR through each queue level from highest (priority 10) to lowest (priority 1)
        for (int i = 9; i >= 0; i--)
        {
            new RR(multilevelQueue.get(i)).schedule();
        }
    }
    
    /* This method does nothing, the RR subroutine selects tasks for us! */
    @Override
    public Task pickNextTask()
    {
        return null; 
    }
    
}

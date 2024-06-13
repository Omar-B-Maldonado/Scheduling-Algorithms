import java.util.ArrayList;

/* This class selects task in the order of highest priority to lowest
 * while allocating each task a timeSlice of 10 to run.
 * If the task is incomplete after running for its alloted time, it gets added to the back of the queue.
 */
public class PriorityRR implements Algorithm
{
    private ArrayList<Task> queue;
    private ArrayList<ArrayList<Task>> levels; //each level is an array list of tasks;
    private int timeSlice = 10;

    public PriorityRR(ArrayList<Task> queue)
    {
        this.queue = queue;
        //sort queue by priority
        //split queue into levels (sorted by priority)
    }

    @Override
    public void schedule()
    {
        
    }

    @Override
    public Task pickNextTask() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pickNextTask'");
    }
    
}

import java.util.ArrayList;

/* This class selects task in the order in which they request the CPU
 * while allocating each class a timeSlice of 10 to run.
 * If the task is incomplete after running for its alloted time, it gets added to the back of the queue.
 */
public class RR implements Algorithm
{
    private ArrayList<Task> queue;
    private int timeSlice = 10;
    
    public RR(ArrayList<Task> queue)
    {
        this.queue = queue;
    }

    /* This method runs the selected task for a timeSlice of 10
     * and adds it to the back of the queue if the task still has remaining burst time */
    @Override
    public void schedule() 
    {
        while (!queue.isEmpty())
        {
            Task T = pickNextTask();
            int burstTime = T.getBurstTime();
            
            //if the task has less than {timeSlice} left in burst time, run it for the remainder of its burst time
            CPU.run(T, Math.min(burstTime, timeSlice));
            
            //update the task's remaining burst time and add it to the back of the queue if needed
            T.setBurstTime(burstTime - timeSlice);
            if (T.getBurstTime() > 0) queue.addLast(T);
        }
    }

    /* This method selects the first task in the queue */
    @Override
    public Task pickNextTask() 
    {
        return queue.removeFirst();
    }
    
}

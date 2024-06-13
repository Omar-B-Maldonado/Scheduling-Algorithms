import java.util.ArrayList;

/* This class selects tasks in the order in which they request the CPU.
 * The selected is allocated to the CPU for a timeSlice of 10
 * and is added to the back of the queue if it still has remaining burst time.
 */
public class RR implements Algorithm
{
    private ArrayList<Task> queue;
    private int timeSlice = 10; //each task will run for a timeslice of 10
    
    public RR(ArrayList<Task> queue)
    {
        this.queue = queue;
    }

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

    @Override
    public Task pickNextTask() 
    {
        return queue.removeFirst(); //removes and returns the queue's first task
    }
    
}

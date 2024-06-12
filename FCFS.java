import java.util.ArrayList;

/* This class schedules tasks in the order in which they
 * request the CPU
 */
public class FCFS implements Algorithm
{
    private ArrayList<Task> queue;

    public FCFS(ArrayList<Task> queue)
    {
        this.queue = queue;
    }

    /* This method selects a task via the FCFS scheduling critera
     * and allocates the CPU to that task */
    @Override
    public void schedule() 
    {
        while (!queue.isEmpty())
        {
            Task selected = pickNextTask();             //select a task
            CPU.run(selected, selected.getBurstTime()); //run it on the CPU
        }
    }

    /* This method removes and returns the first Task from the queue (FCFS) */
    @Override
    public Task pickNextTask() 
    {
        return queue.removeFirst();
    }
}

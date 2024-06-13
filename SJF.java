import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SJF implements Algorithm{
    
    private ArrayList<Task> queue;

    public SJF(ArrayList<Task> queue)
    {
        this.queue = queue;

        //sorts the queue by the task burst time
        Collections.sort(queue, Comparator.comparingInt(Task::getBurstTime)); 
        //the comparator specifies what to order - comparing integers
        //Task::getBurstTime is a method reference operator and uses a direct reference to the method by name
    }

    /* This method selects a task via the SJF scheduling critera
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


    @Override
    public Task pickNextTask() 
    {
        return queue.removeFirst(); //returns and removes the first task in the queue
    }
        

}

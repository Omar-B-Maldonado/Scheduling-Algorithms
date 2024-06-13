import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
//Priorty
public class PRI implements Algorithm{

 private ArrayList<Task> queue;



public PRI(ArrayList<Task> queue)
    {
        this.queue = queue;

        //sorts the queue by the task Priority
        Collections.sort(queue, Comparator.comparingInt(Task::getPriority)); 
        //the comparator specifies what to order - comparing integers
       
    }


    @Override
    public void schedule() {
        while (!queue.isEmpty())
        {
            Task selected = pickNextTask();             //select a task
            CPU.run(selected, selected.getPriority()); //run it on the CPU
        }
       
    }

    @Override
    public Task pickNextTask() {
       
        return queue.removeLast(); //returns and removes the first task in the queue
    } 
}

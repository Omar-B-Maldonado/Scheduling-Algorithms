/* This class emonstrates different scheduling algorithms.
 * 
 * Main() reads in the schedule of tasks (via reading the schedule.txt file)
 * and inserts each task into an ArrayList.
 * 
 * Then, it invokes the process scheduler by
 * calling the schedule() method
 * 
 * Usage:
 *  
 *  java Driver <algorithm> <scheduleFile>
 *
 * where scheduleFile is a .txt file containing a schedule of tasks
 *
 *  algorithm = {FCFS, SJF, PRI, RR, PRI-RR}
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Driver 
{
    ArrayList<Task> tasks;

    
    public static void main(String[] args) throws IOException
    {
        if (args.length != 2) {
            System.err.println("Args as <algorithm> <scheduleTextFile>");
        }

        //create queue of tasks
        ArrayList<Task> queue = new ArrayList<Task>();

        BufferedReader inFile = new BufferedReader(new FileReader(args[1]));
        String schedule;
        //read the schedule text and populate the queue
         while ( (schedule = inFile.readLine()) != null) {
            String[] params = schedule.split(",\\s*");
            queue.add(new Task(params[0], Integer.parseInt(params[1]), Integer.parseInt(params[2])));
        }

        Algorithm scheduler = null;
        String algoType = args[0].toUpperCase();

        switch(algoType) {
            case "FCFS": 
                scheduler = new FCFS(queue);
                break;
            case "SJF": 
                scheduler = new SJF(queue);
                break;
            case "PRI": 
                //scheduler = new PRI(queue);
                break;
            case "RR": 
                scheduler = new RR(queue);
                break;
            case "PRI-RR": 
                //scheduler = new PriorityRR(queue);
                break;
            default:
                System.err.println("Invalid algorithm");
                System.exit(0);
        }

        scheduler.schedule();
    }
}
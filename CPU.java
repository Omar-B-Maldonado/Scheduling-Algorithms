public class CPU
{
    /* Run the specified task for the specified slice of time */
    public static void run(Task task, int timeSlice)
    {
        System.out.println(task.run() + " for " + timeSlice);
    }
}

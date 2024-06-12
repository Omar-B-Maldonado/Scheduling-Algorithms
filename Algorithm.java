public interface Algorithm
{
    // Implementation of scheduling algorithm
    public void schedule();
    
    // Selects the next task to be scheduled
    public Task pickNextTask();
}
public class Task implements Runnable
{
    private String name;
    private int    priority;
    private int    burstTime;

    public Task(String name, int priority, int burstTime)
    {
        this.name      = name;
        this.priority  = priority;
        this.burstTime = burstTime;
    }

    /* Appropriate getters */
    public String getName() {
        return name;
    }
    public int getPriority() {
        return priority;
    }
    public int getBurstTime() {
        return burstTime;
    }

    /* Appropriate setters */
    public void setPriority(int priority) {
        this.priority = priority;
    } 
    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    /**
     * We override equals() so we can use a
     * Task object in Java collection classes.
     */
    public boolean equals(Object other) {
        if (this == other) return true;
        else return false;
    }

    @Override
    public void run() 
    {
        System.out.println("Running " + this);
    }

    @Override
    public String toString()
    {
        return (name + ", " + priority + ", " + burstTime);
    }
}

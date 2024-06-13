public class Task
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

    /* We override equals() so we can use a
     * Task object in Java collection classes. */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        else return false;
    }

    /* Returns this task's running status to the CPU as a String */
    public String run() 
    {
        return ("Running " + "(" + this + ")");
    }

    @Override
    public String toString()
    {
        return (name + ", " + priority + ", " + burstTime);
    }
}

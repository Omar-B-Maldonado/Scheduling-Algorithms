Process Scheduler Simulator
---------------------------

This project involves implementing several different process scheduling algorithms. There is a predefined set of tasks that will be scheduled based on the selected scheduling algorithms. Each task is assigned a priority and burst time.

### Scheduling Algorithms Implemented:  
1. **First-come, first-served (FCFS)**: schedules the tasks in the order they request the CPU.
2. **Shortest-job-first (SJF)**: schedules tasks in order of the length of the tasks' next CPU burst.
3. **Priority (PRI)**: schedules tasks based on priority.
4. **Round-Robin (RR)**: each task is run for a time quantum (or for the remainder of its CPU burst).
5. **Priority with Round-Robin (PRI-RR)**: schedules tasks in order of priority and uses round-robin scheduling for tasks with equal priority.

Priorities range from 1 to 10, where a higher numeric value indicates a higher relative priority. For round-robin scheduling, the length of a time quantum is 10 milliseconds.

### Running the Program:
1. Clone the repo
2. cd into the folder via the terminal
3. Compile and run using the following command: **java Driver fcfs schedule.txt**

Replace 'fcfs' with the desired scheduling algorithm (sjf, pri, rr, pri-rr)

### Implementation Details
Driver.java reads the schedule of tasks, inserts them into a queue(ArrayList), and invokes the process scheduler by the 'schedule()' method. The Algorithm interface identifies a generic scheduling algorithm that the different algorithms will implement. 

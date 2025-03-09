class FogNode {
    private String name;
    private int cpuPower;
    private int memory;
    private int storage;
    private int bandwidth;

    public FogNode(String name, int cpuPower, int memory, int storage, int bandwidth) {
        this.name = name;
        this.cpuPower = cpuPower;
        this.memory = memory;
        this.storage = storage;
        this.bandwidth = bandwidth;
    }

    public void assignTask(FogNode worker, Task task) {
        System.out.println(name + " is assigning task: " + task.getTaskName() + " to " + worker.getName());
    }

    public String getName() {
        return name;
    }
}

class Task {
    private String taskName;
    private int taskSize;

    public Task(String taskName, int taskSize) {
        this.taskName = taskName;
        this.taskSize = taskSize;
    }

    public String getTaskName() {
        return taskName;
    }

    public int getTaskSize() {
        return taskSize;
    }
}

public class MasterWorkerSimulation {
    public static void main(String[] args) {
        // Master node setup
        FogNode master = new FogNode("Master", 4000, 8192, 50000, 1000);

        // Worker nodes setup
        FogNode worker1 = new FogNode("Worker1", 2000, 4096, 20000, 500);
        FogNode worker2 = new FogNode("Worker2", 2000, 4096, 20000, 500);

        // Task distribution
        Task task1 = new Task("Task1", 500);
        Task task2 = new Task("Task2", 700);

        master.assignTask(worker1, task1);
        master.assignTask(worker2, task2);

        System.out.println("Simulation Completed");
    }
}
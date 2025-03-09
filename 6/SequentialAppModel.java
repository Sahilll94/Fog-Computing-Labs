public class SequentialAppModel {
    public static void main(String[] args) {
        // Create a fog node with some specifications
        FogNode master = new FogNode("Master", 4000, 8192, 50000, 1000);

        // Create two tasks
        Task task1 = new Task("Task1", 300); // Task1 takes 300ms
        Task task2 = new Task("Task2", 400); // Task2 takes 400ms

        // Execute tasks on the master fog node
        master.executeTask(task1);
        master.executeTask(task2);

        // Print when execution completes
        System.out.println("Unidirectional Sequential Execution Completed");
    }
}

class FogNode {
    String name;
    int cpuSpeed;
    int ram;
    int storage;
    int networkBandwidth;

    // Constructor to initialize the fog node
    public FogNode(String name, int cpuSpeed, int ram, int storage, int networkBandwidth) {
        this.name = name;
        this.cpuSpeed = cpuSpeed;
        this.ram = ram;
        this.storage = storage;
        this.networkBandwidth = networkBandwidth;
    }

    // Method to execute tasks on this fog node
    public void executeTask(Task task) {
        System.out.println(name + " is executing " + task.getName() + " which takes " + task.getExecutionTime() + " ms.");
        try {
            Thread.sleep(task.getExecutionTime()); // Simulate task execution delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(task.getName() + " execution completed.");
    }
}

class Task {
    String name;
    int executionTime;

    // Constructor to initialize a task
    public Task(String name, int executionTime) {
        this.name = name;
        this.executionTime = executionTime;
    }

    // Getter for task name
    public String getName() {
        return name;
    }

    // Getter for task execution time
    public int getExecutionTime() {
        return executionTime;
    }
}
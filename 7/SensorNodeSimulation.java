public class SensorNodeSimulation {
    public static void main(String[] args) {
        // Create a SensorNode with a name and emission rate of 10 tuples/sec
        SensorNode sensor = new SensorNode("TempSensor", 10); 

        // Create a FogNode (Processor) with specific specifications
        FogNode processor = new FogNode("Processor", 2000, 4096, 20000, 500);

        // Connect the sensor to the processor
        sensor.connectTo(processor);

        // Emit 10 tuples/sec
        sensor.emitTuples(10);

        // Print simulation completion
        System.out.println("Sensor Node Simulation Completed");
    }
}

// SensorNode Class
class SensorNode {
    String name;
    int emissionRate; // Tuples per second
    FogNode connectedNode;

    // Constructor for initializing SensorNode
    public SensorNode(String name, int emissionRate) {
        this.name = name;
        this.emissionRate = emissionRate;
    }

    // Connect the sensor node to a FogNode
    public void connectTo(FogNode fogNode) {
        this.connectedNode = fogNode;
        System.out.println(name + " connected to " + fogNode.getName());
    }

    // Emit tuples to the connected FogNode
    public void emitTuples(int numberOfTuples) {
        System.out.println(name + " emitting " + numberOfTuples + " tuples/sec to " + connectedNode.getName());
        try {
            // Simulate the emission of tuples over time
            Thread.sleep(1000); // 1 second per emission cycle
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Emitted " + numberOfTuples + " tuples to " + connectedNode.getName());
    }
}

// FogNode Class
class FogNode {
    String name;
    int cpuSpeed;
    int ram;
    int storage;
    int networkBandwidth;

    // Constructor to initialize FogNode
    public FogNode(String name, int cpuSpeed, int ram, int storage, int networkBandwidth) {
        this.name = name;
        this.cpuSpeed = cpuSpeed;
        this.ram = ram;
        this.storage = storage;
        this.networkBandwidth = networkBandwidth;
    }

    // Getter for name
    public String getName() {
        return name;
    }
}

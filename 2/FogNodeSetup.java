public class FogNodeSetup {
    public static void main(String[] args) {
        // Creating Fog Nodes with different configurations
        FogNode fogNode1 = new FogNode("Node1", 1000, 2048, 10000, 100);
        FogNode fogNode2 = new FogNode("Node2", 2000, 4096, 20000, 200);
        
        // Displaying Fog Node configurations
        System.out.println("Fog Node 1 Configuration: " + fogNode1);
        System.out.println("Fog Node 2 Configuration: " + fogNode2);
    }
}

// Class representing a Fog Node
class FogNode {
    String name;
    int mips, ram, storage, bw;

    public FogNode(String name, int mips, int ram, int storage, int bw) {
        this.name = name;
        this.mips = mips;
        this.ram = ram;
        this.storage = storage;
        this.bw = bw;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", MIPS: " + mips + ", RAM: " + ram + "MB, Storage: " + storage + "GB, Bandwidth: " + bw + "Mbps";
    }
}
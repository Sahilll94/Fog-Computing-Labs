import java.util.ArrayList;
import java.util.List;

class Application {
    private String name;
    private List<AppModule> modules;
    private List<Edge> edges;

    public Application(String name, List<AppModule> modules) {
        this.name = name;
        this.modules = modules;
        this.edges = new ArrayList<>();
    }

    public void addModule(AppModule module) {
        modules.add(module);
    }

    public void addEdge(String fromModule, String toModule, int bandwidth, int latency) {
        AppModule from = null, to = null;
        for (AppModule module : modules) {
            if (module.getName().equals(fromModule)) {
                from = module;
            }
            if (module.getName().equals(toModule)) {
                to = module;
            }
        }
        if (from != null && to != null) {
            edges.add(new Edge(from, to, bandwidth, latency));
        }
    }

    @Override
    public String toString() {
        return "Application{name='" + name + "', modules=" + modules + ", edges=" + edges + "}";
    }
}

class AppModule {
    private String name;
    private int cpuRequirement;
    private int memoryRequirement;

    public AppModule(String name, int cpuRequirement, int memoryRequirement) {
        this.name = name;
        this.cpuRequirement = cpuRequirement;
        this.memoryRequirement = memoryRequirement;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "AppModule{name='" + name + "', cpuRequirement=" + cpuRequirement + ", memoryRequirement=" + memoryRequirement + "}";
    }
}

class Edge {
    private AppModule fromModule;
    private AppModule toModule;
    private int bandwidth;
    private int latency;

    public Edge(AppModule fromModule, AppModule toModule, int bandwidth, int latency) {
        this.fromModule = fromModule;
        this.toModule = toModule;
        this.bandwidth = bandwidth;
        this.latency = latency;
    }

    @Override
    public String toString() {
        return "Edge{from=" + fromModule.getName() + ", to=" + toModule.getName() + ", bandwidth=" + bandwidth + ", latency=" + latency + "}";
    }
}

public class ApplicationModel {
    public static void main(String[] args) {
        // Create Application
        Application app = new Application("MyApp", new ArrayList<>());

        // Add modules to the application
        AppModule sensorModule = new AppModule("Sensor", 100, 500);
        AppModule processingModule = new AppModule("Processor", 2000, 1024);
        app.addModule(sensorModule);
        app.addModule(processingModule);

        // Define communication between modules
        app.addEdge("Sensor", "Processor", 100, 10);

        System.out.println("Application Model Created: " + app);
    }
}
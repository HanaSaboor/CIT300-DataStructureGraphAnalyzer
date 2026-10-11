
import java.util.*;

public class GraphManager {

    private final Map<String, Set<String>> adjacencyList =
            new LinkedHashMap<>();

    // Number of vertex entries processed and neighbours inspected
    // during the most recent BFS or DFS traversal.
    private int lastTraversalSteps = 0;

    public int getLastTraversalSteps() {
        return lastTraversalSteps;
    }

    // Add a vertex to the graph
    public void addVertex(String vertex) {

        if (vertex == null || vertex.trim().isEmpty()) {
            System.out.println("Vertex cannot be empty.");
            return;
        }

        vertex = vertex.trim();

        if (adjacencyList.containsKey(vertex)) {
            System.out.println("Vertex already exists.");
            return;
        }

        adjacencyList.put(vertex, new LinkedHashSet<>());

        System.out.println("Vertex added: " + vertex);
    }

    // Add an undirected edge between two existing vertices
    public void addEdge(String source, String destination) {

        if (source == null || destination == null
                || source.trim().isEmpty()
                || destination.trim().isEmpty()) {
            System.out.println(
                    "Source and destination cannot be empty.");
            return;
        }

        source = source.trim();
        destination = destination.trim();

        if (!adjacencyList.containsKey(source)
                || !adjacencyList.containsKey(destination)) {
            System.out.println("Both vertices must exist first.");
            return;
        }

        if (adjacencyList.get(source).contains(destination)) {
            System.out.println("Edge already exists.");
            return;
        }

        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);

        System.out.println("Undirected edge added successfully.");
    }

    // Display the graph using an adjacency list
    public void displayGraph() {

        if (adjacencyList.isEmpty()) {
            System.out.println("Graph is empty.");
            return;
        }

        System.out.println("\n--- GRAPH (ADJACENCY LIST) ---");

        for (Map.Entry<String, Set<String>> entry
                : adjacencyList.entrySet()) {

            System.out.println(
                    entry.getKey() + " -> " + entry.getValue());
        }
    }

    // Breadth-First Search using a queue
    public List<String> bfs(String start) {

        lastTraversalSteps = 0;

        List<String> traversal = new ArrayList<>();

        if (start == null) {
            return traversal;
        }

        start = start.trim();

        if (!adjacencyList.containsKey(start)) {
            return traversal;
        }

        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new LinkedHashSet<>();

        visited.add(start);
        queue.offer(start);

        while (!queue.isEmpty()) {

            String current = queue.poll();

            // Count the processed vertex entry
            lastTraversalSteps++;

            traversal.add(current);

            // Inspect each neighbouring vertex
            for (String neighbour : adjacencyList.get(current)) {

                lastTraversalSteps++;

                if (visited.add(neighbour)) {
                    queue.offer(neighbour);
                }
            }
        }

        return traversal;
    }

    // Depth-First Search using a stack
    public List<String> dfs(String start) {

        lastTraversalSteps = 0;

        List<String> traversal = new ArrayList<>();

        if (start == null) {
            return traversal;
        }

        start = start.trim();

        if (!adjacencyList.containsKey(start)) {
            return traversal;
        }

        Set<String> visited = new LinkedHashSet<>();
        Deque<String> stack = new ArrayDeque<>();

        stack.push(start);

        while (!stack.isEmpty()) {

            String current = stack.pop();

            // Count the processed stack entry
            lastTraversalSteps++;

            if (!visited.add(current)) {
                continue;
            }

            traversal.add(current);

            List<String> neighbours =
                    new ArrayList<>(adjacencyList.get(current));

            // Reverse insertion order for predictable traversal.
            for (int i = neighbours.size() - 1; i >= 0; i--) {

                String neighbour = neighbours.get(i);

                lastTraversalSteps++;

                if (!visited.contains(neighbour)) {
                    stack.push(neighbour);
                }
            }
        }

        return traversal;
    }

    // Interactive graph menu
    public void run(Scanner scanner) {

        int choice;

        do {
            System.out.println("\n--- GRAPH OPERATIONS ---");
            System.out.println("1. Add Vertex");
            System.out.println("2. Add Edge");
            System.out.println("3. Display Graph");
            System.out.println("4. BFS Traversal");
            System.out.println("5. DFS Traversal");
            System.out.println("0. Return to Main Menu");

            choice = InputHelper.readInt(
                    scanner, "Enter choice: ");

            switch (choice) {

                case 1: {
                    String vertex = InputHelper.readText(
                            scanner, "Enter vertex name: ");

                    addVertex(vertex);
                    break;
                }

                case 2: {
                    String source = InputHelper.readText(
                            scanner, "Enter source vertex: ");

                    String destination = InputHelper.readText(
                            scanner, "Enter destination vertex: ");

                    addEdge(source, destination);
                    break;
                }

                case 3: {
                    displayGraph();
                    break;
                }

                case 4: {
                    String bfsStart = InputHelper.readText(
                            scanner, "Enter starting vertex: ");

                    List<String> bfsResult = bfs(bfsStart);

                    if (bfsResult.isEmpty()) {
                        System.out.println(
                                "No traversal: check the starting vertex.");
                    } else {
                        System.out.println("BFS: " + bfsResult);
                    }

                    break;
                }

                case 5: {
                    String dfsStart = InputHelper.readText(
                            scanner, "Enter starting vertex: ");

                    List<String> dfsResult = dfs(dfsStart);

                    if (dfsResult.isEmpty()) {
                        System.out.println(
                                "No traversal: check the starting vertex.");
                    } else {
                        System.out.println("DFS: " + dfsResult);
                    }

                    break;
                }

                case 0:
                    System.out.println(
                            "Returning to Main Menu.");
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Please try again.");
            }

        } while (choice != 0);
    }
}

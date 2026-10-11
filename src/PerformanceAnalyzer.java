
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PerformanceAnalyzer {

    public static void run(
            Scanner scanner,
            ArrayManager arrayManager,
            GraphManager graphManager) {

        int choice;

        do {
            System.out.println("\n========== PERFORMANCE ANALYZER ==========");
            System.out.println("1. Search Performance Comparison");
            System.out.println("2. Graph Traversal Performance");
            System.out.println("0. Return to Main Menu");

            choice = InputHelper.readInt(scanner, "Enter choice: ");

            switch (choice) {
                case 1:
                    analyzeSearching(scanner, arrayManager);
                    break;

                case 2:
                    analyzeGraphTraversal(scanner, graphManager);
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }

    private static void analyzeSearching(
            Scanner scanner,
            ArrayManager arrayManager) {

        int[] originalData = arrayManager.getValues();

        if (originalData.length == 0) {
            System.out.println("The array is empty.");
            System.out.println(
                    "Insert elements using Array Operations first.");
            return;
        }

        System.out.println("\n--- SEARCH PERFORMANCE COMPARISON ---");
        System.out.println(
                "Original array: " + Arrays.toString(originalData));

        int target = InputHelper.readInt(
                scanner, "Enter value to search for: ");

        // Linear Search
        int linearComparisons = 0;
        int linearResult = -1;

        long linearStart = System.nanoTime();

        for (int i = 0; i < originalData.length; i++) {
            linearComparisons++;

            if (originalData[i] == target) {
                linearResult = i;
                break;
            }
        }

        long linearTime = System.nanoTime() - linearStart;

        // Sort a copy so the original array remains unchanged.
        int[] sortedData = Arrays.copyOf(
                originalData, originalData.length);
        Arrays.sort(sortedData);

        // Binary Search
        int binaryComparisons = 0;
        int binaryResult = -1;

        int left = 0;
        int right = sortedData.length - 1;

        long binaryStart = System.nanoTime();

        while (left <= right) {
            int middle = left + (right - left) / 2;
            binaryComparisons++;

            if (sortedData[middle] == target) {
                binaryResult = middle;
                break;
            } else if (sortedData[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        long binaryTime = System.nanoTime() - binaryStart;

        System.out.println("\n--- LINEAR SEARCH ---");
        System.out.println("Result: "
                + (linearResult >= 0
                ? "Found at original index " + linearResult
                : "Value not found"));
        System.out.println("Comparisons: " + linearComparisons);
        System.out.println("Execution time: " + linearTime + " ns");
        System.out.println("Time complexity: O(n)");

        System.out.println("\n--- BINARY SEARCH ---");
        System.out.println("Sorted copy: "
                + Arrays.toString(sortedData));
        System.out.println("Result: "
                + (binaryResult >= 0
                ? "Found at sorted-array index " + binaryResult
                : "Value not found"));
        System.out.println("Comparisons: " + binaryComparisons);
        System.out.println("Execution time: " + binaryTime + " ns");
        System.out.println("Time complexity: O(log n)");

        System.out.println("\n--- SEARCH ANALYSIS ---");

        if (linearComparisons < binaryComparisons) {
            System.out.println(
                    "Linear Search used fewer counted comparisons.");
        } else if (binaryComparisons < linearComparisons) {
            System.out.println(
                    "Binary Search used fewer counted comparisons.");
        } else {
            System.out.println(
                    "Both searches used the same number of counted comparisons.");
        }

        System.out.println(
                "Note: Sorting time is excluded from Binary Search timing.");
        System.out.println(
                "Execution times can vary between runs.");
    }

    private static void analyzeGraphTraversal(
            Scanner scanner,
            GraphManager graphManager) {

        System.out.println("\n--- GRAPH TRAVERSAL PERFORMANCE ---");

        String startVertex = InputHelper.readText(
                scanner, "Enter starting vertex: ").trim();

        // Measure BFS.
        long bfsStart = System.nanoTime();
        List<String> bfsResult = graphManager.bfs(startVertex);
        long bfsTime = System.nanoTime() - bfsStart;
        int bfsSteps = graphManager.getLastTraversalSteps();

        if (bfsResult.isEmpty()) {
            System.out.println(
                    "No traversal performed. Check that the starting "
                    + "vertex exists in the graph.");
            return;
        }

        // Measure DFS.
        long dfsStart = System.nanoTime();
        List<String> dfsResult = graphManager.dfs(startVertex);
        long dfsTime = System.nanoTime() - dfsStart;
        int dfsSteps = graphManager.getLastTraversalSteps();

        System.out.println("\n--- BREADTH-FIRST SEARCH (BFS) ---");
        System.out.println("Traversal result: " + bfsResult);
        System.out.println("Vertices visited: " + bfsResult.size());
        System.out.println(
                "Traversal steps (vertex entries + neighbour checks): "
                + bfsSteps);
        System.out.println("Execution time: " + bfsTime + " ns");
        System.out.println("Time complexity: O(V + E)");

        System.out.println("\n--- DEPTH-FIRST SEARCH (DFS) ---");
        System.out.println("Traversal result: " + dfsResult);
        System.out.println("Vertices visited: " + dfsResult.size());
        System.out.println(
                "Traversal steps (vertex entries + neighbour checks): "
                + dfsSteps);
        System.out.println("Execution time: " + dfsTime + " ns");
        System.out.println("Time complexity: O(V + E)");

        System.out.println("\n--- GRAPH PERFORMANCE NOTES ---");
        System.out.println(
                "V = number of vertices; E = number of edges.");
        System.out.println(
                "Traversal visits only vertices reachable from the start.");
        System.out.println(
                "BFS uses a queue, while DFS uses a stack.");
        System.out.println(
                "Step counts use the same defined metric for both traversals.");
        System.out.println(
                "Execution times can vary and may be very small for small graphs.");
    }
}

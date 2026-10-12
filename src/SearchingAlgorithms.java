
import java.util.Arrays;
import java.util.Scanner;

public class SearchingAlgorithms {

    private int lastLinearSteps;
    private int lastBinarySteps;
    private long lastLinearTime;
    private long lastBinaryTime;

    public int linearSearch(int[] data, int target) {
        int steps = 0;
        long start = System.nanoTime();

        for (int i = 0; i < data.length; i++) {
            steps++;

            if (data[i] == target) {
                lastLinearSteps = steps;
                lastLinearTime = System.nanoTime() - start;
                return i;
            }
        }

        lastLinearSteps = steps;
        lastLinearTime = System.nanoTime() - start;
        return -1;
    }

    public int binarySearch(int[] data, int target) {
        int left = 0;
        int right = data.length - 1;
        int steps = 0;
        long start = System.nanoTime();

        while (left <= right) {
            steps++;

            int mid = left + (right - left) / 2;

            if (data[mid] == target) {
                lastBinarySteps = steps;
                lastBinaryTime = System.nanoTime() - start;
                return mid;
            }

            if (data[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        lastBinarySteps = steps;
        lastBinaryTime = System.nanoTime() - start;
        return -1;
    }

    public void compareSearches(int[] original, int target) {
        int[] sorted = Arrays.copyOf(original, original.length);
        Arrays.sort(sorted);

        int linearResult = linearSearch(original, target);
        int binaryResult = binarySearch(sorted, target);

        System.out.println("\n--- SEARCH PERFORMANCE COMPARISON ---");
        System.out.println("Target: " + target);
        System.out.println("Original array: " + Arrays.toString(original));
        System.out.println("Sorted copy: " + Arrays.toString(sorted));

        System.out.println("\nLinear Search");
        System.out.println("Result index: " + linearResult);
        System.out.println("Comparisons: " + lastLinearSteps);
        System.out.println("Time: " + lastLinearTime + " ns");

        System.out.println("\nBinary Search");
        System.out.println("Result index in sorted copy: " + binaryResult);
        System.out.println("Comparisons: " + lastBinarySteps);
        System.out.println("Time: " + lastBinaryTime + " ns");

        System.out.println("\nComplexities:");
        System.out.println("Linear Search: O(n)");
        System.out.println("Binary Search: O(log n), on sorted data");
    }

    // Compares both searches on larger sorted arrays (worst case: value not found)
    // so the difference between O(n) and O(log n) becomes easy to see.
    public void runLargeBenchmark() {
        int[] sizes = {1000, 10000, 100000, 1000000};

        System.out.println("\n--- LARGE ARRAY BENCHMARK (worst case: value not found) ---");
        System.out.printf("%-12s %-14s %-14s %-16s %-16s%n",
                "Array size", "Linear steps", "Binary steps",
                "Linear time(ns)", "Binary time(ns)");

        for (int size : sizes) {
            // Sorted array of even numbers, so binary search can be used directly
            int[] data = new int[size];
            for (int i = 0; i < size; i++) {
                data[i] = i * 2;
            }

            // -1 is not in the array, so both searches do the maximum work
            int target = -1;
            linearSearch(data, target);
            binarySearch(data, target);

            System.out.printf("%-12d %-14d %-14d %-16d %-16d%n",
                    size, lastLinearSteps, lastBinarySteps,
                    lastLinearTime, lastBinaryTime);
        }

        System.out.println("\nLinear Search steps grow with n: O(n).");
        System.out.println("Binary Search steps grow very slowly: O(log n), but needs sorted data.");
        System.out.println("Note: times can vary between runs; the step counts show the real difference.");
    }

    public void run(Scanner scanner, ArrayManager arrayManager) {
        boolean back = false;

        while (!back) {
            System.out.println("\n--------------- SEARCHING OPERATIONS ------------");
            System.out.println("1. Compare searches on my array");
            System.out.println("2. Large array benchmark (1,000 to 1,000,000 values)");
            System.out.println("3. Return to Main Menu");

            int choice = InputHelper.readInt(scanner, "Enter your choice: ");

            switch (choice) {
                case 1:
                    int[] values = arrayManager.getValues();

                    if (values.length == 0) {
                        System.out.println("Insert values into the array first.");
                        break;
                    }

                    int target = InputHelper.readInt(
                            scanner, "Enter value to search for: ");
                    compareSearches(values, target);
                    break;
                case 2:
                    runLargeBenchmark();
                    break;
                case 3:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2 or 3.");
            }
        }
    }
}

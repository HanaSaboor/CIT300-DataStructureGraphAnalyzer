
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

    public void run(Scanner scanner, ArrayManager arrayManager) {
        int[] values = arrayManager.getValues();

        if (values.length == 0) {
            System.out.println("Insert values into the array first.");
            return;
        }

        int target = InputHelper.readInt(
                scanner, "Enter value to search for: ");

        compareSearches(values, target);
    }
}

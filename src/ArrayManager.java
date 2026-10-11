import java.util.Arrays;
import java.util.Scanner;

public class ArrayManager {

    private int[] data = new int[5];
    private int size = 0;

    public void insert(int value) {
        if (size == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }

        data[size] = value;
        size++;

        System.out.println("Value inserted successfully.");
    }

    public void delete(int value) {
        int index = search(value);

        if (index == -1) {
            System.out.println("Value not found.");
            return;
        }

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        size--;
        System.out.println("Value deleted successfully.");
    }

    public int search(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                return i;
            }
        }

        return -1;
    }

    public void display() {
        if (size == 0) {
            System.out.println("Array is empty.");
            return;
        }

        System.out.print("Array: ");

        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }

        System.out.println();
    }

    public int[] getValues() {
        return Arrays.copyOf(data, size);
    }

    public void run(Scanner scanner) {
        int choice;

        do {
            System.out.println("\n--- ARRAY OPERATIONS ---");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Display");
            System.out.println("0. Return to Main Menu");

            choice = InputHelper.readInt(scanner, "Enter choice: ");

            switch (choice) {
                case 1:
                    int value = InputHelper.readInt(
                            scanner, "Enter value to insert: ");
                    insert(value);
                    break;

                case 2:
                    value = InputHelper.readInt(
                            scanner, "Enter value to delete: ");
                    delete(value);
                    break;

                case 3:
                    value = InputHelper.readInt(
                            scanner, "Enter value to search: ");
                    int index = search(value);

                    if (index >= 0) {
                        System.out.println(
                                "Found at index: " + index);
                    } else {
                        System.out.println("Value not found.");
                    }
                    break;

                case 4:
                    display();
                    break;

                case 0:
                    System.out.println("Returning to main menu.");
                    break;

                default:
                    System.out.println("Invalid menu choice.");
            }

        } while (choice != 0);
    }
}
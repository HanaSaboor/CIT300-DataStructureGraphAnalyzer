
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class QueueManager {

    private final Queue<Integer> queue = new ArrayDeque<>();

    public void enqueue(int value) {
        queue.offer(value);
        System.out.println("Value enqueued successfully.");
    }

    public void dequeue() {
        Integer removed = queue.poll();

        if (removed == null) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return;
        }

        System.out.println("Dequeued value: " + removed);
    }

    public void peek() {
        Integer front = queue.peek();

        if (front == null) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.println("Front value: " + front);
    }

    public void display() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.println("Queue (front to rear): " + queue);
    }

    public void run(Scanner scanner) {
        int choice;

        do {
            System.out.println("\n--- QUEUE OPERATIONS ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek / Front");
            System.out.println("4. Display");
            System.out.println("0. Return to Main Menu");

            choice = InputHelper.readInt(scanner, "Enter choice: ");

            switch (choice) {
                case 1:
                    enqueue(InputHelper.readInt(scanner, "Enter value: "));
                    break;
                case 2:
                    dequeue();
                    break;
                case 3:
                    peek();
                    break;
                case 4:
                    display();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }
}


import java.util.ArrayList;
import java.util.Scanner;

public class StackManager {

    private final ArrayList<Integer> stack = new ArrayList<>();

    public void push(int value) {
        stack.add(value);
        System.out.println("Value pushed successfully.");
    }

    public void pop() {
        if (stack.isEmpty()) {
            System.out.println("Stack underflow: stack is empty.");
            return;
        }

        int removed = stack.remove(stack.size() - 1);
        System.out.println("Popped value: " + removed);
    }

    public void peek() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("Top value: " + stack.get(stack.size() - 1));
    }

    public void display() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("Stack (bottom to top): " + stack);
    }

    public void run(Scanner scanner) {
        int choice;

        do {
            System.out.println("\n--- STACK OPERATIONS ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("0. Return to Main Menu");

            choice = InputHelper.readInt(scanner, "Enter choice: ");

            switch (choice) {
                case 1:
                    push(InputHelper.readInt(scanner, "Enter value: "));
                    break;
                case 2:
                    pop();
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

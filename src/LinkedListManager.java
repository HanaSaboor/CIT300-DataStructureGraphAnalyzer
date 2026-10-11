
import java.util.Scanner;

public class LinkedListManager {

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;

    public void insert(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        System.out.println("Value inserted successfully.");
    }

    public void delete(int value) {
        if (head == null) {
            System.out.println("Linked list is empty.");
            return;
        }

        if (head.data == value) {
            head = head.next;
            System.out.println("Value deleted successfully.");
            return;
        }

        Node current = head;

        while (current.next != null && current.next.data != value) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Value not found.");
        } else {
            current.next = current.next.next;
            System.out.println("Value deleted successfully.");
        }
    }

    public boolean search(int value) {
        Node current = head;

        while (current != null) {
            if (current.data == value) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    public void display() {
        if (head == null) {
            System.out.println("Linked list is empty.");
            return;
        }

        Node current = head;
        System.out.print("Linked List: ");

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    public void run(Scanner scanner) {
        int choice;

        do {
            System.out.println("\n--- LINKED LIST OPERATIONS ---");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Display");
            System.out.println("0. Return to Main Menu");

            choice = InputHelper.readInt(scanner, "Enter choice: ");

            switch (choice) {
                case 1:
                    insert(InputHelper.readInt(scanner, "Enter value: "));
                    break;
                case 2:
                    delete(InputHelper.readInt(scanner, "Enter value: "));
                    break;
                case 3:
                    int value = InputHelper.readInt(scanner, "Enter value: ");
                    System.out.println(search(value) ? "Value found." : "Value not found.");
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

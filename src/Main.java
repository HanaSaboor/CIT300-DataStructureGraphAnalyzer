
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Initialize all modules
        ArrayManager arrayManager = new ArrayManager();
        StackManager stackManager = new StackManager();
        QueueManager queueManager = new QueueManager();
        LinkedListManager linkedListManager = new LinkedListManager();
        SearchingAlgorithms searchingAlgorithms = new SearchingAlgorithms();
        GraphManager graphManager = new GraphManager();

        int choice;

        do {
            System.out.println("\n==================================");
            System.out.println(" DATA STRUCTURE & GRAPH ANALYZER");
            System.out.println("==================================");
            System.out.println("1. Array Operations");
            System.out.println("2. Stack Operations");
            System.out.println("3. Queue Operations");
            System.out.println("4. Linked List Operations");
            System.out.println("5. Searching Operations");
            System.out.println("6. Graph Operations");
            System.out.println("7. Performance Analyzer");
            System.out.println("0. Exit");
            System.out.println("==================================");

            choice = InputHelper.readInt(scanner, "Enter choice: ");

            switch (choice) {

                case 1:
                    arrayManager.run(scanner);
                    break;

                case 2:
                    stackManager.run(scanner);
                    break;

                case 3:
                    queueManager.run(scanner);
                    break;

                case 4:
                    linkedListManager.run(scanner);
                    break;

                case 5:
                    searchingAlgorithms.run(scanner, arrayManager);
                    break;

                case 6:
                    graphManager.run(scanner);
                    break;

                case 7:
                    PerformanceAnalyzer.run(
                            scanner,
                            arrayManager,
                            graphManager
                    );
                    break;
                case 0:
                    System.out.println("\nApplication closed.");
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Please select a valid option."
                    );
            }

        } while (choice != 0);

        scanner.close();
    }
}

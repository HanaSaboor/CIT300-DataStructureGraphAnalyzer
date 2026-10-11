import java.util.Scanner;

public class InputHelper {

    public static int readInt(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);

            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine(); // Clear remaining input
                return value;
            }

            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // Discard invalid input
        }
    }

    public static String readText(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }
}
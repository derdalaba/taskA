package exam.kit.util.system;

import java.util.Scanner;

/**
 * Represents a class that provides debugging io utilities.
 * @author uepiy
 */

public final class DebugIo {
    private DebugIo() {
    }
    /**
     * Returns a boolean value from the debug input.
     * @param message the context message to be displayed
     * @return the boolean value from the user input
     */
    public static boolean getDebugDecisionBool(String message) {
        System.out.println("Decide " + message + ": yes or no? (y/n)");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("y")) {
                return true;
            } else if (line.equals("n")) {
                return false;
            } else {
                System.err.println("Invalid input. Please enter 'y' or 'n'.");
            }
        }
        return false;
    }
    /**
     * Returns a double value from the debug input.
     * @param message the context message to be displayed
     * @param min the minimum value
     * @param max the maximum value
     * @return the double value from the user input
     */
    public static double getDebugDecisionDouble(String message, double min, double max) {
        System.out.println("Decide " + message + ": a double between %f and %f".formatted(min, max));
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.matches("[-+]?[0-9]*\\.?[0-9]+")) {
                if (Double.parseDouble(line) >= min && Double.parseDouble(line) < max) {
                    return Double.parseDouble(line);
                } else {
                    System.err.printf("Invalid input. Please enter a double between %f and %f.%n", min, max);
                }
            } else {
                System.err.printf("Invalid input. Please enter a double between %f and %f.%n", min, max);
            }
        }
        return min;
    }
    /**
     * Returns an integer value from the debug input.
     * @param message the context message to be displayed
     * @param min the minimum value
     * @param max the maximum value
     * @return the integer value from the user input
     */
    public static int getDebugDecisionInteger(String message, int min, int max) {
        System.out.println("Decide " + message + ": a double between %d and %d".formatted(min, max));
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.matches("[-+]?[0-9]+")) {
                if (Integer.parseInt(line) >= min && Integer.parseInt(line) <= max) {
                    return Integer.parseInt(line);
                } else {
                    System.err.printf("Invalid input. Please enter a double between %d and %d.%n", min, max);
                }
            } else {
                System.err.printf("Invalid input. Please enter a double between %d and %d.%n", min, max);
            }
        }
        return min;
    }

}

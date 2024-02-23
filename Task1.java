import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GradeTracker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> grades = new ArrayList<>();

        System.out.println("Welcome to the Student Grade Tracker!");

        // Input loop
        while (true) {
            System.out.print("Enter a grade (or type 'done' to finish): ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("done")) {
                break;
            }

            try {
                double grade = Double.parseDouble(input);
                if (grade < 0 || grade > 100) {
                    System.out.println("Please enter a valid grade between 0 and 100.");
                    continue;
                }
                grades.add(grade);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number or 'done' to finish.");
            }
        }

        // Calculate average, highest, and lowest scores
        double sum = 0;
        double average;
        double highest;
        double lowest;

        if (grades.isEmpty()) {
            average = 0;
            highest = 0;
            lowest = 0;
        } else {
            for (Double grade : grades) {
                sum += grade;
            }
            average = sum / grades.size();
            highest = Collections.max(grades);
            lowest = Collections.min(grades);
        }

        // Output results
        System.out.println("Total number of grades entered: " + grades.size());
        System.out.println("Average score: " + average);
        System.out.println("Highest score: " + highest);
        System.out.println("Lowest score: " + lowest);

        scanner.close();
    }
}
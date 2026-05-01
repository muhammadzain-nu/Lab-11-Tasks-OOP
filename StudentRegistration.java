package Tasks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentRegistration {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> registeredCourses = new ArrayList<>();
        final int MAX_CREDIT_HOURS = 15;
        final int CREDITS_PER_COURSE = 3;
        final int MAX_COURSES = MAX_CREDIT_HOURS / CREDITS_PER_COURSE; // 5 courses max

        // 1. Get student information
        System.out.print("Enter Student's Full Name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();

        // 2 & 3. Check prerequisites for OOP
        System.out.print("Enter marks obtained in PF Theory (out of 100): ");
        int pfTheoryMarks = scanner.nextInt();

        System.out.print("Enter marks obtained in PF Lab (out of 100): ");
        int pfLabMarks = scanner.nextInt();
        scanner.nextLine();


        if (pfTheoryMarks >= 50 && pfLabMarks >= 50) {
            registeredCourses.add("OOP Theory");
            registeredCourses.add("OOP Lab");
            System.out.println(" Prerequisites met. Automatically registered for OOP Theory and OOP Lab.");
        } else {
            System.out.println(" Prerequisites not met. Cannot register for OOP courses.");
        }


        System.out.println("\n--- Additional Course Registration ---");
        System.out.println("Note: Each course is 3 credit hours. Max limit is 15 credit hours (" + MAX_COURSES + " courses).");

        while (registeredCourses.size() < MAX_COURSES) {
            int currentCredits = registeredCourses.size() * CREDITS_PER_COURSE;
            System.out.println("Current registered credits: " + currentCredits + "/" + MAX_CREDIT_HOURS);
            System.out.print("Enter a course name to register (or type 'done' to finish): ");
            String course = scanner.nextLine();

            if (course.equalsIgnoreCase("done")) {
                break;
            }

            registeredCourses.add(course);
            System.out.println("Course '" + course + "' added.");
        }

        if (registeredCourses.size() == MAX_COURSES) {
            System.out.println(" Maximum credit limit (15 hours) reached.");
        }


        String fileName = studentName.replaceAll("\\s+", "_") + ".txt";
        File file = new File(fileName);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("Student Name: " + studentName);
            writer.newLine();
            writer.write("Student ID: " + studentId);
            writer.newLine();
            writer.write("Total Credit Hours Registered: " + (registeredCourses.size() * CREDITS_PER_COURSE));
            writer.newLine();
            writer.write("--- Registered Courses ---");
            writer.newLine();

            if (registeredCourses.isEmpty()) {
                writer.write("No courses registered.");
                writer.newLine();
            } else {
                for (String course : registeredCourses) {
                    writer.write("- " + course);
                    writer.newLine();
                }
            }
            System.out.println("\nData successfully written to file: " + fileName);

        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
            return;
        }

        System.out.println("\n --- Reading Data From File ---");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }

        scanner.close();
    }
}

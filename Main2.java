package Tasks;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        File file = new File("Confidential.txt");

        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter designation: ");
        String designation = scanner.nextLine();

        if (designation.equalsIgnoreCase("Faculty")) {
            file.setReadable(true);
            file.setWritable(true);
            file.setExecutable(true);
        } else if (designation.equalsIgnoreCase("Student")) {
            file.setReadable(true);
            file.setWritable(false);
            file.setExecutable(false);
        } else {
            System.out.println("Invalid designation.");
            System.exit(0);
        }

        System.out.println("Access Rights Status:");
        System.out.println("Read Permission: " + file.canRead());
        System.out.println("Write Permission: " + file.canWrite());
        System.out.println("Execute Permission: " + file.canExecute());

        scanner.close();
    }
}

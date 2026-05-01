import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        System.out.println("Please enter 5 elements:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            list.add(scanner.nextLine());
        }

        String userHome = System.getProperty("user.home");
        String filePath = userHome + File.separator + "Desktop" + File.separator + "arrayListOutput.txt";
        File file = new File(filePath);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String item : list) {
                writer.write(item);
                writer.newLine(); // Move to the next line
            }
            System.out.println("\n Successfully wrote to the file: " + file.getName());
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
            return; // Exit if writing fails
        }

        System.out.println("\nReading items from the file:");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("- " + line);
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }

        if (file.delete()) {
            System.out.println("\n File '" + file.getName() + "' successfully deleted from Desktop.");
        } else {
            System.err.println("\nFailed to delete the file. It may be open in another program.");
        }

        scanner.close();
    }
}
package Tasks;

import java.util.Scanner;

class Authenticator<T, U> {
    private T storedUsername;
    private U storedPassword;

    public Authenticator(T storedUsername, U storedPassword) {
        this.storedUsername = storedUsername;
        this.storedPassword = storedPassword;
    }

    public void authenticate(T inputUsername, U inputPassword) {
        if (this.storedUsername.equals(inputUsername) && this.storedPassword.equals(inputPassword)) {
            System.out.println("Logon successful. Welcome to the system.");
        } else {
            System.out.println("Authentication failed. Terminating program.");
            System.exit(1);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Authenticator<String, String> auth = new Authenticator<>("admin", "password123");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String user = scanner.nextLine();

        System.out.print("Enter password: ");
        String pass = scanner.nextLine();

        auth.authenticate(user, pass);

        scanner.close();
    }
}

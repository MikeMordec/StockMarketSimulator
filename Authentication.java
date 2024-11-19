import java.util.HashMap;
import java.util.Scanner;

public class Authentication {
    private HashMap<String, User> users;

    public Authentication() {
        users = new HashMap<>();
    }

    // Register a new user
    public boolean registerUser(String username, String password) {
        if (users.containsKey(username)) {
            return false; // Username already exists
        }
        users.put(username, new User(username, password));
        return true;
    }

    // Login an existing user
    public User login(String username, String password) {
        if (users.containsKey(username)) {
            User user = users.get(username);
            if (user.checkPassword(password)) {
                return user;
            }
        }
        return null; // Invalid credentials
    }
}

Example Usage

public class Main {
    public static void main(String[] args) {
        Authentication auth = new Authentication();
        Scanner scanner = new Scanner(System.in);

        // Register new user
        System.out.println("Register a new user:");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        if (auth.registerUser(username, password)) {
            System.out.println("Registration successful!");
        } else {
            System.out.println("Username already exists.");
        }

        // Login
        System.out.println("Login:");
        System.out.print("Username: ");
        String loginUsername = scanner.nextLine();
        System.out.print("Password: ");
        String loginPassword = scanner.nextLine();
        User user = auth.login(loginUsername, loginPassword);
        if (user != null) {
            System.out.println("Welcome " + user.getUsername() + "!");
        } else {
            System.out.println("Invalid username or password.");
        }
    }
}

public class Report {

    public static void generateUserReport(User user) {
        System.out.println("User Report for " + user.getUsername());
        // Display user's balance, portfolio value, etc.
        System.out.println("Balance: " + user.getBalance());
        user.getPortfolio().showPortfolio();
    }
}

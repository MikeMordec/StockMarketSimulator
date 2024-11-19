import java.util.HashMap;

public class User {
    private String username;
    private String password;
    private HashMap<String, Integer> portfolio; // Stock name and amount

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.portfolio = new HashMap<>();
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    // Adds stock to the user's portfolio
    public void addStock(String stockName, int amount) {
        portfolio.put(stockName, portfolio.getOrDefault(stockName, 0) + amount);
    }

    // Removes stock from the user's portfolio
    public void removeStock(String stockName, int amount) {
        if (portfolio.containsKey(stockName) && portfolio.get(stockName) >= amount) {
            portfolio.put(stockName, portfolio.get(stockName) - amount);
        }
    }

    // Returns portfolio (stock name and amount)
    public HashMap<String, Integer> getPortfolio() {
        return portfolio;
    }

    @Override
    public String toString() {
        return "Username: " + username + ", Portfolio: " + portfolio.toString();
    }
}

import java.util.HashMap;

public class Portfolio {
    private HashMap<String, Integer> stocksOwned;
    private User owner;

    public Portfolio(User owner) {
        this.owner = owner;
        stocksOwned = new HashMap<>();
    }

    public void buyStock(String stockSymbol, int quantity) {
        stocksOwned.put(stockSymbol, stocksOwned.getOrDefault(stockSymbol, 0) + quantity);
    }

    public void sellStock(String stockSymbol, int quantity) {
        if (stocksOwned.containsKey(stockSymbol) && stocksOwned.get(stockSymbol) >= quantity) {
            stocksOwned.put(stockSymbol, stocksOwned.get(stockSymbol) - quantity);
        } else {
            System.out.println("Not enough stocks to sell.");
        }
    }

    public void showPortfolio() {
        System.out.println("Portfolio for " + owner.getUsername() + ":");
        for (String stock : stocksOwned.keySet()) {
            System.out.println("Stock: " + stock + ", Quantity: " + stocksOwned.get(stock));
        }
    }
}

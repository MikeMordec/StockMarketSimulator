import java.util.HashMap;

public class Stock {
    private String stockName;
    private double currentPrice;
    private HashMap<String, Double> priceHistory; // Date -> Price

    public Stock(String stockName, double initialPrice) {
        this.stockName = stockName;
        this.currentPrice = initialPrice;
        this.priceHistory = new HashMap<>();
        this.priceHistory.put("2023-01-01", initialPrice); // Example starting point
    }

    // Update the price on a specific date
    public void updatePrice(String date, double newPrice) {
        this.currentPrice = newPrice;
        priceHistory.put(date, newPrice);
    }

    // Get the current price
    public double getCurrentPrice() {
        return currentPrice;
    }

    // Get the price history
    public HashMap<String, Double> getPriceHistory() {
        return priceHistory;
    }

    @Override
    public String toString() {
        return "Stock: " + stockName + ", Current Price: " + currentPrice + ", Price History: " + priceHistory.toString();
    }
}

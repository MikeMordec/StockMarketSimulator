import java.util.HashMap;

public class StockHistory {
    private HashMap<String, HashMap<String, Double>> stockHistory;

    public StockHistory() {
        stockHistory = new HashMap<>();
    }

    public void addPrice(String stockSymbol, String date, double price) {
        if (!stockHistory.containsKey(stockSymbol)) {
            stockHistory.put(stockSymbol, new HashMap<>());
        }
        stockHistory.get(stockSymbol).put(date, price);
    }

    public Double getPrice(String stockSymbol, String date) {
        if (stockHistory.containsKey(stockSymbol)) {
            return stockHistory.get(stockSymbol).get(date);
        }
        return null; // No data for that date
    }

    public void displayHistory(String stockSymbol) {
        if (stockHistory.containsKey(stockSymbol)) {
            System.out.println("Price history for " + stockSymbol + ":");
            stockHistory.get(stockSymbol).forEach((date, price) -> {
                System.out.println("Date: " + date + " Price: " + price);
            });
        }
    }
}

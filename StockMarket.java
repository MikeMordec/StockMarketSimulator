public class StockMarket {
    private HashMap<String, Stock> availableStocks;
    private HashMap<String, User> users;

    public StockMarket() {
        availableStocks = new HashMap<>();
        users = new HashMap<>();
        // Initialize some stocks in the market
        availableStocks.put("AAPL", new Stock("AAPL", 150.0));
        availableStocks.put("GOOG", new Stock("GOOG", 2700.0));
    }

    public boolean buyStock(User user, String stockSymbol, int quantity) {
        if (availableStocks.containsKey(stockSymbol)) {
            double price = availableStocks.get(stockSymbol).getPrice();
            double cost = price * quantity;
            if (user.getBalance() >= cost) {
                user.deductBalance(cost);
                user.getPortfolio().buyStock(stockSymbol, quantity);
                System.out.println("Purchase successful!");
                return true;
            }
        }
        return false;
    }

    public void addUser(User user) {
        users.put(user.getUsername(), user);
    }
}

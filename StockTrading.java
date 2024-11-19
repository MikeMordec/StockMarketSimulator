public class StockTrading {
    private double userBalance; // User's balance for trading

    public StockTrading(double initialBalance) {
        this.userBalance = initialBalance;
    }

    // Buying stocks
    public boolean buyStock(User user, Stock stock, int amount) {
        double totalCost = stock.getCurrentPrice() * amount;
        if (userBalance >= totalCost) {
            user.addStock(stock.getStockName(), amount);
            userBalance -= totalCost;
            return true;
        }
        return false; // Not enough balance
    }

    // Selling stocks
    public boolean sellStock(User user, Stock stock, int amount) {
        if (user.getPortfolio().containsKey(stock.getStockName()) &&
            user.getPortfolio().get(stock.getStockName()) >= amount) {
            user.removeStock(stock.getStockName(), amount);
            userBalance += stock.getCurrentPrice() * amount;
            return true;
        }
        return false; // Not enough stocks
    }

    public double getUserBalance() {
        return userBalance;
    }
}

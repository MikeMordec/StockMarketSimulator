public class StockPriceFetcher {

    public static double getCurrentPrice(String stockSymbol) {
        // In a real scenario, fetch this data from an API like Alpha Vantage or Yahoo Finance
        // For simplicity, return mock data
        switch (stockSymbol) {
            case "AAPL":
                return 150.0;
            case "GOOG":
                return 2700.0;
            default:
                return 100.0; // Default mock price
        }
    }
}

public class Transaction {
    private String stockSymbol;
    private int quantity;
    private double price;
    private String type; // "buy" or "sell"
    private String date;

    public Transaction(String stockSymbol, int quantity, double price, String type, String date) {
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.price = price;
        this.type = type;
        this.date = date;
    }

    // Getters and setters, toString, etc

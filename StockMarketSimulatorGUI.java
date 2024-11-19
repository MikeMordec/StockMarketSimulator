import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class StockMarketSimulatorGUI {
    private static Authentication auth = new Authentication();
    private static User currentUser = null;
    private static JFrame frame;

    public static void main(String[] args) {
        frame = new JFrame("Stock Market Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        showLoginPanel();

        frame.setVisible(true);
    }

    // Login Screen
    private static void showLoginPanel() {
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Welcome to the Stock Market Simulator!");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginPanel.add(titleLabel);

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);

        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");

        // Login logic
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            User user = auth.login(username, password);
            if (user != null) {
                currentUser = user;
                showMainMenu();
            } else {
                JOptionPane.showMessageDialog(frame, "Oops! Invalid username or password.");
            }
        });

        // Register logic
        registerButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            boolean success = auth.registerUser(username, password);
            if (success) {
                JOptionPane.showMessageDialog(frame, "You're all set up! Login now.");
            } else {
                JOptionPane.showMessageDialog(frame, "This username's already taken. Try another one.");
            }
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(loginButton);
        buttonsPanel.add(registerButton);
        loginPanel.add(buttonsPanel);

        frame.getContentPane().removeAll();
        frame.getContentPane().add(loginPanel);
        frame.revalidate();
    }

    // Main Menu after successful login
    private static void showMainMenu() {
        JPanel mainMenuPanel = new JPanel();
        mainMenuPanel.setLayout(new BoxLayout(mainMenuPanel, BoxLayout.Y_AXIS));

        JLabel welcomeLabel = new JLabel("Welcome back, " + currentUser.getUsername() + "!");
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainMenuPanel.add(welcomeLabel);

        JButton viewPortfolioButton = new JButton("View Portfolio");
        JButton tradeStocksButton = new JButton("Trade Stocks");
        JButton logoutButton = new JButton("Logout");

        // View portfolio logic
        viewPortfolioButton.addActionListener(e -> showPortfolioPanel());

        // Stock trading logic
        tradeStocksButton.addActionListener(e -> showStockListPanel());

        // Logout logic
        logoutButton.addActionListener(e -> {
            currentUser = null;
            showLoginPanel();
        });

        mainMenuPanel.add(viewPortfolioButton);
        mainMenuPanel.add(tradeStocksButton);
        mainMenuPanel.add(logoutButton);

        frame.getContentPane().removeAll();
        frame.getContentPane().add(mainMenuPanel);
        frame.revalidate();
    }

    // Display available stocks and let the user trade
    private static void showStockListPanel() {
        JPanel stockListPanel = new JPanel();
        stockListPanel.setLayout(new BoxLayout(stockListPanel, BoxLayout.Y_AXIS));

        JLabel stockListLabel = new JLabel("Here are some stocks you can trade:");
        stockListLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        stockListPanel.add(stockListLabel);

        // Example stocks
        String[] stockSymbols = {"AAPL", "GOOG", "AMZN"};
        double[] stockPrices = {150.25, 2800.75, 3400.50};

        for (int i = 0; i < stockSymbols.length; i++) {
            JPanel stockPanel = new JPanel();
            stockPanel.setLayout(new FlowLayout());
            JLabel stockLabel = new JLabel(stockSymbols[i] + " - $" + stockPrices[i]);
            JButton buyButton = new JButton("Buy");
            JButton sellButton = new JButton("Sell");

            // Buy stock logic
            buyButton.addActionListener(e -> {
                double price = stockPrices[i];
                currentUser.buyStock(stockSymbols[i], price);
                JOptionPane.showMessageDialog(frame, "You've bought 1 share of " + stockSymbols[i]);
            });

            // Sell stock logic
            sellButton.addActionListener(e -> {
                double price = stockPrices[i];
                currentUser.sellStock(stockSymbols[i], price);
                JOptionPane.showMessageDialog(frame, "You've sold 1 share of " + stockSymbols[i]);
            });

            stockPanel.add(stockLabel);
            stockPanel.add(buyButton);
            stockPanel.add(sellButton);
            stockListPanel.add(stockPanel);
        }

        JButton backButton = new JButton("Back to Main Menu");
        backButton.addActionListener(e -> showMainMenu());
        stockListPanel.add(backButton);

        frame.getContentPane().removeAll();
        frame.getContentPane().add(stockListPanel);
        frame.revalidate();
    }

    // Show user portfolio
    private static void showPortfolioPanel() {
        JPanel portfolioPanel = new JPanel();
        portfolioPanel.setLayout(new BoxLayout(portfolioPanel, BoxLayout.Y_AXIS));

        JLabel portfolioLabel = new JLabel("Here's your portfolio:");
        portfolioLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        portfolioPanel.add(portfolioLabel);

        // Show user’s stocks (just sample data for now)
        HashMap<String, Integer> portfolio = currentUser.getPortfolio();
        for (String stockSymbol : portfolio.keySet()) {
            JLabel stockLabel = new JLabel(stockSymbol + " - " + portfolio.get(stockSymbol) + " shares");
            portfolioPanel.add(stockLabel);
        }

        JButton backButton = new JButton("Back to Main Menu");
        backButton.addActionListener(e -> showMainMenu());
        portfolioPanel.add(backButton);

        frame.getContentPane().removeAll();
        frame.getContentPane().add(portfolioPanel);
        frame.revalidate();
    }
}

class User {
    private String username;
    private double balance;
    private HashMap<String, Integer> portfolio;

    public User(String username) {
        this.username = username;
        this.balance = 10000; // Starting balance
        this.portfolio = new HashMap<>();
    }

    public String getUsername() {
        return username;
    }

    public HashMap<String, Integer> getPortfolio() {
        return portfolio;
    }

    public void buyStock(String symbol, double price) {
        if (balance >= price) {
            balance -= price;
            portfolio.put(symbol, portfolio.getOrDefault(symbol, 0) + 1);
        }
    }

    public void sellStock(String symbol, double price) {
        if (portfolio.containsKey(symbol) && portfolio.get(symbol) > 0) {
            portfolio.put(symbol, portfolio.get(symbol) - 1);
            balance += price;
        }
    }
}

class Authentication {
    private HashMap<String, User> users;

    public Authentication() {
        users = new HashMap<>();
    }

    public boolean registerUser(String username, String password) {
        if (users.containsKey(username)) {
            return false; // Username already taken
        }
        users.put(username, new User(username));
        return true;
    }

    public User login(String username, String password) {
        return users.get(username); // Just checking the username for now
    }
}

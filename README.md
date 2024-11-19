StockMarketSimulator

Welcome to StockMarketSimulator! This is a Java-based application that simulates a basic stock market where users can trade stocks, manage their portfolios, and track the performance of their investments. It includes user authentication, stock trading logic, portfolio management, and more, all accessible through an easy-to-use graphical user interface (GUI).
Table of Contents:

    Overview
    Key Features
    Technologies Used
    Getting Started
    File Structure
    Usage
    GUI Interface
    Contributing

Overview

The StockMarketSimulator provides users with a simple interface to interact with a stock market simulation, where they can:

    Register and log in with user authentication.
    Buy and sell stocks based on market prices.
    View stock details, including historical price data.
    Track portfolio performance and overall balance.
    Simulate market changes and get real-time stock price data.

The application now includes a Graphical User Interface (GUI), making it easier for users to navigate and interact with the stock market simulation.
Key Features:

    User Authentication: Register and log in to track trades and manage your portfolio.
    Stock Trading: Buy and sell stocks from available stock listings.
    Portfolio Management: Track your owned stocks and their quantities.
    Stock History: View historical stock prices over time.
    Market Simulation: Simulate random price fluctuations in stock values.
    Reports: Generate reports on user activities, such as profit/loss and portfolio performance.
    Graphical User Interface: A user-friendly GUI for easier navigation.

Features
User Authentication:

    Register and login functionality with username and password.
    Username and password management to ensure secure access.

Stock Trading Logic:

    Simulate stock market with a list of available stocks.
    Ability to buy and sell stocks, updating balance and portfolio.

Portfolio Management:

    Keep track of owned stocks and their quantities.
    See portfolio performance and stock prices.

Stock Price Fetcher:

    Get the latest stock price (can be mocked or fetched from a real API).

Historical Data:

    Track past stock prices and view historical trends.

Market Simulation:

    Simulate price fluctuations or stock market events.

User Reports:

    Generate detailed reports about the user's stock trades, balance, and portfolio.

Graphical User Interface (GUI):

    Login Screen: Users can easily register or log in with a username and password.
    Main Menu: After logging in, users can access their portfolio or trade stocks.
    Stock Trading Screen: View available stocks, buy or sell them with ease.
    Portfolio Screen: View the user's current portfolio and balance, updated in real time.

Technologies Used

    Java: The core programming language used for the simulator.
    Java Swing: Used for building the GUI interface.
    HashMap: Used to store and manage stocks, users, and portfolios.
    Scanner: For user input from the console (non-GUI interactions).
    JOptionPane: For displaying dialog boxes in the GUI.
    FlowLayout / BoxLayout: For organizing GUI components.

Getting Started

To run the StockMarketSimulator locally, follow these steps:
Prerequisites:

    Java 8 or higher.
    A basic understanding of Java and object-oriented programming.
    Familiarity with GUI development using Java Swing.

Steps:

    Clone this repository:

git clone https://github.com/yourusername/StockMarketSimulator.git

Navigate to the project directory:

cd StockMarketSimulator

Compile and run the code:

    javac StockMarketSimulatorGUI.java
    java StockMarketSimulatorGUI

This will launch the StockMarketSimulator application with the GUI interface.
File Structure

Here is a breakdown of the files in this repository:

    Stock.java: Represents an individual stock with attributes like name, symbol, and current price.
    StockMarketSimulator.java: The main class that manages the entire stock market simulation, including user registration and stock transactions.
    StockTrading.java: Handles stock buying, selling, and portfolio management for the user.
    User.java: Defines the User class with attributes like balance, portfolio, and authentication details.
    Authentication.java: Handles the logic for user registration, login, and password validation.
    Portfolio.java: Manages the user's stock holdings, including buying and selling stocks.
    StockHistory.java: Stores and retrieves historical price data for stocks.
    StockPriceFetcher.java: Fetches real-time stock prices from an external source (mocked for simplicity).
    MarketSimulation.java: Simulates random market events that affect stock prices.
    Report.java: Generates reports on user activities, including portfolio performance and balance.
    StockMarketSimulatorGUI.java: Manages the GUI interface for user authentication, stock trading, portfolio management, and more.

Usage

Once you have the project set up, here’s how you can use the application:

    Register a New User:
    When prompted, enter a unique username and password to register.

    Log In:
    After registering, log in with your username and password to start trading.

    Buy and Sell Stocks:
    Choose from available stocks and buy/sell them using your balance. Your portfolio will be updated after each transaction.

    View Portfolio:
    Check your portfolio to see what stocks you own and their quantities.

    View Stock History:
    See historical price data for stocks to help with decision-making.

    Simulate the Market:
    Use market simulation to see how prices fluctuate.

    Generate Reports:
    View reports on your trades, portfolio, and overall balance.

GUI Interface

The StockMarketSimulator GUI enhances the user experience, allowing users to interact with the application through a visual interface:

    Login Screen:
    The login screen allows users to enter their username and password, and offers options to register a new account.

    Main Menu:
    After logging in, users are greeted with a personalized welcome message. From the main menu, they can choose to view their portfolio, trade stocks, or log out.

    Stock Trading Screen:
    Users can view available stocks and trade them. Each stock is displayed with its symbol and current price, and options to buy or sell are provided.

    Portfolio Screen:
    The portfolio screen shows users their current stock holdings, including the number of shares owned and the value of each stock.

The GUI is built using Java Swing components like JPanel, JButton, JLabel, and layout managers like FlowLayout and BoxLayout.
Contributing

We welcome contributions to improve StockMarketSimulator! If you have an idea for a new feature, bug fix, or enhancement, please follow these steps:

    Fork the repository.
    Create a new branch (git checkout -b feature-name).
    Make your changes.
    Commit your changes (git commit -am 'Add new feature').
    Push to your branch (git push origin feature-name).
    Open a pull request with a detailed explanation of the changes.

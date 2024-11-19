import random
import time

class Stock:
    def __init__(self, symbol, name, price):
        self.symbol = symbol
        self.name = name
        self.price = price

    def update_price(self):
        # Simulate a random price change between -5% to +5%
        price_change = random.uniform(-0.05, 0.05)
        self.price += self.price * price_change
        self.price = round(self.price, 2)  # Keep the price to two decimals

    def __str__(self):
        return f"{self.name} ({self.symbol}): ${self.price}"

class Portfolio:
    def __init__(self, balance):
        self.balance = balance
        self.stocks = {}  # Dictionary to track stocks and their quantities

    def buy_stock(self, stock, quantity):
        total_cost = stock.price * quantity
        if total_cost > self.balance:
            print(f"Oops! You don't have enough funds to buy {quantity} shares of {stock.symbol}.")
        else:
            self.balance -= total_cost
            if stock.symbol in self.stocks:
                self.stocks[stock.symbol] += quantity
            else:
                self.stocks[stock.symbol] = quantity
            print(f"Bought {quantity} shares of {stock.symbol} for ${total_cost}. Remaining balance: ${self.balance}")

    def sell_stock(self, stock, quantity):
        if stock.symbol not in self.stocks or self.stocks[stock.symbol] < quantity:
            print(f"Oops! You don't own {quantity} shares of {stock.symbol}.")
        else:
            total_sales = stock.price * quantity
            self.balance += total_sales
            self.stocks[stock.symbol] -= quantity
            if self.stocks[stock.symbol] == 0:
                del self.stocks[stock.symbol]
            print(f"Sold {quantity} shares of {stock.symbol} for ${total_sales}. New balance: ${self.balance}")

    def show_portfolio(self):
        print("\nYour Portfolio:")
        for symbol, quantity in self.stocks.items():
            print(f"{symbol}: {quantity} shares")
        print(f"Cash balance: ${self.balance}")
        print("-" * 40)

def simulate_market(stock):
    stock.update_price()
    print(f"\n{stock} (Price updated!)")

def main():
    # Some example stocks (In a real-world application, you'd pull this from an API)
    apple = Stock('AAPL', 'Apple', 150.00)
    tesla = Stock('TSLA', 'Tesla', 600.00)
    amazon = Stock('AMZN', 'Amazon', 3000.00)

    # Starting with a balance of $10,000
    portfolio = Portfolio(10000)

    print("Welcome to the Stock Investment Simulator!")
    while True:
        print("\nAvailable actions:")
        print("1. Buy Stock")
        print("2. Sell Stock")
        print("3. Check Portfolio")
        print("4. View Stock Prices")
        print("5. Exit")
        action = input("What would you like to do? ")

        if action == '1':
            print("Available stocks:")
            print(apple)
            print(tesla)
            print(amazon)
            stock_choice = input("Enter the symbol of the stock you want to buy: ").upper()
            quantity = int(input("How many shares would you like to buy? "))
            if stock_choice == 'AAPL':
                portfolio.buy_stock(apple, quantity)
            elif stock_choice == 'TSLA':
                portfolio.buy_stock(tesla, quantity)
            elif stock_choice == 'AMZN':
                portfolio.buy_stock(amazon, quantity)
            else:
                print("Invalid stock symbol.")
        elif action == '2':
            print("Your current portfolio:")
            portfolio.show_portfolio()
            stock_choice = input("Enter the symbol of the stock you want to sell: ").upper()
            quantity = int(input("How many shares would you like to sell? "))
            if stock_choice == 'AAPL':
                portfolio.sell_stock(apple, quantity)
            elif stock_choice == 'TSLA':
                portfolio.sell_stock(tesla, quantity)
            elif stock_choice == 'AMZN':
                portfolio.sell_stock(amazon, quantity)
            else:
                print("Invalid stock symbol.")
        elif action == '3':
            portfolio.show_portfolio()
        elif action == '4':
            simulate_market(apple)
            simulate_market(tesla)
            simulate_market(amazon)
        elif action == '5':
            print("Thanks for using the Stock Investment Simulator. Goodbye!")
            break
        else:
            print("Invalid action. Please try again.")

        # Simulate market updates after every action
        time.sleep(2)

if __name__ == "__main__":
    main()

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String stockSymbol, double price);
}

class MobileApp implements Observer {
    private String appName;

    public MobileApp(String appName) {
        this.appName = appName;
    }

    public void update(String stockSymbol, double price) {
        System.out.println("[" + appName + "] Notification - " + stockSymbol + " is now $" + price);
    }
}

class WebApp implements Observer {
    private String url;

    public WebApp(String url) {
        this.url = url;
    }

    public void update(String stockSymbol, double price) {
        System.out.println("[" + url + "] Dashboard Update - " + stockSymbol + " changed to $" + price);
    }
}

interface Stock {
    void registerObserver(Observer o);
    void deregisterObserver(Observer o);
    void notifyObservers();
}

class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private String stockSymbol;
    private double price;

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void deregisterObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockSymbol, price);
        }
    }

    public void setStockData(String stockSymbol, double price) {
        this.stockSymbol = stockSymbol;
        this.price = price;
        notifyObservers();
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp("StockTrader App");
        Observer webApp = new WebApp("www.financetracker.com");

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        System.out.println("--- First Price Update ---");
        stockMarket.setStockData("AAPL", 175.50);

        System.out.println("\n--- Second Price Update ---");
        stockMarket.setStockData("GOOGL", 2800.75);

        System.out.println("\n--- Removing WebApp Client ---");
        stockMarket.deregisterObserver(webApp);

        System.out.println("\n--- Third Price Update ---");
        stockMarket.setStockData("MSFT", 310.20);
    }
}
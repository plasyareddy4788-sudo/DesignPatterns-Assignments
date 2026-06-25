class Logger {
    private static Logger instance;

    private Logger() {}

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }
}

public class SingletonPattern {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("This is the first log message.");

        Logger logger2 = Logger.getInstance();
        logger2.log("This is the second log message.");

        System.out.println("\n--- Verification Test ---");
        if (logger1 == logger2) {
            System.out.println("Success! Both variables point to the exact same Logger instance.");
        } else {
            System.out.println("Failed!");
        }
    }
}
public class Logger {
    // Private static instance of Logger class
    private static Logger instance;

    // Private constructor to prevent instantiation
    private Logger() {
        // Initialize any necessary resources here
    }

    // Public method to provide access to the single instance
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) { // Double-checked locking
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    // Example logging method
    public void log(String message) {
        System.out.println("Log message: " + message);
    }
}

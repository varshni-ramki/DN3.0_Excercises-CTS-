public class SingletonTest {
    public static void main(String[] args) {
        // Attempt to get instances of Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Verify that both references point to the same instance
        if (logger1 == logger2) {
            System.out.println("Both logger instances are the same.");
        } else {
            System.out.println("Logger instances are different.");
        }

        // Use the logger to log messages
        logger1.log("This is the first log message.");
        logger2.log("This is the second log message.");
    }
}

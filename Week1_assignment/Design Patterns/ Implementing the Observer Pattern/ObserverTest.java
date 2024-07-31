public class ObserverTest {
    public static void main(String[] args) {
        // Create a StockMarket instance
        StockMarket stockMarket = new StockMarket();

        // Create observer instances
        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        // Register observers with the stock market
        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        // Update stock price and notify observers
        System.out.println("Updating stock price to $150.0");
        stockMarket.setStockPrice(150.0);

        // Deregister one observer and update stock price again
        stockMarket.deregisterObserver(mobileApp);

        System.out.println("Updating stock price to $175.0");
        stockMarket.setStockPrice(175.0);
    }
}

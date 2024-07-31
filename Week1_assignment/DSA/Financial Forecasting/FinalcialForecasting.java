public class FinancialForecasting {

    // Recursive method to calculate future value
    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        // Base case: if no periods left, return the present value
        if (periods == 0) {
            return presentValue;
        }
        // Recursive case: calculate the value for the next period
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, periods - 1);
    }

    public static void main(String[] args) {
        double presentValue = 1000.0; // Initial value
        double growthRate = 0.05; // 5% growth rate
        int periods = 10; // Number of periods (e.g., years)

        double futureValue = calculateFutureValue(presentValue, growthRate, periods);
        System.out.println("Future Value: " + futureValue);
    }
}

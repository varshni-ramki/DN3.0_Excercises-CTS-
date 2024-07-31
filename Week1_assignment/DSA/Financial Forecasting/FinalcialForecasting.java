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

//Memoization Approach
import java.util.HashMap;
import java.util.Map;

public class FinancialForecasting {

    // Memoized method to calculate future value
    public static double calculateFutureValue(double presentValue, double growthRate, int periods, Map<Integer, Double> memo) {
        // Base case: if no periods left, return the present value
        if (periods == 0) {
            return presentValue;
        }
        // Check if the value is already calculated
        if (memo.containsKey(periods)) {
            return memo.get(periods);
        }
        // Recursive case: calculate the value for the next period and store it in the memo
        double futureValue = calculateFutureValue(presentValue * (1 + growthRate), growthRate, periods - 1, memo);
        memo.put(periods, futureValue);
        return futureValue;
    }

    public static void main(String[] args) {
        double presentValue = 1000.0; // Initial value
        double growthRate = 0.05; // 5% growth rate
        int periods = 10; // Number of periods (e.g., years)

        Map<Integer, Double> memo = new HashMap<>();
        double futureValue = calculateFutureValue(presentValue, growthRate, periods, memo);
        System.out.println("Future Value: " + futureValue);
    }
}
//Iterative Approach
public class FinancialForecasting {

    // Iterative method to calculate future value
    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        double futureValue = presentValue;
        for (int i = 0; i < periods; i++) {
            futureValue *= (1 + growthRate);
        }
        return futureValue;
    }

    public static void main(String[] args) {
        double presentValue = 1000.0; // Initial value
        double growthRate = 0.05; // 5% growth rate
        int periods = 10; // Number of periods (e.g., years)

        double futureValue = calculateFutureValue(presentValue, growthRate, periods);
        System.out.println("Future Value: " + futureValue);
    }
}



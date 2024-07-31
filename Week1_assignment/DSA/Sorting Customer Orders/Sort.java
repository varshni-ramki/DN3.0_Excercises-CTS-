public class SortingAlgorithms {

    // Bubble Sort
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    // Swap orders[j] and orders[j + 1]
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot) {
                i++;
                // Swap orders[i] and orders[j]
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        // Swap orders[i + 1] and orders[high] (or pivot)
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        Order[] orders = {
            new Order(1, "Alice", 250.50),
            new Order(2, "Bob", 100.00),
            new Order(3, "Charlie", 300.00),
            new Order(4, "David", 150.75),
            new Order(5, "Eve", 50.25)
        };

        // Bubble Sort Test
        System.out.println("Bubble Sort:");
        bubbleSort(orders);
        for (Order order : orders) {
            System.out.println(order);
        }

        // Quick Sort Test
        System.out.println("\nQuick Sort:");
        quickSort(orders, 0, orders.length - 1);
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}

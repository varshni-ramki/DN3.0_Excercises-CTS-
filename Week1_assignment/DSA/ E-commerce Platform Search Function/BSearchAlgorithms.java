import java.util.Arrays;
import java.util.Comparator;

public class BSearchAlgorithms {

    // Linear Search
    public static Product linearSearch(Product[] products, int productId) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null; // Not found
    }

    // Binary Search (Assumes the array is sorted by productId)
    public static Product binarySearch(Product[] products, int productId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (products[mid].getProductId() == productId) {
                return products[mid];
            }
            if (products[mid].getProductId() < productId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // Not found
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Smartphone", "Electronics"),
            new Product(3, "Coffee Maker", "Home Appliances"),
            new Product(4, "Headphones", "Electronics"),
            new Product(5, "Vacuum Cleaner", "Home Appliances")
        };

        // Sort the array by productId for binary search
        Arrays.sort(products, Comparator.comparingInt(Product::getProductId));

        // Linear Search Test
        System.out.println("Linear Search:");
        Product foundProduct = linearSearch(products, 3);
        System.out.println(foundProduct != null ? foundProduct : "Product not found");

        // Binary Search Test
        System.out.println("\nBinary Search:");
        foundProduct = binarySearch(products, 3);
        System.out.println(foundProduct != null ? foundProduct : "Product not found");
    }
}

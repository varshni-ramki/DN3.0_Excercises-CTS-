
public class Main {
	
	    public static void main(String[] args) {
	        Inventory inventory = new Inventory();

	        Product product1 = new Product(1, "Laptop", 50, 999.99);
	        Product product2 = new Product(2, "Smartphone", 150, 699.99);

	        // Add products
	        inventory.addProduct(product1);
	        inventory.addProduct(product2);

	        // Display products
	        System.out.println("Inventory after adding products:");
	        inventory.displayProducts();

	        // Update product
	        Product updatedProduct1 = new Product(1, "Gaming Laptop", 40, 1299.99);
	        inventory.updateProduct(1, updatedProduct1);

	        // Display products after update
	        System.out.println("\nInventory after updating product 1:");
	        inventory.displayProducts();

	        // Delete product
	        inventory.deleteProduct(2);

	        // Display products after deletion
	        System.out.println("\nInventory after deleting product 2:");
	        inventory.displayProducts();
	    }
	


}

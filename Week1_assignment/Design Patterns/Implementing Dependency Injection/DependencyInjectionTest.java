public class DependencyInjectionTest {
    public static void main(String[] args) {
        // Create a concrete implementation of CustomerRepository
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        // Inject the repository into the CustomerService
        CustomerService customerService = new CustomerService(customerRepository);

        // Find a customer by ID
        Customer customer = customerService.getCustomer("1");

        // Display customer details
        if (customer != null) {
            System.out.println("Customer ID: " + customer.getId());
            System.out.println("Customer Name: " + customer.getName());
        } else {
            System.out.println("Customer not found.");
        }
    }
}

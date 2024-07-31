public class Main {
    public static void main(String[] args) {
        EmployeeManagement employeeManagement = new EmployeeManagement(10);

        // Add employees
        employeeManagement.addEmployee(new Employee(1, "John Doe", "Manager", 50000));
        employeeManagement.addEmployee(new Employee(2, "Jane Smith", "Developer", 60000));
        employeeManagement.addEmployee(new Employee(3, "Bob Johnson", "Designer", 45000));

        // Traverse employees
        System.out.println("All Employees:");
        employeeManagement.traverseEmployees();

        // Search for an employee
        System.out.println("Searching for Employee with ID 2:");
        Employee employee = employeeManagement.searchEmployee(2);
        System.out.println(employee);

        // Delete an employee
        System.out.println("Deleting Employee with ID 1:");
        boolean isDeleted = employeeManagement.deleteEmployee(1);
        System.out.println("Deleted: " + isDeleted);

        // Traverse employees after deletion
        System.out.println("All Employees after deletion:");
        employeeManagement.traverseEmployees();
    }
}

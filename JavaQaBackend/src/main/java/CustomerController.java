import java.util.ArrayList;
import java.util.Scanner;


public class CustomerController {
    ArrayList<Customer> customers = new ArrayList<Customer>();
    Scanner scanner = new Scanner(System.in);

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public Customer addCustomer(String fName, String lName, String email, String phone){

        Customer newCustomer = new Customer(fName, lName, email, phone);
        customers.add(newCustomer);
        return newCustomer;
    }

    public void showCustomers(){
        for( Customer c : customers) {
            System.out.println(c + "\n");
        }
    }

    public Customer getCustomer(int id){
        for( Customer c : customers) {
            if (c.getId() == id){
                return c;
            }
        }
        System.out.println("Customer not found");
        return null;
    }

    public void deleteCustomer(int id){
        boolean deleted = false;
        Customer customerToDelete = null;
        for( Customer c : customers) {
            if (c.getId() == id){
                deleted = true;
                customerToDelete = c;
            }
        }
        if (!deleted) {
            System.out.println("Customer not found");
        } else {
            customers.remove(customerToDelete);
            System.out.println("Customer " + customerToDelete + " deleted successfully");
        }
    }

    public void updateCustomer(int id){
        boolean updated = false;
        for( Customer c : customers) {
            if (c.getId() == id){
                System.out.println("Old first name: " + c.getFirstName());
                System.out.println("Enter new first name");
                c.setFirstName(scanner.nextLine());
                System.out.println("Old last name: " + c.getLastName());
                System.out.println("Enter new last name");
                c.setLastName(scanner.nextLine());
                System.out.println("Old email: " + c.getEmail());
                System.out.println("Enter new email");
                c.setEmail(scanner.nextLine());
                System.out.println("Old phone number: " + c.getPhoneNumber());
                System.out.println("Enter new phone number");
                c.setPhoneNumber(scanner.nextLine());
                updated = true;
            }
        }
        if (!updated) {
            System.out.println("Customer not found");
        } else {
            System.out.println("Customer updated successfully");
        }
    }
}

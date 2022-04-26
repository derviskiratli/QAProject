import java.util.ArrayList;
import java.util.Scanner;


public class CustomerController {
    ArrayList<Customer> customers = new ArrayList<Customer>();
    Scanner scanner = new Scanner(System.in);

    public Customer addCustomer(){
        System.out.println("Customer first name:");
        String fName = scanner.nextLine();
        System.out.println("Customer last name:");
        String lName = scanner.nextLine();
        System.out.println("Customer email:");
        String email = scanner.nextLine();
        System.out.println("Customer phone number:");
        String phone = scanner.nextLine();
        Customer newCustomer = new Customer(fName, lName, email, phone);
        customers.add(newCustomer);
        return newCustomer;
    }

    public void showCustomers(){
        for( Customer c : customers) {
            System.out.println(c + "\n");
        }
    }

    public void getCustomer(int id){
        boolean found = false;
        for( Customer c : customers) {
            if (c.getId() == id){
                found = true;
                System.out.println(c);
            }
        }
        if (!found) {
            System.out.println("Customer not found");
        }
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<Customer>();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
            System.out.println("1.Create customer");
            System.out.println("2.Show customers");
            System.out.println("3.Find customers");
            System.out.println("4.Delete customer");
            System.out.println("5.Update customer");
            System.out.println("Enter your choice(0 to cancel): ");
            choice= scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Customer first name:");
                    String fName = scanner.nextLine();
                    System.out.println("Customer last name:");
                    String lName = scanner.nextLine();
                    System.out.println("Customer email:");
                    String email = scanner.nextLine();
                    System.out.println("Customer phone number:");
                    int phone = scanner.nextInt();
                    customers.add(new Customer(fName, lName, email, phone));
                    break;
                case 2:
                    for( Customer c : customers) {
                        System.out.println(c.toString() + "\n");
                    }
                    break;
                case 3:
                    boolean found = false;
                    System.out.println("Enter id of customer to find:");
                    int id = scanner.nextInt();
                    for( Customer c : customers) {
                        if (c.getId() == id){
                            found = true;
                            System.out.println(c.toString());
                        }
                    }
                    if (!found) {
                        System.out.println("Customer not found");
                    }
                    break;
                case 4:
                    boolean deleted = false;
                    Customer customerToDelete = null;
                    System.out.println("Enter id of customer to delete:");
                    id = scanner.nextInt();
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
                        System.out.println("Customer deleted successfully");
                    }
                    break;
                case 5:
                    boolean updated = false;
                    System.out.println("Enter id of customer to update:");
                    id = scanner.nextInt();
                    scanner.nextLine();
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
                            c.setPhoneNumber(scanner.nextInt());
                            updated = true;
                        }
                    }
                    if (!updated) {
                        System.out.println("Customer not found");
                    } else {
                        System.out.println("Customer updated successfully");
                    }
                    break;
            }
        }
        while (choice!= 0);
    }
}

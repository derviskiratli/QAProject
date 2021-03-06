import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CustomerController controller = new CustomerController();
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
                    String phone = scanner.nextLine();
                    Customer newCustomer = controller.addCustomer(fName, lName, email, phone);
                    System.out.println("New customer: " + newCustomer + " created");
                    break;
                case 2:
                    controller.showCustomers();
                    break;
                case 3:
                    System.out.println("Enter id of customer to find:");
                    Customer foundCustomer = controller.getCustomer(scanner.nextInt());
                    System.out.println("Customer found: " + foundCustomer);
                    break;
                case 4:
                    System.out.println("Enter id of customer to delete:");
                    controller.deleteCustomer(scanner.nextInt());
                    break;
                case 5:
                    System.out.println("Enter id of customer to update:");
                    controller.updateCustomer(scanner.nextInt());
                    break;
            }
        }
        while (choice!= 0);
    }
}

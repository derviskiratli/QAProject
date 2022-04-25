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
                        System.out.println(c.toString());
                    }
            }
        }
        while (choice!= 0);
    }
}

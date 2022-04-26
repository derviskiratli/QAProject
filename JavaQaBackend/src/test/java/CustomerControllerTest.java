import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerControllerTest {
    CustomerController controller;
    Customer firstCustomer;
    Customer secondCustomer;

    @BeforeEach
    void setUp() {
        controller = new CustomerController();
        Customer.count =0;
        firstCustomer = new Customer("Dervis", "Kiratli", "dervis.kiratli@hotmail.com", "05888818");
        secondCustomer = new Customer("Test", "tester", "test.tester@hotmail.com", "0595894984");
        controller.getCustomers().add(firstCustomer);
        controller.getCustomers().add(secondCustomer);
    }

    @Test
    void addCustomer() {
        Customer testCustomer = new Customer("abc", "def", "abd.def@hotmail.com", "8048480");
        controller.addCustomer(testCustomer.getFirstName(), testCustomer.getLastName(), testCustomer.getEmail(), testCustomer.getPhoneNumber());
        assertEquals(3, controller.getCustomers().size());
    }

    /*@Test
    void showCustomers() {
        controller.showCustomers();
        assertEquals("Customer{id=0, firstName='Dervis', lastName='Kiratli', email='dervis.kiratli@hotmail.com', phoneNumber='05888818'}\n" +
                "\n" +
                "Customer{id=1, firstName='Test', lastName='tester', email='test.tester@hotmail.com', phoneNumber='0595894984'}", outContent.toString());
    }*/

    @Test
    void getCustomer() {
        assertEquals(firstCustomer, controller.getCustomer(0));
        assertEquals(secondCustomer, controller.getCustomer(1));

    }

    @Test
    void deleteCustomer() {
        controller.deleteCustomer(1);
        assertNull(controller.getCustomer(1));
        assertEquals(controller.getCustomers().size(), 1);
    }

    @Test
    void updateCustomer() {
    }


}
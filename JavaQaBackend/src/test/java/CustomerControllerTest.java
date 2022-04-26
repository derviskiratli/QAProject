import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CustomerControllerTest {
    CustomerController controller = new CustomerController();
    Customer firstCustomer;
    Customer secondCustomer;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {

        firstCustomer = new Customer("Dervis", "Kiratli", "dervis.kiratli@hotmail.com", "05888818");
        secondCustomer = new Customer("Test", "tester", "test.tester@hotmail.com", "0595894984");
        controller.getCustomers().add(firstCustomer);
        controller.getCustomers().add(secondCustomer);
    }


    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
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

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
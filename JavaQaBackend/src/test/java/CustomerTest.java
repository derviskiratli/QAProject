import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @BeforeEach
    void setUp() {
        Customer.count =0;
    }
    @Test
    void getIdTestAutoIncrement() {
        Customer firstCustomer = new Customer("Dervis", "kiratli", "dervis.kiratli@hotmail.com", "048949984");
        Customer secondCustomer = new Customer("test", "tester", "tester@hotmail.com" , "123456789");
        assertEquals(0 , firstCustomer.getId());
        assertEquals(1, secondCustomer.getId());
    }

}
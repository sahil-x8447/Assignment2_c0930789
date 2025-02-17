import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Test class for the Person class
class PersonTest {

    // Test to ensure a valid Person is created
    @Test
    void testValidPersonCreation() {
        Person person = Person.builder()
                .id("200")
                .firstName("Sahil")
                .lastName("Sharma")
                .age(23)
                .gender("Male")
                .build();

        assertNotNull(person); // Ensure the object is created
        assertEquals("Sahil", person.getFirstName()); // Ensure the first name is correct
    }

    // Test to check if exception is thrown when ID is null
    @Test
    void testNullIdThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Person.builder()
                    .id(null)
                    .firstName("Sahil")
                    .lastName("Sharma")
                    .age(23)
                    .gender("Male")
                    .build();
        });
        assertEquals("ID cannot be null", exception.getMessage()); // Verify the exception message
    }

    // Test to check if exception is thrown when first name is blank
    @Test
    void testBlankFirstNameThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Person.builder()
                    .id("200")
                    .firstName("")
                    .lastName("Sharma")
                    .age(23)
                    .gender("Male")
                    .build();
        });
        assertEquals("First name cannot be null or blank", exception.getMessage()); // Verify the exception message
    }

    // Test to check if exception is thrown when age is negative
    @Test
    void testNegativeAgeThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Person.builder()
                    .id("200")
                    .firstName("Sahil")
                    .lastName("Sharma")
                    .age(-5)
                    .gender("Male")
                    .build();
        });
        assertEquals("Age cannot be negative", exception.getMessage()); // Verify the exception message
    }
}

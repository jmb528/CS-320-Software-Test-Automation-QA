import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    void testCreateValidContact() {
        Contact contact = new Contact(
                "C1001",
                "Jenny",
                "Smith",
                "5551234567",
                "123 Main Street");

        assertEquals("C1001", contact.getContactId());
        assertEquals("Jenny", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("5551234567", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    @Test
    void testContactIdCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(null, "Jenny", "Smith",
                        "5551234567", "123 Main Street"));
    }

    @Test
    void testContactIdCannotExceedTenCharacters() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("CONTACT10001", "Jenny", "Smith",
                        "5551234567", "123 Main Street"));
    }

    @Test
    void testFirstNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("C1001", null, "Smith",
                        "5551234567", "123 Main Street"));
    }

    @Test
    void testFirstNameCannotExceedTenCharacters() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("C1001", "Alexandriaaa", "Smith",
                        "5551234567", "123 Main Street"));
    }

    @Test
    void testLastNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("C1001", "Jenny", null,
                        "5551234567", "123 Main Street"));
    }

    @Test
    void testLastNameCannotExceedTenCharacters() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("C1001", "Jenny", "Washingtons",
                        "5551234567", "123 Main Street"));
    }

    @Test
    void testPhoneCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("C1001", "Jenny", "Smith",
                        null, "123 Main Street"));
    }

    @Test
    void testPhoneMustContainExactlyTenDigits() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("C1001", "Jenny", "Smith",
                        "555123456", "123 Main Street"));

        assertThrows(IllegalArgumentException.class, () ->
                new Contact("C1001", "Jenny", "Smith",
                        "55512345678", "123 Main Street"));

        assertThrows(IllegalArgumentException.class, () ->
                new Contact("C1001", "Jenny", "Smith",
                        "555ABC4567", "123 Main Street"));
    }

    @Test
    void testAddressCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("C1001", "Jenny", "Smith",
                        "5551234567", null));
    }

    @Test
    void testAddressCannotExceedThirtyCharacters() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("C1001", "Jenny", "Smith",
                        "5551234567",
                        "1234567890123456789012345678901"));
    }

    @Test
    void testValidFieldUpdates() {
        Contact contact = new Contact(
                "C1001",
                "Jenny",
                "Smith",
                "5551234567",
                "123 Main Street");

        contact.setFirstName("Jane");
        contact.setLastName("Doe");
        contact.setPhone("5559876543");
        contact.setAddress("456 Oak Avenue");

        assertEquals("Jane", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("5559876543", contact.getPhone());
        assertEquals("456 Oak Avenue", contact.getAddress());
    }

    @Test
    void testInvalidFieldUpdatesAreRejected() {
        Contact contact = new Contact(
                "C1001",
                "Jenny",
                "Smith",
                "5551234567",
                "123 Main Street");

        assertThrows(IllegalArgumentException.class,
                () -> contact.setFirstName(null));

        assertThrows(IllegalArgumentException.class,
                () -> contact.setLastName("Washingtons"));

        assertThrows(IllegalArgumentException.class,
                () -> contact.setPhone("12345"));

        assertThrows(IllegalArgumentException.class,
                () -> contact.setAddress(
                        "1234567890123456789012345678901"));
    }
}

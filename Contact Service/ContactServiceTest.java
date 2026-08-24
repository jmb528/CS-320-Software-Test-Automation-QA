import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
    private ContactService service;
    private Contact contact;

    @BeforeEach
    void setUp() {
        service = new ContactService();
        contact = new Contact(
                "C1001",
                "Jenny",
                "Smith",
                "5551234567",
                "123 Main Street");
    }

    @Test
    void testAddContact() {
        service.addContact(contact);

        assertNotNull(service.getContact("C1001"));
        assertEquals(1, service.getContactCount());
    }

    @Test
    void testCannotAddNullContact() {
		//Verifies that invalid input causes an exception, rejecting the invalid input
        assertThrows(IllegalArgumentException.class,
                () -> service.addContact(null));
    }

    @Test
    void testCannotAddDuplicateContactId() {
        service.addContact(contact);

        Contact duplicate = new Contact(
                "C1001",
                "Jane",
                "Doe",
                "5559876543",
                "456 Oak Avenue");

        assertThrows(IllegalArgumentException.class,
                () -> service.addContact(duplicate));
    }

    @Test
    void testDeleteContact() {
        service.addContact(contact);
        service.deleteContact("C1001");

        assertNull(service.getContact("C1001"));
        assertEquals(0, service.getContactCount());
    }

    @Test
    void testCannotDeleteMissingContact() {
        assertThrows(IllegalArgumentException.class,
                () -> service.deleteContact("MISSING"));
    }

    @Test
    void testUpdateFirstName() {
        service.addContact(contact);
        service.updateFirstName("C1001", "Jane");

        assertEquals("Jane",
                service.getContact("C1001").getFirstName());
    }

    @Test
    void testUpdateLastName() {
        service.addContact(contact);
        service.updateLastName("C1001", "Doe");

        assertEquals("Doe",
                service.getContact("C1001").getLastName());
    }

    @Test
    void testUpdatePhone() {
        service.addContact(contact);
        service.updatePhone("C1001", "5559876543");

        assertEquals("5559876543",
                service.getContact("C1001").getPhone());
    }

    @Test
    void testUpdateAddress() {
        service.addContact(contact);
        service.updateAddress("C1001", "456 Oak Avenue");

        assertEquals("456 Oak Avenue",
                service.getContact("C1001").getAddress());
    }

    @Test
    void testCannotUpdateMissingContact() {
        assertThrows(IllegalArgumentException.class,
                () -> service.updateFirstName("MISSING", "Jane"));

        assertThrows(IllegalArgumentException.class,
                () -> service.updateLastName("MISSING", "Doe"));

        assertThrows(IllegalArgumentException.class,
                () -> service.updatePhone("MISSING", "5559876543"));

        assertThrows(IllegalArgumentException.class,
                () -> service.updateAddress("MISSING", "456 Oak Avenue"));
    }

    @Test
    void testInvalidUpdatesAreRejected() {
        service.addContact(contact);

        assertThrows(IllegalArgumentException.class,
                () -> service.updateFirstName("C1001", null));

        assertThrows(IllegalArgumentException.class,
                () -> service.updateLastName("C1001", "Washingtons"));

        assertThrows(IllegalArgumentException.class,
                () -> service.updatePhone("C1001", "ABC"));

        assertThrows(IllegalArgumentException.class,
                () -> service.updateAddress(
                        "C1001",
                        "1234567890123456789012345678901"));
    }
}

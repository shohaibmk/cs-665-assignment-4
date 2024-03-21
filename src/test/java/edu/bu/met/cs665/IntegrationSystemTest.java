package edu.bu.met.cs665;

import edu.bu.met.cs665.example1.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class IntegrationSystemTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void testPrintCustomer_LegacySystem() {
        // Given
        CustomerData_USB legacySystem = new LegacySystem();
        CustomerData_HTTPS newSystem = new NewSystem();
        IntegrationSystem integrationSystem = new IntegrationSystem(legacySystem, newSystem);

        // When
        integrationSystem.printCustomer(1);

        // Then
        // Assert that the output contains the correct information from the new system
        assertEquals("New System - Customer ID: 1, Name: Alice Johnson\n", outContent.toString());
    }

    @Test
    void testPrintCustomer_NewSystem() {
        // Given
        CustomerData_USB legacySystem = new LegacySystem();
        CustomerData_HTTPS newSystem = new NewSystem();
        IntegrationSystem integrationSystem = new IntegrationSystem(legacySystem, newSystem);

        // When
        integrationSystem.printCustomer(2);

        // Then
        // Assert that the output contains the correct information from the new system
        assertEquals("New System - Customer ID: 2, Name: Bob Williams\n", outContent.toString());
    }

    @Test
    void testPrintCustomer_NonExistingCustomer() {
        // Given
        CustomerData_USB legacySystem = new LegacySystem();
        CustomerData_HTTPS newSystem = new NewSystem();
        IntegrationSystem integrationSystem = new IntegrationSystem(legacySystem, newSystem);

        // When
        integrationSystem.printCustomer(100); // Customer ID that does not exist

        // Then
        // Assert that the output indicates that the customer was not found
        assertNotEquals("Legacy System - Customer not found with ID: 100\nNew System - Customer not found with ID: 100\n", outContent.toString());
    }
}

package edu.bu.met.cs665.example1;

public class IntegrationSystem {
    private final CustomerData_USB legacySystem;
    private final CustomerData_HTTPS newSystem;

    public IntegrationSystem(CustomerData_USB legacySystem, CustomerData_HTTPS newSystem) {
        this.legacySystem = legacySystem;
        this.newSystem = newSystem;
    }

    public void printCustomer(int customerId) {
        // Utilize both systems to print customer details
//        legacySystem.printCustomer(customerId);
        newSystem.printCustomer(customerId);
    }
}

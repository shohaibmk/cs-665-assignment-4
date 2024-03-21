package edu.bu.met.cs665.example1;

import java.util.HashMap;
import java.util.Map;

public class LegacySystem implements CustomerData_USB {
    private final Map<Integer, Customer> customerMap;

    public LegacySystem() {
        customerMap = new HashMap<>();
        // Initialize with some mock customer data
        customerMap.put(1, new Customer(1, "Alice Johnson"));
        customerMap.put(2, new Customer(2, "Bob Williams"));
    }

    @Override
    public void printCustomer(int customerId) {
        Customer customer = customerMap.get(customerId);
        if (customer != null) {
            System.out.println("Legacy System - Customer ID: " + customer.getCustomerId() + ", Name: " + customer.getName());
        } else {
            System.out.println("Legacy System - Customer not found with ID: " + customerId);
        }
    }

    @Override
    public void getCustomer_USB(int customerId) {
        System.out.println("Legacy System - Getting customer data via USB for ID: " + customerId);
    }
}

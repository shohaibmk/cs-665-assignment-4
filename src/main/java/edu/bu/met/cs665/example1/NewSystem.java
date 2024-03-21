package edu.bu.met.cs665.example1;

import java.util.HashMap;
import java.util.Map;

public class NewSystem implements CustomerData_HTTPS {
    private final Map<Integer, Customer> customerMap;

    public NewSystem() {
        customerMap = new HashMap<>();
        // Initialize with some mock customer data
        customerMap.put(1, new Customer(1, "Alice Johnson"));
        customerMap.put(2, new Customer(2, "Bob Williams"));
    }

    @Override
    public void printCustomer(int customerId) {
        Customer customer = customerMap.get(customerId);
        if (customer != null) {
            System.out.println("New System - Customer ID: " + customer.getCustomerId() + ", Name: " + customer.getName());
        } else {
            System.out.println("New System - Customer not found with ID: " + customerId);
        }
    }

    @Override
    public void getCustomer_HTTPS(int customerId) {
        System.out.println("New System - Getting customer data via HTTPS for ID: " + customerId);
    }
}

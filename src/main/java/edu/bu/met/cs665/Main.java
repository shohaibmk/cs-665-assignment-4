/**
 * Name: FIRST_NAME LAST_NAME
 * Course: CS-665 Software Designs & Patterns
 * Date: MM/DD/YYYY
 * File Name: Main.java
 * Description: Write a description for this class
 */

package edu.bu.met.cs665;

import edu.bu.met.cs665.example1.IntegrationSystem;
import edu.bu.met.cs665.example1.LegacySystem;
import edu.bu.met.cs665.example1.NewSystem;

/**
 * This is the Main class.
 */
public class Main {


    public static void main(String[] args) {
        LegacySystem legacySystem = new LegacySystem();
        NewSystem newSystem = new NewSystem();

        // Creating an integration system instance
        IntegrationSystem integrationSystem = new IntegrationSystem(legacySystem, newSystem);

        // Testing printCustomer method
        integrationSystem.printCustomer(1);
        integrationSystem.printCustomer(2);
        integrationSystem.printCustomer(3);


    }
}

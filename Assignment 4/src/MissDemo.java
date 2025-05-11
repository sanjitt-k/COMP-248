import java.util.Scanner;
public class MissDemo {
	 private static Registry[] registries;
	 //this program simulates a registry system for the Montreal Intercampus Shipping 
	 //Service (MISS©). It allows users to interact with a set of Registry objects, 
	 //each containing a set of stamps and labels. The program offers a menu with several options for users
	public static void main(String[] args) {
		
		//Display Welcome message
        System.out.println("Welcome to the Montreal Intercampus Shipping Service (MISS©) Application");
        
        initializeRegistries();
        
        //declare the scanner
        Scanner keyboard = new Scanner(System.in);
        
        
        //display the menu
        int selection = 10;
        
        while(selection!=0) {
        	Menu();
        	selection = keyboard.nextInt();
        	keyboard.nextLine();
        	
        	switch (selection) {
        	case 1: 
        		displayAllRegistries();
        		break;
        	case 2:
        		displaySpecificRegistry(keyboard);
        		break;
        	case 3: 
        		compareTotalValue();
        		break;
        	case 4: 
        		compareStampDistribution();
        		break;
        	case 5:
        		listEqualRegistries();
        		break;
        	case 6:	
        		addLabelToRegistry(keyboard);
        		break;
        	case 7: 
        		removeLabelFromRegistry(keyboard);
        		break;
        	case 8:
        		updateLabelExpiry(keyboard);
        		break;
        	case 9:
        		addStampsToRegistry(keyboard);
        		break;
        	case 0: 
        		System.out.println("Exiting program");
        		keyboard.close();
        		return;
        	default:
        		System.out.println("Invalid choice. Please select a valid option.");
        	}
        }
	}
	//output the options to the user
	public static void Menu() {
		System.out.println("What would you like to do?");
		 System.out.println("1. See the content of all Registries");
		 System.out.println("2. See the content of one Registry");
		 System.out.println("3. List Registries with same $ amount of shipment stamps");
		 System.out.println("4. List Registry with same number of shipment Stamps types");
		 System.out.println("5. List Registries with same $ amount of Stamps and same number of prepaid Labels");
		 System.out.println("6. Add a prepaid label to an existing Registry");
		 System.out.println("7. Remove an existing prepaid label from a Registry");
		 System.out.println("8. Update the expiry date of an existing prepaid Label");
		 System.out.println("9. Add Stamps to a Registry");
		 System.out.println("0. To quit \n");
		 System.out.println("Please enter your choice and press <Enter>:");
		 
	}
	// Create the registries as per the given conditions
	   private static void initializeRegistries() {
	        // 2 Registries with the same stamp types and number of labels
	        Stamps stamps1 = new Stamps(5, 3, 2, 1, 0);
	        Label label1 = new Label("Standard", 98000001, 15, 12);
	        Label label2 = new Label("Fragile", 98000002, 20, 10);
	        Label[] labels1 = { label1, label2 };
	        registries = new Registry[5];
	        registries[0] = new Registry(stamps1, labels1);
	        registries[1] = new Registry(new Stamps(stamps1), labels1);

	        // 1 Registry with the same total value but different configuration of stamps and at least 3 labels
	        Stamps stamps2 = new Stamps(10, 0, 1, 2, 0); // Same total value as stamps1
	        Label label3 = new Label("Standard", 98000003, 5, 11);
	        Label label4 = new Label("Confidential", 98000004, 10, 9);
	        Label label5 = new Label("Fragile", 98000005, 25, 6);
	        registries[2] = new Registry(stamps2, new Label[] { label3, label4, label5 });

	        // 2 Registries with the same breakdown of stamps but no labels
	        Stamps stamps3 = new Stamps(2, 4, 1, 3, 0);
	        registries[3] = new Registry(stamps3, null);
	        registries[4] = new Registry(new Stamps(stamps3), null);
	    }               

    // Display the content of all registries
    private static void displayAllRegistries() {
        for (int i = 0; i < registries.length; i++) {
            System.out.println("Registry " + (i + 1) + ":\n" + registries[i]);
        }
    }
    //display the content of a single registry 
    private static void displaySpecificRegistry(Scanner scanner) {
        int registryNumber = -1; // Initialize with an invalid number
        do {
            System.out.print("Enter the Registry number (1-5): ");
            if (scanner.hasNextInt()) { // Check if the input is an integer
                registryNumber = scanner.nextInt();
                if (registryNumber >= 1 && registryNumber <= registries.length) {
                    System.out.println("Registry " + registryNumber + ":\n" + registries[registryNumber - 1]);
                    break; // Valid input, exit the loop
                } else {
                    System.out.println("Invalid Registry number. Please enter a number between 1 and 5.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                scanner.next(); // Clear invalid input
            }
        } while (true); // Keep looping until valid input
    }

    private static void compareTotalValue() {
        for (int i = 0; i < registries.length; i++) {
            for (int j = i + 1; j < registries.length; j++) {
                if (registries[i].totalShipment() == registries[j].totalShipment()) {
                    System.out.println("Registry " + (i + 1) + " and Registry " + (j + 1) +
                            " have the same total shipment value: $" + registries[i].totalShipment());
                }
            }
        }
    }

    private static void compareStampDistribution() {
        for (int i = 0; i < registries.length; i++) {
            for (int j = i + 1; j < registries.length; j++) {
                if (registries[i].equals(registries[j])) {
                    System.out.println("Registry " + (i + 1) + " and Registry " + (j + 1) +
                            " have the same stamp distribution.");
                }
            }
        }
    }

    private static void listEqualRegistries() {
        for (int i = 0; i < registries.length; i++) {
            for (int j = i + 1; j < registries.length; j++) {
                if (registries[i].equals(registries[j])) {
                    System.out.println("Registry " + (i + 1) + " and Registry " + (j + 1) +
                            " are equal.");
                }
            }
        }
    }

    private static void addLabelToRegistry(Scanner scanner) {
        System.out.print("Enter the Registry number (1-5): ");
        int registryNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (registryNumber < 1 || registryNumber > registries.length) {
            System.out.println("Invalid Registry number.");
            return;
        }

        System.out.print("Enter Label type (Standard, Small, Oversize, Express, Fragile, Confidential): ");
        String type = scanner.nextLine();
        System.out.print("Enter Label ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter Label day: ");
        int day = scanner.nextInt();
        System.out.print("Enter Label month: ");
        int month = scanner.nextInt();

        Label newLabel = new Label(type, id, day, month);
        registries[registryNumber - 1].addLabel(newLabel);
        System.out.println("Label added successfully.");
    }

    private static void removeLabelFromRegistry(Scanner scanner) {
        System.out.print("Enter the Registry number (1-5): ");
        int registryNumber = scanner.nextInt();

        if (registryNumber < 1 || registryNumber > registries.length) {
            System.out.println("Invalid Registry number.");
            return;
        }

        System.out.print("Enter the index of the Label to remove: ");
        int index = scanner.nextInt();

        Label[] labels = registries[registryNumber - 1].labels;
        if (labels == null || index < 0 || index >= labels.length) {
            System.out.println("Invalid index.");
            return;
        }

        registries[registryNumber - 1].removeLabel(labels[index]);
        System.out.println("Label removed successfully.");
    }

    private static void updateLabelExpiry(Scanner scanner) {
        System.out.print("Enter the Registry number (1-5): ");
        int registryNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (registryNumber < 1 || registryNumber > registries.length) {
            System.out.println("Invalid Registry number.");
            return;
        }

        System.out.print("Enter the index of the Label to update: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Label[] labels = registries[registryNumber - 1].labels;
        if (labels == null || index < 0 || index >= labels.length) {
            System.out.println("Invalid index.");
            return;
        }

        System.out.print("Enter new expiry day: ");
        int newDay = scanner.nextInt();
        System.out.print("Enter new expiry month: ");
        int newMonth = scanner.nextInt();

        registries[registryNumber - 1].newExpiryDate(labels[index], newDay, newMonth);
        System.out.println("Label expiry date updated successfully.");
    }

    private static void addStampsToRegistry(Scanner scanner) {
        System.out.print("Enter the Registry number (1-5): ");
        int registryNumber = scanner.nextInt();

        if (registryNumber < 1 || registryNumber > registries.length) {
            System.out.println("Invalid Registry number.");
            return;
        }

        System.out.print("Enter number of CATEGORY_A stamps to add: ");
        int categoryA = scanner.nextInt();
        System.out.print("Enter number of CATEGORY_B stamps to add: ");
        int categoryB = scanner.nextInt();
        System.out.print("Enter number of CATEGORY_C stamps to add: ");
        int categoryC = scanner.nextInt();
        System.out.print("Enter number of CATEGORY_D stamps to add: ");
        int categoryD = scanner.nextInt();
        System.out.print("Enter number of CATEGORY_E stamps to add: ");
        int categoryE = scanner.nextInt();

        registries[registryNumber - 1].addShipmentStamps(categoryA, categoryB, categoryC, categoryD, categoryE);
        System.out.println("Stamps added successfully.");
    }
}
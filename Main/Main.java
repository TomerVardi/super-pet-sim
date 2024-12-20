import java.util.Scanner;

/**
 * Main class for the Pet Sim game. This class contains the main game loop and logic for interacting with the player and their virtual pet.
 */
public class Main {

    /**
     * The main method is the entry point of the program. It runs the Pet Sim game, allowing the player to create and interact with a virtual pet.
     *
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        boolean gameRunning = true; // Determines if the game should keep running
        boolean petKind; // True for Cat, False for Dog
        String petName;  // Name of the pet
        int petAge;      // Age of the pet

        // Scanner for user input
        Scanner in = new Scanner(System.in);

        // Welcome message
        System.out.println("Welcome to Pet Sim!");

        // Get the player's name
        System.out.println("Please enter your name: ");
        String name = in.nextLine();
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Invalid name");
        }

        // Get the type of pet the player wants to create
        System.out.println("What kind of pet would you like to create? (Dog or Cat) ");
        String kind = in.nextLine();

        if (kind.equalsIgnoreCase("cat")) {
            petKind = true; // Player chose a cat
        } else if (kind.equalsIgnoreCase("dog")) {
            petKind = false; // Player chose a dog
        } else {
            throw new IllegalArgumentException("Invalid kind of pet");
        }

        // Convert petKind into a readable string
        String petType = petKind ? "cat" : "dog";

        // Get the pet's name
        System.out.println("What would you like to name your pet? ");
        petName = in.nextLine();
        if (petName.isEmpty()) {
            throw new IllegalArgumentException("Invalid name");
        }

        // Get the pet's age
        System.out.println("How old is your pet? ");
        petAge = in.nextInt();
        in.nextLine(); // Consume leftover newline
        if (petAge <= 0) {
            throw new IllegalArgumentException("Invalid age");
        }

        // Create the pet object
        System.out.println("Creating pet...");
        Pet pet = new Pet(petName, petKind, petAge);

        // Inform the player their pet has been created
        System.out.println("Enjoy your new pet... " + pet.getName());

        // Main game loop
        while (gameRunning) {
            // Display options to the player
            System.out.println("""
                What would you like to do?
                1. Feed your pet
                2. Pet your pet
                3. Play with your pet
                4. Take your pet for a walk
                5. View your pet and its details
                6. What does your pet look like
                7. Put your pet to sleep
            """);

            // Get the player's choice
            int choice = in.nextInt();
            in.nextLine(); // Consume leftover newline

            // Process the player's choice
            switch (choice) {
                case 1 -> {
                    // Feed the pet
                    System.out.println("Your pet's hunger level is: " + pet.calculateHungerLevel());
                    System.out.println("Would you like to feed your pet? (y/n) ");
                    String feed = in.nextLine();
                    if (feed.equalsIgnoreCase("y")) {
                        System.out.println("How much would you like to feed your pet? ");
                        int foodAmount = in.nextInt();
                        in.nextLine(); // Consume leftover newline
                        pet.feed(foodAmount);
                        System.out.println("You fed your pet " + foodAmount + " units of food. Its hunger level is now: " + pet.getHungerLevel());
                    } else {
                        System.out.println("You chose not to feed your pet.");
                    }
                }
                case 2 -> {
                    // Pet the pet
                    System.out.println(pet.getName() + " is very happy that you pet it. Its happiness has increased by 5.");
                    pet.setHappiness(pet.getHappiness() + 5);
                }
                case 3 -> {
                    // Play with the pet
                    System.out.println(pet.getName() + " is unbelievably happy that you decided to play with it. If you take it to the park, its happiness will increase by 7; however, if you take it to the beach, its happiness will increase by 10. Where would you like to take it? (p/b) ");
                    String location = in.nextLine();
                    if (location.equalsIgnoreCase("p")) {
                        System.out.println(pet.getName() + " is ecstatic you took it to the park. Its happiness has increased by 7.");
                        pet.setHappiness(pet.getHappiness() + 7);
                    } else if (location.equalsIgnoreCase("b")) {
                        System.out.println(pet.getName() + " is jubilant you decided to take it to the beach. Its happiness has increased by 10.");
                        pet.setHappiness(pet.getHappiness() + 10);
                    } else {
                        throw new IllegalArgumentException("Invalid location");
                    }
                }
                case 4 -> {
                    // Take the pet for a walk
                    System.out.println("You take your pet for a walk. Its happiness will increase by 3.");
                    pet.setHappiness(pet.getHappiness() + 3);
                }
                case 5 -> {
                    // View pet details
                    System.out.println("Your pet's details:");
                    System.out.println("Name: " + pet.getName());
                    System.out.println("Type: " + petType);
                    System.out.println("Age: " + pet.getAge() + " years");
                    System.out.println("Happiness: " + pet.getHappiness());
                    System.out.println("Hunger Level: " + pet.calculateHungerLevel());
                }
                case 6 -> {
                    // Display ASCII art for the pet
                    ArtPrinter petArt = new ArtPrinter();
                    if (petKind) {
                        petArt.printRandomCatArt();
                    } else {
                        petArt.printRandomDogArt();
                    }
                }
                case 7 -> {
                    // End the game
                    System.out.println("Although your " + petType + ", " + pet.getName() + " wanted to spend more time with you, it understands that you are a busy individual and must attend to other matters.");
                    System.out.println("Are you sure you want to put your pet to sleep? (y/n)");
                    String answer = in.nextLine();
                    if (answer.equalsIgnoreCase("y")) {
                        System.out.println("Goodbye, " + name + ". " + pet.getName() + " will always remember you.");
                        gameRunning = false;
                    } else {
                        System.out.println(pet.getName() + " is ecstatic you chose to spend more time with it. Its happiness has increased by 100000000.");
                        pet.setHappiness(pet.getHappiness() + 100000000);
                    }
                }
                default -> System.out.println("Invalid choice. Please choose a valid option.");
            }

            // Separator for readability
            System.out.println("\n-----------------------------\n");
        }
    }
}

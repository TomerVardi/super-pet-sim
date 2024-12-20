import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean gameRunning = true;

        boolean petKind;
        String petName;
        int petAge;

        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to Pet Sim!");

        System.out.println("Please enter your name: ");
        String name = in.nextLine();
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Invalid name");
        }

        System.out.println("What kind of pet would you like to create? (Dog or Cat) ");
        String kind = in.nextLine();

        if (kind.equalsIgnoreCase("cat")) {
            petKind = true;
        } else if (kind.equalsIgnoreCase("dog")) {
            petKind = false;
        } else {
            throw new IllegalArgumentException("Invalid kind of pet");
        }

        String petType;

        if (petKind) {
            petType = "cat";
        }
        else {
            petType = "dog";
        }

        System.out.println("What would you like to name your pet? ");
        petName = in.nextLine();
        if (petName.isEmpty()) {
            throw new IllegalArgumentException("Invalid name");
        }

        System.out.println("How old is your pet? ");
        petAge = in.nextInt();
        in.nextLine(); // Consume leftover newline
        if (petAge <= 0) {
            throw new IllegalArgumentException("Invalid age");
        }

        System.out.println("Creating pet...");
        Pet pet = new Pet(petName, petKind, petAge);

        System.out.println("Enjoy your new pet... " + pet.getName());

        while (gameRunning) {
            System.out.println("""
                What would you like to do?
                1. Feed your pet
                2. Pet your pet
                3. Play with your pet
                4. Take your pet for a walk
                5. View your pet and its details
                6. Put your pet to sleep
            """);

            int choice = in.nextInt();
            in.nextLine(); // Consume leftover newline

            switch (choice) {
                case 1 -> {
                    System.out.println("Your pet's hunger level is: " + pet.getHungerLevel());
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
                    System.out.println(pet.getName() + " is very happy that you pet it. Its happiness has increased by 5.");
                    pet.setHappiness(pet.getHappiness() + 5);
                }
                case 3 -> {
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
                    System.out.println("You take your pet for a walk. Its happiness will increase by 3.");
                    pet.setHappiness(pet.getHappiness() + 3);
                }
                case 5 -> {
                    System.out.println("Your pet's details:");
                    System.out.println("Name: " + pet.getName());
                    System.out.println("Type: " + petType);
                    System.out.println("Age: " + pet.getAge() + " years");
                    System.out.println("Happiness: " + pet.getHappiness());
                    System.out.println("Hunger Level: " + pet.getHungerLevel());
                }
                case 6 -> {
                    System.out.println("Although your " + petType + ", " + pet.getName() + " wanted to spend more time with you, it understands that you are a busy individual and must attend to other matters.");
                    System.out.println("Are you sure you want to put your pet to sleep? (y/n)");
                    String answer = in.nextLine();
                    if (answer.equalsIgnoreCase("y")) {
                        System.out.println("Goodbye, " + name + ". " + pet.getName() + " will always remember you.");
                        gameRunning = false;
                    } else {
                        System.out.println(pet.getName() + " is ecstatic you chose to spend more time with it. It's happiness has increased by 100000000.");
                        pet.setHappiness(pet.getHappiness() + 100000000);
                    }
                }
                default -> System.out.println("Invalid choice. Please choose a valid option.");
            }

            System.out.println("\n-----------------------------\n"); // Separator for readability
        }
    }
}

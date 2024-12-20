import java.util.Scanner; // For input
/**
 * Pet class creates a pet with attributes like name, type, age, hunger, and happiness.
 */
public class Pet {
    // Name
    private String name;
    // False == Dog, True == Cat
    private boolean petType;
    // Age
    private final int age;
    // Hunger level from 0 (not hungry) to 10 (very hungry)
    private int hungerLevel;
    // Happiness level from 0 (unhappy) to 10 (very happy)
    private int happiness;

    public Pet(String name, boolean petType, int age) {
        this.name = name;
        this.petType = petType;
        this.age = age;
        // Default hunger level (neutral state)
        this.hungerLevel = 5;
        // Default happiness level (neutral state)
        this.happiness = 5;

    }

    public void feed(int foodAmount) {
        System.out.println(name + " is being fed!");
        for (int i = 0; i < foodAmount; i++) {
            // Each feeding decreases hunger level
            if (hungerLevel > 0) {
                hungerLevel--;
                System.out.println(name + " is eating... Hunger level: " + hungerLevel);
            } else {
                System.out.println(name + " is not hungry anymore.");
                break;  // If hunger is satisfied, stop feeding
            }
        }
        // Increase happiness after feeding
        happiness = Math.min(10, happiness + 1);  // Max happiness is 10
        System.out.println(name + "'s happiness after feeding: " + happiness);
    }
    // returns name
    public String getName() {
        return name;
    }
    // sets name
    public void setName(String name) {
        this.name = name;
    }
    // returns type of pet
    public boolean isPetType() {
        return petType;
    }
    // allows user to Set the Type of pet
    public void setPetType(boolean petType) {
        this.petType = petType;
    }
    // returns age
    public int getAge() {
        return age;
    }

    public int getHungerLevel() {
        return hungerLevel;
    }

    public void setHungerLevel(int hungerLevel) {
        this.hungerLevel = hungerLevel;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public void displayInfo() {
        System.out.println("Pet name: " + name);
        System.out.println("Pet type: " + petType);
        System.out.println("Pet age: " + age);
        System.out.println("Pet hunger level: " + hungerLevel);
        System.out.println("Pet happiness: " + happiness);
    }
}

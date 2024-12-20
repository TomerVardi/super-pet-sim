/**
 * Represents a virtual pet in the Pet Sim game. 
 * Each pet has a name, type (dog or cat), age, hunger level, happiness level, and a record of when it was last fed.
 */
public class Pet {
    // Pet's name
    private String name;

    // False == Dog, True == Cat
    private boolean petType;

    // Pet's age
    private final int age;

    // Hunger level from 0 (not hungry) to 10 (very hungry)
    private int hungerLevel;

    // Happiness level from 0 (unhappy) to 10 (very happy)
    private int happiness;

    // Time the pet was last fed (in milliseconds since epoch)
    private long timeLastFed;

    /**
     * Constructs a new Pet object.
     *
     * @param name    The name of the pet.
     * @param petType True if the pet is a cat, false if it's a dog.
     * @param age     The age of the pet.
     */
    public Pet(String name, boolean petType, int age) {
        this.name = name;
        this.petType = petType;
        this.age = age;
        this.hungerLevel = 5; // Default neutral hunger level
        this.happiness = 5;  // Default neutral happiness level
        this.timeLastFed = System.currentTimeMillis(); // Record the current time as last fed time
    }

    /**
     * Feeds the pet and updates its hunger and happiness levels.
     *
     * @param foodAmount The amount of food to feed the pet.
     */
    public void feed(int foodAmount) {
        // Update hunger level based on time passed since the last feeding
        hungerLevel = calculateHungerLevel();

        System.out.println(name + " is being fed!");
        for (int i = 0; i < foodAmount; i++) {
            if (hungerLevel > 0) {
                hungerLevel--; // Decrease hunger level
                System.out.println(name + " is eating... Hunger level: " + hungerLevel);
            } else {
                System.out.println(name + " is not hungry anymore.");
                break; // Stop feeding if hunger level is satisfied
            }
        }

        // Increase happiness after feeding (maximum level is 10)
        happiness = Math.min(10, happiness + 1);
        System.out.println(name + "'s happiness after feeding: " + happiness);

        // Update the time of the last feeding
        timeLastFed = System.currentTimeMillis();
    }

    /**
     * Calculates the pet's hunger level based on the time elapsed since it was last fed.
     *
     * @return The updated hunger level (0 to 10).
     */
    public int calculateHungerLevel() {
        long diff = System.currentTimeMillis() - timeLastFed; // Time difference in milliseconds
        int hungerIncrease = (int) (diff / 60000); // Hunger increases every minute
        return Math.min(10, hungerLevel + hungerIncrease); // Hunger level cannot exceed 10
    }

    /**
     * Returns the name of the pet.
     *
     * @return The pet's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the pet.
     *
     * @param name The new name for the pet.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns whether the pet is a cat or a dog.
     *
     * @return True if the pet is a cat, false if it's a dog.
     */
    public boolean isPetType() {
        return petType;
    }

    /**
     * Sets the type of the pet.
     *
     * @param petType True if the pet is a cat, false if it's a dog.
     */
    public void setPetType(boolean petType) {
        this.petType = petType;
    }

    /**
     * Returns the age of the pet.
     *
     * @return The pet's age.
     */
    public int getAge() {
        return age;
    }

    /**
     * Returns the pet's current hunger level.
     *
     * @return The hunger level (0 to 10).
     */
    public int getHungerLevel() {
        return hungerLevel;
    }

    /**
     * Returns the pet's current happiness level.
     *
     * @return The happiness level (0 to 10).
     */
    public int getHappiness() {
        return happiness;
    }

    /**
     * Sets the pet's happiness level.
     *
     * @param happiness The new happiness level (0 to 10).
     */
    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    /**
     * Returns the time the pet was last fed.
     *
     * @return The time (in milliseconds since epoch) when the pet was last fed.
     */
    public long getTimeLastFed() {
        return timeLastFed;
    }
}

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
    // Time the pet was last fed (in milliseconds)
    private long timeLastFed;

    public Pet(String name, boolean petType, int age) {
        this.name = name;
        this.petType = petType;
        this.age = age;
        // Default hunger level (neutral state)
        this.hungerLevel = 5;
        // Default happiness level (neutral state)
        this.happiness = 5;
        // Time the pet was last fed is initialized to the current time
        this.timeLastFed = System.currentTimeMillis();
    }

    // Method to feed the pet
    public void feed(int foodAmount) {
        // Update hunger based on the time passed since last feeding
        hungerLevel = calculateHungerLevel();

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

        // Update the time of the last feeding
        timeLastFed = System.currentTimeMillis();
    }

    // Method to calculate hunger based on time passed since last feeding
    public int calculateHungerLevel() {
        long diff = System.currentTimeMillis() - timeLastFed;

        // Hunger increases over time (time is in milliseconds)
        int hungerIncrease = (int) (diff / 60000);  // Increase hunger every minute
        int newHungerLevel = Math.min(10, hungerLevel + hungerIncrease); // Ensure hunger doesn't go above 10
        return newHungerLevel;
    }

    // Returns the pet's name
    public String getName() {
        return name;
    }

    // Sets the pet's name
    public void setName(String name) {
        this.name = name;
    }

    // Returns the type of pet
    public boolean isPetType() {
        return petType;
    }

    // Sets the type of pet
    public void setPetType(boolean petType) {
        this.petType = petType;
    }

    // Returns the pet's age
    public int getAge() {
        return age;
    }

    // Returns the pet's hunger level
    public int getHungerLevel() {
        return hungerLevel;
    }

    // Sets the pet's hunger level
    public void setHungerLevel(int hungerLevel) {
        this.hungerLevel = hungerLevel;
    }

    // Returns the pet's happiness level
    public int getHappiness() {
        return happiness;
    }

    // Sets the pet's happiness level
    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    // Returns the time the pet was last fed (in milliseconds)
    public long getTimeLastFed() {
        return timeLastFed;
    }
}

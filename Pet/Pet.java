public class Pet {
    // Name
    private String name;
    // False == Dog, True == Cat
    private boolean petType;
    // Age
    private final int age;

    public Pet(String name, boolean petType, int age) {
        this.name = name;
        this.petType = petType;
        this.age = age;
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
}

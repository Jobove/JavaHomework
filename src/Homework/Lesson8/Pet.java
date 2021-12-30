package Homework.Lesson8;

public class Pet {
    private String name;

    private int age;

    private double weight;

    public Pet() {
        name = "No name yet.";
        age = 0;
        weight = 0;
    }

    public Pet(String initialName, int initialAge, double initialWeight) throws Exception {
        name = initialName;
        if (initialAge < 0 || initialWeight < 0) {
            throw new Exception("Error: Negative age or weight.");
        } else {
            age = initialAge;
            weight = initialWeight;
        }
    }

    public Pet(String initialName) {
        this();
        name = initialName;
    }

    public Pet(int initialAge) throws Exception {
        this();
        if (initialAge < 0)
            throw new Exception("Error: Negative age.");
        age = initialAge;
    }

    public Pet(double initialWeight) throws Exception {
        this();
        if (initialWeight < 0)
            throw new Exception("Error: Negative weight.");
        weight = initialWeight;
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setAge(int newAge) throws Exception {
        if (age < 0)
            throw new Exception("Error: Negative age.");
        age = newAge;
    }

    public void setWeight(double newWeight) throws Exception {
        if (newWeight < 0)
            throw new Exception("Error: Negative weight.");
        weight = newWeight;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                ", Age: " + age + "years" +
                ", Weight: " + weight + " pounds.";
    }
}

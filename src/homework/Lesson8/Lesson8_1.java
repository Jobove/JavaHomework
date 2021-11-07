package homework.Lesson8;

class Pet {
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

class Dog extends Pet {
    private String breed;

    private boolean boosterShot;

    Dog() {
        super();
        breed = "No breed yet.";
        boosterShot = false;
    }

    Dog(String initialName, int initialAge, double initialWeight) throws Exception {
        super(initialName, initialAge, initialWeight);
        breed = "No breed yet.";
        boosterShot = false;
    }

    Dog(String initialBreed) {
        this();
        breed = initialBreed;
    }

    Dog(boolean initialBoosterShot) {
        this();
        boosterShot = initialBoosterShot;
    }

    Dog(String initialBreed, boolean initialBoosterShot) {
        this();
        breed = initialBreed;
        boosterShot = initialBoosterShot;
    }

    Dog(String initialName, int initialAge, double initialWeight,
        String initialBreed, boolean initialBoosterShot) throws Exception {
        super(initialName, initialAge, initialWeight);
        breed = initialBreed;
        boosterShot = initialBoosterShot;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public boolean isBoosterShot() {
        return boosterShot;
    }

    public void setBoosterShot(boolean boosterShot) {
        this.boosterShot = boosterShot;
    }
}

public class Lesson8_1 {
    public static void main(String[] args) {
        Dog[] dogs = new Dog[6];
        try {
            dogs[1] = new Dog(
                    "dog1", 1, 1, "breed1", true
            );
            dogs[2] = new Dog(
                    "dog2", 2, 2, "breed2", false
            );
            dogs[3] = new Dog(
                    "dog3", 3, 3, "breed3", true
            );
            dogs[4] = new Dog(
                    "dog4", 4, 4, "breed4", false
            );
            dogs[5] = new Dog(
                    "dog5", 5, 5, "breed5", true
            );
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        for (int i = 1; i <= 5; ++i) {
            Dog p = dogs[i];
            if(p.getAge() >= 2 && !p.isBoosterShot())
                System.out.println(p.getName() + " " + p.getBreed());
        }
    }
}

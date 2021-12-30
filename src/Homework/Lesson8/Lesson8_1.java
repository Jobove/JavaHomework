package Homework.Lesson8;

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

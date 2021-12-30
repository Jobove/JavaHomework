package Homework.Lesson10;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

class LifeDeathProbability {
    double[] man;
    double[] woman;

    enum Sex{
        MAN, WOMAN;
    }

    LifeDeathProbability(@NotNull String filePath) throws Exception {
        man = new double[120];
        woman = new double[120];

        final File file = new File(filePath);
        InputStream inputStream = new FileInputStream(file);
        Scanner scanner = new Scanner(inputStream);

        for (int i = 0; i < 120; ++i) {
            int age = scanner.nextInt();
            man[age] = scanner.nextDouble();
            woman[age] = scanner.nextDouble();
        }
    }

    public double get(int age, Sex sex) {
        return sex == Sex.MAN ? man[age] : woman[age];
    }
}

public class Lesson10_1 {
    public static void main(String[] args) throws Exception {
        LifeDeathProbability tool = new LifeDeathProbability("D:/JavaTest/LifeDeathProbability.txt");
        Scanner scanner = new Scanner(System.in);

        LifeDeathProbability.Sex sex = null;
        while (sex == null) {
            System.out.print("Please input your sex ignoring the case: ");
            String input = scanner.nextLine();
            input = input.replaceAll("(^ *)|( *$)", "");
            if (input.equalsIgnoreCase("Man")) {
                sex = LifeDeathProbability.Sex.MAN;
            } else if (input.equalsIgnoreCase("Woman")) {
                sex = LifeDeathProbability.Sex.WOMAN;
            } else {
                System.out.println("Please input your sex correctly!");
            }
        }
        int age;
        System.out.print("Please input your age: ");
        age = scanner.nextInt();

        Random random = new Random(System.currentTimeMillis());
        while (age < 120) {
            double probability = random.nextDouble();
            if (probability > tool.get(age, sex)) {
                System.out.printf("Congratulations! You've survived your %d's!\n", age++);
            } else {
                System.out.printf("Such a pity, you passed away when you're %d.\n", age);
                break;
            }
        }
        if (age == 120) {
            System.out.println("Wonderful, you might live up to 120 year!");
        }
    }
}

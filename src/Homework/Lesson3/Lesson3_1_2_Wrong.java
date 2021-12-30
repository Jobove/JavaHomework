package Homework.Lesson3;

import java.util.Scanner;

public class Lesson3_1_2_Wrong {
    public static void main(String[] args) {
        System.out.print("Please input an integer: ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input > 100 || input >= 50 && input <= 70) {
            System.out.println("YES.");
        }
        else {
            System.out.println("NO.");
        }
    }
}

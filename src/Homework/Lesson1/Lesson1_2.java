package homeWork.Lesson1;

import java.util.Scanner;

import static java.lang.Math.*;

public class Lesson1_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int int1, int2;
        System.out.println("Please enter two integer to get the number of integers between them.");
        int1 = scanner.nextInt();
        int2 = scanner.nextInt();
        System.out.println("There are " + (abs(int1 - int2) + 1) + " numbers between " + min(int1, int2) + " and " + max(int1, int2) + '.');
    }
}

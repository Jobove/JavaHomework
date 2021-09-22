package homeWork.Lesson1;

import java.util.Scanner;

public class Lesson1_1 {
    public static void main(String[] args) {
        System.out.println("Enter two numbers to multiply.");
        Scanner scanner = new Scanner(System.in);
        int n1, n2;
        n1 = scanner.nextInt();
        n2 = scanner.nextInt();
        int product = n1 * n2;
        System.out.println("The product is: " + product +'.');
    }
}


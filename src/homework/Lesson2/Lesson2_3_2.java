package homework.Lesson2;

import java.util.Scanner;

public class Lesson2_3_2 {
    public static void main(String[] args) {
        System.out.print("Enter a temperature in degrees Fahrenheit: ");
        Scanner scanner = new Scanner(System.in);
        int FahrenheitDegree = scanner.nextInt();
        double result = 5.0 * (FahrenheitDegree - 32.0) / 9.0;
        System.out.printf("%d degrees Fahrenheit is %.1f degrees Celsius.", FahrenheitDegree, result);
    }
}

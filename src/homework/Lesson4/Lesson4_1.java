package homework.Lesson4;

import java.util.Scanner;

public class Lesson4_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0, k = 0;
        while(scanner.hasNextInt()) {
            sum += scanner.nextInt();
            ++k;
        }
        System.out.println(Math.pow(sum, 1.0 / k));
    }
}

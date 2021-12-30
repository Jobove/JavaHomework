package Homework.Lesson2;

import java.util.Scanner;

public class Lesson2_3_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        for(int i = 0; i < 3; ++i) {
            int num = scanner.nextInt();
            sum += num;
        }
        double result = sum / 3.0;
        System.out.println(result);
    }
}

package homework.Lesson3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lesson3_1_1 {
    public static void main(String[] args) {
        System.out.println("Please enter your sex(\"M\" for man and \"W\" for woman), weight, height and your age: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("([MW]) (\\d+|(\\d+\\.\\d+)) (\\d+|(\\d+\\.\\d+)) (\\d+)");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            boolean isWoman = matcher.group(1).contentEquals("W");
            double weight = Double.parseDouble(matcher.group(2)),
                    height = Double.parseDouble(matcher.group(4));
            int age = Integer.parseInt(matcher.group(6));
            System.out.printf("To maintain your weight, you need to eat %.0f chocolate bar(s) per day.\n",
                    Math.ceil(calculateBMR(isWoman, weight, height, age)));
        }
    }

    static double calculateBMR(boolean isWoman, double weight, double height, int age) {
        return isWoman ? 655 + 4.3 * weight + 4.7 * height - 4.7 * age : 66 + 6.3 * weight + 12.9 * height - 6.8 * age;
    }
}

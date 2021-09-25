package homework.Lesson3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lesson3_1_2 {
    enum SportStatus{
        NEVER, SOMETIMES, OFTEN, VERY_OFTEN
    }

    public static void main(String[] args) {
        System.out.println("Please enter your sex(\"M\" for man and \"W\" for woman), weight, height and your age: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println("Which item below matches your own sport status best?\n" +
                "a) 久坐不动;\n" +
                "b) 有些活跃;\n" +
                "c) 活跃;\n" +
                "d) 非常活跃.");
        String status = scanner.nextLine();
        SportStatus sportStatus;
        switch (status) {
            case "久坐不动":
                sportStatus = SportStatus.NEVER;
                break;
            case "有些活跃":
                sportStatus = SportStatus.SOMETIMES;
                break;
            case "活跃":
                sportStatus = SportStatus.OFTEN;
                break;
            default:
                sportStatus = SportStatus.VERY_OFTEN;
                break;
        }
        Pattern pattern = Pattern.compile("([MW]) (\\d+|(\\d+\\.\\d+)) (\\d+|(\\d+\\.\\d+)) (\\d+)");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            boolean isWoman = matcher.group(1).contentEquals("W");
            double weight = Double.parseDouble(matcher.group(2)),
                    height = Double.parseDouble(matcher.group(4));
            int age = Integer.parseInt(matcher.group(6));
            System.out.printf("To maintain your weight, you need to eat %.0f chocolate bar(s) per day.\n",
                    Math.ceil(calculateBMR(sportStatus, isWoman, weight, height, age)));
        }
    }

    static double calculateBMR(SportStatus sportStatus, boolean isWoman, double weight, double height, int age) {
        double basic = isWoman ?
                655 + 4.3 * weight + 4.7 * height - 4.7 * age :
                66 + 6.3 * weight + 12.9 * height - 6.8 * age;
        switch (sportStatus) {
            case NEVER:
                basic *= 1.2;
                break;
            case OFTEN:
                basic *= 1.3;
                break;
            case SOMETIMES:
                basic *= 1.4;
                break;
            case VERY_OFTEN:
                basic *= 1.5;
                break;
        }
        return basic;
    }
}

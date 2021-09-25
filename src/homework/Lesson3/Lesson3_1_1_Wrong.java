package homework.Lesson3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lesson3_1_1_Wrong {
    public static void main(String[] args) {
        System.out.print("Enter an integer ends with 'c' or 'C' to transform Celsius degree, " +
                "or an integer ends with 'f' or 'F' to transform vice versa: ");
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.next();

        Pattern CelsiusPattern = Pattern.compile("(\\d+(|\\.\\d+))[cC]");
        Matcher CelsiusMatcher = CelsiusPattern.matcher(inputString);

        if(CelsiusMatcher.find()) {
            double Celsius = Double.parseDouble(CelsiusMatcher.group(1));
            double result = CelsiusToFahrenheit(Celsius);
            System.out.printf("%.1f degrees Celsius is %.1f degrees Fahrenheit.", Celsius, result);
        }
        else {
            Pattern FahrenheitPattern = Pattern.compile("(\\d+(|\\.\\d+))[fF]");
            Matcher FahrenheitMatcher = FahrenheitPattern.matcher(inputString);
            if(FahrenheitMatcher.find()) {
                double Fahrenheit = Double.parseDouble(FahrenheitMatcher.group(1));
                double result = FahrenheitToCelsius(Fahrenheit);
                System.out.printf("%.1f degrees Fahrenheit is %.1f degrees Celsius.", Fahrenheit, result);

            }
            else {
                System.out.println("Wrong input, please correct!");
                System.exit(1);
            }
        }
    }

    static double CelsiusToFahrenheit(double Celsius) {
        return Celsius / 5.0 * 9 + 32;
    }

    static double FahrenheitToCelsius(double Fahrenheit) {
        return (Fahrenheit - 32) * 5.0 / 9;
    }
}

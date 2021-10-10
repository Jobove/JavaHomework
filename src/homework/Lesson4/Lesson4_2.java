package homework.Lesson4;

import java.util.Scanner;

/**
 * @author 张泽贤
 */
public class Lesson4_2 {
    /**
     * 计算总分等.
     *
     * @param args 默认参数.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sumOfScore = 0, sumOfStudents = 0, sumA = 0, sumB = 0, sumC = 0, sumD = 0, sumF = 0, maxScore = 0, minScore = 100;
        double averageScore;
        while(scanner.hasNextInt()) {
            int tmp = scanner.nextInt();
            sumOfScore += tmp;
            ++sumOfStudents;
            if(maxScore < tmp)
                maxScore = tmp;
            if(minScore > tmp)
                minScore = tmp;
            switch (tmp / 10) {
                case 10:
                case 9:
                    ++sumA;
                    break;
                case 8:
                    ++sumB;
                    break;
                case 7:
                    ++sumC;
                    break;
                case 6:
                    ++sumD;
                    break;
                default:
                    ++sumF;
                    break;
            }
        }
        averageScore = 1.0 * sumOfScore / sumOfStudents;
        System.out.printf("The sum of Scores is: %d.\n" +
                "The total number of students who get 'A' is: %d.\n" +
                "The total number of students who get 'B' is: %d.\n" +
                "The total number of students who get 'C' is: %d.\n" +
                "The total number of students who get 'D' is: %d.\n" +
                "The total number of students who get 'F' is: %d.\n" +
                "The percentage of each grade is: %.2f%%, %.2f%%, %.2f%%, %.2f%%, %.2f%%.\n" +
                "The highest score is: %d.\n" +
                "The lowest score is: %d.\n" +
                "The average score is: %.2f.\n",
                sumOfScore,
                sumA, sumB, sumC, sumD, sumF,
                100.0 * sumA / sumOfStudents, 100.0 * sumB / sumOfStudents, 100.0 * sumC / sumOfStudents, 100.0 * sumD / sumOfStudents, 100.0 * sumF / sumOfStudents,
                maxScore, minScore, averageScore);
    }
}

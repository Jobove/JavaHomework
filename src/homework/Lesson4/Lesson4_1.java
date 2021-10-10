package homework.Lesson4;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author 张泽贤
 */
public class Lesson4_1 {
    /**
     * 没有采用哨兵值而是直接检测输入流的终止(^D).
     *
     * @param args 默认参数.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0, k = 0;
        while(scanner.hasNextInt()) {
            sum += scanner.nextInt();
            ++k;
        }
        System.out.println(new DecimalFormat("#.#####").format(Math.pow(sum, 1.0 / k)));
    }
}

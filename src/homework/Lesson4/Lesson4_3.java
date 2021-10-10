package homework.Lesson4;

import java.util.Vector;

/**
 * @author 张泽贤
 */
public class Lesson4_3 {
    /**
     * 检查各数位是否不同.
     *
     * @param num 需要检查的数字.
     * @return 一个布尔值, true则符合要求, false则反之.
     */
    static boolean checkUnique(int num) {
        Vector<Integer> array = new Vector<Integer>();
        while(num != 0) {
            int digit = num % 10;
            for(Integer item : array) {
                if(digit == item)
                    return false;
            }
            array.add(digit);
            num /= 10;
        }
        return true;
    }

    /**
     * 对数字的各位进行求和.
     *
     * @param num 待操作的数字.
     * @return 各数位的和.
     */
    static int sumOfAllDigit(int num) {
        int sum = 0;
        while(num != 0) {
            int digit = num % 10;
            sum += digit;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        for(int i = 1000; i < 10000; ++i) {
            if(!checkUnique(i))
                continue;
            int digitOfThousand = i / 1000, digitOfTen = (i / 10) % 10;
            if(digitOfThousand != 3 * digitOfTen)
                continue;
            if((i & 1) == 0)
                continue;
            if(sumOfAllDigit(i) != 27)
                continue;
            System.out.println("The address is: " + i);
            break;
        }
    }
}

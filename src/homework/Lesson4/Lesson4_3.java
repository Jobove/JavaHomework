package homework.Lesson4;

import java.util.Vector;

public class Lesson4_3 {
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

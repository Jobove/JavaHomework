package Homework.Lesson6;

class Number {
    int a, b;

    /**
     * 缺省构造函数
     */
    Number() {
        this.a = 0;
        this.b = 1;
    }

    /**
     * 参数用于分子和分母的构造器, 该构造器会将所产生的比率转换为简化形式.
     * @param a 分子.
     * @param b 分母.
     */
    Number(int a, int b) {
        this.a = a;
        this.b = b;
        simplify();
    }

    /**
     * 使用getGCD()函数将有理数简化.
     */
    private void simplify() {
        int gcd = getGCD(a, b);
        this.a = a / gcd;
        this.b = b / gcd;
    }

    /**
     * 利用递归形式的辗转相除法获取两个正整数a和b的最大公约数
     * @param a 第一个正整数
     * @param b 第二个正整数
     * @return 正整数a和b的最大的公约数
     */
    public static int getGCD(int a, int b) {
        return b == 0 ? a : getGCD(b, a % b);
    }

    /**
     * 将该有理数作为double值返回.
     * @return double类型的该有理数.
     */
    public double getValue() {
        return 1.0 * a / b;
    }

    /**
     * 重载的toString()方法, 将有理数以"a/b"的形式返回.
     * @return 一个字符串, 形式为"a/b".
     */
    @Override
    public String toString() {
        return String.format("%d/%d", a, b);
    }
}

public class Lesson6_4 {
    public static void main(String[] args) {
        Number num1 = new Number(10, 3), num2 = new Number(4, 10), zero = new Number();
        System.out.printf("num1.getValue() = %.5f.\n" +
                "num2.toString() = %s.\n" +
                "getGCD(20, 16) = %d.\n",
                num1.getValue(), num2, Number.getGCD(20, 16));
    }
}

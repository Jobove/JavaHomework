package homework.Lesson7;

class Polynomial {
    /**
     * 指数的最大值
     */
    private final int degree;

    /**
     * 系数数组
     */
    private final double[] coefficients;

    /**
     * 构造函数, 将数组初始化
     * @param max 指定指数的最大值
     */
    public Polynomial(int max) {
        degree = max;
        coefficients = new double[degree + 1];
    }

    /**
     * 设置某一项的系数
     * @param i 指定需要修改项的次数
     * @param value 修改值
     * @throws IndexOutOfBoundsException 当下标非法时抛出异常
     */
    public void setConstant(int i, double value) throws IndexOutOfBoundsException {
        if(i < 0 || i > degree) {
            throw new IndexOutOfBoundsException("次数超出下标!");
        }
        coefficients[i] = value;
    }

    /**
     * 计算多项式的值
     * @param x 自变量x的值
     * @return P(x)的结果
     */
    public double evaluate(double x) {
        double ans = 0, base = 1;
        for (double i : coefficients) {
            ans += base * i;
            base *= x;
        }
        return ans;
    }
}

public class Lesson7_1 {
    public static void main(String[] args) {
        Polynomial test = new Polynomial(3);
        double[] input = {3, 5, 0, 2};
        for (int i = 0; i < input.length; ++i) {
            test.setConstant(i, input[i]);
        }
        System.out.printf("The ans of P(x) = 3 + 5x + 2x^3 where x = 7 is %.1f.\n", test.evaluate(7));
    }
}

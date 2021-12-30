package Homework.Lesson5;

public class Lesson5_2 {
    /**
     * Beer类, 存放了品牌名和酒精度两个成员变量.
     * 包含2个Getter和2个Setter.
     * 提供一个包含两个参数的构造函数.
     *
     * @author 张泽贤
     * */
    public static class Beer {
        String name;
        double alcohol;

        /**
         * @return 返回酒的名字.
         * */
        public String getName() {
            return name;
        }

        /**
         * 更改酒的名字.
         *
         * @param name 更改后酒的名字
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * @return 返回酒的名字.
         */
        public double getAlcohol() {
            return alcohol;
        }

        /**
         * 更改酒的酒精度.
         *
         * @param alcohol 更改后酒的酒精度.
         */
        public void setAlcohol(double alcohol) {
            this.alcohol = alcohol;
        }

        /**
         * 计算一个成年人喝醉所需该种酒的瓶数.
         *
         * @param weight 一个成年人的体重, 单位为kg.
         * @return 返回一个重量为weight的成年人喝醉所需这种酒的瓶数.
         */
        public double intoxicated(double weight) {
            double numDrinks;
            numDrinks = (0.08 + 0.015) * weight / (12 * 7.5 * alcohol);
            return numDrinks;
        }

        /**
         * @param name 酒的名字.
         * @param alcohol 酒的酒精度.
         */
        Beer(String name, double alcohol) {
            setName(name);
            setAlcohol(alcohol);
        }
    }

    public static void main(String[] args) {
        Beer beer = new Beer("Beer", 0.05),
                liquor = new Beer("Liquor", 0.12);
        double light = 64, heavy = 80;
        System.out.printf("A person of 64 kilos needs to drink %.1f bottle(s) of beers or %.1f bottle(s) of liquor to be drunk.\n",
                beer.intoxicated(light), liquor.intoxicated(light));
        System.out.printf("A person of 80 kilos needs to drink %.1f bottle(s) of beers or %.1f bottle(s) of liquor to be drunk.\n",
                beer.intoxicated(heavy), liquor.intoxicated(heavy));
    }
}

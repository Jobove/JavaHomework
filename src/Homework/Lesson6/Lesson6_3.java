package Homework.Lesson6;

class Beer {
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
     * 更改酒的酒精度, 若输入数值大于1则将其除以100.
     *
     * @param alcohol 更改后酒的酒精度.
     */
    public void setAlcohol(double alcohol) {
        this.alcohol = alcohol > 1 ? alcohol / 100 : alcohol;
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

public class Lesson6_3 {
    public static void main(String[] args) {
        Beer beer1 = new Beer("Beer", 0.05),
                beer2 = new Beer("Liquor", 5);
        double light = 64, heavy = 80;
        System.out.printf("A person of 64 kilos needs to drink %.1f bottle(s) of beers or %.1f bottle(s) of liquor to be drunk.\n",
                beer1.intoxicated(light), beer2.intoxicated(light));
    }
}

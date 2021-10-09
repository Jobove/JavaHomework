package homework.Lesson5;

public class Lesson5_2 {
    public static class Beer {
        String name;
        double alcohol;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getAlcohol() {
            return alcohol;
        }

        public void setAlcohol(double alcohol) {
            this.alcohol = alcohol;
        }

        public double intoxicated(double weight) {
            double numDrinks;
            numDrinks = (0.08 + 0.015) * weight / (12 * 7.5 * alcohol);
            return numDrinks;
        }

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

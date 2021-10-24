package homework.Lesson6;

class Merlin {
    private static Merlin theWizard;

    /**
     * 私有构造器.
     */
    private Merlin() {}

    /**
     * 返回theWizard, 如果theWizard为空则生成后返回.
     * @return Merlin实例theWizard
     */
    public static Merlin summon() {
        if (theWizard == null)
            theWizard = new Merlin();
        return theWizard;
    }

    /**
     * 打印"Pull the sword from the stone."
     */
    public void consult() {
        System.out.println("Pull the sword from the stone.");
    }
}

public class Lesson6_2 {
    public static void main(String[] args) {
        Merlin test = Merlin.summon();
        test.consult();
        System.out.println(test);
        test = Merlin.summon();
        System.out.println(test);
    }
}

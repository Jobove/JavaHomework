package Experiment.Exp4;

import org.jetbrains.annotations.NotNull;

class Result {
    private final int[] countMain;

    private final int[] countWingMan;

    private final long timeCostMillis;

    public static final int MAIN = 0, WINGMAN = 1;

    public static final int GET = 0, SET = 1, SWAP = 2, COMPARE = 3;

    <T extends MyData<?>> Result(@NotNull T array, long startTimeMillis) {
        countMain = array.getCount(MAIN);
        countWingMan = array.getCount(WINGMAN);
        timeCostMillis = System.currentTimeMillis() - startTimeMillis;
    }

    /**
     * 获取指定类型的指定操作类型的计数
     * @param arrayType 数组类型
     * @param operationType 操作类型
     * @return 返回计数
     */
    public int getCount(int arrayType, int operationType) {
        if (arrayType > 1 || operationType > 3)
            throw new IndexOutOfBoundsException();

        if (arrayType == MAIN) {
            return countMain[operationType];
        }
        return countWingMan[operationType];
    }

    /**
     * 获取排序所花费时间
     * @return 排序所花费时间
     */
    public long getTimeCostMillis() {
        return timeCostMillis;
    }
}
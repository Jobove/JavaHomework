package Experiment.Exp4;

import org.jetbrains.annotations.NotNull;

/**
 * 结果类, 便于输出结果
 */
class Result {
    private final long[] countMain;

    private final long[] countWingMan;

    private final long timeCostMillis;

    public static final int MAIN = 0, WINGMAN = 1;

    public static final int GET = 0, SET = 1, SWAP = 2, COMPARE = 3;

    /**
     * 构造函数, 在MySort中使用
     * @param array 被排序的数组
     * @param startTimeMillis 排序操作的最开始的时间
     * @param <T> MyData类或其派生类
     */
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
    public long getCount(int arrayType, int operationType) {
        if (arrayType > 1 || operationType > 3)
            throw new IndexOutOfBoundsException();

        if (arrayType == MAIN) {
            return countMain[operationType];
        }
        return countWingMan[operationType];
    }

    /**
     * 获取指定操作的计数的和
     * @param operationType 操作类型
     * @return 总数
     */
    public long getCount(int operationType) {
        if (operationType > 3)
            throw new IndexOutOfBoundsException();

        return countMain[operationType] + countWingMan[operationType];
    }

    /**
     * 获取排序所花费时间
     * @return 排序所花费时间
     */
    public long getTimeCostMillis() {
        return timeCostMillis;
    }
}
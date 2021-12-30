package Experiment.Exp4;

import java.util.Arrays;
import java.util.Random;

/**
 * MyData类, 用以存放数据
 * @param <N> 任意实现了Comparable接口的Number的子类
 */
public class MyData<N extends Number & Comparable<N>> {
    private final Number[] elementData;

    private final Number[] wingMan;

    private final int[] countMain;

    private final int[] countWingMan;

    private final int size;

    public static final int MAIN = 0, WINGMAN = 1;

    /**
     * 构造器
     * @param size 默认大小
     */
    public MyData(int size) {
        this.size = size;
        elementData = new Number[size];
        wingMan = new Number[size];
        countMain = new int[4];
        countWingMan = new int[4];
        for (int i = 0; i < 4; ++i)
            countMain[i] = 0;
    }

    /**
     * 一个没什么意义的默认构造器, 调用MyData(0)实现
     */
    public MyData() {
        this(0);
    }

    @Deprecated
    public MyData<N> getWingMan() {
        return new MyData<>(size);
    }

    /**
     * 随机填充数组
     */
    public void fill() {
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < size; ++i) {
            elementData[i] = random.nextInt();
        }
    }

    /**
     * 返回数组元素, 忽略检查
     * @param index 元素所在下标
     * @return 强制转换后的T类型实例
     */
    @SuppressWarnings("unchecked")
    private N elementData(int index) {
        return (N) elementData[index];
    }

    /**
     * 用以访问指定下标的辅助数组内容(调用前检查下标合法性)
     * @param index 下标
     * @return 辅助数组下标为index的内容
     */
    @SuppressWarnings("unchecked")
    private N wingMan(int index) {
        return (N) wingMan[index];
    }

    /**
     * 检查下标是否合法, 若否则抛出异常
     * @param index 下标
     */
    private void rangeCheck(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
    }

    /**
     * 获取指定下标的元素(若下标合法)
     * @param index 元素所在下标
     * @return 元素
     */
    public N get(int index) {
        rangeCheck(index);

        ++countMain[0];
        return elementData(index);
    }

    /**
     * 用以访问指定下标的辅助数组内容, 访问前检查下标是否合法
     * @param index 下标
     * @return 内容
     */
    public N getWingMan(int index) {
        rangeCheck(index);

        ++countWingMan[0];
        return wingMan(index);
    }

    /**
     * 更改位于给定下标的元素的值(若下标合法)
     * @param index 元素所在下标
     * @param newValue 更改后的值
     * @return 元素原本的值
     */
    public N set(int index, N newValue) {
        rangeCheck(index);

        ++countMain[1];
        N oldValue = elementData(index);
        elementData[index] = newValue;
        return oldValue;
    }

    /**
     * 更改辅助数组中位于给定下标的元素的值(若下标合法)
     * @param index 元素所在下标
     * @param newValue 更改后的值
     * @return 元素原本的值
     */
    public N setWingMan(int index, N newValue) {
        rangeCheck(index);

        ++countWingMan[1];
        N oldValue = elementData(index);
        wingMan[index] = newValue;
        return oldValue;
    }

    /**
     * 交换位于位置i与j的元素(若i, j均合法)
     * @param i 第一个元素
     * @param j 第二个元素
     */
    public void swap(int i, int j) {
        rangeCheck(i);
        rangeCheck(j);

        ++countMain[2];
        N tmp = elementData(j);
        elementData[j] = elementData[i];
        elementData[i] = tmp;
    }

    /**
     * 交换辅助数组中位于位置i与j的元素(若i, j均合法)
     * @param i 第一个元素
     * @param j 第二个元素
     */
    public void swapWingMan(int i, int j) {
        rangeCheck(i);
        rangeCheck(j);

        ++countWingMan[2];
        N tmp = wingMan(j);
        wingMan[j] = wingMan(i);
        wingMan[i] = tmp;
    }

    /**
     * 调用已经实现的接口比较位于位置i与j的元素(若i, j均合法)
     * @param i 第一个元素
     * @param j 第二个元素
     * @return 比较结果
     */
    public int compare(int i, int j) {
        rangeCheck(i);
        rangeCheck(j);

        ++countMain[3];
        return elementData(i).compareTo(elementData(j));
    }

    /**
     * 调用已经实现的接口比较辅助数组中位于位置i与j的元素(若i, j均合法)
     * @param i 第一个元素
     * @param j 第二个元素
     * @return 比较结果
     */
    public int compareWingMan(int i, int j) {
        rangeCheck(i);
        rangeCheck(j);

        ++countWingMan[3];
        return wingMan(i).compareTo(wingMan(j));
    }

    /**
     * 获取数组大小
     * @return 数组的大小
     */
    public int getSize() {
        return size;
    }

    /**
     * 将主数组中指定的闭区间[start, end]内的数据拷贝到辅助数组的同等位置中
     * @param start 起点
     * @param end 终点
     */
    public void copyToWingMan(int start, int end) {
        rangeCheck(start);
        rangeCheck(end);

        for (int i = start; i <= end; ++i) {
            setWingMan(i, get(i));
        }
    }

    /**
     * 无参数的copyToWingMan的重载, 将主数组内的所有内容拷贝到辅助数组中
     */
    public void copyToWingMan() {
        copyToWingMan(0, size - 1);
    }

    /**
     * 将辅助数组中指定的闭区间[start, end]内的数据拷贝到主数组的同等位置中
     * @param start 起点
     * @param end 终点
     */
    public void copyToMain(int start, int end) {
        rangeCheck(start);
        rangeCheck(end);

        for (int i = start; i <= end; ++i) {
            set(i, getWingMan(i));
        }
    }

    /**
     * 无参数的copyToMain的重载, 将辅助数组内的所有内容拷贝到主数组中
     */
    public void copyToMain() {
        copyToMain(0, size - 1);
    }

    /**
     * 获取指定数组类型的计数数组
     * @param arrayType 数组类型
     * @return 返回计数数组的一个拷贝
     */
    public int[] getCount(int arrayType) {
        if (arrayType > 1)
            throw new IndexOutOfBoundsException();

        if (arrayType == MAIN) {
            return Arrays.copyOf(countMain, 4);
        }
        return Arrays.copyOf(countWingMan, 4);
    }

    /**
     * 清除所有计数器
     */
    public void clearCount() {
        clearCountMain();
        clearCountWingMan();
    }

    /**
     * 清除主计数器
     */
    public void clearCountMain() {
        for (int i = 0; i < 4; ++i)
            countMain[i] = 0;
    }

    /**
     * 清除辅助计数器
     */
    public void clearCountWingMan() {
        for (int i = 0; i < 4; ++i)
            countWingMan[i] = 0;
    }
}
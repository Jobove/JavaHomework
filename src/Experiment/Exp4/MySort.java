package Experiment.Exp4;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * 工具类, 不具有任何数据成员, 只作为排序方法的包装, 无需实例化
 */
public class MySort {
    public static final int BUBBLE = 0, SELECTION = 1, INSERTION = 2, MERGE = 3, MERGE_RECURSIVE = 4;

    public static final int[] sortType = {BUBBLE, SELECTION, INSERTION, MERGE, MERGE_RECURSIVE};

    /**
     * 冒泡排序
     * @param array 待排序的数组
     * @param <T> MyData或其派生类
     */
    @Contract("_ -> new")
    public static <T extends MyData<?>> @NotNull Result BubbleSort(@NotNull T array) {
        final long startTime = System.currentTimeMillis();
        int size = array.getSize();
        for (int i = 0; i < size; ++i) {
            int pos = 0;
            while (pos < size - 1) {
                if (array.compare(pos, pos + 1) > 0) {
                    array.swap(pos, pos + 1);
                }
                ++pos;
            }
        }
        return new Result(array, startTime);
    }

    /**
     * 选择排序
     * @param array 待排序的数组
     * @param <T> MyData或其派生类
     */
    @Contract("_ -> new")
    public static <T extends MyData<?>> @NotNull Result SelectionSort(@NotNull T array) {
        final long startTime = System.currentTimeMillis();
        int size = array.getSize();

        array.copyToWingMan();
        for (int i = 0; i < size; ++i) {
            int smallest = i;
            for (int j = i + 1; j < size; ++j) {
                if (array.getWingMan(smallest).compareTo(array.get(j)) > 0)
                    smallest = j;
            }
            array.swapWingMan(i, smallest);
        }
        array.copyToMain();
        return new Result(array, startTime);
    }

    /**
     * 插入排序
     * @param array 待排序的数组
     * @param <T> MyData或其派生类
     */
    @Contract("_ -> new")
    public static <T extends MyData<?>> @NotNull Result InsertionSort(@NotNull T array) {
        final long startTime = System.currentTimeMillis();
        int size = array.getSize();

        array.setWingMan(0, array.get(0));
        for (int i = 1; i < size; ++i) {
            //如果当前数字小于有序数组内的所有数, 则将有序数组全部后移一个并将这个数插入至有序数组的开头
            if (array.getWingMan(0).compareTo(array.get(i)) >= 0) {
                for (int k = i - 1; k >= 0; --k) {
                    array.swapWingMan(k, k + 1);
                }
                array.setWingMan(0, array.get(i));
                continue;
            }

            for (int j = 0; j < i; ++j) {
                //否则一直寻找, 直到第j个数小于待插入数字
                if (array.getWingMan(j).compareTo(array.get(i)) < 0) {
                    //且j已经是有序数组的最后一个, 则直接将其插入至有序数组末尾
                    if (j == i - 1) {
                        array.setWingMan(i, array.get(i));
                        break;
                    }
                    //或者第j个数小于待插入数字且第j+1个数大于等于待插入数字
                    //则将第j+1个数及之后的所有的数字往后移一位, 再将待插入数字插入至下标j+1
                    if (array.getWingMan(j + 1).compareTo(array.get(i)) >= 0) {
                        for (int k = i - 1; k > j; --k) {
                            array.swapWingMan(k, k + 1);
                        }
                        array.setWingMan(j + 1, array.get(i));
                        break;
                    }
                }
            }
        }

        array.copyToMain();
        return new Result(array, startTime);
    }

    /**
     * 从外部调用的归并排序方法, 并不实现任何功能, 用以分离递归部分
     * @param array 待排序数组
     * @param <T> MyData或其派生类
     */
    public static <T extends MyData<?>> @NotNull Result MergeSortRecursive(@NotNull T array) {
        final long startTime = System.currentTimeMillis();
        MergeSortWorker(array, 0, array.getSize() - 1);
        return new Result(array, startTime);
    }

    /**
     * 归并排序递归实现的工作函数
     * @param array 待排序数组
     * @param start 需要排序的区间起始位置
     * @param end 需要排序的区间末尾位置
     * @param <T> MyData或其派生类
     */
    private static <T extends MyData<?>> void MergeSortWorker(T array, int start, int end) {
        //递归边界条件, 如果数组长度为1则无需排序
        if (start == end)
            return;

        //辅助变量, 用来待排序区间的记录长度
        final int length = end - start + 1;
        //将待排序区间分为长度相等或相差1的两个区间, 左区间的端点分别为ls和le, 右区间的端点为rs和re(end)
        //同时ls和rs记录左右区间未排序的第一个数的位置
        int ls = start, le = start + length / 2 - 1, rs = le + 1;

        //首先将左区间和右区间分别排序
        MergeSortWorker(array, ls, le);
        MergeSortWorker(array, rs, end);

        //而后分别比较左区间和右区间的第一个待排序的数, 将较小的插入到有序数组内
        for (int i = 0; i < length; ++i) {
            //如果左区间或右区间已经取完, 则直接将另外一个区间内剩余的数直接按顺序插入
            if (ls > le) {
                array.setWingMan(i, array.get(rs++));
                continue;
            }
            if (rs > end) {
                array.setWingMan(i, array.get(ls++));
                continue;
            }

            //否则比较左区间和右区间的第一个待排序的数, 将更小的那个插入到有序数组内
            if (array.get(ls).compareTo(array.get(rs)) <= 0) {
                array.setWingMan(i, array.get(ls++));
            } else {
                array.setWingMan(i, array.get(rs++));
            }
        }

        //最后将排序好的有序数组拷贝到主数组中
        array.copyToMain(start, end);
    }

    /**
     * 非递归的归并排序
     * @param array 待排序数组
     * @param <T> MyData或其派生类
     */
    @Contract("_ -> new")
    public static <T extends MyData<?>> @NotNull Result MergeSortNonRecursive(@NotNull T array) {
        final long startTime = System.currentTimeMillis();
        int len = 2, size = array.getSize();
        //从大小为2的区间开始排序, 直到排序的区间的大小与数组大小相等或更大时进行最后一次排序, 而后终止循环
        //因此当排序区间大小len >= size时将flag标记为true, 进行最后一次排序
        //排序结束后, 若flag == true, 则退出循环
        boolean flag = false;

        while (true) {
            //首先枚举各个待排序区间的起点start
            for (int start = 0; start < size; start += len) {
                //由于可能出现最后一个待排序区间的终点大于数组终点的情况, 即len > size的情况
                //因此在每个小区间内比较时需将比较的终点设置为start+len-1和size-1中较小的那个
                final int end = Math.min(start + len - 1, size - 1);
                //剩余部分与递归实现没有差别, 不再赘述
                int ls = start, le = ls + len / 2 - 1, rs = le + 1;
                if (start == end)
                    continue;
                for (int j = 0; j < Math.min(len, size - start); ++j) {
                    if (ls > le) {
                        array.setWingMan(j, array.get(rs++));
                        continue;
                    }
                    if (rs > end) {
                        array.setWingMan(j, array.get(ls++));
                        continue;
                    }

                    if (array.get(ls).compareTo(array.get(rs)) <= 0) {
                        array.setWingMan(j, array.get(ls++));
                    } else {
                        array.setWingMan(j, array.get(rs++));
                    }
                }

                array.copyToMain(start, end);
            }

            //排序完成后将len乘以2
            len *= 2;
            //如果flag == true则结束循环
            //即此时已经完成了一次len >= size(因为此时flag == true)的排序
            //因此可以直接结束循环
            if (flag)
                break;
            //否则, 如果原本的len * 2 >= size, 则需进行最后一次排序
            //将flag设置为true, 完成最后一次排序后退出
            if (len >= size)
                flag = true;
        }
        return new Result(array, startTime);
    }

    public static <T extends MyData<?>> @NotNull Result sort(@NotNull T array, int operationType) {
        switch (operationType) {
            case BUBBLE:
                return BubbleSort(array);
            case SELECTION:
                return SelectionSort(array);
            case INSERTION:
                return InsertionSort(array);
            case MERGE:
                return MergeSortNonRecursive(array);
            case MERGE_RECURSIVE:
                return MergeSortRecursive(array);
            default:
                throw new IndexOutOfBoundsException();
        }
    }
}


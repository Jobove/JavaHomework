package Experiment.Exp4;

import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.Scanner;

/**
 * 测试类
 */
public class MyTest {
    static Scanner scanner = new Scanner(System.in);
    static final String[] strings =
            {"BubbleSort", "SelectionSort", "InsertionSort", "MergeSort_NonRecursive", "MergeSort_Recursive"};

    /**
     * 用以输出排序的各种结果
     * @param result MySort返回的结果
     */
    static void output(@NotNull Result result) {
        System.out.printf("%d time(s) of get operation,\n" +
                "%d time(s) of set operation,\n" +
                "%d time(s) of swap operation,\n" +
                "%d time(s) of compare operation.\n" +
                "This process cost %d millisecond(s) in total, that's %.1f second(s).\n",
                result.getCount(Result.GET), result.getCount(Result.SET),
                result.getCount(Result.SWAP), result.getCount(Result.COMPARE),
                result.getTimeCostMillis(), 1.0 * result.getTimeCostMillis() / 1000);
    }

    /**
     * 用以输出原本的数组
     * @param array 原本的数组
     */
    static void output(Integer @NotNull [] array) {
        for (int i : array) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }

    /**
     * 将排序后的MyData类输出
     * @param array MyData类的实例, 应已排序
     */
    static void output(@NotNull MyData<Integer> array) {
        for (int i = 0; i < array.getSize(); ++i) {
            System.out.printf("%d ", array.get(i));
        }
        System.out.println();
    }

    /**
     * 工作函数, 用于精简主函数
     * @param sort 排序类型
     * @param arraySize 数组大小
     * @param output 是否将原数组和排序后的数组输出, 如果值为True则输出
     */
    static void worker(int sort, int arraySize, boolean output) {
        MyData<Integer> array = new MyData<>(arraySize);
        final int minValue = 0, maxValue = 10000;

        /*
        通过传回的种子创造Random实例, 调用ints()方法获得IntStream, 再调用boxed()方法获得Stream<Integer>, 最后调用toArray(Integer[]::new)获得原数组,
        使用Stream<Integer>的sorted()方法获取正确排序后的Stream<Integer>便于确认排序是否正确
        每次生成原数组都应使用新的Random实例, 否则无法复原
         */
        long seed = array.fill(minValue, maxValue);
        if (output)
            output(new Random(seed).ints(arraySize, minValue, maxValue).boxed().toArray(Integer[]::new));
        Integer[] sortedArray = new Random(seed).ints(arraySize, minValue, maxValue).boxed().sorted().toArray(Integer[]::new);

        Result result = MySort.sort(array, sort);
        if (output)
            output(array);
        if (array.check(sortedArray))
            System.out.println("Result correct.");
        else
            System.out.println("Result incorrect.");

        //输出排序所使用的各种操作的次数
        System.out.printf("The %s costs: \n", strings[sort]);
        output(result);
        System.out.println("--------------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("Input the size of the array you want to generate(an integer): ");
        final int arraySize = scanner.nextInt();

        System.out.println("Are you willing to see the original and the result array?\n" +
                "It's not recommended if the size of array is large!\n" +
                "If true, type \"True\", else type \"False\": ");
        final boolean output = scanner.nextBoolean();
        System.out.println("--------------------------------------------------------------------------");

        for (int sort : MySort.sortType) {
            worker(sort, arraySize, output);
        }
    }
}

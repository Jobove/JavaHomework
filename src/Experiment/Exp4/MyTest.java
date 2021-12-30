package Experiment.Exp4;

import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class MyTest {
    static void output(@NotNull Result result) {
        System.out.printf("This sort uses: \n" +
                "%d time(s) of get operation,\n" +
                "%d time(s) of set operation,\n" +
                "%d time(s) of swap operation,\n" +
                "%d time(s) of compare operation.\n" +
                "This process cost %d millisecond(s) in total, that's %.1f second(s).\n",
                result.getCount(Result.GET), result.getCount(Result.SET),
                result.getCount(Result.SWAP), result.getCount(Result.COMPARE),
                result.getTimeCostMillis(), 1.0 * result.getTimeCostMillis() / 1000);
    }

    static void output(int @NotNull [] array) {
        for (int i : array) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }

    static void output(@NotNull MyData<Integer> array) {
        for (int i = 0; i < array.getSize(); ++i) {
            System.out.printf("%d ", array.get(i));
        }
        System.out.println();
    }

    static void init(MyData<Integer> array, int @NotNull [] arrayToSort) {
        for (int i = 0; i < arrayToSort.length; ++i) {
            array.set(i, arrayToSort[i]);
        }
        array.clearCount();
    }

    public static void main(String[] args) {
        Random random = new Random(System.currentTimeMillis());
        final int arraySize = 10000;
        String[] strings =
                {"BubbleSort", "SelectionSort", "InsertionSort", "MergeSort_NonRecursive", "MergeSort_Recursive"};

        for (int sort : MySort.sortType) {
            int[] arrayToSort = random.ints(arraySize, 0, 10000).toArray();
//            System.out.print("The original array is: \n");
//            output(arrayToSort);
            MyData<Integer> array = new MyData<>(arraySize);
            init(array, arrayToSort);

            Result result = MySort.sort(array, sort);
//            System.out.printf("After %s, the array has been changed into: \n", strings[sort]);
//            output(array);
            System.out.println("Cost:");
            output(result);
            System.out.println("--------------------------------------------------------------------------");
        }
    }
}

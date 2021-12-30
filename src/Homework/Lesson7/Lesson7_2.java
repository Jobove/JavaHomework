package Homework.Lesson7;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

class ArraySorter {
    /**
     * 交换数组中两个值的位置
     * @param i 要交换的第一个值的下标
     * @param j 要交换的第二个值的下标
     * @param a 所在的数组
     */
    private static void interchange(int i, int j, Integer @NotNull [] a) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * 对数组进行冒泡排序
     * @param anArray 需要排序的数组
     */
    public static void bubbleSort(Integer @NotNull [] anArray) {
        for (int maxIndex = anArray.length - 1; maxIndex >= 0; --maxIndex) {
            for (int index = 0; index < maxIndex; ++index) {
                if (anArray[index] > anArray[index + 1]) {
                    interchange(index, index + 1, anArray);
                }
            }
        }
    }

    /**
     * 对数组进行插入排序
     * @param anArray 需要排序的数组
     */
    public static void insertionSort(Integer @NotNull [] anArray) {
        ArrayList<Integer> arrayList = new ArrayList<>(anArray.length);
        for (int i : anArray) {
            if (arrayList.isEmpty())
                arrayList.add(i);
            for (int j = 0; j < arrayList.size(); ++j) {
                if (arrayList.get(j) > i) {
                    arrayList.add(j, i);
                    break;
                }
            }
        }
        arrayList.toArray(anArray);
    }
}

public class Lesson7_2 {
    public static void main(String[] args) {
        Integer[][] descendingArray = {{5, 4, 3, 2, 1}, {5, 4, 3, 2, 1}};
        String[] names = {"bubbleSort", "insertionSort"};
        for (int i = 0; i < names.length; ++i) {
            System.out.println("The origin array is: ");
            for(Integer integer : descendingArray[i]) {
                System.out.printf("%d ", integer);
            }
            System.out.print('\n');
            if(i == 0)
                ArraySorter.bubbleSort(descendingArray[i]);
            else
                ArraySorter.insertionSort(descendingArray[i]);
            System.out.printf("The result of %s is: \n", names[i]);
            for (Integer integer : descendingArray[i]) {
                System.out.printf("%d ", integer);
            }
            System.out.print('\n');
        }
    }
}

package Homework.Lesson7;

import java.util.HashSet;
import java.util.Scanner;

class SudokuPuzzle {
    /**
     * 一个二维数组, 用以存放棋盘.
     */
    private final Integer[][] board;

    /**
     * 一个二维boolean数组, 表示棋盘在这个位置上的数是否能被addGuess()更改.
     */
    private final Boolean[][] start;

    /**
     * 无参构造器, 将两个二维数组初始化
     */
    public SudokuPuzzle() {
        board = new Integer[10][];
        for (int i = 1; i <= 9; ++i) {
            board[i] = new Integer[10];
            for(int j = 1; j <= 9; ++j) {
                board[i][j] = 0;
            }
        }
        start = new Boolean[10][];
        for (int i = 1; i <= 9; ++i) {
            start[i] = new Boolean[10];
            for(int j = 1; j <= 9; ++j) {
                start[i][j] = false;
            }
        }
    }

    /**
     * 覆写后的toString(), 输出棋盘内容, 同一行内以空格间隔并换行.
     * @return 符合打印要求的String.
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= 9; ++i) {
            for (int j = 1; j <= 9; ++j) {
                Integer integer = board[i][j];
                stringBuilder.append(integer).append(' ');
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }

    /**
     * 检查给定的下标是否合法.
     * @param row 行数, 当且仅当 1 <= row <= 9时合法.
     * @param col 列数, 当且仅当 1 <= col <= 9时合法.
     * @throws IndexOutOfBoundsException 下标非法时抛出异常.
     */
    private void checkIndexLegality(int row, int col) throws IndexOutOfBoundsException {
        if (row <= 0 || row > 9 || col <= 0 || col > 9)
            throw new IndexOutOfBoundsException("Index should be between 1 and 9");
    }

    /**
     * 将给定方块设置为给定的值，作为游戏玩家不能修改的初始值.
     * @param row 行数, 当且仅当 1 <= row <= 9时合法.
     * @param col 列数, 当且仅当 1 <= col <= 9时合法.
     * @param value 更改的值.
     * @throws Exception 下标或给定值非法时抛出异常.
     */
    public void addInitial(int row, int col, int value) throws Exception {
        checkIndexLegality(row, col);
        if (value < 0 || value > 9)
            throw new Exception("Number should be between 0 and 9");
        start[row][col] = true;
        board[row][col] = value;
    }

    /**
     * 将给定方块设置为给定的值，这个值之后可以被另一个对addGuess的调用所修改.
     * @param row 行数, 当且仅当 1 <= row <= 9时合法.
     * @param col 列数, 当且仅当 1 <= col <= 9时合法.
     * @param value 更改的值.
     * @throws Exception 下标或给定值非法时抛出异常.
     */
    public void addGuess(int row, int col, int value) throws Exception {
        checkIndexLegality(row, col);
        if (start[row][col])
            throw new Exception("This value cannot be modified!");
        if (value < 0 || value > 9)
            throw new Exception("Number should be between 1 and 9");
        board[row][col] = value;
    }

    /**
     * 检查某一行是否违反约束条件.
     * @param row 行数.
     * @return 一个boolean表示是否符合约束条件.
     */
    private boolean checkRow(int row) {
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 1; i < 10; ++i) {
            Integer now = board[row][i];
            if (now >= 0 && now <= 9)
                count += 1;
            else
                return false;
            set.add(now);
        }
        return set.size() == count;
    }

    /**
     * 检查某一列是否违反约束条件.
     * @param col 列数.
     * @return 一个boolean表示是否符合约束条件.
     */
    private boolean checkCol(int col) {
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 1; i < 10; ++i) {
            Integer now = board[i][col];
            if (now >= 0 && now <= 9)
                count += 1;
            else
                return false;
            set.add(now);
        }
        return set.size() == count;
    }

    /**
     * 检查某一方块(3*3)是否违反约束条件.
     * @param index 格子所在的序号.
     * @return 一个boolean表示是否符合约束条件.
     */
    private boolean checkBox(int index) {
        HashSet<Integer> set = new HashSet<>();
        int count = 0, s = (index - 1) % 3 * 3 + 1;
        for (int i = s; i < s + 3; ++i) {
            for (int j = s; j < j + 3; ++j) {
                Integer now = board[i][j];
                if (now >= 0 && now <= 9)
                    count += 1;
                else
                    return false;
                set.add(now);
            }
        }
        return set.size() == count;
    }

    /**
     * 检查整个棋盘是否违反约束条件.
     * @return 一个boolean表示是否符合约束条件.
     */
    public boolean checkPuzzle() {
        for (int i = 1; i < 10; ++i) {
            if (!checkRow(i) || !checkCol(i) ||!checkBox(i))
                return false;
        }
        return true;
    }

    /**
     * 获取棋盘上某个位置的值.
     * @param row 行数, 当且仅当 1 <= row <= 9时合法.
     * @param col 列数, 当且仅当 1 <= col <= 9时合法.
     * @return 棋盘上某个位置的值.
     * @throws IndexOutOfBoundsException 下标非法时抛出异常.
     */
    public Integer getValueIn(int row, int col) throws IndexOutOfBoundsException {
        checkIndexLegality(row, col);
        return board[row][col];
    }

    /**
     * 返回一个由9个布尔值构成的一维数组，其中每个布尔值都对应于一个数字，如果该数字填入给定的方块时不会违反约束条件，则元素为true.
     * @param row 行数, 当且仅当 1 <= row <= 9时合法.
     * @param col 列数, 当且仅当 1 <= col <= 9时合法.
     * @return 一个由9个布尔值构成的一维数组，其中每个布尔值都对应于一个数字，如果该数字填入给定的方块时不会违反约束条件，则元素为true.
     * @throws IndexOutOfBoundsException 下标非法时抛出异常.
     */
    public Boolean[] getAllowedValues(int row, int col) throws IndexOutOfBoundsException {
        checkIndexLegality(row, col);
        Boolean[] ans = new Boolean[10];
        for (Boolean i : ans)
            i = true;
        for (int i = 1; i < 10; ++i) {
            Integer now = board[row][i];
            if (now >= 1 && now <= 9)
                ans[now] = false;
        }
        for (int i = 1; i < 10; ++i) {
            Integer now = board[i][col];
            if (now >= 1 && now <= 9)
                ans[now] = false;
        }
        int index = ((row - 1) % 3) * 3 + (col - 1) % 3, s = (index - 1) % 3 * 3 + 1;
        for (int i = s; i < s + 3; ++i) {
            for (int j = s; j < j + 3; ++j) {
                Integer now = board[i][j];
                if (now >= 1 && now <= 9)
                    ans[now] = false;
            }
        }
        return ans;
    }

    /**
     * 检查棋盘是否已被填满.
     * @return 如果棋盘已经被填满则返回true.
     */
    public boolean isFull() {
        for (int i = 1; i <= 9; ++i) {
            for (int j = 1; j <= 9; ++j) {
                if (board[i][j] == 0)
                    return false;
            }
        }
        return true;
    }

    /**
     * 重置棋盘.
     */
    public void reset() {
        for (int i = 1; i <= 9; ++i) {
            for (int j = 1; j <= 9; ++j) {
                if (!start[i][j])
                    board[i][j] = 0;
            }
        }
    }

}

public class Lesson7_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SudokuPuzzle sudoku = new SudokuPuzzle();

        while (true) {
            System.out.println("棋盘当前状态是:");
            System.out.print(sudoku);
            System.out.println("请输入想要进行的操作, -1为退出游戏, 0为重置游戏, 1为向空格内填数:");

            int operate = scanner.nextInt();
            if(operate == -1) {
                break;
            } else if (operate == 0) {
                sudoku.reset();
            } else if (operate == 1) {
                System.out.println("请输入想要填入的位置和数, 格式为行 列 数, 参数间以空格分隔:");

                int row = scanner.nextInt(), col = scanner.nextInt(), value = scanner.nextInt();
                try {
                    sudoku.addGuess(row, col, value);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }

                if(sudoku.checkPuzzle() && sudoku.isFull()) {
                    System.out.println("恭喜你成功解决了这个谜题!");
                } else {
                    System.out.println("谜题尚未解决, 请再接再厉!");
                }
            } else {
                System.out.println("请输入正确的操作!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

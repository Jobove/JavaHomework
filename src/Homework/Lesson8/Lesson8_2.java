package Homework.Lesson8;

import org.jetbrains.annotations.NotNull;


interface MessageEncoder {
    /**
     * 加密函数
     * @param plainText 待加密的文本
     * @return 加密后文本
     */
    public String encode(String plainText);
}

class SubstitutionCipher implements MessageEncoder {
    /**
     * 移位次数
     */
    private int shift;

    /**
     * 带有初始移位次数参数的构造器
     * @param shift 移位次数
     */
    SubstitutionCipher(int shift) {
        setShift(shift);
    }

    /**
     * 获取shift
     * @return shift的值
     */
    public int getShift() {
        return shift;
    }

    /**
     * 设置shift值, 当传入的值为负数时转化为正数
     * @param shift 设置后的shift的值
     */
    public void setShift(int shift) {
        this.shift = (shift % 26 + 26) % 26;
    }

    /**
     * 获取移位后的字符
     * @param ch 待移位字符
     * @return 移位后的字符
     */
    private char shiftChar(char ch) {
        int start = (ch >= 'a' && ch <= 'z') ? 'a' : 'A';
        return (char)(start + (ch - start + shift) % 26);
    }

    /**
     * 加密函数
     * @param plainText 待加密的文本
     * @return 加密后的文本
     */
    public String encode(@NotNull String plainText) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < plainText.length(); ++i) {
            stringBuilder.append(shiftChar(plainText.charAt(i)));
        }
        return stringBuilder.toString();
    }
}

class ShuffleCipher implements MessageEncoder {
    /**
     * 打乱次数
     */
    private int n;

    /**
     * 带有初始打乱次数的构造器
     * @param n 初始打乱次数
     * @throws Exception 如果打乱次数小于0则抛出异常
     */
    ShuffleCipher(int n) throws Exception {
        setN(n);
    }

    /**
     * 获取打乱次数n
     * @return 打乱次数n
     */
    public int getN() {
        return n;
    }

    /**
     * 设置打乱次数n
     * @param n 设置后的打乱次数n
     * @throws Exception 如果打乱次数n小于0则抛出异常
     */
    public void setN(int n) throws Exception {
        if (n < 0)
            throw new Exception("Negative n.");
        this.n = n;
    }

    /**
     * 将字符串打乱一次
     * @param stringToShuffle 待打乱的字符串
     * @return 打乱后的字符串
     */
    private @NotNull String shuffle(@NotNull String stringToShuffle) {
        StringBuilder stringBuilder = new StringBuilder();

        //下面的halfLength均指实际的长度除以2的值, 即不舍去0.5时
        //求出floor(halfLength)以及判断长度是否奇数
        int halfLength = stringToShuffle.length() / 2, ifIsOdd = stringToShuffle.length() & 1;
        boolean isOdd = (ifIsOdd) == 1;
        //无论长度是否奇数, 进行floor(halfLength)次循环
        for (int i = 0; i < halfLength; ++i) {
            stringBuilder.append(stringToShuffle.charAt(i));
            stringBuilder.append(
                    //如果是偶数则从halfLength开始, 否则从floor(halfLength) + 1开始
                    stringToShuffle.charAt(halfLength + i + ifIsOdd)
            );
        }
        //如果长度是奇数, 则补上一个字符
        if (isOdd)
            stringBuilder.append(
                    stringToShuffle.charAt(halfLength)
            );

        return stringBuilder.toString();
    }

    /**
     * 打乱n次字符串
     * @param plainText 待加密的文本
     * @return 打乱n次后的字符串
     */
    public String encode(String plainText) {
        String ans = "";
        for (int i = 0; i < n; ++i) {
            ans = shuffle(plainText);
        }
        return ans;
    }
}

public class Lesson8_2 {
    public static void main(String[] args) {
        SubstitutionCipher substitutionCipher = new SubstitutionCipher(3);
        System.out.println(
                substitutionCipher.encode("abcdefghijklmnopqrstuvwxyz")
        );
        try {
            ShuffleCipher shuffleCipher = new ShuffleCipher(1);
            System.out.println(
                    shuffleCipher.encode("abcdefghi")
            );
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

package homework.Lesson8;

import java.util.Scanner;

public class Lesson8_3_1 {
    public static void main(String[] args) {
        int op;
        Scanner scanner = new Scanner(System.in);
        SubstitutionCipher substitutionCipher;
        ShuffleCipher shuffleCipher;
        String stringToEncode;
        do {
            System.out.print("本程序有以下加密方式:\n" +
                    "1. 将字符串的字符移n位;\n" +
                    "2. 将字符串打乱n次;\n" +
                    "或输入0以退出.\n" +
                    "请输入想要进行的操作并回车:\n");
            op = scanner.nextInt();
            int n;
            switch (op) {
                case 0:
                    break;
                case 1:
                    System.out.print("请输入n并回车:\n");
                    n = scanner.nextInt();
                    substitutionCipher = new SubstitutionCipher(n);
                    System.out.print("请输入待加密字符串并回车:\n");
                    scanner.nextLine();
                    stringToEncode = scanner.nextLine();
                    System.out.println(substitutionCipher.encode(stringToEncode));
                    break;
                case 2:
                    System.out.print("请输入n并回车:\n");
                    n = scanner.nextInt();
                    try {
                        shuffleCipher = new ShuffleCipher(n);
                        System.out.print("请输入待加密字符串并回车:\n");
                        scanner.nextLine();
                        stringToEncode = scanner.nextLine();
                        System.out.println(shuffleCipher.encode(stringToEncode));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("请输入正确的操作数!");
                    break;
            }
        } while (op != 0);
    }
}

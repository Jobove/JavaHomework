package Homework.Lesson2;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Scanner;

public class Lesson2_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入你的名字: ");
        String name = scanner.next();
        try {
            for(int i = 0; i < name.length(); ++i) {
                String subString = name.substring(i, i + 1);
                System.out.println(subString + "的UTF-8编码是" +
                        URLEncoder.encode(subString, "UTF-8").replace("%", ""));
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}

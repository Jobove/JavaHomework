package homework.Lesson3;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lesson3_2_1 {
    public static void main(String[] args) throws Exception {
        System.out.println("Please input two date in the form of \"HH:MM:SS AM/PM\" in two lines:");
        Scanner scanner = new Scanner(System.in);

        String firstTime = scanner.nextLine(),
                secondTime = scanner.nextLine();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");

        Pattern pattern = Pattern.compile("(\\d{2}:\\d{2}:\\d{2}) (AM|PM)");
        Matcher firstMatcher = pattern.matcher(firstTime);
        Matcher secondMatcher = pattern.matcher(secondTime);

        if (firstMatcher.find() && secondMatcher.find()) {
            Calendar firstCalender = Calendar.getInstance();
            firstCalender.setTime(simpleDateFormat.parse(firstMatcher.group(1)));
            if(firstMatcher.group(2).contentEquals("PM"))
                firstCalender.set(Calendar.HOUR, firstCalender.get(Calendar.HOUR) + 12);

            Calendar secondCalender = Calendar.getInstance();
            secondCalender.setTime(simpleDateFormat.parse(secondMatcher.group(1)));
            if(secondMatcher.group(2).contentEquals("PM"))
                secondCalender.set(Calendar.HOUR, secondCalender.get(Calendar.HOUR) + 12);

            if(firstCalender.compareTo(secondCalender) > 0)
                secondCalender.set(Calendar.DATE, secondCalender.get(Calendar.DATE) + 1);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date(secondCalender.getTimeInMillis() - firstCalender.getTimeInMillis()));
            System.out.printf("两个时间间隔了%d小时%d分钟%d秒.\n",
                    calendar.get(Calendar.HOUR) - 8,
                    calendar.get(Calendar.MINUTE),
                    calendar.get(Calendar.SECOND));
        }
    }

}

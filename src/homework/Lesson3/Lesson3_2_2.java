package homework.Lesson3;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Lesson3_2_2 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Text firstTimeText = new Text();
        firstTimeText.setText("请输入第一个时间: ");
        firstTimeText.setTextAlignment(TextAlignment.CENTER);

        TextField firstTimeInput = new TextField();
        HBox firstTimeInputBox = new HBox();
        ObservableList<Node> firstTimeInputBoxChildren = firstTimeInputBox.getChildren();
        firstTimeInputBoxChildren.addAll(firstTimeText, firstTimeInput);


        Text secondTimeText = new Text();
        secondTimeText.setText("请输入第二个时间: ");
        secondTimeText.setTextAlignment(TextAlignment.CENTER);

        TextField secondTimeInput = new TextField();
        HBox secondTimeInputBox = new HBox();
        ObservableList<Node> secondTimeInputBoxChildren = secondTimeInputBox.getChildren();
        secondTimeInputBoxChildren.addAll(secondTimeText, secondTimeInput);

        Button enterButton = new Button("确认!");
        enterButton.setOnAction(e -> {
            String firstTime = firstTimeInput.getText(),
                    secondTime = secondTimeInput.getText();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");

            Pattern pattern = Pattern.compile("(\\d{2}:\\d{2}:\\d{2}) (AM|PM)");
            Matcher firstMatcher = pattern.matcher(firstTime);
            Matcher secondMatcher = pattern.matcher(secondTime);

            if (firstMatcher.find() && secondMatcher.find()) {
                try {
                    Calendar firstCalender = Calendar.getInstance();
                    firstCalender.setTime(simpleDateFormat.parse(firstMatcher.group(1)));
                    if (firstMatcher.group(2).contentEquals("PM"))
                        firstCalender.set(Calendar.HOUR, firstCalender.get(Calendar.HOUR) + 12);

                    Calendar secondCalender = Calendar.getInstance();
                    secondCalender.setTime(simpleDateFormat.parse(secondMatcher.group(1)));
                    if (secondMatcher.group(2).contentEquals("PM"))
                        secondCalender.set(Calendar.HOUR, secondCalender.get(Calendar.HOUR) + 12);

                    if (firstCalender.compareTo(secondCalender) > 0)
                        secondCalender.set(Calendar.DATE, secondCalender.get(Calendar.DATE) + 1);

                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(new Date(secondCalender.getTimeInMillis() - firstCalender.getTimeInMillis()));
                    JOptionPane.showMessageDialog(null, String.format("两个时间间隔了%d小时%d分钟%d秒.\n",
                            calendar.get(Calendar.HOUR) - 8,
                            calendar.get(Calendar.MINUTE),
                            calendar.get(Calendar.SECOND)));

                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }
            }
        });

        VBox inputBox = new VBox();
        ObservableList<Node> inputBoxChildren = inputBox.getChildren();
        inputBoxChildren.addAll(firstTimeInputBox, secondTimeInputBox, enterButton);
        inputBox.setAlignment(Pos.CENTER);
        inputBox.setPadding(new Insets(10, 20, 10, 20));
        inputBox.setSpacing(50);

        Scene scene = new Scene(inputBox, 300, 200);
        primaryStage.setTitle("Lesson2_2 By Jobove");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
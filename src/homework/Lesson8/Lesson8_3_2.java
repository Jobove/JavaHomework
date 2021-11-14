package homework.Lesson8;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Lesson8_3_2 extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //消息输入框
        Text messageText = new Text();
        messageText.setText("请输入消息: ");
        messageText.setTextAlignment(TextAlignment.CENTER);
        TextField messageInput = new TextField();
        //消息输入框所属的水平行
        HBox messageInputBox = new HBox();
        ObservableList<Node> messageInputBoxChildren = messageInputBox.getChildren();
        messageInputBoxChildren.addAll(messageText, messageInput);

        //n输入框
        Text nText= new Text();
        nText.setText("请输入n:   ");
        nText.setTextAlignment(TextAlignment.CENTER);
        TextField nInput = new TextField();
        //n输入框所属水平行
        HBox nInputBox = new HBox();
        ObservableList<Node> nInputBoxChildren = nInputBox.getChildren();
        nInputBoxChildren.addAll(nText, nInput);

        //移位按钮
        Button substitutionButton = new Button("移位");
        substitutionButton.setOnAction(e -> {
            try {
                SubstitutionCipher substitutionCipher = new SubstitutionCipher(Integer.parseInt(nInput.getText()));
                //弹出提示框显示结果
                Alert substitutionAlert = new Alert(Alert.AlertType.INFORMATION);
                substitutionAlert.setHeaderText("加密后信息");
                substitutionAlert.setContentText(
                        substitutionCipher.encode(messageInput.getText())
                );
                substitutionAlert.show();
            } catch (NumberFormatException numberFormatException) {
                //如果n输入框内数字格式错误则处理异常
                Alert exceptionAlert = new Alert(Alert.AlertType.ERROR);
                exceptionAlert.setHeaderText("无效的n");
                exceptionAlert.setContentText("n输入框内格式错误!");
                exceptionAlert.show();
            }
        });

        //打乱按钮
        Button shuffleButton = new Button("打乱");
        shuffleButton.setOnAction(event -> {
            try {
                ShuffleCipher shuffleCipher = new ShuffleCipher(Integer.parseInt(nInput.getText()));
                //弹出提示框显示结果
                Alert shuffleAlert = new Alert(Alert.AlertType.INFORMATION);
                shuffleAlert.setHeaderText("加密后信息");
                shuffleAlert.setContentText(shuffleCipher.encode(messageInput.getText()));
                shuffleAlert.show();
            } catch (NumberFormatException numberFormatException) {
                //如果n输入框内数字格式错误则处理异常
                Alert exceptionAlert = new Alert(Alert.AlertType.ERROR);
                exceptionAlert.setHeaderText("无效的n");
                exceptionAlert.setContentText("n输入框内格式错误!");
                exceptionAlert.show();
            } catch (Exception e) {
                //如果获取到负值n异常则处理异常
                Alert exceptionAlert = new Alert(Alert.AlertType.ERROR);
                exceptionAlert.setHeaderText("负值n");
                exceptionAlert.setContentText("你设置的n为负数");
                exceptionAlert.show();
            }
        });

        //两个按钮所在的水平行
        HBox buttonBox = new HBox();
        ObservableList<Node> buttonBoxChildren = buttonBox.getChildren();
        buttonBoxChildren.addAll(substitutionButton, shuffleButton);
        //设置对齐和间距
        buttonBox.setAlignment(Pos.BASELINE_CENTER);
        buttonBox.setSpacing(100);

        //设置总的垂直布局
        VBox inputBox = new VBox();
        ObservableList<Node> inputBoxChildren = inputBox.getChildren();
        inputBoxChildren.addAll(messageInputBox, nInputBox, buttonBox);
        //设置对齐, 内径和间距
        inputBox.setAlignment(Pos.CENTER);
        inputBox.setPadding(new Insets(10, 20, 10, 20));
        inputBox.setSpacing(50);

        //显示程序
        Scene scene = new Scene(inputBox, 300, 200);
        primaryStage.setTitle("Lesson8_3_2 By Jobove");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
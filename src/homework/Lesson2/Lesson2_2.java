package homework.Lesson2;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import javax.swing.*;


public class Lesson2_2 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Text text = new Text();
        text.setText("请输入你的名字");
        text.setTextAlignment(TextAlignment.CENTER);

        TextField nameInput = new TextField();

        Button enterButton = new Button("确认!");
        enterButton.setOnAction(e -> {
            String name = nameInput.getText(),
                    returnString;
            StringBuilder returnStringBuilder = new StringBuilder();
            for (int i = 0; i < name.length(); ++i) {
                char ch = name.charAt(i);
                returnStringBuilder.append(ch).
                        append("的Unicode编码是").
                        append((int) ch)
                        .append("\n");
            }
            returnString = returnStringBuilder.toString();
            JOptionPane.showMessageDialog(null, returnString);
        });

        VBox inputBox = new VBox();
        ObservableList<Node> list = inputBox.getChildren();
        list.addAll(text, nameInput, enterButton);
        inputBox.setAlignment(Pos.CENTER);
        inputBox.setPadding(new Insets(10, 20, 10, 20));
        inputBox.setSpacing(50);

        Scene scene = new Scene(inputBox, 300, 200);
        primaryStage.setTitle("Lesson2_2 By Jobove");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

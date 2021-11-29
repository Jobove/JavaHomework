package homework.Lesson9;

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
import javafx.stage.Stage;

public class Lesson9_2 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //喜欢的颜色
        Text favouriteColorText = new Text("Choose your favourite color: ");
        //添加按钮
        ToggleGroup favouriteColorChoiceGroup = new ToggleGroup();
        RadioButton[] colorButtons = new RadioButton[4];
        String[] colorArray = {"Red", "Orange", "Blue", "Green"};
        for (int i = 0; i < 4; ++i) {
            colorButtons[i] = new RadioButton(colorArray[i]);
            colorButtons[i].setToggleGroup(favouriteColorChoiceGroup);
        }
        colorButtons[1].setSelected(true);
        //将文字以及单选框添加到一个水平布局中
        HBox favouriteColor = new HBox();
        ObservableList<Node> favouriteColorChildren = favouriteColor.getChildren();
        favouriteColorChildren.addAll(favouriteColorText);
        for (RadioButton radioButton : colorButtons) {
            favouriteColorChildren.addAll(radioButton);
        }

        //年龄及对应的水平布局
        Text ageText = new Text("What's your age: ");
        Spinner<Integer> ageSpinner = new Spinner<>(10, 100, 18, 1);
        HBox age = new HBox();
        age.getChildren().addAll(ageText, ageSpinner);

        //喜欢的语言及对应水平布局
        Text favouriteLanguageText = new Text("What's you favourite language: ");
        ChoiceBox<String> favouriteLanguageChoiceBox = new ChoiceBox<>();
        favouriteLanguageChoiceBox.getItems().addAll("Java", "C++", "Python", "C#");
        HBox favouriteLanguage = new HBox();
        favouriteLanguage.getChildren().addAll(favouriteLanguageText, favouriteLanguageChoiceBox);

        //按钮
        Button pressButton = new Button("Press!");
        //处理按钮触发事件的匿名函数
        pressButton.setOnAction(e -> {
            //获取对应的值
            String favouriteColorValue = ((RadioButton) favouriteColorChoiceGroup.getSelectedToggle()).getText(),
                    favouriteLanguageValue = favouriteLanguageChoiceBox.getValue();
            Integer ageValue = ageSpinner.getValue();

            //用提示框弹出各项选择的总结
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Your choices");
            alert.setContentText("Your favourite color is: " + favouriteColorValue + ".\n" +
                    "Your age is: " + ageValue + ".\n" +
                    "Your favourite language is: " + favouriteLanguageValue + ".");
            alert.show();
        });

        //整体放入水平布局
        VBox root = new VBox();
        root.getChildren().addAll(favouriteColor, age, favouriteLanguage, pressButton);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10, 20, 10, 20));
        root.setSpacing(50);

        //显示
        Scene scene = new Scene(root, 450, 250);
        primaryStage.setTitle("Lesson9_2 By Jobove");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

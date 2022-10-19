package lab9.chapter20.javafx;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import java.util.*;

public class Lab9Chapter20JavaFX extends Application {

    protected TextField textField = new TextField();
    protected TextArea textArea = new TextArea();
    protected LinkedList<Integer> list = new LinkedList<>();

    @Override
    public void start(Stage primaryStage) {

        Button btSort = new Button("Sort");
        Button btShuffle = new Button("Shuffle");
        Button btReverse = new Button("Reverse");

        HBox paneForTextField = new HBox(10);
        paneForTextField.getChildren().addAll(
                new Label("Enter a number:"), textField);
        paneForTextField.setAlignment(Pos.CENTER);

        HBox paneForButtons = new HBox(5);
        paneForButtons.getChildren().addAll(
                btSort, btShuffle, btReverse);
        paneForButtons.setAlignment(Pos.CENTER);

        BorderPane pane = new BorderPane();
        pane.setTop(paneForTextField);
        pane.setCenter(textArea);
        pane.setBottom(paneForButtons);

        textArea.setEditable(false);
        textArea.setWrapText(true);

        textField.setOnAction(e -> add());

        btSort.setOnAction(e -> {
            Collections.sort(list);
            showText();
        });

        btShuffle.setOnAction(e -> {
            Collections.shuffle(list);
            showText();
        });

        btReverse.setOnAction(e -> {
            Collections.sort(list, Collections.reverseOrder());
            showText();
        });

        Scene scene = new Scene(pane, 400, 150);
        primaryStage.setTitle("Exercise20_02");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void add() {
        list.addLast(Integer.parseInt(textField.getText()));
        showText();
    }

    private void showText() {
        String output = "";
        for (Integer e : list) {
            output += e + " ";
        }

        textArea.setText(output);
        textField.setText("");
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author jacob
 */
public class Calculator extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        TextField tfNumber1 = new TextField();
        TextField tfNumber2 = new TextField();
        TextField tfResult = new TextField();

        FlowPane pane = new FlowPane();
        pane.setHgap(5);

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(0, 0, 0, 15));
        vBox.setSpacing(12);
        vBox.setAlignment(Pos.CENTER_LEFT);
        vBox.getChildren().addAll(new Label("Number1: "), new Label("Number2: "), new Label("Result: "));

        VBox vBox2 = new VBox();
        vBox2.setPadding(new Insets(0, 0, 0, 15));
        vBox2.setAlignment(Pos.CENTER_LEFT);
        vBox2.getChildren().addAll(tfNumber1, tfNumber2, tfResult);

        HBox hBox = new HBox();
        Button btnAdd = new Button("+");
        Button btnSubtract = new Button("-");
        Button btnDivide = new Button("÷");
        Button btnMultiply = new Button("×");
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(35);
        hBox.setPadding(new Insets(15, 0, 0, 15));
        hBox.getChildren().addAll(btnAdd, btnSubtract, btnMultiply, btnDivide);
        pane.getChildren().addAll(vBox, vBox2, hBox);

        Scene scene = new Scene(pane, 250, 125);
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();

        btnAdd.setOnAction(e -> {
            tfResult.setText(Double.parseDouble(tfNumber1.getText())
                    + Double.parseDouble(tfNumber2.getText()) + "");
        });

        btnMultiply.setOnAction(e -> {
            tfResult.setText(Double.parseDouble(tfNumber1.getText())
                    * Double.parseDouble(tfNumber2.getText()) + "");
        });

        btnSubtract.setOnAction(e -> {
            tfResult.setText(Double.parseDouble(tfNumber1.getText())
                    - Double.parseDouble(tfNumber2.getText()) + "");
        });

        btnDivide.setOnAction(e -> {
            tfResult.setText(Double.parseDouble(tfNumber1.getText())
                    / Double.parseDouble(tfNumber2.getText()) + "");
        });

    }

    public static void main(String[] args) {
        launch(args);
    }

}

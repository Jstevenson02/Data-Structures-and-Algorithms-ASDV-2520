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
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author jacob
 */
public class Investment extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        TextField investmentAmount = new TextField();
        TextField numberOfYears = new TextField();
        TextField annualInterestRate = new TextField();
        TextField futureValue = new TextField();

        FlowPane pane = new FlowPane();
        pane.setHgap(5);

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(0, 0, 0, 15));
        vBox.setSpacing(12);
        vBox.setAlignment(Pos.CENTER_LEFT);
        vBox.getChildren().addAll(new Label("Investment Amount: "), new Label("Number of Years: "), new Label("Annual Interest Rate: "), new Label("Future value: "));

        VBox vBox2 = new VBox();
        vBox2.setPadding(new Insets(0, 0, 0, 15));
        vBox2.setAlignment(Pos.CENTER_LEFT);
        vBox2.getChildren().addAll(investmentAmount, numberOfYears, annualInterestRate, futureValue);

        HBox hBox = new HBox();
        Button calculate = new Button("Calculate");
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(35);
        hBox.setPadding(new Insets(15, 0, 0, 15));
        hBox.getChildren().addAll(calculate);
        pane.getChildren().addAll(vBox, vBox2, hBox);

        Scene scene = new Scene(pane, 350, 175);
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();
        
        calculate.setOnAction(e -> {

            double years = Double.parseDouble(numberOfYears.getText());
            double investment = Double.parseDouble(investmentAmount.getText());
            double monthly = Double.parseDouble(annualInterestRate.getText()) / 12 / 100;
            double calculated = investment * Math.pow((1 + monthly), (years * 12));

            futureValue.setText("$" + calculated); 
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

}

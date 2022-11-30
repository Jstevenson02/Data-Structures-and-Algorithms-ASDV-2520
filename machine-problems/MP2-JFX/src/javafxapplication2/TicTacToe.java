/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package javafxapplication2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author jacob
 */
public class TicTacToe extends Application {

    @Override
    public void start(Stage primaryStage) {
        Image imageX = new Image("images/x.gif");
        Image imageO = new Image("images/o.gif");

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(5);
        pane.setVgap(5);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int status = (int) (Math.random() * 3);
                if (status == 0) {
                    pane.add(new ImageView(imageX), j, i);
                } else if (status == 1) {
                    pane.add(new ImageView(imageO), j, i);
                }
            }
        }
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        launch(args);
//    }

}

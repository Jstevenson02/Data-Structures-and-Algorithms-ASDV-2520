/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package javafxapplication2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author jacob
 */
public class ThreeRandomCards extends Application {

    public void start(Stage primaryStage) {

        
        GridPane cardPane = new GridPane();
        cardPane.setAlignment(Pos.CENTER);
        cardPane.setHgap(5);
        cardPane.setVgap(5);
        cardPane.setPadding(new Insets(10));

        Button buttonPickThreeCards = new Button("Pick!");
        buttonPickThreeCards.setOnAction(e -> {
            generateCards(cardPane);
        });

        // 
        HBox hBox = new HBox(1);
        hBox.setPadding(new Insets(10));
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().add(buttonPickThreeCards);

        // 
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(cardPane);
        borderPane.setBottom(hBox);
        borderPane.setAlignment(hBox, Pos.BOTTOM_CENTER);

        //
        Scene scene = new Scene(borderPane, 300, 180);
        primaryStage.setTitle("Three Random Cards");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void generateCards(GridPane pane) {
        int range = 52 - 1;

        String[] cards = {
            "image/1.png",
            "image/2.png",
            "image/3.png",
            "image/4.png",
            "image/5.png",
            "image/6.png",
            "image/7.png",
            "image/8.png",
            "image/9.png",
            "image/10.png",
            "image/11.png",
            "image/12.png",
            "image/13.png",
            "image/14.png",
            "image/15.png",
            "image/16.png",
            "image/17.png",
            "image/18.png",
            "image/19.png",
            "image/20.png",
            "image/21.png",
            "image/22.png",
            "image/23.png",
            "image/24.png",
            "image/25.png",
            "image/26.png",
            "image/27.png",
            "image/28.png",
            "image/29.png",
            "image/30.png",
            "image/31.png",
            "image/32.png",
            "image/33.png",
            "image/34.png",
            "image/35.png",
            "image/36.png",
            "image/37.png",
            "image/38.png",
            "image/39.png",
            "image/40.png",
            "image/41.png",
            "image/42.png",
            "image/43.png",
            "image/44.png", 
            "image/45.png",
            "image/46.png",
            "image/47.png",
            "image/48.png",
            "image/49.png",
            "image/50.png",
            "image/51.png",
            "image/52.png"};

        pane.getChildren().clear();

        for (int i = 0; i < 3; i++) {
            int index = (int) (Math.random() * range);
            Image image = new Image(cards[index]);
            ImageView view = new ImageView(image);

            pane.add(view, i, 0);
        }
    }
}

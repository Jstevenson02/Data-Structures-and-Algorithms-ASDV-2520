/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fx2;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import style.ButtonStyle;

/**
 *
 * @author jacob
 */
public class HandleClickEvent extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        Button buttonOk = new Button("OK");
        buttonOk.setStyle(ButtonStyle.getStyle());
        
        OkHandleClass eventHandler = new OkHandleClass();
        buttonOk.setOnAction(eventHandler);
        
        Pane pane = new Pane();
        pane.getChildren().add(buttonOk);
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
    class OkHandleClass implements EventHandler<ActionEvent>
    {

        @Override
        public void handle(ActionEvent event) {
            System.out.println("You clicked Ok.");
        }
    }
}

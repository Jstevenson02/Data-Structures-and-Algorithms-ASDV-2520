/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package events;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import style.ButtonStyle;

public class HandleClickEvent extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Button buttonOk = new Button("OK");
        buttonOk.setStyle(ButtonStyle.getStyle());
        
        OkHandler eventHandler = new OkHandler();
        buttonOk.setOnAction(eventHandler);
        
        Pane pane = new Pane();
        pane.getChildren().add(buttonOk);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
class OkHandler implements EventHandler<ActionEvent>
{
    @Override
    public void handle(ActionEvent event) {
        System.out.println("You clicked OK!");
    }
    
}


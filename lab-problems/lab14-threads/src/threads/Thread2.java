package threads;

import java.util.concurrent.Callable;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Thread2 extends Application {

    private String text = "";

    @Override // Override the start method in the Application class

    public void start(Stage primaryStage) {
        StackPane pane = new StackPane();
        Label lblText = new Label("Programming is fun");
        pane.getChildren().add(lblText);

 

        Thread t1 = new Thread(
                new Runnable() {
            public void run() {
                try {
                    while (true) {

                        text = " ";

                        Platform.runLater(
                                new Runnable() {
                            @Override
                            public void run() {
                                lblText.setText(text);
                            }
                        });

                        Thread.sleep(300);
                    }
                } catch (InterruptedException ex) {
                }
            }

            private void PrintChar() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        t1.start();

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 200, 50);
        primaryStage.setTitle("Concurrent Output"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    public static void main(String[] args) {
        launch(args);
    }
}

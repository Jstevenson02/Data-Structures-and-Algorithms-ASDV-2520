import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Checkerboard extends Application {

    public void drawPicture(GraphicsContext g, int width, int height) {

        int row;
        int col;
        int x,y;

        for ( row = 0;  row < 8;  row++ ) {

            for ( col = 0;  col < 8;  col++) {
                x = col * 80;
                y = row * 80;
                if ( (row % 2) == (col % 2) )
                    g.setFill(Color.BLUE);
                else
                    g.setFill(Color.YELLOW);
                g.fillRect(x, y, 80, 80);
            }

        }
    }
    
    public void start(Stage stage) {
        int width = 800;
        int height = 800;

        Canvas canvas = new Canvas(width,height);
        drawPicture(canvas.getGraphicsContext2D(), width, height);
        BorderPane root = new BorderPane(canvas);
        root.setStyle("-fx-border-width: 4px; -fx-border-color: #444");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Checkerboard");
        stage.show();
        stage.setResizable(true);
    }

    public static void main(String[] args) {
        launch();
    }

}

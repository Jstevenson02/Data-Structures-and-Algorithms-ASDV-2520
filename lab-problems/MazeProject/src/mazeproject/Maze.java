package mazeproject;

import java.util.Optional;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Maze extends Application {

    double paneWidth = 440;
    double paneHeight = 440;

    private Cell[][] board = new Cell[8][8];
    private Button btFindPath = new Button("RED Path");
    private Button btFindPath2 = new Button("GREEN Path");
    private Button btClearPath = new Button("Clear Path");
    private Label lblStatus = new Label();

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {

        GridPane gridPane = new GridPane();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                gridPane.add(board[i][j] = new Cell(), j, i);
            }
        }

        HBox hBox = new HBox(5);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(btFindPath, btFindPath2, btClearPath);

        BorderPane pane = new BorderPane();
        pane.setTop(lblStatus);
        BorderPane.setAlignment(lblStatus, Pos.CENTER);
        pane.setCenter(gridPane);
        pane.setBottom(hBox);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, paneWidth, paneHeight + 60);
        primaryStage.setTitle("Maze"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        btFindPath.setOnAction(e -> findPath());
        btFindPath2.setOnAction(e -> findPath2());
        btClearPath.setOnAction(e -> clearPath());
        showSampleMessage();

    }

    public void showSampleMessage() {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);

        a.setTitle("Maze Information");
        a.setHeaderText(" Put this message in its proper place. ");
        a.setContentText("This square cannot have an X");
        Optional<ButtonType> result = a.showAndWait();
        if (result.get() == ButtonType.OK) {
            System.out.println("OK ");
        } else if (result.get() == ButtonType.CANCEL) {
            System.out.println("CANCEL");
        }
    }

    public void findPath() {
        if (findPath(0, 0)) {
            lblStatus.setText("Path Found!");
        } else {
            lblStatus.setText("Entrance / Exit squares are blocked!");
        }
    }

    public void findPath2() {
        if (findPath2(0, 7)) {
            lblStatus.setText("Path Found!");
        } else {
            lblStatus.setText("Entrance / Exit squares are blocked!");
        }
    }

    public boolean findPath(int row, int col) {
        board[row][col].visit(false);

        if ((col == 7) && (row == 7)) {
            board[row][col].selectCell();
            return true;
        }

        if ((row > 0) && !board[row - 1][col].marked()
                && !board[row - 1][col].blocked(false) && !board[row - 1][col].visited(false)) {
            block(row, col, false);

            if (findPath(row - 1, col)) {
                board[row][col].selectCell();
                return true;
            }

            unblock(row, col, false);
        }

        if ((row < 7) && !board[row + 1][col].marked()
                && !board[row + 1][col].blocked(false) && !board[row + 1][col].visited(false)) {
            block(row, col, false);

            if (findPath(row + 1, col)) {
                board[row][col].selectCell();
                return true;
            }
            unblock(row, col, false);
        }

        if ((col > 0) && !board[row][col - 1].marked()
                && !board[row][col - 1].blocked(false) && !board[row][col - 1].visited(false)) {
            block(row, col, false);
            if (findPath(row, col - 1)) {
                board[row][col].selectCell();
                return true;
            }

            unblock(row, col, false);
        }

        if ((col < 7) && !board[row][col + 1].marked()
                && !board[row][col + 1].blocked(false) && !board[row][col + 1].visited(false)) {
            block(row, col, false);
            if (findPath(row, col + 1)) {
                board[row][col].selectCell();
                return true;
            }
            unblock(row, col, false);
        }
        return false;
    }

    public boolean findPath2(int row, int col) {

        board[row][col].visit(true);

        if ((col == 0) && (row == 7)) {
            board[row][col].selectCell(true);
            return true;
        }

        if ((row > 0) && !board[row - 1][col].marked()
                && !board[row - 1][col].blocked(true) && !board[row - 1][col].visited(true)) {
            block(row, col, true);

            if (findPath2(row - 1, col)) {
                board[row][col].selectCell(true);
                return true;
            }

            unblock(row, col, true);
        }

        if ((row < 7) && !board[row + 1][col].marked()
                && !board[row + 1][col].blocked(true) && !board[row + 1][col].visited(true)) {
            block(row, col, true);

            if (findPath2(row + 1, col)) {
                board[row][col].selectCell(true);
                return true;
            }
            unblock(row, col, true);
        }

        if ((col > 0) && !board[row][col - 1].marked()
                && !board[row][col - 1].blocked(true) && !board[row][col - 1].visited(true)) {
            block(row, col, true);
            if (findPath2(row, col - 1)) {
                board[row][col].selectCell(true);
                return true;
            }

            unblock(row, col, true);
        }

        if ((col < 7) && !board[row][col + 1].marked()
                && !board[row][col + 1].blocked(true) && !board[row][col + 1].visited(true)) {
            block(row, col, true);
            if (findPath2(row, col + 1)) {
                board[row][col].selectCell(true);
                return true;
            }
            unblock(row, col, true);
        }
        return false;
    }

    // Temporary block the neighbor to prevent neighboring path
    public void block(int row, int col, boolean colorGreen) {
        if (row > 0) {
            board[row - 1][col].block(colorGreen);
        }
        if (row < 7) {
            board[row + 1][col].block(colorGreen);
        }
        if (col > 0) {
            board[row][col - 1].block(colorGreen);
        }
        if (col < 7) {
            board[row][col + 1].block(colorGreen);
        }
    }

    // Remove the temporary block
    public void unblock(int row, int col, boolean colorGreen) {
        if (row > 0) {
            board[row - 1][col].unblock(colorGreen);
        }
        if (row < 7) {
            board[row + 1][col].unblock(colorGreen);
        }
        if (col > 0) {
            board[row][col - 1].unblock(colorGreen);
        }
        if (col < 7) {
            board[row][col + 1].unblock(colorGreen);
        }
    }

    public void clearPath() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col].deselectCell();
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    // Inner class
    class Cell extends StackPane {

        private boolean marked = false;
        private boolean visited = false;
        private boolean blocked = false;

        private boolean visited2 = false;
        private boolean blocked2 = false;

        private boolean filledRed = false;
        private boolean filledGreen = false;

        double width = paneWidth / 8;
        double height = paneHeight / 8;
        private Rectangle rectangle = new Rectangle(0, 0, width, height);

        Line line1 = new Line(0, 0, width, height);
        Line line2 = new Line(width, 0, 0, height);

        public Cell() {
            this.getChildren().add(rectangle);
            rectangle.setFill(Color.WHITE);
            rectangle.setStroke(Color.BLACK);

            this.setOnMousePressed(e
                    -> {
                marked = !marked;
                if (marked) {
                    mark();
                } else {
                    unmark();
                }
            });
        }

        public void mark() {
            this.getChildren().addAll(line1, line2);
        }

        public void unmark() {
            this.getChildren().remove(line1);
            this.getChildren().remove(line2);
        }

        public boolean marked() {
            return marked;
        }

        public void visit(boolean colorGreen) {
            if (colorGreen) {
                visited2 = true;
            } else {
                visited = true;
            }
        }

        public boolean visited(boolean colorGreen) {
            if (colorGreen) {
                return visited2;
            } else {
                return visited;
            }
        }

        public boolean blocked(boolean colorGreen) {
            if (colorGreen) {
                return blocked2;
            } else {
                return blocked;
            }
        }

        public void block(boolean colorGreen) {
            if (colorGreen) {
                blocked2 = true;
            } else {
                blocked = true;
            }
        }

        public void unblock(boolean colorGreen) {
            if (colorGreen) {
                blocked2 = false;
            } else {
                blocked = false;
            }
        }

        public void selectCell(boolean colorGreen) {
            if (colorGreen) {
                rectangle.setFill(Color.GREEN);
                filledGreen = true;
            } else {
                rectangle.setFill(Color.RED);
                filledRed = true;
            }

            if (filledRed && filledGreen) {
                rectangle.setFill(Color.YELLOW);
            }
        }

        public void selectCell() {
            selectCell(false);
        }

        public void deselectCell() {
            rectangle.setFill(Color.WHITE);
            blocked = false;
            visited = false;
            blocked2 = false;
            visited2 = false;
            filledRed = false;
            filledGreen = false;
        }
    }
}

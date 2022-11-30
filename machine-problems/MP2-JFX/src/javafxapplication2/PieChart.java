/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication2;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

/**
 *
 * @author jacob
 */
public class PieChart extends Application {

    double diameter = 400.0;
    double radius = diameter / 2.0;
    double project = .20;
    double quiz = .10;
    double midterm = .30;
    double finals = .40;

    @Override
    public void start(Stage stage) throws Exception {

        /// Create the pie slices
        double startAngle = 0;
        double endAngle = 360 * project;

        Arc projectArc = new Arc(radius, radius, radius, radius, startAngle, endAngle);
        projectArc.setFill(Color.RED);
        projectArc.setType(ArcType.ROUND);
        startAngle += endAngle;

        Text tProject = new Text("Project -- " + project + "%");
        tProject.setX(radius + radius / 8);
        tProject.setY(radius - radius / 4);

        endAngle = 360 * quiz;
        Arc quizArc = new Arc(radius, radius, radius, radius, startAngle, endAngle);
        quizArc.setFill(Color.BLUE);
        quizArc.setType(ArcType.ROUND);
        startAngle += endAngle;

        Text tJava = new Text("Quiz -- " + quiz * 100 + "%");
        tJava.setX(radius);

        endAngle = 360 * midterm;
        Arc midtermArc = new Arc(radius, radius, radius, radius, startAngle, endAngle);
        midtermArc.setFill(Color.GREEN);
        midtermArc.setType(ArcType.ROUND);
        startAngle += endAngle;

        Text tMidterm = new Text("Midterm -- " + midterm * 100 + "%");
        tMidterm.setY(radius);

        endAngle = 360 * finals;
        Arc finalsArc = new Arc(radius, radius, radius, radius, startAngle, endAngle);
        finalsArc.setFill(Color.ORANGE);
        finalsArc.setType(ArcType.ROUND);

        Text tFinals = new Text("Finals -- " + finals * 100 + "%");
        tFinals.setX(radius);
        tFinals.setY(radius + radius);

        Pane pie = new Pane();
        pie.getChildren().addAll(projectArc, quizArc, midtermArc, finalsArc, tProject, tJava, tMidterm, tFinals);

        StackPane pane = new StackPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(20));
        pane.getChildren().add(pie);

        Scene scene = new Scene(pane);
        stage.setTitle("Pie Chart");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

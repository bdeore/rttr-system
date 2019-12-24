/*
 * Copyright (c)  @Author :Suyog Deore
 * Reproduction or redistribution of Following Codes -or-
 * Libraries without proper permissions is liable to Prosecution.
 */

package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.SQLException;

public class Main extends Application {

    private double xOffset = 0;
    private double yOffset = 0;


    public static void main(String[] args) throws SQLException {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception  {
       Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));


        primaryStage.initStyle(StageStyle.TRANSPARENT);

        Scene scene = new Scene(root);
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            }
        });

        scene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("  Welcome ");
        Image icon = new Image(getClass().getResourceAsStream("/Images/maps.png"));
        primaryStage.getIcons().add(icon);
        primaryStage.show();

    }
}

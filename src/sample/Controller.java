package sample;

import com.jfoenix.controls.*;
import com.mysql.jdbc.PreparedStatement;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private double xOffset = 0;
    private double yOffset = 0;
    private Connection connection;
    private PreparedStatement preparedStatement;

    @FXML
    private Label labelb;

    @FXML
    private Label labelp;

    @FXML
    private JFXProgressBar pBar;

    @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXPasswordField password1;

    @FXML
    private AnchorPane dashboard;

    @FXML
    private AnchorPane signup;

    @FXML
    private JFXButton btnSignup;

    @FXML
    private JFXTextField suuname;

    @FXML
    private JFXPasswordField supassword;

    @FXML
    private JFXPasswordField csupassword;

    @FXML
    private JFXTextField sueid;

    @FXML
    public Label labela;

    @FXML
    private Label labelInvalid;

    @FXML
    private JFXSpinner spinner;

    @FXML
    private JFXButton trackbutton;

    @FXML
    private JFXSpinner loSpinner;

    @FXML
    private JFXButton btnLogin;

    @FXML
    private JFXProgressBar pBar1;

    @FXML
    private JFXButton btnupdates;


    @FXML
    void loadMaps(ActionEvent event) throws Exception {
        Stage stage1 = new Stage();
        trackingController tc = new trackingController();
        tc.start(stage1);
    }

    @FXML
    void loadtracking(ActionEvent event) throws Exception{

        AnchorPane pane2 = new AnchorPane();
        pane2 = FXMLLoader.load(getClass().getResource("tracking.fxml"));

        dashboard.getChildren().setAll(pane2);


    }




    @FXML
    void openLoginscreen(ActionEvent event) throws Exception {

        AnchorPane pane2 = new AnchorPane();
        pane2 = FXMLLoader.load(getClass().getResource("loginAP.fxml"));
        signup.getChildren().setAll(pane2);

    }

    @FXML
    void loadSignupData(ActionEvent event) throws Exception {

       if (supassword.getText().equals(csupassword.getText()) ) {
            connection = DBConnection.getConnection();
            int udata = connection.createStatement().executeUpdate("INSERT INTO primary.verify VALUES ('" + suuname.getText() + "','" + supassword.getText() + "'," + sueid.getText() + ")");
            System.out.println("Query Successfully Executed!");
            labelp.setVisible(false);
            labela.setVisible(true);
            pBar.setOpacity(0.00);

        }
            else{System.out.println("Passwords do not Match.");
            labela.setVisible(false);
            labelp.setVisible(true);
       }

    }

    @FXML
    void loadSignup(ActionEvent event) throws IOException {

            AnchorPane pane1 = new AnchorPane();

            pane1 = FXMLLoader.load(getClass().getResource("/sample/signup.fxml"));
            signup.getChildren().setAll(pane1);

    }

    @FXML
    private void loadDashboard(ActionEvent event) throws IOException {
        AnchorPane pane = new AnchorPane();

        pane = FXMLLoader.load(getClass().getResource("/sample/dashboard.fxml"));
        dashboard.getChildren().setAll(pane);

    }

    @FXML
    private void loadAnalysis(ActionEvent event) throws IOException {
        AnchorPane pane = new AnchorPane();

        pane = FXMLLoader.load(getClass().getResource("/sample/analysis.fxml"));
        dashboard.getChildren().setAll(pane);

    }

    @FXML
    void loadupdates(ActionEvent event) throws IOException {
        AnchorPane pane = new AnchorPane();

        pane = FXMLLoader.load(getClass().getResource("/sample/beupdates.fxml"));
        dashboard.getChildren().setAll(pane);
    }

    @FXML
    void loadbeupdatesgrid(ActionEvent event) throws IOException {
        AnchorPane pane = new AnchorPane();
        pane = FXMLLoader.load(getClass().getResource("beupdatesgrid.fxml"));

        dashboard.getChildren().setAll(pane);


    }

    @FXML
    void loadbeeupdatesgrid(ActionEvent event) throws IOException{
        AnchorPane pane = new AnchorPane();

        pane = FXMLLoader.load(getClass().getResource("/sample/beupdatesgrid.fxml"));
        dashboard.getChildren().setAll(pane);
    }

    @FXML
    void exit(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void minimize(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        // is stage minimizable into task bar. (true | false)
        stage.setIconified(true);
    }


    Stage stage;
    Parent root;
    Scene scene;

    @FXML
    void logicAction(ActionEvent event) throws Exception {


        connection = DBConnection.getConnection();

        //String sql_query = "SELECT * FROM verify WHERE USERNAME = '" + username.getText() + "' AND PASSWORD= '" + password.getText() + "' AND employeeID = '" + password1.getText()+ "'";
        //ResultSet resultSet = connection.prepareStatement(sql_query).executeQuery();
        ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM primary.verify WHERE USERNAME = '" + username.getText() + "' AND PASSWORD= '" + password.getText() + "' AND employeeID = '" + password1.getText()+ "'");

        if (resultSet.next()) {


            stage = (Stage) password.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("home.fxml"));
            stage.setTitle("  Get Started!");
            scene = new Scene(root);

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
                    stage.setX(event.getScreenX() - xOffset);
                    stage.setY(event.getScreenY() - yOffset);
                }
            });

            scene.setFill(Color.TRANSPARENT);
            stage.setScene(scene);
            stage.show();
            stage.centerOnScreen();
            System.out.println("Login Successful!");

        } else {
            labelInvalid.setVisible(true);
            System.out.println("Login Unsuccessful!");
        }
}



    public Controller() {
    }


    @Override
    public void initialize(URL url, ResourceBundle rb)  {


    }


}
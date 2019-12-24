/*
 * Copyright (c)  @Author :Suyog Deore
 * Reproduction or redistribution of Following Codes -or-
 * Libraries without proper permissions is liable to Prosecution.
 */

package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class trackingController  extends Application implements MapComponentInitializedListener,Initializable {

    private String m;
    private Connection connection;
    GoogleMapView mapView;
    GoogleMap map;
    int i;
    public static ArrayList lat = new ArrayList();
    public static ArrayList lon = new ArrayList();
    public static ArrayList bid = new ArrayList();


    @FXML
    private JFXDatePicker datePicker;

    @FXML
    private JFXTimePicker timePicker;

    @FXML
    private JFXButton trackbutton;

  //  @FXML
//    private ComboBox<String> busid;

    @FXML
    private JFXComboBox<String> busid;

    ObservableList<String> busidlist= FXCollections.observableArrayList(
            "BID1","BID2","BID3","BID4","BID5","BID6","BID7","BID8");

    @FXML
    void loadMaps(ActionEvent event) throws Exception {
        Stage stage1 = new Stage();
        trackingController tc = new trackingController();
        tc.start(stage1);
    }



    public void start(Stage stage) throws Exception, SQLException {

        connection = DBConnection.getConnection();
        ResultSet rs = connection.createStatement().executeQuery("SELECT bid, latitude, longitude FROM primary.bid1");

        while (rs.next()) {
            bid.add((rs.getString(1)));
            lat.add((rs.getString(2)));
            lon.add((rs.getString(3)));

        }

        mapView = new GoogleMapView();
        mapView.addMapInitializedListener(this);

        Scene scene = new Scene(mapView);

        scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent t) {
                if(t.getCode()==KeyCode.ESCAPE)
                {
                    System.out.println("click on escape");
                    Stage sb = (Stage)mapView.getScene().getWindow();//use any one object
                    sb.close();
                }
            }
        });
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setWidth(990);
        stage.setHeight(631);
        stage.setX(326);
        stage.setY(94);
        stage.setTitle("Tracking: Google Maps");
        Image mps = new Image(getClass().getResourceAsStream("/Images/maps1.png"));
        stage.getIcons().add(mps);
        stage.setScene(scene);
        stage.show();
    }


  @Override
    public void mapInitialized() {
      MapOptions mapOptions = new MapOptions();

      mapOptions.center(new LatLong(lat.get(3), lon.get(3)))
              //   .mapType(MapType.ROADMAP)
              .overviewMapControl(false)
              .panControl(false)
              .rotateControl(true)
              .scaleControl(false)
              .streetViewControl(false)
              .zoomControl(true)
              .zoom(15);


          map = mapView.createMap(mapOptions);

          for (i = 0; i < 4; i++) {
          //Add a marker to the map
           MarkerOptions markerOptions = new MarkerOptions();
           markerOptions.position(new LatLong(lat.get(i), lon.get(i)))
                  .visible(Boolean.TRUE)
                  .title(" Bus ID: " +bid.get(i));

          Marker marker = new Marker(markerOptions);
          map.addMarker(marker);

      }

  }

    public static void main(String[] args) {
        launch(args);

    }
    @Override
    public void initialize(URL url, ResourceBundle rb)  {
        busid.setItems(busidlist);

    }

}

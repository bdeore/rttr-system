/*
 * Copyright (c)  @Author :Suyog Deore
 * Reproduction or redistribution of Following Codes or Libraries without proper permissions is liable to Prosecution.
 */
/*
package com.lynden.gmapsfx;




import com.lynden.gmapsfx.javascript.object.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class testMap extends Application implements MapComponentInitializedListener {


    GoogleMapView mapView;
    GoogleMap map;


    public void start(Stage stage) throws Exception {

        //Create the JavaFX component and set this as a listener so we know when
        //the map has been initialized, at which point we can then begin manipulating it.
        mapView = new GoogleMapView();
        mapView.addMapInitializedListener(this);

        Scene scene = new Scene(mapView);
        stage.setWidth(1100);
        stage.setHeight(600);
        stage.setTitle("JavaFX and Google Maps");
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void mapInitialized() {
        //Set the initial properties of the map.
        MapOptions mapOptions = new MapOptions();

        mapOptions.center(new LatLong(18.4448418, 73.89335499999993))
                //   .mapType(MapType.ROADMAP)
                .overviewMapControl(false)
                .panControl(false)
                .rotateControl(true)
                .scaleControl(false)
                .streetViewControl(false)
                .zoomControl(true)
                .zoom(18);

        map = mapView.createMap(mapOptions);

        //Add a marker to the map
        MarkerOptions markerOptions = new MarkerOptions();

        markerOptions.position(new LatLong(18.4448418, 73.89335499999993))
                .visible(Boolean.TRUE)
                .title("Bus Number 3 (KHSN)");

        Marker marker = new Marker(markerOptions);

        map.addMarker(marker);
    }
    public static void main(String[] args) {
        launch(args);

    }

}
*/
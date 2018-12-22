/*
 * Copyright (c)  @Author :Suyog Deore
 * Reproduction or redistribution of Following Codes -or-
 * Libraries without proper permissions is liable to Prosecution.
 */

package sample;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class trackingLatLong extends RecursiveTreeObject<Primary> {

    private final StringProperty sessionTime;
    private final StringProperty latitude;
    private final StringProperty longitude;


    public trackingLatLong(String sessionTime, String latitude, String longitude){
        this.sessionTime = new SimpleStringProperty(sessionTime);
        this.latitude = new SimpleStringProperty(latitude);
        this.longitude = new SimpleStringProperty(longitude);
    }

    public String getLatitude() {
        return latitude.get();
    }

    public String getLongitude() {
        return longitude.get();
    }

    public String getSessionTime() {
        return sessionTime.get();
    }



    public void setLatitude(String value){
        latitude.setValue(value);
    }

    public void setLongitude(String value){
        longitude.setValue(value);
    }

    public void setSessionTime(String value){
        sessionTime.setValue(value);
    }


    public StringProperty latitudeProperty() {
        return latitude;
    }

    public StringProperty longitudeProperty() {
        return longitude;
    }

    public StringProperty sessionTimeProperty() {
        return sessionTime;
    }



}

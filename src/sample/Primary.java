package sample;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Primary extends RecursiveTreeObject<Primary> {

    private final StringProperty sessionTime;
    private final StringProperty origin;
    private final StringProperty destination;
    private final StringProperty passengers;
    private final StringProperty priorityLevel;
    private final StringProperty hpriorityLevel;
    private final StringProperty rid;

    //private Button button;

    public Primary( String sessionTime, String rid, String origin, String destination, String passengers, String priorityLevel, String hpriorityLevel){

        this.sessionTime = new SimpleStringProperty(sessionTime);
        this.rid = new SimpleStringProperty(rid);
        this.origin = new SimpleStringProperty(origin);
        this.destination = new SimpleStringProperty(destination);
        this.passengers = new SimpleStringProperty(passengers);
        this.priorityLevel = new SimpleStringProperty(priorityLevel);
        this.hpriorityLevel = new SimpleStringProperty(hpriorityLevel);
        //this.button = new Button("Analysis");
    }



    public String getOrigin() {
        return origin.get();
    }

    public String getRid() {
        return rid.get();
    }

    public String getDestination() {
        return destination.get();
    }

    public String getSessionTime() {
        return sessionTime.get();
    }

    public String getPassengers() {
        return passengers.get();
    }

    public String getPriorityLevel() {
        return priorityLevel.get();
    }

    public String gethPriorityLevel() {
        return hpriorityLevel.get();
    }

    //  public Button getButton(){ return button; }


    public void setOrigin(String value){
        origin.setValue(value);
    }

    public void setRid(String value){
        rid.setValue(value);
    }

    public void setDestination(String value){
        destination.setValue(value);
    }

    public void setSessionTime(String value){
        sessionTime.setValue(value);
    }

    public void setPassengers(String value){
        passengers.setValue(value);
    }

    public void setPriorityLevel(String value){ priorityLevel.setValue(value); }

    public void sethPriorityLevel(String value){ hpriorityLevel.setValue(value); }

    //public void setButton(Button button){ this.button = button;}


    public StringProperty originProperty() {
        return origin;
    }

    public StringProperty ridProperty() {
        return rid;
    }

    public StringProperty destinationProperty() {
        return destination;
    }

    public StringProperty sessionTimeProperty() {
        return sessionTime;
    }

    public StringProperty passengersProperty() {
        return passengers;
    }

    public StringProperty priorityLevelProperty() { return priorityLevel; }

    public StringProperty hpriorityLevelProperty() { return hpriorityLevel; }

}


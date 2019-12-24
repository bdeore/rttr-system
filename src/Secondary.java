package sample;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Secondary extends RecursiveTreeObject<Primary> {

    private final StringProperty sessionTime;
    private final StringProperty totalnop;
    private final StringProperty bs1;
    private final StringProperty bs2;
    private final StringProperty bs3;
    private final StringProperty bs4;
    private final StringProperty bs5;
    private final StringProperty bs6;
    private final StringProperty bs7;
    private final StringProperty bs8;
    private final StringProperty bs9;
    private final StringProperty bs10;
    private final StringProperty bs11;
    private final StringProperty bs12;


    //private Button button;

    public Secondary ( String sessionTime, String totalnop, String bs1, String bs2, String bs3, String bs4, String bs5, String bs6, String bs7, String bs8,String bs9, String bs10, String bs11, String bs12 ){

        this.sessionTime = new SimpleStringProperty(sessionTime);
        this.totalnop = new SimpleStringProperty(totalnop);
        this.bs1 = new SimpleStringProperty(bs1);
        this.bs2 = new SimpleStringProperty(bs2);
        this.bs3 = new SimpleStringProperty(bs3);
        this.bs4 = new SimpleStringProperty(bs4);
        this.bs5 = new SimpleStringProperty(bs5);
        this.bs6 = new SimpleStringProperty(bs6);
        this.bs7 = new SimpleStringProperty(bs7);
        this.bs8 = new SimpleStringProperty(bs8);
        this.bs9 = new SimpleStringProperty(bs9);
        this.bs10 = new SimpleStringProperty(bs10);
        this.bs11 = new SimpleStringProperty(bs11);
        this.bs12 = new SimpleStringProperty(bs12);

    }



    public String getSessionTime() {
        return sessionTime.get();
    }

    public String getTotalnop() {
        return totalnop.get();
    }

    public String getbs1() {
        return bs1.get();
    }

    public String getbs2() {
        return bs2.get();
    }

    public String getbs3() {
        return bs3.get();
    }

    public String getbs4() {
        return bs4.get();
    }

    public String getbs5() {
        return bs5.get();
    }

    public String getbs6() {
        return bs6.get();
    }

    public String getbs7() {
        return bs7.get();
    }

    public String getbs8() {
        return bs8.get();
    }

    public String getbs9() {
        return bs9.get();
    }

    public String getbs10() {
        return bs10.get();
    }

    public String getbs11() {
        return bs11.get();
    }

    public String getbs12() {
        return bs12.get();
    }



    public void setSessionTime(String value){
        sessionTime.setValue(value);
    }

    public void setTotalnop(String value){
        totalnop.setValue(value);
    }

    public void setBs1(String value){ bs1.setValue(value); }
    public void setBs2(String value){ bs2.setValue(value); }
    public void setBs3(String value){ bs3.setValue(value); }
    public void setBs4(String value){ bs4.setValue(value); }
    public void setBs5(String value){ bs5.setValue(value); }
    public void setBs6(String value){ bs6.setValue(value); }
    public void setBs7(String value){ bs7.setValue(value); }
    public void setBs8(String value){ bs8.setValue(value); }
    public void setBs9(String value){ bs9.setValue(value); }
    public void setBs10(String value){ bs10.setValue(value); }
    public void setBs11(String value){ bs11.setValue(value); }
    public void setBs12(String value){ bs12.setValue(value); }




    public StringProperty sessionTimeProperty() {
        return sessionTime;
    }

    public StringProperty totalnopProperty() {
        return totalnop;
    }

    public StringProperty bs1Property() { return bs1; }
    public StringProperty bs2Property() { return bs2; }
    public StringProperty bs3Property() { return bs3; }
    public StringProperty bs4Property() { return bs4; }
    public StringProperty bs5Property() { return bs5; }
    public StringProperty bs6Property() { return bs6; }
    public StringProperty bs7Property() { return bs7; }
    public StringProperty bs8Property() { return bs8; }
    public StringProperty bs9Property() { return bs9; }
    public StringProperty bs10Property() { return bs10; }
    public StringProperty bs11Property() { return bs11; }
    public StringProperty bs12Property() { return bs12; }





}


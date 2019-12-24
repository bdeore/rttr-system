/*
 * Copyright (c)  @Author :Suyog Deore
 * Reproduction or redistribution of Following Codes -or-
 * Libraries without proper permissions is liable to Prosecution.
 */

package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class analysisController implements Initializable {
    @FXML
    private TableView<Secondary> tableView;

    @FXML
    private TableColumn<Secondary, String> columnT;

    @FXML
    private TableColumn<Secondary, String> columnTNOP;

    @FXML
    private TableColumn<Secondary, String> column1;

    @FXML
    private TableColumn<Secondary, String> column2;

    @FXML
    private TableColumn<Secondary, String> column3;

    @FXML
    private TableColumn<Secondary, String> column4;

    @FXML
    private TableColumn<Secondary, String> column5;

    @FXML
    private TableColumn<Secondary, String> column6;

    @FXML
    private TableColumn<Secondary, String> column7;

    @FXML
    private TableColumn<Secondary, String> column8;

    @FXML
    private TableColumn<Secondary, String> column9;


    @FXML
    private TableColumn<Secondary, String> column10;

    @FXML
    private TableColumn<Secondary, String> column11;

    @FXML
    private TableColumn<Secondary, String> column12;

    @FXML
    private JFXTextField filterInput1;

    @FXML
    private JFXButton startButton1;


    @FXML
    private AnchorPane parent;
    private ObservableList<Secondary> data1;
    private DBConnection conn;

    public void initialize(URL url, ResourceBundle rb) {

        filterInput1.textProperty().addListener(new ChangeListener() {
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                filterList((String) oldValue, (String) newValue);
            }
        });
    }

    @FXML
    void loadDataFromDatabase1(ActionEvent event) throws SQLException {
        Connection conn = DBConnection.getConnection();
        data1 = FXCollections.observableArrayList();

        ResultSet rs = conn.createStatement().executeQuery("SELECT session_time, totalnop, bs1,bs2,bs3, bs4, bs5, bs6, bs7, bs8, bs9, bs10, bs11, bs12 FROM primary.rid2 ORDER BY session_time DESC ");
        while (rs.next()) {
            data1.add(new Secondary(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13), rs.getString(14)));

        }

        columnT.setCellValueFactory(new PropertyValueFactory<>("sessionTime"));
        columnTNOP.setCellValueFactory(new PropertyValueFactory<>("totalnop"));
        column1.setCellValueFactory(new PropertyValueFactory<>("bs1"));
        column2.setCellValueFactory(new PropertyValueFactory<>("bs2"));
        column3.setCellValueFactory(new PropertyValueFactory<>("bs3"));
        column4.setCellValueFactory(new PropertyValueFactory<>("bs4"));
        column5.setCellValueFactory(new PropertyValueFactory<>("bs5"));
        column6.setCellValueFactory(new PropertyValueFactory<>("bs6"));
        column7.setCellValueFactory(new PropertyValueFactory<>("bs7"));
        column8.setCellValueFactory(new PropertyValueFactory<>("bs8"));
        column9.setCellValueFactory(new PropertyValueFactory<>("bs9"));
        column10.setCellValueFactory(new PropertyValueFactory<>("bs10"));
        column11.setCellValueFactory(new PropertyValueFactory<>("bs11"));
        column12.setCellValueFactory(new PropertyValueFactory<>("bs12"));



        // tableView.setItems(null);
        tableView.setItems(data1);
    }



    @FXML

    public void filterList (String oldValue, String newValue){
        ObservableList<Secondary> filteredList = FXCollections.observableArrayList();
        if (filterInput1 == null || newValue.length() < oldValue.length() || newValue == null) {
            tableView.setItems(data1);
        } else {
            newValue = newValue.toUpperCase();
            for (Secondary vrfy : tableView.getItems()) {
                String filterVO = vrfy.getTotalnop();
                String filterVD = vrfy.getbs1();
                String filterVA = vrfy.getbs2();
                String filterVB = vrfy.getbs3();


                if (filterVO.toUpperCase().contains(newValue) || filterVA.toUpperCase().contains(newValue) || filterVB.toUpperCase().contains(newValue)|| filterVD.toUpperCase().contains(newValue)) {
                    filteredList.add(vrfy);
                }
            }
            tableView.setItems(filteredList);
        }

    }



}

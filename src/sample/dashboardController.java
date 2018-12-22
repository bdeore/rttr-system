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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class dashboardController implements Initializable {

    @FXML
    private JFXButton startButton;

    @FXML
    private TableView<Primary> tableView;

    @FXML
    private TableColumn<Primary, String> columnTime;

    @FXML
    private TableColumn<Primary, String> columnOrigin;

    @FXML
    private TableColumn<Primary, String> columnDestination;

    @FXML
    private TableColumn<Primary, String> columnPassengers;

    @FXML
    private TableColumn<Primary, String> columnPriority;

    @FXML
    private TableColumn<Primary, String> columnRID;

    @FXML
    private TableColumn<Primary, String> columnHP;

    @FXML
    private JFXTextField filterInput;

    @FXML
    private JFXButton refresh;

    private Connection connection;
    List<Integer> passengers = new ArrayList<Integer>();

    int i, priority;

    @FXML
    void calculatePriority(ActionEvent event) throws SQLException {
        connection = DBConnection.getConnection();
        ResultSet rs = connection.createStatement().executeQuery("SELECT passengers FROM primary.dashboard_main ");

        while (rs.next()) {
            passengers.add(rs.getInt(1));
        }



        for (i=0; i<40; i++){

            int a = 70 - passengers.get(i);

            if(a <= 10){
                priority = 5;

                }else if (a <=30){
                priority = 4;

            }else if(a <= 40){
                priority = 3;

            }else if(a<= 25){
                priority = 2;

            }else
                priority = 1;

            connection = DBConnection.getConnection();
            connection.createStatement().executeUpdate("UPDATE primary.dashboard_main SET priority_level="+priority+" WHERE passengers = "+passengers.get(i));

        }

    }

    @FXML
    private AnchorPane parent;
    private ObservableList<Primary> data;
    private DBConnection conn;


    public void initialize(URL url, ResourceBundle rb) {

        filterInput.textProperty().addListener(new ChangeListener() {
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                filterList((String) oldValue, (String) newValue);
            }
        });
    }

    @FXML
    void loadDataFromDatabase(ActionEvent event) throws SQLException {
        Connection conn = DBConnection.getConnection();
        data = FXCollections.observableArrayList();

        ResultSet rs = conn.createStatement().executeQuery("SELECT session_time, origin, destination, passengers, priority_level, hour_prediction, rid  FROM primary.dashboard_main ORDER BY session_time ASC");
        while (rs.next()) {
            data.add(new Primary(rs.getString(1), rs.getString(7), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));

        }

        columnTime.setCellValueFactory(new PropertyValueFactory<>("sessionTime"));
        columnOrigin.setCellValueFactory(new PropertyValueFactory<>("origin"));
        columnDestination.setCellValueFactory(new PropertyValueFactory<>("destination"));
        columnPassengers.setCellValueFactory(new PropertyValueFactory<>("passengers"));
        columnPriority.setCellValueFactory(new PropertyValueFactory<>("priorityLevel"));
        columnHP.setCellValueFactory(new PropertyValueFactory<>("hpriorityLevel"));
        columnRID.setCellValueFactory(new PropertyValueFactory<>("rid"));

       // tableView.setItems(null);
        tableView.setItems(data);
    }



        @FXML

        public void filterList (String oldValue, String newValue){
            ObservableList<Primary> filteredList = FXCollections.observableArrayList();
            if (filterInput == null || newValue.length() < oldValue.length() || newValue == null) {
                tableView.setItems(data);
            } else {
                newValue = newValue.toUpperCase();
                for (Primary vrfy : tableView.getItems()) {
                    String filterVO = vrfy.getOrigin();
                    String filterVD = vrfy.getDestination();

                    if (filterVO.toUpperCase().contains(newValue) || filterVD.toUpperCase().contains(newValue)) {
                        filteredList.add(vrfy);
                    }
                }
                tableView.setItems(filteredList);
            }

        }


}







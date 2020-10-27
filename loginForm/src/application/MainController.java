package application;

import java.net.URL;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Node;
public class MainController implements Initializable{
	@FXML
	public AnchorPane rootPane;
	@FXML
	public Label testLabel1,testLabel2,testLabel3;
	@FXML
	public ComboBox<String> fromLocation;
	ObservableList<String> fromList = FXCollections.observableArrayList("Mohali","Delhi","Mumbai");
	
	@FXML
	public ComboBox<String> toLocation;
	ObservableList<String> toList = FXCollections.observableArrayList("Banaglore","Pune","Kolkata");
	@FXML
	private DatePicker dp;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		fromLocation.setItems(fromList);
		toLocation.setItems(toList);
	}
	public void fromLocationChanged(ActionEvent event)
	{
		testLabel1.setText(fromLocation.getValue());
	}
	public void toLocationChanged(ActionEvent event)
	{
		testLabel2.setText(toLocation.getValue());
	}
	public void showDate(ActionEvent event)
	{
		LocalDate ld = dp.getValue();
		testLabel3.setText(ld.toString());	
	}
	@FXML
	public void loadLogin(ActionEvent event) throws Exception
	{
		URL url = Paths.get("../airline_management/loginForm/src/Login.fxml").toUri().toURL();
		AnchorPane pane = FXMLLoader.load(url);
		rootPane.getChildren().setAll(pane);
		
	}
	
	
}

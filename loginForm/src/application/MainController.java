package application;

import java.net.URL;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import java.awt.event.*;  
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Node;

public class MainController implements Initializable{
	@FXML
	public AnchorPane rootPane;
	@FXML
	public Label testLabel1,testLabel2,testLabel3,testLabel4;
	@FXML
	public ComboBox<String> fromLocation;
	ObservableList<String> fromList = FXCollections.observableArrayList("Mohali","Delhi","Mumbai");
	
	@FXML
	public ComboBox<String> toLocation;
	ObservableList<String> toList = FXCollections.observableArrayList("Banaglore","Pune","Kolkata");
	@FXML
	private DatePicker dp1;
	@FXML
	private DatePicker dp2;
	@FXML
	public CheckBox check1; 
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
	public void DepartureDate(ActionEvent event)
	{
		LocalDate ld = dp1.getValue();
		testLabel3.setText(ld.toString());	
	}
	public void ReturnDate(ActionEvent event)
	{
		LocalDate ld = dp2.getValue();
		testLabel4.setText(ld.toString());	
	}
	public void loadLogin(ActionEvent event) throws Exception
	{
		URL url = Paths.get("../airline_management/loginForm/src/Login.fxml").toUri().toURL();
		AnchorPane pane = FXMLLoader.load(url);
		rootPane.getChildren().setAll(pane);
	}
//	public void one_way(ActionEvent event) throws Exception{
//		if(check1.isSelected()) {
//			
//		}
//	}
}

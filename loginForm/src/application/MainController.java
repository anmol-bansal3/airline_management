package application;

import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainController implements Initializable{
	@FXML
	public Label testLabel1,testLabel2;
	@FXML
	private Label lblStatus;
	@FXML
	private TextField txtUserName;
	@FXML
	private TextField txtPassword;
	@FXML
	public ComboBox<String> fromLocation;
	ObservableList<String> fromList = FXCollections.observableArrayList("Mohali","Delhi","Mumbai");
	
	@FXML
	public ComboBox<String> toLocation;
	ObservableList<String> toList = FXCollections.observableArrayList("Banaglore","Pune","Kolkata");
	public void Login(ActionEvent event) throws Exception
	{
		if(txtUserName.getText().equals("user") && txtPassword.getText().equals("pass") )
		{
			lblStatus.setText("Login Success!!!");
			
			//Showing 2nd Scene after Login is Successful
			Stage primaryStage = new Stage();
			URL url = Paths.get("../airline_management/loginForm/src/Main.fxml").toUri().toURL();
			Parent root = FXMLLoader.load(url);
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		else lblStatus.setText("Login Failed (: ");
			
	}
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
	
}

package application;

import java.net.URL;
import java.nio.file.Paths;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController {
	@FXML 
	AnchorPane loginRootPane;
	@FXML
	private Label lblStatus;
	@FXML
	private TextField txtUserName;
	@FXML
	private TextField txtPassword;
	@FXML
	public void Login(ActionEvent event) throws Exception
	{
		if(txtUserName.getText().equals("user") && txtPassword.getText().equals("pass") )
		{
			lblStatus.setText("Login Success!!!");
			
			//Showing 2nd Scene after Login is Successful
			URL url = Paths.get("C:/Users/Snehil Sharma/git/airline_management/loginForm/src/UserScreen.fxml").toUri().toURL();
			AnchorPane pane = FXMLLoader.load(url);
			loginRootPane.getChildren().setAll(pane);
			System.out.println("Reached here Successfully");
		}
		else lblStatus.setText("Login Failed (: ");
			
	}
}

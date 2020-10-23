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
import javafx.stage.Stage;

public class MainController {
	@FXML
	private Label lblStatus;
	@FXML
	private TextField txtUserName;
	@FXML
	private TextField txtPassword;
	public void Login(ActionEvent event) throws Exception
	{
		if(txtUserName.getText().equals("user") && txtPassword.getText().equals("pass") )
		{
			lblStatus.setText("Login Success!!!");
			
			//Showing 2nd Scene after Login is Successful
			Stage primaryStage = new Stage();
			URL url = Paths.get("/home/karan/git/airline_management/loginForm/src/Main.fxml").toUri().toURL();
			Parent root = FXMLLoader.load(url);
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		else lblStatus.setText("Login Failed (: ");
			
	}
}

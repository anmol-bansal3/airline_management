package application;

import java.net.URL;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
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
	private Button back;
	public void Login(ActionEvent event) throws Exception
	{
		if(txtUserName.getLength()==0){
			lblStatus.setTextFill(Color.RED);
			lblStatus.setText("Please Enter Username");
		}
		else if(txtPassword.getLength()==0)
		{
			lblStatus.setTextFill(Color.RED);
			lblStatus.setText("Please Enter Password");
		}
		else{
			lblStatus.setTextFill(Color.BLUE);
			lblStatus.setText("Status");
		Connection con = jdbc.getConnection();
		String query = "select * from Users";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next())
		if(txtUserName.getText().equals(rs.getString("username")) && txtPassword.getText().equals(rs.getString("password")) )
		{
			lblStatus.setText("Login Success!!!");
			
			//Showing 2nd Scene after Login is Successful
			URL url = Paths.get("../airline_management/loginForm/src/UserScreen.fxml").toUri().toURL();
			AnchorPane pane = FXMLLoader.load(url);
			loginRootPane.getChildren().setAll(pane);
			System.out.println("Reached here Successfully");
		}
		else lblStatus.setText("Login Failed (: ");		
		}
	}
	public void signup(ActionEvent event) throws Exception
	{
		URL url = Paths.get("../airline_management/loginForm/src/Signup.fxml").toUri().toURL();
		AnchorPane pane = FXMLLoader.load(url);
		loginRootPane.getChildren().setAll(pane);
	}
	public void goBack(ActionEvent event) throws Exception
	{
		URL url = Paths.get("../airline_management/loginForm/src/Front.fxml").toUri().toURL();
		AnchorPane pane = FXMLLoader.load(url);
		loginRootPane.getChildren().setAll(pane);
	}
}

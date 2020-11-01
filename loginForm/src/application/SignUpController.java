package application;
import java.net.MalformedURLException;
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

public class SignUpController {
	@FXML 
	AnchorPane signupRootPane;
	@FXML
	private Label lblStatus;
	@FXML
	private TextField txtUserName;
	@FXML
	private TextField txtPassword;
	@FXML
	private TextField phoneno;
	@FXML
	private TextField email;
	@FXML
	private Button back;
	public void Signup(ActionEvent event) throws Exception
	{
		Connection con = jdbc.getConnection();
		Statement st = con.createStatement();
//		java.util.Date date = new java.util.Date();
//		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
//		java.sql.Timestamp sqlTime = new java.sql.Timestamp(date.getTime());
//		System.out.print(txtUserName.getText() + "," + txtPassword.getText() + "," + phoneno.getText() + "," + email.getText());
		
		if(txtUserName.getLength()==0){
			lblStatus.setTextFill(Color.RED);
			lblStatus.setText("Username can't be Empty!");
		}
		else if(txtPassword.getLength()==0){
			lblStatus.setTextFill(Color.RED);
			lblStatus.setText("Password can't be Empty!");
		}
		else if(phoneno.getLength()==0){
			lblStatus.setTextFill(Color.RED);
			lblStatus.setText("Phone Number can't be Empty!");
		}
		else if(email.getLength()==0){
			lblStatus.setTextFill(Color.RED);
			lblStatus.setText("Email can't be Empty!");
		}
		else{
			lblStatus.setTextFill(Color.BLUE);
			lblStatus.setText("Status");
		String record = "INSERT INTO Users(username, password, phoneno, email, enabled)" + "VALUES ('"+txtUserName.getText()+"','"+txtPassword.getText()+"','"+phoneno.getText()+"','"+email.getText()+"','1')";
		if(st.executeUpdate(record) == 1) {
			lblStatus.setText("Account Successfully created");
			URL url = Paths.get("../airline_management/loginForm/src/Login.fxml").toUri().toURL();
			AnchorPane pane = FXMLLoader.load(url);
			signupRootPane.getChildren().setAll(pane);
		}
		else {
			lblStatus.setText("Account Not Created (: ");
			}
		}
	}
	public void goBack(ActionEvent event) throws Exception
	{
		URL url = Paths.get("../airline_management/loginForm/src/Login.fxml").toUri().toURL();
		AnchorPane pane = FXMLLoader.load(url);
		signupRootPane.getChildren().setAll(pane);
	}
}

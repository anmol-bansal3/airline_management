package application;

import java.net.URL;
import java.nio.file.Paths;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class UserScreenController {
	@FXML
	AnchorPane userScreenRootPane;
	@FXML
	void openFront(ActionEvent event) throws Exception
	{
		URL url = Paths.get("../airline_management/loginForm/src/Front.fxml").toUri().toURL();
		AnchorPane pane = FXMLLoader.load(url);
		userScreenRootPane.getChildren().setAll(pane);
	}
}

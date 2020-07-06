package com.internshala.javaFX;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Mycontroller implements Initializable {
	@FXML
	public Label welcomelabel;
	@FXML
	public ChoiceBox<String> choicebox;
	@FXML
	public TextField userinputfield;
	@FXML
	public Button convertbutton;
	public static final String C_TO_F_TEXT="Celsius to Fahrenheit";
	public static final String F_TO_C_TEXT="Fahrenheit to Celsius";
	private boolean isC_TO_F=true;



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		choicebox.getItems().add(C_TO_F_TEXT);
		choicebox.getItems().add(F_TO_C_TEXT);
		choicebox.setValue(C_TO_F_TEXT);
		choicebox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue.equals(C_TO_F_TEXT)){
				isC_TO_F=true;
			}else {
				isC_TO_F=false;
			}

		});

		convertbutton.setOnAction(event -> {
			convert();
		});

	}

	private void convert() {
		String input=userinputfield.getText();
		float enteredtemperature=0.0f;
		try {
			enteredtemperature = Float.parseFloat(input);
		}catch (Exception exception){
			warnuser();
			return;
		}

		float newtemperature=0.0f;
		if (isC_TO_F){
			newtemperature=(enteredtemperature*9/5)+32;
		}else {
			newtemperature=(enteredtemperature-32)*5/9;
		}
		display(newtemperature);
	}

	private void warnuser() {
		Alert alert=new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error Occurred");
		alert.setHeaderText("Invalid Temperature Entered");
		alert.setContentText("Please Enter a Valid Temperature");
		alert.show();
	}

	private void display(float newtemperature) {
		String unit=isC_TO_F?"F":"C";
		Alert alert=new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Result");
		alert.setContentText("The new Temperature is:"+newtemperature+unit);
		alert.show();

	}

}

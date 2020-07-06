package com.internshala.javaFX;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class Mymain extends Application {
	public static void main(String[] args) {
    launch(args);
	}

	@Override
	public void init() throws Exception {
		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();

		MenuBar menuBar=createMenu();
		rootNode.getChildren().add(0,menuBar);


		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter Tool");
		primaryStage.show();

	}
	private MenuBar createMenu(){
		Menu filemenu=new Menu("File");

		MenuItem newMenuitem= new MenuItem("New");

		newMenuitem.setOnAction(event -> {

		});

		SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();
		MenuItem quitMenuitem=new MenuItem("Quit");

		quitMenuitem.setOnAction(event -> {
			Platform.exit();
			System.exit(0);
		});

		filemenu.getItems().addAll(newMenuitem,separatorMenuItem,quitMenuitem);

		Menu helpmenu=new Menu("Help");
		MenuItem aboutApp=new MenuItem("About");

		aboutApp.setOnAction(event -> aboutApp());

		helpmenu.getItems().addAll(aboutApp);
		MenuBar menuBar=new MenuBar();
		menuBar.getMenus().addAll(filemenu,helpmenu);
		return menuBar;
	}

	private void aboutApp() {
		Alert alertDialog=new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("My first desktop application");
		alertDialog.setHeaderText("Learning javafx");
		alertDialog.setContentText("I am just a beginner now but soon I will be a pro");
		ButtonType yesbtn=new ButtonType("yes");
		ButtonType nobtn=new ButtonType("no");
		alertDialog.getButtonTypes().setAll(yesbtn,nobtn);

		Optional<ButtonType> clickedbtn=alertDialog.showAndWait();
		if (clickedbtn.isPresent() && clickedbtn.get()==yesbtn){

		}else {

		}
	}

	@Override
	public void stop() throws Exception {
		super.stop();
	}
}

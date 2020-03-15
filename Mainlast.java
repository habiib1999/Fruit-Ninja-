package GUI;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import CommandPattern.*;
import factoryPattern.*;
import GUI.*;
import javafx.scene.layout.Pane;
import logic.*;

public class Mainlast extends Application {
    
    
	@Override
	public void start(Stage primaryStage) {
		try {
			//BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("ENTRY.fxml"));
                        //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
                        Homescreen homescreen = new Homescreen(primaryStage);
                        Levelscreen levelscreen = new Levelscreen(primaryStage);
                        
                        levelscreen.preparescene();
                        homescreen.preparescene();
                        
                        homescreen.setLevelscreen(levelscreen);
                        
			primaryStage.setScene(homescreen.getsScene());
			primaryStage.show();
		    } 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	
		/** Testing Factory Pattern **/
		/*
		Factory favFactory = new FruitFactory();
		Product frProduct = favFactory.getProduct("APPLE");
		Factory favFactory1 = new BombFactory();

		Product frProduct1 = favFactory1.getProduct("FATAL");
		Product frProduct2 = favFactory1.getProduct("DANGEROUS");

		System.out.println(((Apple) frProduct).getXlocation());
		System.out.println(((Fatal)frProduct1).getXlocation());
		System.out.println(((Dangerous) frProduct2).getXlocation());

		RemoteContoller contoller =new RemoteContoller();
		Receiver filReceiver= new File();
		Command savwCommand =new SaveCommand(filReceiver);
		Command savwCommand1 =new LoadCommand(filReceiver);
		

		contoller.setCommand(savwCommand1);
		contoller.pressButton();
		contoller.setCommand(savwCommand);
		contoller.pressButton();
		
		GameController controller = GameController.getInstance();
		GameObject gameObject = (Apple) controller.createGameObject("APPLE", "fruit");
		GameObject gameObject2 = (Fatal) controller.createGameObject("FATAL", null);

		System.out.println(gameObject.getXlocation());
		System.out.println(gameObject2.getXlocation());
		
		
		controller.loadGame();
		controller.saveGame();
		*/
		
		
	}
	
}

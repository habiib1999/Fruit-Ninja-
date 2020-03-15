/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.File;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import logic.GameController;

/**
 *
 * @author ABD-ELRAHMAN
 */
public class Levelscreen {
    Scene scene;
    Stage stage;
    Gameplayscreen gameplayscreen;
    Homescreen homescreen;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    GameController controller ;

    Pane root = new Pane();

    Levelscreen(Stage primaryStage) {
        this.stage = primaryStage;
        this.gameplayscreen=new Gameplayscreen(this.stage);
		this.controller =GameController.getInstance();


    }




    
    public void preparescene(){
        	scene = new Scene(root, 1000, 600);
                
  	       	File file1 = new File("./src/icons/chooselevelscreen.png");
	        Image image1 = new Image(file1.toURI().toString());
                imageView1 = new ImageView();
                imageView1.setImage(image1);
                imageView1.fitWidthProperty().bind(scene.widthProperty()); 
                imageView1.fitHeightProperty().bind(scene.heightProperty());
                root.getChildren().add((Node)imageView1);
                          
                
            	File file2 = new File("./src/icons/easybutton.png");
            	Image image2 = new Image(file2.toURI().toString());
                imageView2 = new ImageView();
                imageView2.setImage(image2);
                imageView2.setFitWidth(150);
                imageView2.setFitHeight(150);
                imageView2.setLayoutX(50);
                imageView2.setLayoutY(350);
                root.getChildren().add((Node)imageView2);
                

                imageView2.setOnMouseClicked(new EventHandler<MouseEvent>() {                      	                                       
                    
                	@Override                        
                    public void handle(MouseEvent event) {
                        //gameplayscreen.prepareScene();
                        //stage.setScene(gameplayscreen.getsScene());
                		controller.setGameType("easy");
                        gameplayscreen.prepareScene(.001,5,2);
                        stage.setScene(gameplayscreen.getsScene());
                    }
                });
                
                
                File file3 = new File("./src/icons/mediumbutton.png");
	        Image image3 = new Image(file3.toURI().toString());
                imageView3 = new ImageView();
                imageView3.setImage(image3);
                imageView3.setFitWidth(150);
                imageView3.setFitHeight(150);
                imageView3.setLayoutX(430);
                imageView3.setLayoutY(350);
                root.getChildren().add((Node)imageView3);
                
        imageView3.setOnMouseClicked(new EventHandler<MouseEvent>() {                      	                                       
                    
                	@Override                        
                    public void handle(MouseEvent event) {
                        //gameplayscreen.prepareScene();
                        //stage.setScene(gameplayscreen.getsScene());
                		controller.setGameType("medium");

                        gameplayscreen.prepareScene(.008,15,4);
                        stage.setScene(gameplayscreen.getsScene());
                    }
                });

                
                File file4 = new File("./src/icons/hardbutton.png");
	        Image image4 = new Image(file4.toURI().toString());
                imageView4 = new ImageView();
                imageView4.setImage(image4);
                imageView4.setFitWidth(150);
                imageView4.setFitHeight(150);
                imageView4.setLayoutX(800);
                imageView4.setLayoutY(350);
                root.getChildren().add((Node)imageView4);
                
                
       imageView4.setOnMouseClicked(new EventHandler<MouseEvent>() {                      	                                       
                    
                	@Override                        
                    public void handle(MouseEvent event) {
                        //gameplayscreen.prepareScene();
                        //stage.setScene(gameplayscreen.getsScene());
                		controller.setGameType("hard");
                        gameplayscreen.prepareScene(.01,25,6);
                        stage.setScene(gameplayscreen.getsScene());
                    }
                });
                
    }

    Scene getsScene() {
        return  this.scene;
    }

    public void setGameplayscreen(Gameplayscreen gameplayscreen) {
        this.gameplayscreen = gameplayscreen;
    }


}
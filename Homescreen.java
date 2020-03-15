/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Font;
import java.io.File;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logic.GameController;

/**
 *
 * @author ABD-ELRAHMAN
 */
public class Homescreen {
    Scene scene;
    Stage stage;
    Levelscreen levelscreen;
    Gameplayscreen gameplayscreen;

    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    GameController controller ;

    
    Pane root = new Pane();




    
    public void preparescene()
    {
        	scene = new Scene(root, 1000, 600);
        	
	        
	        

                 
            
            File file1 = new File("./src/icons/background2.png");
	        Image image1 = new Image(file1.toURI().toString());
            imageView1 = new ImageView();
            imageView1.setImage(image1);
            imageView1.fitWidthProperty().bind(scene.widthProperty()); 
            imageView1.fitHeightProperty().bind(scene.heightProperty());
            
            root.getChildren().add((Node)imageView1);
            
            File file2 = new File("./src/icons/newgamebutton.png");
	        Image image2 = new Image(file2.toURI().toString());
            imageView2 = new ImageView();
            imageView2.setImage(image2);
            imageView2.setFitWidth(150);
            imageView2.setFitHeight(150);
            imageView2.setLayoutX(650);
            imageView2.setLayoutY(350);
            root.getChildren().add((Node)imageView2);
                //MOUSE ACTION HANDLER               
                imageView2.setOnMouseClicked(new EventHandler<MouseEvent>() {                      	                                       
                        @Override                        
                        public void handle(MouseEvent event) {
                            //gameplayscreen.prepareScene();
                            //stage.setScene(gameplayscreen.getsScene());
                            stage.setScene(levelscreen.getsScene());
                        }
                    });

    	        Image loadmage = new Image(new File("./src/icons/loadbutton.png").toURI().toString());
                imageView3 = new ImageView();
                imageView3.setImage(loadmage);
                imageView3.setFitWidth(150);
                imageView3.setFitHeight(150);
                imageView3.setLayoutX(250);
                imageView3.setLayoutY(350);
                root.getChildren().add((Node)imageView3);
                    //MOUSE ACTION HANDLER               
                    imageView3.setOnMouseClicked(new EventHandler<MouseEvent>() {                      	                                       
                            @Override                        
                            public void handle(MouseEvent event) {
                                //gameplayscreen.prepareScene();
                                //stage.setScene(gameplayscreen.getsScene());
                            	try {
                            		controller.loadGame();
                            		switch (controller.getGameType()) {
    								case "easy":
    			                        gameplayscreen.prepareScene(.001,5,2);
    			                        stage.setScene(gameplayscreen.getsScene());

    									break;
    								case "medium":
    			                        gameplayscreen.prepareScene(.008,15,4);
    			                        stage.setScene(gameplayscreen.getsScene());


    									break;
    								case "hard":
    			                        gameplayscreen.prepareScene(.01,25,6);
    			                        stage.setScene(gameplayscreen.getsScene());
    									break;

    								default:
    									break;
    								}
								} catch (Exception e) {
		                            stage.setScene(levelscreen.getsScene());
								}
                            	
                              
                            }
                        });

    }
    public class Panel extends Pane {

        private ImageView image = new ImageView(new Image(getClass().getResourceAsStream("red.jpg")));
 
        private Label label1 = new Label();

        public Panel() {

            label1.relocate(524, 280);
            label1.setGraphic(image);
            this.getChildren().add(label1);
        }}

    Scene getsScene() {
        return  this.scene;
    }

   

	public void setGameplayscreen(Gameplayscreen gameplayscreen) {
		this.gameplayscreen = gameplayscreen;
	}

	public void setLevelscreen(Levelscreen levelscreen) {
        this.levelscreen = levelscreen;
    }



    public Homescreen(Stage stage) {
        this.stage = stage;
		this.controller =GameController.getInstance();
        this.gameplayscreen=new Gameplayscreen(this.stage);


    }

}

package GUI ;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.io.File;
import java.util.ArrayList;

import com.sun.javafx.scene.EnteredExitedHandler;

import logic.*;
import factoryPattern.*;
import GUI.*;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
public class Gameplayscreen {
            Scene scene;
            Homescreen homescreen;
            Stage stage;
            ImageView imageView1;
            AnimationTimer timer;
            AnimationTimer BombssTimer;
            Label remaringtext ;
            Label scoretext ;
            Label maxScoretext;

            Timeline bombTimeline2;
            Timeline bombTimeline1 ;
            Timeline FTimeline3 ;
            Timeline FTimeline1 ; 
            Timeline FTimeline2; 
            Timeline FTimeline4; 
            Timeline FTimeline5; 

            double limit = 90;
	       int M1=0,M2=0,M3=0,M5=0,M4=0,bombcounter1=0,bombcounter2=0;
	       int n =0,r=0,s=0;
	       GameController controller ;
	       double speed;
		   double falling;
	       int numOfFruits=0 ; 
	       TextArea textArea ;
	       Pane root = new Pane();
	    
            
	    public Gameplayscreen(Stage primaryStage ) {
			this.controller =GameController.getInstance();
	        this.stage = primaryStage;
	      
	    }            
	    public void prepareScene(double speed, int numOfFruits, int numOfBombs) {
	    	  
	       try {
	    	   controller.loadmaxGame();
		} catch (Exception e) {
			// TODO: handle exception
		}
	        //adding Score image & label 
	        Image scoreimage = new Image(new File("./src/icons/scorepanel.png").toURI().toString());
	        ImageView scoreImageView = new ImageView(scoreimage);
	        scoreImageView.setFitWidth(80);
	        scoreImageView.setFitHeight(80);
            scoreImageView.setLayoutX(10);
            scoreImageView.setLayoutY(10);
                      
             scoretext =new Label("");
            scoretext.setLayoutX(40);
            scoretext.setLayoutY(44);
            scoretext.setTextFill(Color.web("#0076a3"));
            scoretext.setFont(Font.font("Cambria",25));
            
          //adding maxScore image & label 
	        Image maxScoreimage = new Image(new File("./src/icons/maxscore.png").toURI().toString());
	        ImageView maxScoreImageView = new ImageView(maxScoreimage);
	        maxScoreImageView.setFitWidth(80);
	        maxScoreImageView.setFitHeight(80);
	        maxScoreImageView.setLayoutX(100);
	        maxScoreImageView.setLayoutY(10);
                      
             maxScoretext =new Label("");
           maxScoretext.setLayoutX(110);
            maxScoretext.setLayoutY(44);
            maxScoretext.setTextFill(Color.web("#0076a3"));
            maxScoretext.setFont(Font.font("Cambria",25));

            //adding reamring image & label 
	        Image remaringImage= new Image( new File("./src/icons/remaininglives.png").toURI().toString());
	        ImageView remaringImageView = new ImageView(remaringImage);
	        remaringImageView.setFitWidth(80);
	        remaringImageView.setFitHeight(80);
	        remaringImageView.setLayoutX(200);
	        remaringImageView.setLayoutY(10);

             remaringtext = new Label("");
            remaringtext.setLayoutX(230);
            remaringtext.setLayoutY(44);
            remaringtext.setTextFill(Color.web("#0076a3"));
            remaringtext.setFont(Font.font("Cambria",32));
            
          //adding save image 
	        Image saveImage= new Image( new File("./src/icons/savebutton.png").toURI().toString());
	        ImageView saveImageView = new ImageView(saveImage);
	        saveImageView.setFitWidth(80);
	        saveImageView.setFitHeight(80);
	        saveImageView.setLayoutX(900);
	        saveImageView.setLayoutY(10);
	        
	        saveImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {                      	                                       
                @Override                        
                public void handle(MouseEvent event) {
                   controller.saveGame();
                   // set alert type       
      			 Alert a = new Alert(AlertType.INFORMATION);
       			// set alert type       
                // set content text 
                a.setContentText("\n game saved  !!"); 
                // show the dialog 
                a.show(); 
                return;
                   }
            });
	        this.numOfFruits=numOfFruits;
	        this.speed=speed;
         falling = 2000;
	  
		         FTimeline1 = new Timeline(new KeyFrame(Duration.millis(falling*1.5), event -> { 
		        	 this.speed += 0.35;
		        	 try {
		        	 controller.getOrangeList().add(controller.createGameObject("ORANGE", "fruit"));
		             setImageViewToObject((Orange)controller.getOrangeList().get(M1++));
		             clickOrange();
			         
		             root.getChildren().add(((Node)controller.getOrangeList().get(controller.getOrangeList().size()-1).getImageView()));
		         	
				} catch (Exception e) {
					// TODO: handle exception
				}
		           
		        }));
		        
		         FTimeline2 = new Timeline(new KeyFrame(Duration.millis(falling*2.5), event -> { 
		        	try {
		        	 controller.getMelonList().add( controller.createGameObject("MELLON", "fruit"));
		             setImageViewToObject((Mellon)(controller.getMelonList().get(M2++)));
			         clickMellon();
			         
		             root.getChildren().add(((Node)controller.getMelonList().get(controller.getMelonList().size()-1).getImageView()));
		         	
				} catch (Exception e) {
					// TODO: handle exception
				}
		           
		        }));
		        
		         FTimeline3 = new Timeline(new KeyFrame(Duration.millis(falling*3.5), event -> { 
		        	 
		        	try {
					
			         controller.getAppleList().add( controller.createGameObject("APPLE", "fruit"));
		             setImageViewToObject((Apple)(controller.getAppleList().get(M3++)));
			         clickApple();
			         
		             root.getChildren().add(((Node)controller.getAppleList().get(controller.getAppleList().size()-1).getImageView()));
		         	
					} catch (Exception e) {
						// TODO: handle exception
					}
		        }));
		        
		         FTimeline4 = new Timeline(new KeyFrame(Duration.millis(falling*4.5), event -> { 
		        	 
			        	try {
						
				         controller.getBananaList().add( controller.createGameObject("BANANA", "fruit"));
			             setImageViewToObject((Banana)(controller.getBananaList().get(M4++)));
				         clickBanana();
				         
			             root.getChildren().add(((Node)controller.getBananaList().get(controller.getBananaList().size()-1).getImageView()));
			         	
						} catch (Exception e) {
							// TODO: handle exception
						}
			        })); 
		         FTimeline5 = new Timeline(new KeyFrame(Duration.millis(falling*5.5), event -> { 
			        	 
			        	try {
						
				         controller.getGreenAppleList().add( controller.createGameObject("GREENAPPLE", "fruit"));
			             setImageViewToObject((GreenApple)(controller.getGreenAppleList().get(M5++)));
				         clickGreenApple();
				         
			             root.getChildren().add(((Node)controller.getGreenAppleList().get(controller.getGreenAppleList().size()-1).getImageView()));
			         	
						} catch (Exception e) {
							// TODO: handle exception
						}
			        }));
		         
		         
		         
		        FTimeline3.setCycleCount(numOfFruits);
		        FTimeline3.play();
		        FTimeline2.setCycleCount(numOfFruits);
		        FTimeline2.play();
		        FTimeline1.setCycleCount(numOfFruits);
		        FTimeline1.play();
		        FTimeline4.setCycleCount(numOfFruits);
		        FTimeline4.play(); 
		        FTimeline5.setCycleCount(numOfFruits);
		        FTimeline5.play();
		        
		        /**   **/
		        
		         bombTimeline1 = new Timeline(new KeyFrame(Duration.millis(falling*8), event -> { 
		        	 this.speed += 0.35;
		        	 try {
		        	 controller.getDangerousList().add( controller.createGameObject("DANGEROUS", null));
		             setImageViewToObject((Dangerous)(controller.getDangerousList().get(bombcounter2++)));
			         clickDangerous();
			         
		             root.getChildren().add(((Node)controller.getDangerousList().get(controller.getDangerousList().size()-1).getImageView()));
		         	
				} catch (Exception e) {
					// TODO: handle exception
				}
		        }));
		         bombTimeline2 = new Timeline(new KeyFrame(Duration.millis(falling*9.5), event -> { 
		        	try {
			        
		             controller.getFatalList().add( controller.createGameObject("FATAL", null));
		             setImageViewToObject((Fatal)(controller.getFatalList().get(bombcounter1++)));
			         clickFatal();
		             root.getChildren().add(((Node)controller.getFatalList().get(controller.getFatalList().size()-1).getImageView()));
		         	
				} catch (Exception e) {
					// TODO: handle exception
				}
		           
		           
		        }));
		        bombTimeline1.setCycleCount(numOfBombs);
		        bombTimeline1.play();
		        bombTimeline2.setCycleCount(numOfBombs-1);
		        bombTimeline2.play();
		        
		       
		        timer = new AnimationTimer() {
		            @Override
		            public void handle(long arg0) {
		                gameUpdate(); 
		              /* System.out.println("Score is : "+controller.getScoreNum());
		               System.out.println("Remaning lives is : "+controller.getRemainingLives());
	*/
		                
		            }
		           
		        };
	                        
		        timer.start(); 
		        
		      
	      
	        scene = new Scene(root, 1000, 600);

                File file1 = new File("./src/icons/background0.png");
	        Image image1 = new Image(file1.toURI().toString());
                imageView1 = new ImageView();
                imageView1.setImage(image1);
                imageView1.fitWidthProperty().bind(scene.widthProperty()); 
                imageView1.fitHeightProperty().bind(scene.heightProperty());
                imageView1.fitWidthProperty().bind(scene.widthProperty()); 
                imageView1.fitHeightProperty().bind(scene.heightProperty());
            root.getChildren().add((Node)imageView1);
            
 	         root.getChildren().add((Node)scoreImageView);
 	         root.getChildren().add((Node)remaringImageView);
	         root.getChildren().add((Node)saveImageView);
	         root.getChildren().add((Node)maxScoreImageView);



 	       root.getChildren().add((Node)remaringtext);
 	         root.getChildren().add((Node)scoretext);
 	         root.getChildren().add((Node)maxScoretext);


	    } 
	 
            public void setImageViewToObject(GameObject object)
            {
            object.setIntialImageView();
	        object.getImageView().setFitHeight(100);
	        object.getImageView().setFitWidth(100);
	        object.getImageView().setLayoutX(rand(100, 800));
	        object.getImageView().setLayoutY(600);
	        object.setLimit(rand(80, 110));
            }
	       
	   
	    public int rand(int min, int max) {
	        return (int)(Math.random() * max + min);
	    }
	    
             public void clickOrange(){
                click(controller.getOrangeList());
            }
            public void clickMellon()
            {
		         click(controller.getMelonList());  
            }
            public void clickApple()
            {
		         click(controller.getAppleList());  
            }
            public void clickFatal()
            {
		         click(controller.getFatalList());  
            }
            public void clickDangerous()
            {
		         click(controller.getDangerousList());  
            }
            public void clickBanana()
            {
		         click(controller.getBananaList());  
            }
            public void clickGreenApple()
            {
		         click(controller.getGreenAppleList());  
            }
            
            
            
            public void click(ArrayList<GameObject> objectList)
            
            {
            	if ( controller.getRemainingLives()==0)
    			{
    				endOfGame();
    			}

            	objectList.forEach(o->{
            	o.getImageView().setOnMouseClicked(new EventHandler<MouseEvent>() 
            	{
            		@Override
                    public void handle(MouseEvent event) 
                    {
            			try {
            			
            				controller.sliceObjects(o);
            			
						} catch (Exception e) {
							// TODO: handle exception
						}
            		}
            	});
            });
                 }
             public void objectUpdate(ArrayList<GameObject> objectList){
            	 GameObject objectprev;
            	 objectList.forEach(o->{
            		 if ( o.isSliced())
      	            {
      	                ((ImageView) o.getImageView()).setLayoutY(((ImageView) o.getImageView()).getLayoutY() );

      	            }else {
            	 if(((ImageView) o.getImageView()).getLayoutY() > o.getLimit())
 	                ((ImageView) o.getImageView()).setLayoutY(((ImageView)o.getImageView()).getLayoutY() - speed - ((ImageView) o.getImageView()).getLayoutY() / 700 );
 	            if(((ImageView) o.getImageView()).getLayoutY() <= o.getLimit()){
 	                ((ImageView) o.getImageView()).setLayoutY(((ImageView) o.getImageView()).getLayoutY() + speed + ((ImageView) o.getImageView()).getLayoutY() / 700);
 	               o.setLimit(((ImageView) o.getImageView()).getLayoutY());   
 	            }}
            		 
            	 });
            
             }
            
	        
	   public void  endOfGame()
	   {
		    timer.stop();
	         FTimeline1.stop();
	         FTimeline2.stop();
	         FTimeline3.stop();
	         bombTimeline1.stop();
	         bombTimeline2.stop();
	         
		// set alert type       
			 Alert a = new Alert(AlertType.ERROR);
			// set alert type       
         // set content text 
         a.setContentText("\n End Of Game  !! With Score : "+controller.getScoreNum()); 
         // show the dialog 
          
         
         a.show();
         stage.close();
         return;
	   }
	    
	    
	    public void gameUpdate(){
            remaringtext.setText( Integer.toString(controller.getRemainingLives()));
            scoretext.setText( Integer.toString(controller.getScoreNum()));
            maxScoretext.setText(String.valueOf(controller.getMaxScore()));

            
            if ( controller.getRemainingLives()==0)
			{
				endOfGame();
			}
               objectUpdate (controller.getOrangeList());
               objectUpdate (controller.getMelonList());
               objectUpdate (controller.getAppleList());
               objectUpdate (controller.getGreenAppleList());
               objectUpdate (controller.getBananaList());
               objectUpdate (controller.getDangerousList());
               objectUpdate (controller.getFatalList());
               
               for (int i = 0; i < controller.getOrangeList().size(); i++) {
       	
                    	 
          	           if( controller.getOrangeList().get(i).getImageView().getLayoutY() >= 620 && controller.getOrangeList().get(i).hasMovedOffScreen()==false && controller.getOrangeList().get(i).isSliced()==false) {
                           // root.getChildren().remove(o);
          	        	   System.out.println("Inside REMOVING !!");
          	        	 controller.getOrangeList().remove(controller.getOrangeList().get(i));
                            controller.remainingLives=controller.remainingLives-1;
          
                        }
       } 
               for (int i = 0; i < controller.getMelonList().size(); i++) {
               	
               	 
       	           if( controller.getMelonList().get(i).getImageView().getLayoutY() >= 620 && controller.getMelonList().get(i).hasMovedOffScreen()==false && controller.getMelonList().get(i).isSliced()==false ) {
                        // root.getChildren().remove(o);
       	        	   System.out.println("Inside REMOVING !!");
       	        	 controller.getMelonList().remove(controller.getMelonList().get(i));
                         controller.remainingLives=controller.remainingLives-1;

                     }
       }         for (int i = 0; i < controller.getAppleList().size(); i++) {
          	
         	 
           if( controller.getAppleList().get(i).getImageView().getLayoutY() >= 620 && controller.getAppleList().get(i).hasMovedOffScreen()==false && controller.getAppleList().get(i).isSliced()==false ) {
             // root.getChildren().remove(o);
        	   System.out.println("Inside REMOVING !!");
        	 controller.getAppleList().remove(controller.getAppleList().get(i));
              controller.remainingLives=controller.remainingLives-1;

          }
    }            for (int i = 0; i < controller.getBananaList().size(); i++) {
       	
      	 
        if( controller.getBananaList().get(i).getImageView().getLayoutY() >= 620 && controller.getBananaList().get(i).hasMovedOffScreen()==false && controller.getBananaList().get(i).isSliced()==false ) {
          // root.getChildren().remove(o);
     	   System.out.println("Inside REMOVING !!");
     	 controller.getBananaList().remove(controller.getBananaList().get(i));
           controller.remainingLives=controller.remainingLives-1;

       }
 }            for (int i = 0; i < controller.getGreenAppleList().size(); i++) {
    	
   	 
     if( controller.getGreenAppleList().get(i).getImageView().getLayoutY() >= 620 && controller.getGreenAppleList().get(i).hasMovedOffScreen()==false && controller.getGreenAppleList().get(i).isSliced()==false ) {
       // root.getChildren().remove(o);
  	   System.out.println("Inside REMOVING !!");
  	 controller.getGreenAppleList().remove(controller.getGreenAppleList().get(i));
        controller.remainingLives=controller.remainingLives-1;

    }
}         

}  
	  
            
            public Scene getsScene(){
                return this.scene;
            }

            public void setHomescreen(Homescreen homescreen) {
                 this.homescreen = homescreen;
            }

            

}
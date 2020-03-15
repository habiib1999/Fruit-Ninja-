package factoryPattern;

import java.awt.image.BufferedImage;

import javafx.scene.image.ImageView;

public abstract class Product {
	 double limit;
     ImageView imageView;
	BufferedImage[] images ;
	boolean flagSLiced= false;
	boolean hasMovedOffScreen =false ;
	public void setHasMoved(boolean flag) {
		this.hasMovedOffScreen=flag ;
	} ;

}

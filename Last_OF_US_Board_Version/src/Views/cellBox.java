package Views;

import java.awt.Point;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.characters.*;
import model.characters.Character;
public class cellBox extends VBox  {
//    VBox box;
   public static  String cssBordering = "-fx-border-color:#654321 ; \n" //#090a0c
            + "-fx-border-insets:2;\n"
            + "-fx-border-radius:7;\n"
            + "-fx-border-width:2.0";
    String cssBordering2 = "-fx-border-color:green ; \n" //#090a0c
            + "-fx-border-insets:2;\n"
            + "-fx-border-radius:7;\n"
            + "-fx-border-width:2.0";
   
    Character character;
    Point Location;
    
    public cellBox(){
        super();
        
       
       //        box = new VBox(20);
        setMinWidth(80);
        setMinHeight(57);
        setMaxWidth(80);
        setMaxHeight(57);
      
    setStyle(cssBordering);
//       // assuming button is a Button
        // set background color to transparent
        
      
        
        setOnMouseClicked(e->{
        	gameview.removeclicked();
        	gameview.SelectedHero.setTarget(character); 
      setStyle(cssBordering2);
        });


	
   

  

}}

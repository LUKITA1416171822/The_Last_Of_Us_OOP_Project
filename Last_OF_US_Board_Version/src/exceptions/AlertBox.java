package exceptions;

import Views.Pick_Hero;
import Views.gameview;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AlertBox extends Application{
	VBox vb;
	public static StackPane sp1=new StackPane();
public AlertBox(String s) {
	//gameview.sp.setAlignment(sp1,Pos.CENTER);
	BackgroundFill fill = new BackgroundFill (Color.rgb (0, 0, 0, 0.5), null, null); // black with 50% opacity
    Background background1 = new Background (fill);
	VBox vb=new VBox();
	Label l=new Label(s);
	l.setFont(Pick_Hero.fraktur);
	l.setStyle("-fx-font: 40px \"" + Pick_Hero.fraktur.getName()+ "\" ;-fx-shape: \"M0,0 L150,0 L112.5,50 L37.5,50 Z\";  -fx-text-fill: White;");
	Button b2=new Button("Close");
	
	
	vb.getChildren().addAll(l,b2);
	
	vb.setBackground(background1);
	sp1.getChildren().add(vb);
	vb.setAlignment(Pos.CENTER);
	gameview.sp.getChildren().add(sp1);
	b2.setStyle("-fx-font: 30px \"" + Pick_Hero.fraktur.getName() + "\" ;-fx-background-color: transparent;-fx-shape: \"M0,0 L150,0 L112.5,50 L37.5,50 Z\";  -fx-text-fill: White;");
	b2.setOnMouseExited(e -> b2.setStyle("-fx-font: 30px \"" + Pick_Hero.fraktur.getName()+ "\";-fx-shape: \"M0,0 L100,0 L75,50 L25,50 Z\"; -fx-background-color:transparent; -fx-text-fill: white;"));
	b2.setOnMouseEntered(e -> b2.setStyle("-fx-font: 30px \"" + Pick_Hero.fraktur.getName() + "\";-fx-shape: \"M0,0 L100,0 L75,50 L25,50 Z\"; -fx-background-color:black; -fx-text-fill: white;"));
	//vb.setMouseTransparent(false);
    
    b2.setOnMouseClicked(e->{
		gameview.sp.getChildren().remove(sp1);
    	vb.setVisible(false);
		gameview.isAlert = false;
	});
	
	
}
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

}

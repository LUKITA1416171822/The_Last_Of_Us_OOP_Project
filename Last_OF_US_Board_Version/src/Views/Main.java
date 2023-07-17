package Views;

import java.nio.file.Paths;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.stage.Stage;

public class Main extends Application  {
  
	public static void main (String [] args) {
	  launch(args);

  }

@Override
public void start(Stage Start) throws Exception {
	Control c=new Control(Start);
//	AnchorPane pane=new AnchorPane();
//	Scene scene=new Scene(pane);
//	Start.setScene(scene);
//	Pick_Hero ph =new Pick_Hero(Start,scene);
//	Image img=new Image(Paths.get("C:\\Users\\Yahia Hesham\\Downloads\\Hope.jpg").toUri().toString()); 
    Start.setFullScreen(true);
	
	
}
}
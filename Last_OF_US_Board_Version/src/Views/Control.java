package Views;

import java.awt.Point;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import engine.Game;
import exceptions.AlertBox;
import exceptions.MovementException;
import exceptions.NotEnoughActionsException;
import javafx.scene.text.Font;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.awt.Cursor;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.util.Duration;
import model.characters.Direction;
public class Control  {
static Stage start;

public  Control(Stage star){
		this.start=star;
		start.setFullScreen(true);
		music();
		StackPane root = new StackPane();
		//window =start;
		Image image = new Image ("the-last-of-us-part-ii-game-gn.jpg");
		//Image img=new Image("Hope.jpg"); 
        //ImageView img2=new ImageView(image);
		
//		BackgroundImage backgroundImage2 = new BackgroundImage (img,
//			    BackgroundRepeat.NO_REPEAT,
//			    BackgroundRepeat.NO_REPEAT,
//			    BackgroundPosition.CENTER,
//			    new BackgroundSize (100, 100, true, true, true, true));
		// Create a BackgroundImage with the image and a BackgroundSize that covers 100% of the region's area
		BackgroundImage backgroundImage = new BackgroundImage (image,
		    BackgroundRepeat.NO_REPEAT,
		    BackgroundRepeat.NO_REPEAT,
		    BackgroundPosition.CENTER,
		    new BackgroundSize (100, 100, true, true, true, true));
		
		// Create a Background with the BackgroundImage
		Background background = new Background (backgroundImage);
		// Create a Pane and set its background with the Background
		AnchorPane pane = new AnchorPane ();
		pane.setBackground (background);
		// Create a Scene with the Pane as the root
		// Get the screen size
		// Create a Pane and set its preferred size to the screen size
	
		Button StartGame=new Button();
		Button Description=new Button();
		Button ExitGame=new Button();
		StartGame.setText("Start Game");
		Description.setText("Description");
		ExitGame.setText("Exit Game");
	    StartGame.setPrefWidth(200);
	    StartGame.setPrefHeight(20);
	    Description.setPrefWidth(200);
	    Description.setPrefHeight(20);
	    ExitGame.setPrefWidth(200);
	    ExitGame.setPrefHeight(20);
	    StartGame.setStyle ("-fx-shape: \"M0,0 L100,0 L75,50 L25,50 Z\"; -fx-background-color: transparent; -fx-text-fill: white;"); // set the text color, font size, font family and background color
	    StartGame.setFont(new Font("Arial", 20));
	    Description.setStyle ("-fx-shape: \"M0,0 L100,0 L75,50 L25,50 Z\"; -fx-background-color: transparent; -fx-text-fill: white;"); // set the text color, font size, font family and background color
	    Description.setFont(new Font("Arial", 20));
	    ExitGame.setStyle ("-fx-shape: \"M0,0 L100,0 L75,50 L25,50 Z\"; -fx-background-color: transparent; -fx-text-fill: white;"); // set the text color, font size, font family and background color
	    ExitGame.setFont(new Font("Arial", 20));
	    //StartGame.setMouseTransparent(false);
		//b.setBackground(background);
		AnchorPane.setLeftAnchor (StartGame, 100d); // distance 0 from left side
		AnchorPane.setTopAnchor (StartGame, 250d); // distance 0 from top
		AnchorPane.setLeftAnchor (Description, 100d); // distance 0 from left side
		AnchorPane.setTopAnchor (Description, 350d); // distance 0 from top
		AnchorPane.setLeftAnchor (ExitGame, 100d); // distance 0 from left side
		AnchorPane.setTopAnchor (ExitGame, 450d); // 
		
		//Cursor customCursor =Toolkit.getDefaultToolkit().createCustomCursor(img, new Point(0,0), "c");
		// set custom cursor for scene
		
		//StartGame.setStyle();
		pane.getChildren().addAll(StartGame,Description,ExitGame);
	    StartGame.setOnMouseEntered(e -> StartGame.setStyle("-fx-shape: \"M0,0 L100,0 L75,50 L25,50 Z\"; -fx-background-color: black; -fx-text-fill: white;"));
		StartGame.setOnMouseExited(e -> StartGame.setStyle("-fx-shape: \"M0,0 L100,0 L75,50 L25,50 Z\"; -fx-background-color: transparent; -fx-text-fill: white;"));
		Description.setOnMouseEntered(e -> Description.setStyle("-fx-shape: \"M0,0 L100,0 L75,50 L25,50 Z\"; -fx-background-color: black; -fx-text-fill: white;"));
		Description.setOnMouseExited(e -> Description.setStyle("-fx-shape: \"M0,0 L100,0 L75,50 L25,50 Z\"; -fx-background-color: transparent; -fx-text-fill: white;"));
		ExitGame.setOnMouseExited(e -> ExitGame.setStyle("-fx-shape: \"M0,0 L100,0 L75,50 L25,50 Z\"; -fx-background-color:transparent; -fx-text-fill: white;"));
		ExitGame.setOnMouseEntered(e -> ExitGame.setStyle("-fx-shape: \"M0,0 L100,0 L75,50 L25,50 Z\"; -fx-background-color: black; -fx-text-fill: white;"));
		//Background b=new Background(backgroundImage2);
		 Font fraktur = Font.loadFont(getClass().getResourceAsStream("GRUDBLIT.TTF"),40);
		 StartGame.setFont(fraktur);
		 Description.setFont(fraktur);
		ExitGame.setFont(fraktur);
		AnchorPane pane2=new AnchorPane();
        ProgressBar progressBar = new ProgressBar();
        progressBar.setStyle("-fx-accent: red;");
		progressBar.setPrefWidth(400);
        progressBar.setPrefHeight(30);
		//progressBar.setBackground(b);
		pane2.getChildren().add(progressBar);
		AnchorPane.setTopAnchor(progressBar, 400d);
		AnchorPane.setLeftAnchor(progressBar, 550d);
		//Scene scene2=new Scene(pane2,600,600);
		File file = new File("src\\Untitled video - Made with Clipchamp (3).mp4");
		Media media = new Media(file.toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		MediaView mediaView = new MediaView(mediaPlayer);
		//mediaView.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth());
		//mediaView.setFitHeight(Screen.getPrimary().getVisualBounds().getHeight());
		mediaView.fitWidthProperty().bind(start.widthProperty());
		mediaView.fitHeightProperty().bind(start.heightProperty()); 
		Scene scene = new Scene (pane,Screen.getPrimary().getVisualBounds().getWidth(),Screen.getPrimary().getVisualBounds().getHeight());
	     start.setFullScreenExitHint("");
		StartGame.setOnMouseClicked(event -> {
		    FadeTransition fadeTransition = new FadeTransition();
		    fadeTransition.setFromValue(1.0);
		    fadeTransition.setToValue(0.0);
		    fadeTransition.setOnFinished(event2 -> {
		    	pane2.setPrefHeight(30);
		    	pane2.setPrefWidth(400);
		    	root.getChildren().add(mediaView);
	    	    root.getChildren().add(pane2);
	    	    
	    		//new Thread(task).start();
	    		//root.getChildren().remove(pane2);
	    		
	    		scene.setRoot(root);
	    		start.setScene(scene);
		    	Timeline timeline = new Timeline(
		    		    new KeyFrame(Duration.ZERO, new KeyValue(progressBar.progressProperty(), 0)),
		    		    new KeyFrame(Duration.seconds(4), new KeyValue(progressBar.progressProperty(), 1)),
		    		    new KeyFrame(Duration.seconds(4),ev -> { progressBar.setVisible(false);}
		    		));
		    		
		    		
		    		mediaPlayer.setAutoPlay(true);
		    		timeline.play();
		    		
		    		
		    		mediaPlayer.setOnEndOfMedia(() -> {
		    		   Pick_Hero Hp =new Pick_Hero(start,scene);
		    		   
		    			//start.setScene(scene2);
		    		    
		    		});
		    		//start.setScene(scene2);
		    		//primaryStage.show();
		    	//start.setScene(scene2);
		       start.setFullScreen(true);
		    });
		    fadeTransition.play();
		});
		
		ExitGame.setOnMouseClicked(event ->{ start.close(); });
		Description.setVisible(false);
     //scene.getRoot().setStyle("-fx-background-color: transparent;");
    // start.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
start.setTitle("Last of Us - Legacy");
start.setScene(scene);
	//start.setResizable(false);
	//start.setFullScreenExitHint("Esc");
	//start.setMaximized(true);
	//Screen.getPrimary().getVisualBounds().getHeight();
	start.fullScreenExitHintProperty();
//	scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
//		final KeyCombination keyComb = new KeyCodeCombination(KeyCode.Q);
//
//		public void handle(KeyEvent ke) {
//			if (keyComb.match(ke)) {
//			start.close();
//			}
//		}
//	});
	scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
		final KeyCombination keyComb = new KeyCodeCombination(KeyCode.ESCAPE);

		public void handle(KeyEvent ke) {
			if (keyComb.match(ke)) {
			start.close();
			}
		}
	});
		start.show();
	}
	static MediaPlayer mediaPlayer;
	public static void music() {
		String s = "src\\background.mp3";
		Media h = new Media(Paths.get(s).toUri().toString());
		mediaPlayer = new MediaPlayer(h);
		mediaPlayer.setVolume(0.1);
		mediaPlayer.play();
		mediaPlayer.setOnEndOfMedia(new Runnable() {
			  public void run() {
				  mediaPlayer.seek(Duration.ZERO);
				  mediaPlayer.play();
			  }
			});
		
	}
	
public static void main(String[] args) {
	
}
}

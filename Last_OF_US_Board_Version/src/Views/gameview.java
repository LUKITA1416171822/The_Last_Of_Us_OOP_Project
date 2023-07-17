package Views;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import model.characters.Direction;
import model.characters.Explorer;
import model.characters.Fighter;
import model.characters.Hero;
import model.characters.Medic;
import model.characters.Zombie;
import model.collectibles.Supply;
import model.world.CharacterCell;
import model.world.CollectibleCell;
import model.world.TrapCell;

import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

import engine.Game;
import exceptions.AlertBox;
import exceptions.InvalidTargetException;
import exceptions.MovementException;
import exceptions.NoAvailableResourcesException;
import exceptions.NotEnoughActionsException;

//
public class gameview implements EventHandler<MouseEvent> {
	public static boolean isAlert=false;
//	public boolean isAlert() {
//		return isAlert;
//	}
//	public void setAlert(boolean a) {
//		isAlert = a;
//	}
	String cssBordering = "-fx-border-color:darkblue ; \n" // #090a0c
			+ "-fx-border-insets:2;\n" + "-fx-border-radius:7;\n" + "-fx-border-width:2.0";
	String cssBordering2 = "-fx-border-color:green ; \n" // #090a0c
			+ "-fx-border-insets:2;\n" + "-fx-border-radius:7;\n" + "-fx-border-width:2.0";
    static String s = "src\\audiomass-output.mp3";
	static Media h = new Media(Paths.get(s).toUri().toString());
  static String s2="src\\trap.mp3";
  static Media h1=new Media(Paths.get(s2).toUri().toString());
static    MediaPlayer mediaPlayer;
static MediaPlayer mediaPlayer2;
//static Media media1 = new Media(new File("C:\\Users\\Yahia Hesham\\Downloads\\Untitled video - Made with Clipchamp (3).mp4").toURI().toString());
//static MediaPlayer mediaPlayer1 = new MediaPlayer(media1);
//static MediaView mediaView1 = new MediaView(mediaPlayer1);
//static Media media2 = new Media(new File("C:\\Users\\Yahia Hesham\\eclipse-workspace\\Milestone2-Solution\\src\\trap.mp3").toURI().toString());
//static MediaPlayer mediaPlayer2 = new MediaPlayer(media2);
//static MediaView mediaView2 = new MediaView(mediaPlayer2);
static Media media3 = new Media(new File("src\\Untitled video - Made with Clipchamp (10).mp4").toURI().toString());
static MediaPlayer mediaPlayer3 = new MediaPlayer(media3);
static MediaView mediaView3 = new MediaView(mediaPlayer3);
static Media media4 = new Media(new File("src\\Win(we are thechampions).mp4").toURI().toString());
static MediaPlayer mediaPlayer4 = new MediaPlayer(media4);
static MediaView mediaView4 = new MediaView(mediaPlayer4);
	static BorderPane border = new BorderPane();
	public static AnchorPane sp = new AnchorPane();
	public static Hero SelectedHero;
	static VBox allstuff = new VBox();
//	Image img1 = new Image(
//			Paths.get("C:\\Users\\Administrator\\Documents\\Game Folder\\al_mo3allem_rashdan-removebg-preview.png")
//					.toUri().toString());
//	Image img2 = new Image(Paths.get(
//			"C:\\Users\\Legion\\Desktop\\sem4\\CSEN401\\milestone 3\\Milestone2-Solution\\alex-removebg-preview (1).png")
//			.toUri().toString());
//	Image img3 = new Image(Paths.get(
//			"C:\\Users\\Administrator\\Documents\\Game Folder\\aps_504x498_small_transparent-pad_600x600_f8f8f8.u3-removebg-preview.png")
//			.toUri().toString());
//	Image img4 = new Image(Paths.get("C:\\Users\\Administrator\\Documents\\Game Folder\\clover-removebg-preview.png")
//			.toUri().toString());
//	Image img5 = new Image(Paths.get("C:\\Users\\Administrator\\Documents\\Game Folder\\images-removebg-preview.png")
//			.toUri().toString());
//	Image img6 = new Image(
//			Paths.get("C:\\Users\\Administrator\\Documents\\Game Folder\\sam-removebg-preview.png").toUri().toString());
//	Image img7 = new Image(Paths.get(
//			"C:\\Users\\Administrator\\Documents\\Game Folder\\st_small_845x845-pad_1000x1000_f8f8f8.u2-removebg-preview.png")
//			.toUri().toString());
//	Image img8 = new Image(Paths.get(
//			"C:\\Users\\Administrator\\Documents\\Game Folder\\st_small_845x845-pad_1000x1000_f8f8f8.u4-removebg-preview.png")
//			.toUri().toString());

//	ImageView view1 = new ImageView(img1);
//
//	ImageView view2 = new ImageView(img2);
//	ImageView view3 = new ImageView(img3);
//	ImageView view4 = new ImageView(img4);
//	ImageView view5 = new ImageView(img5);
//	ImageView view6 = new ImageView(img6);
//	ImageView view7 = new ImageView(img7);
//	ImageView view8 = new ImageView(img8);

	// Button b1 = new Button("Bingoo");
	static Stage stage;
	public static cellBox[][] boxes = new cellBox[15][15];

	public gameview(Stage stage, Scene scene) throws IOException {
//Control.music();
		AnchorPane lost =new AnchorPane();
		lost.getChildren().add(mediaView3);
		AnchorPane.setTopAnchor(mediaView3,0.0);
		AnchorPane.setLeftAnchor(mediaView3,0.0);
		AnchorPane.setRightAnchor(mediaView3,0.0);
		AnchorPane.setBottomAnchor(mediaView3,0.0);
		mediaView3.fitWidthProperty().bind(stage.widthProperty());
		mediaView3.fitHeightProperty().bind(stage.heightProperty()); 
		mediaPlayer3.setOnEndOfMedia(()->
		stage.close());
		AnchorPane win =new AnchorPane();
		win.getChildren().add(mediaView4);
		AnchorPane.setTopAnchor(mediaView4,0.0);
		AnchorPane.setLeftAnchor(mediaView4,0.0);
		AnchorPane.setRightAnchor(mediaView4,0.0);
		AnchorPane.setBottomAnchor(mediaView4,0.0);
		mediaView4.fitWidthProperty().bind(stage.widthProperty());
		mediaView4.fitHeightProperty().bind(stage.heightProperty()); 
		mediaPlayer4.setOnEndOfMedia(()->
		stage.close());
		SelectedHero.setTarget(SelectedHero);
		VBox Attack = new VBox(20);
		VBox Cure = new VBox();
		VBox Heal = new VBox();

		Label Curel = new Label("Cure");
		Label Heall = new Label("Heal");
		VBox Actions = new VBox();

		Cure.getChildren().add(Curel);
		Heal.getChildren().add(Heall);
		Actions.getChildren().add(Attack);
		Attack.setStyle("-fx-font: 40px \"" + Pick_Hero.fraktur.getName()
				+ "\" ;-fx-shape: \"M0,0 L150,0 L112.5,50 L37.5,50 Z\"; -fx-background-color: transparent; -fx-text-fill: Black;");
		Attack.setOnMouseExited(e -> Attack.setBorder(null));
		Attack.setOnMouseEntered(e -> Attack.setStyle(Pick_Hero.cssBordering));
//      Curel.setStyle ("-fx-font: 30px \"" + Pick_Hero.fraktur.getName() + "\" ;-fx-shape: \"M0,0 L150,0 L112.5,50 L37.5,50 Z\"; -fx-background-color: transparent; -fx-text-fill: Black;");
//      Cure.setOnMouseExited(e -> Cure.setStyle("-fx-font: 30px \"" + Pick_Hero.fraktur.getName() + "\" ;-fx-shape: \"M0,0 L150,0 L112.5,50 L37.5,50 Z\"; -fx-background-color:transparent; -fx-text-fill: White;"));
//	 Cure.setOnMouseEntered(e -> Cure.setStyle("-fx-font: 30px \"" + Pick_Hero.fraktur.getName() + "\";-fx-shape: \"M0,0 L150,0 L112.5,50 L37.5,50 Z\"; -fx-background-color: black; -fx-text-fill: white;"));
// 	Heall.setStyle ("-fx-font: 30px \"" + Pick_Hero.fraktur.getName() + "\" ;-fx-shape: \"M0,0 L150,0 L112.5,50 L37.5,50 Z\"; -fx-background-color: transparent; -fx-text-fill: Black;");
//	 Heal.setOnMouseExited(e -> Heal.setStyle("-fx-font: 30px \"" + Pick_Hero.fraktur.getName() + "\" ;-fx-shape: \"M0,0 L150,0 L112.5,50 L37.5,50 Z\"; -fx-background-color:transparent; -fx-text-fill: White;"));
//	 Heal.setOnMouseEntered(e -> Heal.setStyle("-fx-font: 30px \"" + Pick_Hero.fraktur.getName() + "\";-fx-shape: \"M0,0 L150,0 L112.5,50 L37.5,50 Z\"; -fx-background-color: black; -fx-text-fill: white;"));	

		BackgroundFill fill = new BackgroundFill(Color.rgb(0, 0, 0, 0.5), null, null); // black with 50% opacity
		Background background1 = new Background(fill);
		// Actions.setBackground(background1);
		// Attack.setStyle("-fx-font: 30px \"" + Pick_Hero.fraktur.getName() + "\"
		// ;-fx-shape: \"M0,0 L150,0 L112.5,50 L37.5,50 Z\"; -fx-text-fill: White;");
		// Cure.setStyle("-fx-font: 30px \"" + Pick_Hero.fraktur.getName() + "\"
		// ;-fx-shape: \"M0,0 L150,0 L112.5,50 L37.5,50 Z\"; -fx-text-fill: White;");
		// Heal.setStyle("-fx-font: 30px \"" + Pick_Hero.fraktur.getName() + "\"
		// ;-fx-shape: \"M0,0 L150,0 L112.5,50 L37.5,50 Z\"; -fx-text-fill: White;");

		GridPane grid = new GridPane();

		Label[][] labels = new Label[15][15];
		Image image = new Image("WhatsApp Image 2023-05-21 at 7.55.33 PM.jpeg");
		BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				new BackgroundSize(100, 100, true, true, true, true));
		Background background = new Background(backgroundImage);

		border.setBackground(background);

		AnchorPane.setTopAnchor(border, 0.0);
		AnchorPane.setBottomAnchor(border, 0.0);
		AnchorPane.setLeftAnchor(border, 0.0);
		AnchorPane.setRightAnchor(border, 0.0);
		Actions.setVisible(true);
		// border.getChildren().add(Actions);

		AnchorPane.setTopAnchor(AlertBox.sp1, 00d);
		AnchorPane.setLeftAnchor(AlertBox.sp1, 00d);
//         AnchorPane.setBottomAnchor(AlertBox.sp1, 0.0);
//         AnchorPane.setRightAnchor(AlertBox.sp1, 0.0);

		AnchorPane.setRightAnchor(Actions, 10.0);
		AnchorPane.setTopAnchor(Actions, 10.0);

		VBox attack = new VBox();
		VBox usespecial = new VBox();
		VBox use = new VBox();
		VBox endturn = new VBox();
		VBox cure = new VBox();
		VBox heal = new VBox();
		Button endturnb = new Button("End Turn");
		Button attackb = new Button("Attack");
		Button usespecialb = new Button("use Special");
		Button cureb = new Button("cure");
		Button healb = new Button("Heal");
		Button helpb = new Button("Help");
		VBox help=new VBox();
		helpb.setPrefWidth(200);
		helpb.setPrefHeight(20);
		helpb.setFont(Pick_Hero.fraktur);
		helpb.setStyle("-fx-font: 30px \"" + Pick_Hero.fraktur.getName() + "\" ;-fx-shape: \"M0,0 L100,0 L75,33 L25,33 Z\"; -fx-background-color:transparent; -fx-text-fill: black;");
		helpb.setOnMouseExited(e -> {
			
			helpb.setStyle("-fx-font: 30px \"" + Pick_Hero.fraktur.getName() + "\" ;-fx-shape: \"M0,0 L100,0 L75,33 L25,33 Z\"; -fx-background-color:transparent; -fx-text-fill: White;");
			
			});
			helpb.setOnMouseEntered(e -> {
				
			helpb.setStyle("-fx-font: 30px \"" + Pick_Hero.fraktur.getName() + "\";-fx-shape: \"M0,0 L100,0 L75,33 L25,33 Z\"; -fx-background-color: black; -fx-text-fill: white;");
			
			
			});
			
			helpb.setMinSize(150, 50);
			helpb.setMaxSize(150, 50);
			help.getChildren().add(helpb);
			

			// create a trapezium shape with four points
			
			
			helpb.setOnMouseClicked(e ->{
			if(!isAlert) {	
				AlertBox ab=new AlertBox("Press 'space bar' to attack"+System.lineSeparator ()+"Press 'u' to usespecial"+System.lineSeparator ()+"Press 'c' to cure"
						+System.lineSeparator ()+"Press 'e' to end turn"+System.lineSeparator ()+"Use the arrows in the keyboard to move");
				isAlert = true;}});
			
		endturnb.setVisible(false);
		attackb.setVisible(false);
		usespecialb.setVisible(false);
		cureb.setVisible(false);
		healb.setVisible(false);
		
		attackb.setStyle(
				"-fx-shape: \"M0,0 L100,0 L75,50 L25,50 Z\"; -fx-background-color: transparent; -fx-text-fill: black;");
		attackb.setOnMouseEntered(e -> attackb.setStyle("-fx-background-color: black; -fx-text-fill: white;"));
		attackb.setOnMouseExited(e -> attackb.setStyle(" -fx-background-color: transparent; -fx-text-fill: black;"));
		attack.getChildren().add(attackb);

		attackb.setStyle("-fx-font-weight: bold;-fx-background-color: black;-fx-font: 15px \""
				+ Pick_Hero.fraktur.getName()
				+ "\" ;-fx-shape: \"M0,0 L150,0 L112.5,50 L37.5,50 Z\"; -fx-background-color: transparent; -fx-text-fill: black;");

		endturnb.setStyle(
				"-fx-shape: \"M0,0 L100,0 L75,50 L25,50 Z\"; -fx-background-color: transparent; -fx-text-fill: black;");
		endturnb.setOnMouseEntered(e -> endturnb.setStyle(" -fx-background-color: black; -fx-text-fill: white;"));
		endturnb.setOnMouseExited(e -> endturnb.setStyle(" -fx-background-color: transparent; -fx-text-fill: black;"));
		endturn.getChildren().add(endturnb);
		cureb.setStyle(
				"-fx-shape: \"M0,0 L100,0 L75,50 L25,50 Z\"; -fx-background-color: transparent; -fx-text-fill: black;");
		cureb.setOnMouseEntered(e -> cureb.setStyle(
				"-fx-shape: \"M0,0 L100,0 L75,50 L25,50 Z\"; -fx-background-color: black; -fx-text-fill: white;"));
		cureb.setOnMouseExited(e -> cureb.setStyle(
				"-fx-shape: \"M0,0 L100,0 L75,50 L25,50 Z\"; -fx-background-color: transparent; -fx-text-fill: black;"));
		cure.getChildren().add(cureb);

		usespecialb.setStyle(
				"-fx-shape: \"M0,0 L100,0 L75,50 L25,50 Z\"; -fx-background-color: transparent; -fx-text-fill: black;");
		usespecialb.setOnMouseEntered(e -> usespecialb.setStyle(
				"-fx-shape: \"M0,0 L100,0 L75,50 L25,50 Z\"; -fx-background-color: black; -fx-text-fill: white;"));
		usespecialb.setOnMouseExited(e -> usespecialb.setStyle(
				"-fx-shape: \"M0,0 L100,0 L75,50 L25,50 Z\"; -fx-background-color: transparent; -fx-text-fill: black;"));
		usespecial.getChildren().add(usespecialb);
		
		scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
			final KeyCombination keyComb = new KeyCodeCombination(KeyCode.U);

			public void handle(KeyEvent ke) {
				if (keyComb.match(ke)) {
					try {removeclicked();
						SelectedHero.useSpecial();
						heroesdetails h1 = new heroesdetails();
						allstuff.getChildren().clear();
						allstuff.getChildren().add(h1.allheroes);
						removeimages();
						showimages();

					} catch (NoAvailableResourcesException | InvalidTargetException e1) {
						// TODO Auto-generated catch block
						// e1.printStackTrace();
						AlertBox ab=new AlertBox(e1.getMessage());
					}
//					 ke.consume(); // stops passing the event to next node
				}
			}
		});
		usespecialb.setOnMouseClicked(e -> {
			try {
				SelectedHero.useSpecial();
				heroesdetails h1 = new heroesdetails();
				allstuff.getChildren().clear();
				allstuff.getChildren().add(h1.allheroes);
				removeimages();
				showimages();

			} catch (NoAvailableResourcesException | InvalidTargetException e1) {
				// TODO Auto-generated catch block
				// e1.printStackTrace();
				AlertBox ab=new AlertBox(e1.getMessage());
			}
		});
		//1
		
		scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
			final KeyCombination keyComb = new KeyCodeCombination(KeyCode.SPACE);

			public void handle(KeyEvent ke) {
				if (keyComb.match(ke)) {
					try {
						SelectedHero.attack();
						removeclicked();
						Game.adjustVisibility(SelectedHero);

						heroesdetails h1 = new heroesdetails();
						allstuff.getChildren().clear();
						allstuff.getChildren().add(h1.allheroes);

						SelectedHero.setTarget(null);

						removeimages();
						showimages();

					} catch (NotEnoughActionsException | InvalidTargetException e1) {
						if(!isAlert) {	
							AlertBox ab=new AlertBox(e1.getMessage());
							isAlert = true;
						}
						// TODO Auto-generated catch block
						// e1.printStackTrace();
					}
//					 ke.consume(); // stops passing the event to next node
				}
			}
		});
		
		//2
		attackb.setOnMouseClicked(e -> {
			try {
				SelectedHero.attack();

				Game.adjustVisibility(SelectedHero);

				heroesdetails h1 = new heroesdetails();
				allstuff.getChildren().clear();
				allstuff.getChildren().add(h1.allheroes);

				SelectedHero.setTarget(null);

				removeimages();
				showimages();

			} catch (NotEnoughActionsException | InvalidTargetException e1) {
				AlertBox ab=new AlertBox(e1.getMessage());
				// TODO Auto-generated catch block
				// e1.printStackTrace();
			}
		});
		scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
			final KeyCombination keyComb = new KeyCodeCombination(KeyCode.C);

			public void handle(KeyEvent ke) {
				if (keyComb.match(ke)) {
					try {
						removeclicked();
						SelectedHero.cure();
						if (Game.checkWin())
                        {
                        	scene.setRoot(win);
                        	mediaPlayer4.play();
                        	
                        }
						heroesdetails h1 = new heroesdetails();
						allstuff.getChildren().clear();
						allstuff.getChildren().add(h1.allheroes);
						removeimages();
						showimages();
					} catch (NoAvailableResourcesException | InvalidTargetException | NotEnoughActionsException e1) {
						AlertBox ab=new AlertBox(e1.getMessage());
						// TODO Auto-generated catch block
						// e1.printStackTrace();
					}
//					 ke.consume(); // stops passing the event to next node
				}
			}
		});
		cureb.setOnMouseClicked(e -> {

			try {

				SelectedHero.cure();
				heroesdetails h1 = new heroesdetails();
				allstuff.getChildren().clear();
				allstuff.getChildren().add(h1.allheroes);
				removeimages();
				showimages();
			} catch (NoAvailableResourcesException | InvalidTargetException | NotEnoughActionsException e1) {
				AlertBox ab=new AlertBox(e1.getMessage());
				// TODO Auto-generated catch block
				// e1.printStackTrace();
			}

		});
		scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
			final KeyCombination keyComb = new KeyCodeCombination(KeyCode.E);

			public void handle(KeyEvent ke) {
				if (keyComb.match(ke)) {
					try {
						Game.endTurn();
						removeclicked();
						if (Game.checkGameOver())
                        {
                        	scene.setRoot(lost);
                        	mediaPlayer3.play();
                        	
                        }
						heroesdetails h1 = new heroesdetails();
						allstuff.getChildren().clear();
						allstuff.getChildren().add(h1.allheroes);
						removeimages();
						showimages();
					} catch (NotEnoughActionsException | InvalidTargetException e1) {
						AlertBox ab=new AlertBox(e1.getMessage());
						// TODO Auto-generated catch block
						// e1.printStackTrace();
					}
//					 ke.consume(); // stops passing the event to next node
				}
			}
		});
		endturnb.setOnMouseClicked(e -> {
			try {
				Game.endTurn();

				heroesdetails h1 = new heroesdetails();
				allstuff.getChildren().clear();
				allstuff.getChildren().add(h1.allheroes);
				removeimages();
				showimages();
			} catch (NotEnoughActionsException | InvalidTargetException e1) {
				AlertBox ab=new AlertBox(e1.getMessage());
				// TODO Auto-generated catch block
				// e1.printStackTrace();
			}
		});
		scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
			final KeyCombination keyComb = new KeyCodeCombination(KeyCode.H);

			public void handle(KeyEvent ke) {
				if (keyComb.match(ke)) {
					if (SelectedHero instanceof Medic && SelectedHero.isSpecialAction()) {
						try {
							removeclicked();
							SelectedHero.useSpecial();
						} catch (NoAvailableResourcesException | InvalidTargetException e1) {
							// TODO Auto-generated catch block

						}
					}
//					 ke.consume(); // stops passing the event to next node
				}
			}
		});
		healb.setOnMouseClicked(e -> {
			if (SelectedHero instanceof Medic && SelectedHero.isSpecialAction()) {
				try {
					
					SelectedHero.useSpecial();
				} catch (NoAvailableResourcesException | InvalidTargetException e1) {
					// TODO Auto-generated catch block

				}
			}
		});

		sp.getChildren().addAll(border, help);
		AnchorPane.setBottomAnchor(help,10.0);
		AnchorPane.setLeftAnchor(help,10.0);
		
		 AnchorPane.setTopAnchor(AlertBox.sp1, 00d);
		    AnchorPane.setRightAnchor(AlertBox.sp1, 00d);
		    AnchorPane.setTopAnchor(AlertBox.sp1, 00d);
		    AnchorPane.setBottomAnchor(AlertBox.sp1, 00d);
		    
		scene.setRoot(sp);

		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				boxes[i][j] = new cellBox();
				boxes[i][j].Location = new Point(i, j);
				GridPane.setConstraints(boxes[i][j], j, i);
				grid.getChildren().add(boxes[i][j]);
			}
		}

		// showimages();

		heroesdetails h = new heroesdetails();

		grid.setAlignment(Pos.CENTER);
		// VBox allstuff= new VBox();
		allstuff.getChildren().add(h.allheroes);
		
//		allstuff.setMinWidth(200);allstuff.setMaxWidth(200);
		
		border.setLeft(allstuff);
		border.setRight(grid);

		showimages();
		// 1

		

		// 2
		
		scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
			final KeyCombination keyComb = new KeyCodeCombination(KeyCode.UP);

			public void handle(KeyEvent ke) {
				if (keyComb.match(ke)) {
					try {removeclicked();
					
						SelectedHero.move(Direction.UP);

						removeimages();
						if (Game.checkGameOver())
                        {
                        	scene.setRoot(lost);
                        	mediaPlayer3.play();
                        	
                        }
        					zombieadjacent();
						heroesdetails h1 = new heroesdetails();
						allstuff.getChildren().clear();
						allstuff.getChildren().add(h1.allheroes);
						showimages();
					} catch (MovementException | NotEnoughActionsException e1) {
						if(!isAlert) {	
							AlertBox ab=new AlertBox(e1.getMessage());
							isAlert = true;
						}
					}
					// ke.consume(); // stops passing the event to next node
				}
			}
		});
		scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
			final KeyCombination keyComb = new KeyCodeCombination(KeyCode.RIGHT);

			public void handle(KeyEvent ke) {
				if (keyComb.match(ke)) {
					try {removeclicked();
						SelectedHero.move(Direction.RIGHT);
						removeimages();
						if (Game.checkGameOver())
                        {
                        	scene.setRoot(lost);
                        	mediaPlayer3.play();
                        	
                        }
						heroesdetails h1 = new heroesdetails();
						allstuff.getChildren().clear();
						allstuff.getChildren().add(h1.allheroes);
						showimages();
      					zombieadjacent();
					} catch (MovementException | NotEnoughActionsException e1) {
						if(!isAlert) {	
							AlertBox ab=new AlertBox(e1.getMessage());
							isAlert = true;
						}
					}
					// ke.consume(); // stops passing the event to next node
				}
			}
		});
		scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
			final KeyCombination keyComb = new KeyCodeCombination(KeyCode.DOWN);

			public void handle(KeyEvent ke) {
				if (keyComb.match(ke)) {
					try {removeclicked();
						SelectedHero.move(Direction.DOWN);
						removeimages();
                        if (Game.checkGameOver())
                        {
                        	scene.setRoot(lost);
                        	mediaPlayer3.play();
                        	
                        }
						heroesdetails h1 = new heroesdetails();
						allstuff.getChildren().clear();
						allstuff.getChildren().add(h1.allheroes);
						showimages();
      					zombieadjacent();
					} catch (MovementException | NotEnoughActionsException e1) {
						if(!isAlert) {	
							AlertBox ab=new AlertBox(e1.getMessage());
							isAlert = true;
						}
					}
					// ke.consume(); // stops passing the event to next node
				}
			}
		});
		scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
			final KeyCombination keyComb = new KeyCodeCombination(KeyCode.LEFT);

			public void handle(KeyEvent ke) {
				if (keyComb.match(ke)) {
					try {removeclicked();
						SelectedHero.move(Direction.LEFT);
						removeimages();
						if (Game.checkGameOver())
                        {
                        	scene.setRoot(lost);
                        	mediaPlayer3.play();
                        	
                        }
						heroesdetails h1 = new heroesdetails();
						allstuff.getChildren().clear();
						allstuff.getChildren().add(h1.allheroes);
						showimages();
      					zombieadjacent();
					} catch (MovementException | NotEnoughActionsException e1) {
						if(!isAlert) {	
							AlertBox ab=new AlertBox(e1.getMessage());
							isAlert = true;
						}
					}
					// ke.consume(); // stops passing the event to next node
				}
			}
		});
		// grid.setStyle("-fx-background-color: transparent" );
		// Scene scene = new Scene(border,500,300);
		stage.setScene(scene);
		stage.setFullScreen(true);

		stage.show();

	}

	public static void showimages() {

		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {

				if ((Game.map[i][j] instanceof CharacterCell
						&& ((CharacterCell) Game.map[i][j]).getCharacter() != null)) {
					if (((CharacterCell) Game.map[i][j]).getCharacter() instanceof Hero) {
						String s = ((CharacterCell) Game.map[i][j]).getCharacter().getName();
						// System.out.println(s);
						int u = Pick_Hero.names.indexOf(s);
						// System.out.println(Pick_Hero.names.toString());
//         		for(int k=0;k<Pick_Hero.names.size();k++) {
//         			System.out.println("here" +Pick_Hero.names.get(k));

//         		}

						ImageView newview1 = new ImageView(Pick_Hero.images[u]);
						newview1.setFitHeight(50);
						newview1.setTranslateX(10);
						newview1.setFitWidth(50);
						boxes[14 - i][j].character = ((CharacterCell) Game.map[i][j]).getCharacter();
                        
						boxes[14 - i][j].getChildren().add(newview1);

						// if (this.getLocation().x==14)
					} else {
						if (((CharacterCell) Game.map[i][j]).isVisible()) {
							ImageView newview1 = new ImageView(Pick_Hero.ZombZomb);
							newview1.setFitHeight(50);
							newview1.setTranslateX(10);
							newview1.setFitWidth(50);
							boxes[14 - i][j].character = ((CharacterCell) Game.map[i][j]).getCharacter();
							
							boxes[14 - i][j].getChildren().add(newview1);

						}

					}

				} else if ((Game.map[i][j] instanceof CharacterCell
						&& ((CharacterCell) Game.map[i][j]).getCharacter() == null)) {
					boxes[14 - i][j].character = null;
//					boxes[14 - i][j].setGraphic(null);
				} else if ((Game.map[i][j] instanceof CollectibleCell) && Game.map[i][j].isVisible()) {
					if (((CollectibleCell) Game.map[i][j]).getCollectible() instanceof Supply) {
						ImageView newview1 = new ImageView(Pick_Hero.supplo);
						newview1.setFitHeight(50);
						newview1.setTranslateX(10);
						newview1.setFitWidth(50);

						boxes[14 - i][j].getChildren().add(newview1);
					}

					else {

						ImageView newview1 = new ImageView(Pick_Hero.vacco);
						newview1.setFitHeight(50);
						newview1.setTranslateX(10);
						newview1.setFitWidth(50);

						boxes[14 - i][j].getChildren().add(newview1);

					}
				}
				if (!Game.map[i][j].isVisible() ) {
					ImageView newview1 = new ImageView(Pick_Hero.Visible);
					newview1.setFitHeight(50);
					//newview1.setTranslateX(10);
					newview1.setFitWidth(72);

					boxes[14 - i][j].getChildren().add(newview1);

				}

			}
		}
	}

	public static void removeimages() {

		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				boxes[i][j].getChildren().clear();
			}
		}
	}

	public static void main(String[] args) {

	}

	@Override
	public void handle(MouseEvent mouseEvent) {

	}
	public static void removeclicked() {
		for(int i=0;i<15;i++)
			for(int j=0;j<15;j++)
				boxes[i][j].setStyle(cellBox.cssBordering);
		
	}
 public void zombieadjacent() {
	 for(int i=0;i<Game.zombies.size();i++) {
		 SelectedHero.setTarget(Game.zombies.get(i));
		 if(SelectedHero.checkDistance())
		 {
			 mediaPlayer = new MediaPlayer(h);
				mediaPlayer.play();
				SelectedHero.setTarget(SelectedHero);
				return;
		 }
	 }
 }	
 public static void trapis() {
	 mediaPlayer2=new MediaPlayer(h1);
	 Control.mediaPlayer.stop();
	 mediaPlayer2.play();
	 mediaPlayer2.setOnEndOfMedia(()->
	 Control.music()
			 );
 }
}

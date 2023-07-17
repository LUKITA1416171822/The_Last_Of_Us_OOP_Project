package Views;

import javafx.application.Application;
import javafx.beans.binding.When;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import engine.Game;

//
public class Pick_Hero extends Application {
   static Stage stage;
   public static Font fraktur = Font.loadFont (Pick_Hero.class.getResourceAsStream ("GRUDBLIT.TTF"), 40);
	public static String cssBordering = "-fx-border-color:darkblue ; \n" //#090a0c
         + "-fx-border-insets:3;\n"
         + "-fx-border-radius:7;\n"
         + "-fx-border-width:1.0";
 GridPane grid;
 Scene scene;
 static Image img3 = new Image ("sam-removebg-preview (1).png");
 static  Image img4 = new Image ("alex-removebg-preview (1).png");
 static Image img1 = new Image ("al-mo3allem-rashdan-removebg-preview.png");
 static Image img5 = new Image ("aps-504x498-small-transparent-pad-600x600-f8f8f8.u3-removebg-preview.png");
 static Image img2 = new Image ("clover-removebg-preview (1).png");
 static Image img6 = new Image ("Don.png");
 static Image img7 = new Image ("st-small-845x845-pad-1000x1000-f8f8f8.u2-removebg-preview.png");
 static Image img8 = new Image ("st-small-845x845-pad-1000x1000-f8f8f8.u4-removebg-preview.png");
 static Image supplo= new Image("Screenshot_20230519_160944_Google.jpg");
 static Image vacco= new Image("Screenshot_20230519_161806_Brave.jpg");
// static Image NotVisible= new Image("super-mario-3d-world-super-mario-bros-super-mario-64-mario-bros-removebg-preview.png");
 static Image Visible= new Image("super-mario-3d-world-super-mario-bros-super-mario-64-mario-bros-removebg-preview.png");
 
 static Image ZombZomb= new Image("fx5wdzmuxeh21-removebg-preview.png");
// heropackage hero1=new heropackage(img3)
 static ImageView view1 = new ImageView(img1);
 static ImageView view2 = new ImageView(img2);
 static ImageView view3 = new ImageView(img3);
 static ImageView view4 = new ImageView(img4);
 static ImageView view5 = new ImageView(img5);
 static ImageView view6 = new ImageView(img6);
 static ImageView view7 = new ImageView(img7);
 static ImageView view8 = new ImageView(img8);
// static ImageView newview1 = new ImageView(img1);
// static ImageView newview2 = new ImageView(img2);
// static ImageView newview3 = new ImageView(img3);
// static ImageView newview4 = new ImageView(img4);
// static ImageView newview5 = new ImageView(img5);
// static ImageView newview6 = new ImageView(img6);
// static ImageView newview7 = new ImageView(img7);
// static ImageView newview8 = new ImageView(img8);
 

 static Image [] images= {img1,img2,img3,img4,img5,img6,img7,img8};
 //Image img = new Image (Paths.get("C:\\Users\\Administrator\\Documents\\Game Folder\\Zombies.png.jpg").toUri().toString());

 //ImageView view = new ImageView(img);
 Button b1 = new Button("Bingoo");
 Button b2 = new Button("Button B");
 Button b3 = new Button("Button C");
 Button b4 = new Button("Button D");
 Button b5 = new Button("Button E");
 Button b6 = new Button("Button F");
 Button b7 = new Button("Button G");
 Button b8 = new Button("Button H");

 Circle c1 = new Circle(30);
 Circle c2 = new Circle(30);
 Circle c3 = new Circle(30);
 Circle c4 = new Circle(30);
 Circle c5 = new Circle(30);
 Circle c6 = new Circle(30);
 Circle c7 = new Circle(30);
 Circle c8 = new Circle(30);

 Label l1 = new Label("Fighter");
 Label l2 = new Label("Medic");
 Label l3 = new Label("Explorer");
 Label l4 = new Label("Explorer");
 Label l5 = new Label("Explorer");
 Label l6 = new Label("Medic");
 Label l7 = new Label("Fighter");
 Label l8 = new Label("Medic");
 
 VBox vbox1 = new VBox(20);
 VBox vbox2 = new VBox(20);
 VBox vbox3 = new VBox(20);
 VBox vbox4 = new VBox(20);
 VBox vbox5 = new VBox(20);
 VBox vbox6 = new VBox(20);
 VBox vbox7 = new VBox(20);
 VBox vbox8 = new VBox(20);
 VBox vBox11 = new VBox();
 VBox vBox12 = new VBox();
 VBox vBox13 = new VBox();
 VBox vBox14 = new VBox();
 VBox vBox15 = new VBox();
 VBox vBox16 = new VBox();
 VBox vBox17 = new VBox();
 VBox vBox18 = new VBox();
 VBox vboxt1 = new VBox(20);
 VBox vboxt2 = new VBox(20);
 VBox vboxt3 = new VBox(20);
 VBox vboxt4 = new VBox(20);
 VBox vboxt5 = new VBox(20);
 VBox vboxt6 = new VBox(20);
 VBox vboxt7 = new VBox(20);
 VBox vboxt8 = new VBox(20);
 
 static ArrayList <String> names=new ArrayList<>();
 
 
 public Pick_Hero(Stage star,Scene scene) {
	 Border border = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.FULL));
	 
	 vboxt1.setBorder(border);
	 vboxt2.setBorder(border);
	 vboxt3.setBorder(border);
	 vboxt4.setBorder(border);
	 vboxt5.setBorder(border);
	 vboxt6.setBorder(border);
	 vboxt7.setBorder(border);
	 vboxt8.setBorder(border);
	 
	 try {
		 Game.loadHeroes("src\\Heroes.csv");
		 for(int i=0;i<Game.availableHeroes.size();i++) {
				names.add(Game.availableHeroes.get(i).getName());
				//System.out.println(Game.heroes.get(i).getName());
			}
		 } catch (IOException e1) {
	// TODO Auto-generated catch block
	//e1.printStackTrace();
	
	
	
	
}
     VBox vbox = new VBox(20);
//     view1.setFitHeight(view8.getFitHeight());
//     view1.setFitWidth(view8.getFitWidth());
//     view2.setFitHeight(view8.getFitHeight());
//     view2.setFitWidth(view8.getFitWidth());
//     view3.setFitHeight(view8.getFitHeight());
//     view3.setFitWidth(view8.getFitWidth());
//     view4.setFitHeight(view8.getFitHeight());
//     view4.setFitWidth(view8.getFitWidth());
//     view5.setFitHeight(view8.getFitHeight());
//     view5.setFitWidth(view8.getFitWidth());
//     view6.setFitHeight(view8.getFitHeight());
//     view6.setFitWidth(view8.getFitWidth());
//     view7.setFitHeight(view8.getFitHeight());
//     view7.setFitWidth(view8.getFitWidth());
    

     HBox hbox = new HBox(20);
     HBox hbox2 = new HBox(20);




     c1.setStroke(Color.RED);

     vbox1.getChildren().addAll(view1);
     vbox2.getChildren().addAll(view2);
     vbox3.getChildren().addAll(view3);
     vbox4.getChildren().addAll(view4);
     vbox5.getChildren().addAll(view5);
     vbox6.getChildren().addAll(view6);
     vbox7.getChildren().addAll(view7);
     vbox8.getChildren().addAll(view8);
     Font fraktur = Font.loadFont(getClass().getResourceAsStream("GRUDBLIT.TTF"),40);
//     vbox1.setStyle("-fx-background-color: black;");
//     vbox2.setStyle("-fx-background-color: black;");
//     vbox3.setStyle("-fx-background-color: black;");
//     vbox4.setStyle("-fx-background-color: black;");
//     vbox5.setStyle("-fx-background-color: black;");
//     vbox6.setStyle("-fx-background-color: black;");
//     vbox7.setStyle("-fx-background-color: black;");
//     vbox8.setStyle("-fx-background-color: black;");
//     vbox.setStyle("-fx-background-color: black;");
//     l1.setFont(fraktur);
//     l2.setFont(fraktur);
//     l3.setFont(fraktur);
//     l4.setFont(fraktur);
//     l5.setFont(fraktur);
//     l6.setFont(fraktur);
//     l7.setFont(fraktur);
//     l8.setFont(fraktur);
//     l1.setStyle("-fx-font-weight: bold;-fx-background-color: black;-fx-shape: \"M0,0 L150,0 L112.5,50 L37.5,50 Z\"; -fx-background-color: transparent; -fx-text-fill: Black;");
//     l2.setStyle("-fx-font-weight: bold;-fx-background-color: black;-fx-shape: \"M0,0 L150,0 L112.5,50 L37.5,50 Z\"; -fx-background-color: transparent; -fx-text-fill: Black;");
//     l3.setStyle("-fx-font-weight: bold;-fx-background-color: black;-fx-shape: \"M0,0 L150,0 L112.5,50 L37.5,50 Z\"; -fx-background-color: transparent; -fx-text-fill: Black;");
//     l4.setStyle("-fx-font-weight: bold;-fx-background-color: black;-fx-shape: \"M0,0 L150,0 L112.5,50 L37.5,50 Z\"; -fx-background-color: transparent; -fx-text-fill: Black;");
//     l5.setStyle("-fx-font-weight: bold;-fx-background-color: black;-fx-shape: \"M0,0 L150,0 L112.5,50 L37.5,50 Z\"; -fx-background-color: transparent; -fx-text-fill: Black;");
//     l6.setStyle("-fx-font-weight: bold;-fx-background-color: black;-fx-shape: \"M0,0 L150,0 L112.5,50 L37.5,50 Z\"; -fx-background-color: transparent; -fx-text-fill: Black;");
//     l7.setStyle("-fx-font-weight: bold;-fx-background-color: black;-fx-shape: \"M0,0 L150,0 L112.5,50 L37.5,50 Z\"; -fx-background-color: transparent; -fx-text-fill: Black;");
//     l8.setStyle("-fx-font-weight: bold;-fx-background-color: black;-fx-shape: \"M0,0 L150,0 L112.5,50 L37.5,50 Z\"; -fx-background-color: transparent; -fx-text-fill: Black;");
     
     vbox1.setAlignment(Pos.CENTER);
     vbox2.setAlignment(Pos.CENTER);
     vbox3.setAlignment(Pos.CENTER);
     vbox4.setAlignment(Pos.CENTER);
     vbox5.setAlignment(Pos.CENTER);
     vbox6.setAlignment(Pos.CENTER);
     vbox7.setAlignment(Pos.CENTER);
     vbox8.setAlignment(Pos.CENTER);
    


     hbox.getChildren().addAll(vbox1,vbox2,vbox3,vbox4);
     hbox2.getChildren().addAll(vbox5,vbox6,vbox7,vbox8);

     hbox.setAlignment(Pos.CENTER);
     hbox2.setAlignment(Pos.CENTER);

     vbox.setAlignment(Pos.CENTER);

     vbox.getChildren().addAll(hbox,hbox2);




     //Background background = new Background()


     view1.setFitHeight(200);
     view1.setFitWidth(200);
     view2.setFitHeight(200);
     view2.setFitWidth(200);
     view3.setFitHeight(200);
     view3.setFitWidth(200);
     view4.setFitHeight(200);
     view4.setFitWidth(200);
     view5.setFitHeight(200);
     view5.setFitWidth(200);
     view6.setFitHeight(200);
     view6.setFitWidth(200);
     view7.setFitHeight(200);
     view7.setFitWidth(200);
     view8.setFitHeight(200);
     view8.setFitWidth(200);
     //view.setFitHeight(1000);
     //view.setFitWidth(2000);

   
     AnchorPane pane = new AnchorPane(vbox);
     Label Hero1 = new Label("Name: "+Game.availableHeroes.get(0).getName()+System.lineSeparator ()+"MaxHp: "+Game.availableHeroes.get(0).getMaxHp()+System.lineSeparator ()+
    	"ActionsAvailable: "+	 Game.availableHeroes.get(0).getActionsAvailable() + System.lineSeparator ()+"AttackDmg: "+Game.availableHeroes.get(0).getAttackDmg()+System.lineSeparator ()+"Type: Fighter");
//     Label maxHp1 = new Label("Max HP = 140");
//     Label actions1 = new Label("Actions Available = 5");
//     Label damage1 = new Label("Attack Damage = 30");
     Image img11 = img1;
     ImageView view11 = new ImageView(img11);
     vBox11.getChildren().add(view11);
     vboxt1.getChildren().add(Hero1);
     Hero1.setFont(fraktur);
      Hero1.setStyle("-fx-font-weight: bold;-fx-background-color: black;-fx-shape: \"M0,0 L150,0 L112.5,50 L37.5,50 Z\"; -fx-background-color: transparent; -fx-text-fill: White;");
    
    
    
    
     Label Hero2 = new Label("Name: "+Game.availableHeroes.get(1).getName()+System.lineSeparator ()+"MaxHp: "+Game.availableHeroes.get(1).getMaxHp()+System.lineSeparator ()+
    	    	"ActionsAvailable: "+	 Game.availableHeroes.get(1).getActionsAvailable() + System.lineSeparator ()+"AttackDmg: "+Game.availableHeroes.get(1).getAttackDmg()+System.lineSeparator ()+"Type: Medic");
     Image img22 = img2;
     ImageView view22 = new ImageView(img22);
     vBox12.getChildren().add(view22);
     vboxt2.getChildren().add(Hero2);
     Label Hero3 = new Label("Name: "+Game.availableHeroes.get(2).getName()+System.lineSeparator ()+"MaxHp: "+Game.availableHeroes.get(2).getMaxHp()+System.lineSeparator ()+
    	    	"ActionsAvailable: "+	 Game.availableHeroes.get(2).getActionsAvailable() + System.lineSeparator ()+"AttackDmg: "+Game.availableHeroes.get(2).getAttackDmg()+System.lineSeparator ()+"Type: Explorer");
     Image img33 = img3;
     ImageView view33 = new ImageView(img33);
     vBox13.getChildren().addAll(view33);
     vboxt3.getChildren().add(Hero3);
     Label Hero4 = new Label("Name: "+Game.availableHeroes.get(3).getName()+System.lineSeparator ()+"MaxHp: "+Game.availableHeroes.get(3).getMaxHp()+System.lineSeparator ()+
    	    	"ActionsAvailable: "+	 Game.availableHeroes.get(3).getActionsAvailable() + System.lineSeparator ()+"AttackDmg: "+Game.availableHeroes.get(3).getAttackDmg()+System.lineSeparator ()+"Type: Explorer");
     Image img44 = img4;
     ImageView view44 = new ImageView(img44);
     vBox14.getChildren().addAll(view44);
     vboxt4.getChildren().add(Hero4);
     Label Hero5 = new Label("Name: "+Game.availableHeroes.get(4).getName()+System.lineSeparator ()+"MaxHp: "+Game.availableHeroes.get(4).getMaxHp()+System.lineSeparator ()+
    	    	"ActionsAvailable: "+	 Game.availableHeroes.get(4).getActionsAvailable() + System.lineSeparator ()+"AttackDmg: "+Game.availableHeroes.get(4).getAttackDmg()+System.lineSeparator ()+"Type: Explorer");
     Image img55 = img5;
     ImageView view55 = new ImageView(img55);
     vBox15.getChildren().addAll(view55);
     vboxt5.getChildren().add(Hero5);
     Label Hero6 = new Label("Name: "+Game.availableHeroes.get(5).getName()+System.lineSeparator ()+"MaxHp: "+Game.availableHeroes.get(5).getMaxHp()+System.lineSeparator ()+
    	    	"ActionsAvailable: "+	 Game.availableHeroes.get(5).getActionsAvailable() + System.lineSeparator ()+"AttackDmg: "+Game.availableHeroes.get(5).getAttackDmg()+System.lineSeparator ()+"Type: Medic");
     Image img66=img6;
     ImageView view66=new ImageView(img66);
     vBox16.getChildren().addAll(view66);
     vboxt6.getChildren().add(Hero6);
     Label Hero7 = new Label("Name: "+Game.availableHeroes.get(6).getName()+System.lineSeparator ()+"MaxHp: "+Game.availableHeroes.get(6).getMaxHp()+System.lineSeparator ()+
    	    	"ActionsAvailable: "+	 Game.availableHeroes.get(6).getActionsAvailable() + System.lineSeparator ()+"AttackDmg: "+Game.availableHeroes.get(6).getAttackDmg()+System.lineSeparator ()+"Type: Fighter");
     Image img77 = img7;
     ImageView view77 = new ImageView(img77);
     vBox17.getChildren().addAll(view77);
     vboxt7.getChildren().add(Hero7);
     Label Hero8 = new Label("Name: "+Game.availableHeroes.get(7).getName()+System.lineSeparator ()+"MaxHp: "+Game.availableHeroes.get(7).getMaxHp()+System.lineSeparator ()+
    	    	"ActionsAvailable: "+	 Game.availableHeroes.get(7).getActionsAvailable() + System.lineSeparator ()+"AttackDmg: "+Game.availableHeroes.get(7).getAttackDmg()+System.lineSeparator ()+"Type: Fighter");
     Image img88 = img8;
     ImageView view88 = new ImageView(img88);
     vBox18.getChildren().addAll(view88);
     vboxt8.getChildren().add(Hero8);
     Hero2.setStyle("-fx-font-weight: bold;-fx-background-color: black;-fx-font: 40px \"" + fraktur.getName() + "\" ;-fx-shape: \"M0,0 L150,0 L112.5,50 L37.5,50 Z\"; -fx-background-color: transparent;  -fx-text-fill: White;");
     Hero3.setStyle("-fx-font-weight: bold;-fx-background-color: black;-fx-font: 40px \"" + fraktur.getName() + "\" ;-fx-shape: \"M0,0 L150,0 L112.5,50 L37.5,50 Z\"; -fx-background-color: transparent; -fx-text-fill: White;");
     Hero4.setStyle("-fx-font-weight: bold;-fx-background-color: black;-fx-font: 40px \"" + fraktur.getName() + "\" ;-fx-shape: \"M0,0 L150,0 L112.5,50 L37.5,50 Z\"; -fx-background-color: transparent; -fx-text-fill: White;");
     Hero5.setStyle("-fx-font-weight: bold;-fx-background-color: black;-fx-font: 40px \"" + fraktur.getName() + "\" ;-fx-shape: \"M0,0 L150,0 L112.5,50 L37.5,50 Z\"; -fx-background-color: transparent; -fx-text-fill: White;");
     Hero6.setStyle("-fx-font-weight: bold;-fx-background-color: black;-fx-font: 40px \"" + fraktur.getName() + "\" ;-fx-shape: \"M0,0 L150,0 L112.5,50 L37.5,50 Z\"; -fx-background-color: transparent; -fx-text-fill: White;");
     Hero7.setStyle("-fx-font-weight: bold;-fx-background-color: black;-fx-font: 40px \"" + fraktur.getName() + "\" ;-fx-shape: \"M0,0 L150,0 L112.5,50 L37.5,50 Z\"; -fx-background-color: transparent; -fx-text-fill: White;");
     Hero8.setStyle("-fx-font-weight: bold;-fx-background-color: black;-fx-font: 40px \"" + fraktur.getName() + "\" ;-fx-shape: \"M0,0 L150,0 L112.5,50 L37.5,50 Z\"; -fx-background-color: transparent; -fx-text-fill: White;");
     BackgroundFill fill = new BackgroundFill (Color.rgb (0, 0, 0, 0.5), null, null); // black with 50% opacity
     Background background1 = new Background (fill);
     //Hero2.setBackground (background1);
     vboxt1.setBackground(background1);
     vboxt2.setBackground(background1);
     vboxt3.setBackground(background1);
     vboxt4.setBackground(background1);
     vboxt5.setBackground(background1);
     vboxt6.setBackground(background1);
     vboxt7.setBackground(background1);
     vboxt8.setBackground(background1);
     SetVboxVisibility();
     pane.getChildren().addAll(vBox11,vBox12,vBox13,vBox14,vBox15,vBox16,vBox17,vBox18,vboxt1,vboxt2,vboxt3,vboxt4,vboxt5,vboxt6,vboxt7,vboxt8);
     vBox11.setVisible(true);
	 vboxt1.setVisible(true);
	 vbox1.setStyle(cssBordering);
	 //vBox11.getChildren().clear();
	 //pane.getChildren().remove(vBox11);
    // vBox11.getChildren().addAll(view11,name1);
     AnchorPane.setBottomAnchor(vBox11,290.0);
     AnchorPane.setRightAnchor(vBox11,0.0);
     AnchorPane.setBottomAnchor(vboxt1,90.0);
     AnchorPane.setRightAnchor(vboxt1,120.0);
     vbox1.setOnMouseClicked(e -> {
    	 SetVboxVisibility();
    	 setButtonswidthzero();
    	 vBox11.setVisible(true);
    	 vboxt1.setVisible(true);
    	 vbox1.setStyle(cssBordering);
    	 //vBox11.getChildren().clear();
    	 //pane.getChildren().remove(vBox11);
        // vBox11.getChildren().addAll(view11,name1);
         AnchorPane.setBottomAnchor(vBox11,290.0);
         AnchorPane.setRightAnchor(vBox11,0.0);
         AnchorPane.setBottomAnchor(vboxt1,90.0);
         AnchorPane.setRightAnchor(vboxt1,120.0);
        // pane.getChildren().add(vBox11);
         //vbox1.requestFocus ();
     });
//     vbox1.setOnMouseExited(e -> {
//    	 setButtonswidthzero();
//    	 vbox1.setStyle(null);
//         pane.getChildren().remove(vBox11);
//         vBox11.getChildren().removeAll(view11,name1);
//     });
     vbox2.setOnMouseClicked(e -> {
    	 SetVboxVisibility();
setButtonswidthzero();
//    	 pane.getChildren().remove(vBox11);
//         vBox11.getChildren().removeAll();
         vBox12.setVisible(true) ;   	 
vbox2.setStyle(cssBordering);
         //vBox11.getChildren().addAll(view22,name2,maxHp2,actions2,damage2);
         AnchorPane.setBottomAnchor(vBox12,290.0);
         AnchorPane.setRightAnchor(vBox12,0.0);
         vboxt2.setVisible(true);
         AnchorPane.setBottomAnchor(vboxt2,90.0);
         AnchorPane.setRightAnchor(vboxt2,120.0);
         //pane.getChildren().add(vBox11);
        // vbox2.requestFocus ();
     });
//     vbox2.setOnMouseExited(e -> {
//         vbox2.setStyle(null);
//         pane.getChildren().remove(vBox11);
//         vBox11.getChildren().removeAll(view22,name2,maxHp2,actions2,damage2);
//     });
     vbox3.setOnMouseClicked(e -> {
    	 SetVboxVisibility();
    	 setButtonswidthzero();
    	 vBox13.setVisible(true);
    	 vboxt3.setVisible(true);
    	 //pane.getChildren().remove(vBox11);
         //vBox11.getChildren().removeAll();
    	 vbox3.setStyle(cssBordering);
         //vBox11.getChildren().addAll(view33,name3,maxHp3,actions3,damage3);
         AnchorPane.setBottomAnchor(vBox13,290.0);
         AnchorPane.setRightAnchor(vBox13,50.0);
         AnchorPane.setBottomAnchor(vboxt3,90.0);
         AnchorPane.setRightAnchor(vboxt3,120.0);
        // pane.getChildren().add(vBox11);
        // vbox3.requestFocus ();
     });
//     vbox3.setOnMouseExited(e -> {
//         vbox3.setStyle(null);
//         pane.getChildren().remove(vBox11);
//         vBox11.getChildren().removeAll(view33,name3,maxHp3,actions3,damage3);
//     });
     vbox4.setOnMouseClicked(e -> {
    	 SetVboxVisibility();
    	 setButtonswidthzero();
    	 vBox14.setVisible(true);
    	 vboxt4.setVisible(true);
    	// pane.getChildren().remove(vBox11);
        // vBox11.getChildren().removeAll();
    	 vbox4.setStyle(cssBordering);
         //vBox11.getChildren().addAll(view44,name4,maxHp4,actions4,damage4);
         AnchorPane.setBottomAnchor(vBox14,290.0);
         AnchorPane.setRightAnchor(vBox14,60.0);
         AnchorPane.setBottomAnchor(vboxt4,90.0);
         AnchorPane.setRightAnchor(vboxt4,120.0);
         //pane.getChildren().add(vBox11);
         //vbox4.requestFocus ();
     });
//     vbox4.setOnMouseExited(e -> {
//         vbox4.setStyle(null);
//         pane.getChildren().remove(vBox11);
//         vBox11.getChildren().removeAll(view44,name4,maxHp4,actions4,damage4);
//     });

     vbox5.setOnMouseClicked(e -> {
    	 SetVboxVisibility();
    	 setButtonswidthzero();
    	 vboxt5.setVisible(true);
    	 
    	// pane.getChildren().remove(vBox11);
         vBox15.setVisible(true);
    	 //vBox11.getChildren().removeAll();
    	 vbox5.setStyle(cssBordering);
        //vBox11.getChildren().addAll(view55,name5,maxHp5,actions5,damage5);
         AnchorPane.setBottomAnchor(vBox15,220.0);
         AnchorPane.setRightAnchor(vBox15,10.0);
         AnchorPane.setBottomAnchor(vboxt5,90.0);
         AnchorPane.setRightAnchor(vboxt5,120.0);
         //pane.getChildren().add(vBox11);
         //vbox5.requestFocus ();
     });
//     vbox5.setOnMouseExited(e -> {
//        
//    	 vbox5.setStyle(null);
//         pane.getChildren().remove(vBox11);
//         vBox11.getChildren().removeAll(view55,name5,maxHp5,actions5,damage5);
//     });
     vbox6.setOnMouseClicked(e -> {
    	 SetVboxVisibility();
    	 setButtonswidthzero();
    	 vBox16.setVisible(true);
    	 vboxt6.setVisible(true);
    	 
    	 //pane.getChildren().remove(vBox11);
         //vBox11.getChildren().removeAll();
    	 vbox6.setStyle(cssBordering);
         //vBox11.getChildren().addAll(view66,name6,maxHp6,actions6,damage6);
         AnchorPane.setBottomAnchor(vBox16,220.0);
         AnchorPane.setRightAnchor(vBox16,50.0);
         AnchorPane.setBottomAnchor(vboxt6,90.0);
         AnchorPane.setRightAnchor(vboxt6,120.0);
         //pane.getChildren().add(vBox11);
        // vbox6.requestFocus ();
     });
//     vbox6.setOnMouseExited(e -> {
//         vbox6.setStyle(null);
//         pane.getChildren().remove(vBox11);
//         vBox11.getChildren().removeAll(view66,name6,maxHp6,actions6,damage6);
//     });
     vbox7.setOnMouseClicked(e -> {
    	 SetVboxVisibility();
    	 setButtonswidthzero();
    	 vboxt7.setVisible(true);
    	 //pane.getChildren().remove(vBox11);
         //vBox11.getChildren().removeAll();
    	 vbox7.setStyle(cssBordering);
    	 vBox17.setVisible(true);
    	  AnchorPane.setBottomAnchor(vboxt7,90.0);
          AnchorPane.setRightAnchor(vboxt7,120.0);
        // vBox11.getChildren().addAll(view77,name7,maxHp7,actions7,damage7);
         AnchorPane.setBottomAnchor(vBox17,270.0);
         AnchorPane.setRightAnchor(vBox17,15.0);
        // pane.getChildren().add(vBox11);
       //  vbox7.requestFocus ();
     });
//     vbox7.setOnMouseExited(e -> {
//         vbox7.setStyle(null);
//         pane.getChildren().remove(vBox11);
//         vBox11.getChildren().removeAll(view77,name7,maxHp7,actions7,damage7);
//     });
     vbox8.setOnMouseClicked(e -> {
         setButtonswidthzero();
         SetVboxVisibility();
         vboxt8.setVisible(true);
    	 vbox8.setStyle(cssBordering);
         vBox18.setVisible(true);
         AnchorPane.setBottomAnchor(vBox18,260.0);
         AnchorPane.setRightAnchor(vBox18,10.0);
         AnchorPane.setBottomAnchor(vboxt8,90.0);
         AnchorPane.setRightAnchor(vboxt8,120.0);
        // pane.getChildren().add(vBox18);
         //vbox8.requestFocus ();
     });
     
     
//     vbox8.setOnMouseExited(e -> {
//         vbox8.setStyle(null); pane.getChildren().remove(vBox11);
//         vBox11.getChildren().removeAll(view88,name8,maxHp8,actions8,damage8);
//     });
//     pane.setBottom(b1);
//     b1.setAlignment(Pos.CENTER);
//     vbox1.focusedProperty ().addListener ((obs, wasFocused, isNowFocused) -> { if (!isNowFocused) { vbox1.setStyle ("-fx-border-width: 0"); pane.getChildren().remove(vBox11);vBox11.getChildren().removeAll(view11,name1);} });
//     vbox2.focusedProperty ().addListener ((obs, wasFocused, isNowFocused) -> { if (!isNowFocused) { vbox2.setStyle ("-fx-border-width: 0");pane.getChildren().remove(vBox11);  vBox11.getChildren().removeAll(view22,name2,maxHp2,actions2,damage2);} });
//     vbox3.focusedProperty ().addListener ((obs, wasFocused, isNowFocused) -> { if (!isNowFocused) { vbox3.setStyle ("-fx-border-width: 0");pane.getChildren().remove(vBox11);  vBox11.getChildren().removeAll(view33,name3,maxHp3,actions3,damage3);} });
//     vbox4.focusedProperty ().addListener ((obs, wasFocused, isNowFocused) -> { if (!isNowFocused) { vbox4.setStyle ("-fx-border-width: 0"); pane.getChildren().remove(vBox11); vBox11.getChildren().removeAll(view44,name4,maxHp4,actions4,damage4);} });
//     vbox5.focusedProperty ().addListener ((obs, wasFocused, isNowFocused) -> { if (!isNowFocused) { vbox5.setStyle ("-fx-border-width: 0");pane.getChildren().remove(vBox11);  vBox11.getChildren().removeAll(view55,name5,maxHp5,actions5,damage5);} });
//     vbox6.focusedProperty ().addListener ((obs, wasFocused, isNowFocused) -> { if (!isNowFocused) { vbox6.setStyle ("-fx-border-width: 0"); pane.getChildren().remove(vBox11); vBox11.getChildren().removeAll(view66,name6,maxHp6,actions6,damage6);} });
//     vbox7.focusedProperty ().addListener ((obs, wasFocused, isNowFocused) -> { if (!isNowFocused) { vbox7.setStyle ("-fx-border-width: 0"); pane.getChildren().remove(vBox11); vBox11.getChildren().removeAll(view77,name7,maxHp7,actions7,damage7);} });
//     //vbox8.focusedProperty ().addListener ((obs, wasFocused, isNowFocused) -> { if (!isNowFocused) { vbox8.setStyle ("-fx-border-width: 0"); } });
//     vbox8.focusedProperty ().addListener ((obs, wasFocused, isNowFocused) -> { if (!isNowFocused) { vbox8.setStyle ("-fx-border-width: 0"); pane.getChildren().remove(vBox11); vBox11.getChildren().removeAll(view88,name8,maxHp8,actions8,damage8);} });
//
//     vbox1.focusedProperty ().addListener ((obs, wasFocused, isNowFocused) -> { if (isNowFocused) {  vbox1.setStyle ("-fx-border-color: blue; -fx-border-width: 2;"); pane.getChildren ().add (vbox1); } else {  vbox1.setStyle("-fx-border-width: 0"); pane.getChildren ().remove (vbox1); } });
//     vbox2.focusedProperty ().addListener ((obs, wasFocused, isNowFocused) -> { if (isNowFocused) {  vbox2.setStyle ("-fx-border-color: blue; -fx-border-width: 2;"); pane.getChildren ().add (vbox2); } else {  vbox2.setStyle("-fx-border-width: 0"); pane.getChildren ().remove (vbox2); } });
//     vbox3.focusedProperty ().addListener ((obs, wasFocused, isNowFocused) -> { if (isNowFocused) {  vbox3.setStyle ("-fx-border-color: blue; -fx-border-width: 2;"); pane.getChildren ().add (vbox3); } else {  vbox3.setStyle("-fx-border-width: 0"); pane.getChildren ().remove (vbox3); } });
//     vbox4.focusedProperty ().addListener ((obs, wasFocused, isNowFocused) -> { if (isNowFocused) {  vbox4.setStyle ("-fx-border-color: blue; -fx-border-width: 2;"); pane.getChildren ().add (vbox4); } else {  vbox4.setStyle("-fx-border-width: 0"); pane.getChildren ().remove (vbox4); } });
//     vbox5.focusedProperty ().addListener ((obs, wasFocused, isNowFocused) -> { if (isNowFocused) {  vbox5.setStyle ("-fx-border-color: blue; -fx-border-width: 2;"); pane.getChildren ().add (vbox5); } else {  vbox5.setStyle("-fx-border-width: 0"); pane.getChildren ().remove (vbox5); } });
//     vbox6.focusedProperty ().addListener ((obs, wasFocused, isNowFocused) -> { if (isNowFocused) {  vbox6.setStyle ("-fx-border-color: blue; -fx-border-width: 2;"); pane.getChildren ().add (vbox6); } else {  vbox6.setStyle("-fx-border-width: 0"); pane.getChildren ().remove (vbox6); } });
//     vbox7.focusedProperty ().addListener ((obs, wasFocused, isNowFocused) -> { if (isNowFocused) {  vbox7.setStyle ("-fx-border-color: blue; -fx-border-width: 2;"); pane.getChildren ().add (vbox7); } else {  vbox7.setStyle("-fx-border-width: 0"); pane.getChildren ().remove (vbox7); } });
//     vbox8.focusedProperty ().addListener ((obs, wasFocused, isNowFocused) -> { if (isNowFocused) {  vbox8.setStyle ("-fx-border-color: blue; -fx-border-width: 2;"); pane.getChildren ().add (vbox8); } else {  vbox8.setStyle("-fx-border-width: 0"); pane.getChildren ().remove (vbox); } });
//     
     
     
     
     
     
     Image image =new Image("photo2pixel_download.png");
     BackgroundImage backgroundImage = new BackgroundImage (image,
     		    BackgroundRepeat.NO_REPEAT,
     		    BackgroundRepeat.NO_REPEAT,
     		    BackgroundPosition.CENTER,
     		    new BackgroundSize (100, 100, true, true, true, true));
      Background background = new Background (backgroundImage);
     pane.setBackground(background);

   
		//Font fraktur = Font.font("Arial", 20);

     pane.getChildren().add(b1);
     AnchorPane.setBottomAnchor(b1,34.50);
     AnchorPane.setRightAnchor(b1,130.0);
  // Load the font from a file
    
     scene.setRoot(pane);
     AnchorPane.setTopAnchor(vbox,50.0);
     AnchorPane.setLeftAnchor(vbox,50.0);
     b1.setPrefWidth(200);
     b1.setPrefHeight(20);
     b1.setFont(fraktur);
     b1.setStyle ("-fx-font: 30px \"" + fraktur.getName() + "\" ;-fx-shape: \"M0,0 L150,0 L112.5,50 L37.5,50 Z\"; -fx-background-color: transparent; -fx-text-fill: White;"); // set the text color, font size, font family and background color
	 //b1.setFont(new Font("fraktur", 30));
     b1.setOnMouseExited(e -> b1.setStyle("-fx-font: 30px \"" + fraktur.getName() + "\" ;-fx-shape: \"M0,0 L150,0 L112.5,50 L37.5,50 Z\"; -fx-background-color:transparent; -fx-text-fill: White;"));
	 b1.setOnMouseEntered(e -> b1.setStyle("-fx-font: 30px \"" + fraktur.getName() + "\";-fx-shape: \"M0,0 L150,0 L112.5,50 L37.5,50 Z\"; -fx-background-color: black; -fx-text-fill: white;"));
     star.setFullScreen(true);
     //star.setScene(scene);
     //stage.setFullScreen(true);
     //star.show();
    star.setResizable(false);
star.show();

b1.setOnMouseClicked(e -> {select();
try {
	gameview gg=new gameview(star,scene);
} catch (IOException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
}
	 
);



 }

private void SetVboxVisibility() {
	vBox11.setVisible(false);
	vBox12.setVisible(false);
	vBox13.setVisible(false);
	vBox14.setVisible(false);
	vBox15.setVisible(false);
	vBox16.setVisible(false);
	vBox17.setVisible(false);
	vBox18.setVisible(false);
	vboxt1.setVisible(false);
	vboxt2.setVisible(false);
	vboxt3.setVisible(false);
	vboxt4.setVisible(false);
	vboxt5.setVisible(false);
	vboxt6.setVisible(false);
	vboxt7.setVisible(false);
	vboxt8.setVisible(false);
}

private void setButtonswidthzero() {
	// TODO Auto-generated method stub
	 vbox1.setStyle(null);
	 vbox2.setStyle(null);
	 vbox3.setStyle(null);
	 vbox4.setStyle(null);
	 vbox5.setStyle(null);
	 vbox6.setStyle(null);
	 vbox7.setStyle(null);
	 vbox8.setStyle(null);
	
	 
	 //.setStyle(null);
}




private void select () {
	if(vBox11.isVisible()) {
		
		Game.startGame(Game.availableHeroes.get(0));
	}
	else if(vBox12.isVisible()) {
		Game.startGame(Game.availableHeroes.get(1));
	}
	else if(vBox13.isVisible()) {
		Game.startGame(Game.availableHeroes.get(2));
	}
	else if(vBox14.isVisible()) {
		Game.startGame(Game.availableHeroes.get(3));
	}
	else if(vBox15.isVisible()) {
		Game.startGame(Game.availableHeroes.get(4));
	}
	else if(vBox16.isVisible()) {
		Game.startGame(Game.availableHeroes.get(5));
	}
	else if(vBox17.isVisible()) {
		Game.startGame(Game.availableHeroes.get(6));
	}
	else if(vBox18.isVisible()) {
		Game.startGame(Game.availableHeroes.get(7));
	}
	else {
		Game.startGame(Game.availableHeroes.get(0));
	}
	
}

// public void start(Stage stage) {
//     AnchorPane pane = new AnchorPane();
//     pane.getChildren().add(c1);
//     AnchorPane.setTopAnchor(c1,200.0);
////     AnchorPane.setBottomAnchor(c1,200.0);
//     AnchorPane.setLeftAnchor(c1,200.0);
//     AnchorPane.setRightAnchor(c1,200.0);
//     scene = new Scene(pane,600,400);
//     stage.setScene(scene);
////     scene.setOnMouseClicked(e -> c1.setRadius((scene.getWidth()+scene.getHeight())/40));
////     scene.setOnMouseMoved(e -> c1.setRadius((scene.getWidth()+scene.getHeight())/40));
//
//     stage.show();
// }



// public static void main(String[] args){
//     launch(args);
// }

 public void handle(MouseEvent actionEvent) {
     if(actionEvent.getSource()==view1)
         System.out.print("Image 1");
 }

@Override
public void start(Stage arg0) throws Exception {
	// TODO Auto-generated method stub
	
}


}
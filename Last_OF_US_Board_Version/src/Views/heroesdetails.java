package Views;

import engine.Game;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import model.characters.Explorer;
import model.characters.Fighter;
import model.characters.Hero;

public class heroesdetails {
	
	static VBox allheroes;
	public heroesdetails(){
//		Pick_Hero.newview1.setFitHeight(50);
//    	Pick_Hero.newview1.setTranslateX(10);
//    	Pick_Hero.newview1.setFitWidth(50);
//    	Pick_Hero.newview2.setFitHeight(50);
//    	Pick_Hero.newview2.setFitWidth(50);
//    	Pick_Hero.newview2.setTranslateX(10);
//    	Pick_Hero.newview3.setFitHeight(50);
//    	Pick_Hero.newview3.setFitWidth(50);
//    	Pick_Hero.newview3.setTranslateX(10);
//    	Pick_Hero.newview4.setFitHeight(50);
//    	Pick_Hero.newview4.setFitWidth(50);
//    	Pick_Hero.newview4.setTranslateX(10);
//    	Pick_Hero.newview5.setFitHeight(50);
//    	Pick_Hero.newview5.setFitWidth(50);
//    	Pick_Hero.newview5.setTranslateX(10);
//    	Pick_Hero.newview6.setFitHeight(50);
//    	Pick_Hero.newview6.setFitWidth(50);
//    	Pick_Hero.newview6.setTranslateX(10);
//    	Pick_Hero.newview7.setFitHeight(50);
//    	Pick_Hero.newview7.setFitWidth(50);
//    	Pick_Hero.newview7.setTranslateX(10);
//    	Pick_Hero.newview8.setFitHeight(50);
//    	Pick_Hero.newview8.setFitWidth(50);
//    	Pick_Hero.newview8.setTranslateX(10);
//    	Pick_Hero.images.add(Pick_Hero.newview1);
//    	Pick_Hero.images.add(Pick_Hero.newview2);
//    	Pick_Hero.images.add(Pick_Hero.newview3);
//    	Pick_Hero.images.add(Pick_Hero.newview4);
//    	Pick_Hero.images.add(Pick_Hero.newview5);
//    	Pick_Hero.images.add(Pick_Hero.newview6);
//    	Pick_Hero.images.add(Pick_Hero.newview7);
//    	Pick_Hero.images.add(Pick_Hero.newview8);
		
		
		
		
		allheroes= new VBox(5);
		for( int i=0;i<Game.heroes.size();i++) {
			String s=Game.heroes.get(i).getName();
			int u=Pick_Hero.names.indexOf(s);
			//if(u != -1)
 			VBox heroimage = new VBox();
 			ImageView newview1=new ImageView(Pick_Hero.images[u]);
 			newview1.setFitHeight(120);
 	    	newview1.setTranslateX(10);
 	    	newview1.setFitWidth(120);
 			//heroimage.getChildren().add(newview1);
 			ProgressBar pb=new ProgressBar();
 			double d=Game.heroes.get(i).getCurrentHp();
 			pb.setProgress(d/Game.heroes.get(i).getMaxHp());
 			pb.setVisible(true);
 			pb.setStyle("-fx-accent: red;");
 			
			Label Hero7 = new Label("Name: "+Game.heroes.get(i).getName()+System.lineSeparator ()+
	    	    	"ActionsAvailable: "+	 Game.heroes.get(i).getActionsAvailable() + System.lineSeparator ()+"AttackDmg: "+Game.heroes.get(i).getAttackDmg()+System.lineSeparator ()+"Type: "+getType(Game.heroes.get(i))+ System.lineSeparator ()+ "Number of supplies: "+Game.heroes.get(i).getSupplyInventory().size()+ System.lineSeparator ()+ "Number of vaccines: "+Game.heroes.get(i).getVaccineInventory().size());
			 Hero7.setStyle("-fx-font-weight: bold;-fx-background-color: black;-fx-font: 15px \"" + Pick_Hero.fraktur.getName()+ "\" ;-fx-shape: \"M0,0 L150,0 L112.5,50 L37.5,50 Z\"; -fx-background-color: transparent; -fx-text-fill: white;" );
			VBox hero=new VBox();
			
			 BackgroundFill fill = new BackgroundFill (Color.rgb (0, 0, 0, 0.5), null, null); // black with 50% opacity
		     Background background1 = new Background (fill);
			StackPane st=new StackPane();
			int Current=Game.heroes.get(i).getCurrentHp();
			Label lb=new Label(Current+" HP");
			lb.setStyle("-fx-font-weight: bold;-fx-background-color: black;-fx-font: 15px \"" + Pick_Hero.fraktur.getName() + "\" ;-fx-shape: \"M0,0 L150,0 L112.5,50 L37.5,50 Z\"; -fx-background-color: transparent; -fx-text-fill: black;");
			st.getChildren().addAll(pb,lb);
		     hero.getChildren().addAll(Hero7,st);
			heroimage.getChildren().add(newview1);
		    HBox hero1 =new HBox(); 
			hero1.getChildren().addAll(heroimage,hero);
			hero1.setMinSize(250.0, 130.0);
			hero1.setMaxSize(250.0, 130.0);
			hero1.setSpacing(20.0);
			hero1.setBackground(background1);
			
			hero1.setOnMouseClicked(e->{
				
				setUnvisible();
				hero1.setStyle(Pick_Hero.cssBordering);
				for(int j=0;j<Game.heroes.size();j++) {
					if(Game.heroes.get(j).getName().equals(s))
						gameview.SelectedHero=Game.heroes.get(j);
					
				}
				
			});
			allheroes.getChildren().add(hero1);
		
		
		
		}
		
	}
	
	public static String getType(Hero h) {
		if (h instanceof Fighter) {
			return "Fighter";
		}
		else {
			if(h instanceof Explorer)
				return "Explorer";
			else {
				return "Medic";
			}
		}
		
	}
	private void setUnvisible() {System.out.print(false);
		for(int j=0;j<Game.heroes.size();j++) {
			int size=allheroes.getChildren().size();
			HBox hbox = (HBox)allheroes.getChildren().get(j);
			hbox.setStyle(null);
			//System.out.print(false);	
		}
	}
	

}

package views;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import main.Launcher;



public class SelectionPage extends FlowPane {
	

	public SelectionPage() {
		
		this.setId("pane");

		//Creates invisible polygons over starsigns for tooltip and click event
        createShape("Aquarius", "Aquarius (January 20 to February 18)", 0, 30, 100);
		createShape("Pisces", "Pisces (February 19 to March 20)", 30, -95, 50);
		createShape("Aries", "Aries (March 21 to April 19)", 60, 165, -115);
		createShape("Taurus", "Taurus (April 20 to May 20)", 90, 55, -90);
		createShape("Gemini", "Gemini May 21 to June 20)", 120, 297, -180);
		createShape("Cancer", "Cancer (June 21 to July 22)", 150, 130, -100);
		createShape("Leo", "Leo (July 23 to August 22)", 180, 290, -165);
		createShape("Virgo", "Virgo (August 23 to September 22)", 210, 40, -120);
		createShape("Libra", "Libra (September 23 to October 22)", 240, 150, -245);	
		createShape("Scorpio", "Scorpio (October 23 to November 21)", 270, -108, -270);
		createShape("Sagittarius", "Sagittarius (November 22 to December 21)", 300.0, 20, -470);
		createShape("Capricorn", "Capricorn (December 22 to January 19)", 330.0, -180.0, -550.0);
		createShape("Libra", "Libra (September 23 to October 22)", 240, 40, 120);
	}
	
	
	private void createShape(String starSign, String tooltipText, double rotation, double xCoord, double yCoord) {
		
		Group group = new Group();

		Polygon polygon = new Polygon();
		polygon.getPoints().addAll(new Double[] { 105.0, 90.0, 97.0, 115.0, -80.0, 60.0, -20.0, -30.0 });
		polygon.setOpacity(0);

		polygon.setOnMouseClicked(e-> horoscopeClicked(e, starSign));

		Tooltip tooltip = new Tooltip(tooltipText);
		tooltip.install(polygon, tooltip);
		
		group.setRotate(rotation);
		group.setTranslateX(xCoord);
		group.setTranslateY(yCoord);

		group.getChildren().add(polygon);
		this.getChildren().add(group);
	}
	
	
	private void horoscopeClicked(MouseEvent e, String starSign) {
		Launcher.informationPage(starSign);
	}	
}




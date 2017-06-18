package views;


import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import main.Launcher;


public class InformationPage extends BorderPane {
	
	
	private static HBox topPanel;
	private static VBox leftPanel, bodyBox;
	private static Region shiftRight;											//Used to shift buttons to the right
	private static ToggleButton today, tomorrow, thisWeek, nextWeek;
	private static ToggleGroup buttonGroup;
	private static Button goBackBtn;
	private static MenuBar buttonHolder;
	private static Button goBack;
	private static Label starSign;
	private static Image image;
	private static ImageView imageView;
	private static TextArea textArea;
	
	
	public InformationPage() {
		
		
		// Top Panel ############################################################################################################
		today = new ToggleButton("Today");
		tomorrow = new ToggleButton("Tomorrow");
		thisWeek = new ToggleButton("This Week");
		nextWeek = new ToggleButton("Next Week");
		
		buttonGroup = new ToggleGroup();
		today.setToggleGroup(buttonGroup);
		tomorrow.setToggleGroup(buttonGroup);
		thisWeek.setToggleGroup(buttonGroup);
		nextWeek.setToggleGroup(buttonGroup);
		buttonGroup.selectToggle(today);
		
		shiftRight = new Region();
		shiftRight.setMinWidth(112);
		
		topPanel = new HBox();
		topPanel.setPadding(new Insets(10, 10, 10, 10));
		topPanel.getChildren().addAll(shiftRight, today, tomorrow, new Separator(), thisWeek, nextWeek);
		// Top Panel ############################################################################################################
		
		// Left Panel ###########################################################################################################
		starSign = labelTitle();
		starSign.setId("starSign");
		starSign.setMaxWidth(Double.MAX_VALUE);
	    starSign.setAlignment(Pos.CENTER);
	    starSign.setId("starSign");
		
		image = new Image(setImage());
		imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitWidth(100);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
		
		leftPanel = new VBox();
		leftPanel.setPadding(new Insets(0, 10, 10, 10));
		leftPanel.getChildren().addAll(starSign, imageView);
		// Left Panel '###########################################################################################################
		
		// Body ##################################################################################################################
		textArea = new TextArea();
		textArea.setWrapText(true);
		textArea.setId("textArea");
		
		goBackBtn = new Button("Go Back");
		goBackBtn.setId("goBackBtn");
		
		bodyBox = new VBox();
		bodyBox.getChildren().addAll(textArea, goBackBtn);
		bodyBox.setAlignment(Pos.TOP_CENTER);
		// Body ##################################################################################################################
		
		// Events ################################################################################################################
		today.setOnAction(e -> todayClicked(e));
		tomorrow.setOnAction(e -> tomorrowClicked(e));
		thisWeek.setOnAction(e -> thisWeekClicked(e));
		nextWeek.setOnAction(e -> nextWeekClicked(e));
		goBackBtn.setOnAction(e -> goBackClicked(e));
		
		today.fire(); 										//Default button to start 
		// Events ################################################################################################################
		
		
		this.setId("pane");
		this.setTop(topPanel);
		this.setLeft(leftPanel);
		this.setCenter(bodyBox);
	}

	
	private Label labelTitle() {
		String labelText = Launcher.getParsedData().getStarSign();
		return new Label(labelText);
	}
	

	private String setImage() {
		
		String starSign = Launcher.getParsedData().getStarSign();
		
		switch (starSign) {
			case "Aries" 		: return "file:resources/aries.png";
			case "Taurus" 		: return "file:resources/taurus.png";
			case "Gemini" 		: return "file:resources/gemini.png";
			case "Cancer" 		: return "file:resources/cancer.png";
			case "Leo" 			: return "file:resources/leo.png";
			case "Virgo" 		: return "file:resources/virgo.png";
			case "Libra" 		: return "file:resources/libra.png";
			case "Scorpio" 		: return "file:resources/scorpio.png";
			case "Sagittarius" 	: return "file:resources/sagittarius.png";
			case "Capricorn" 	: return "file:resources/capricorn.png";
			case "Aquarius" 	: return "file:resources/aquarius.png";
			case "Pisces" 		: return "file:resources/pisces.png";
			default :
				throw new IllegalStateException("Star sign not valid");
		}
	}
	
	
	private void goBackClicked(ActionEvent e) {
		Launcher.selectionPage();
	}


	private void todayClicked(ActionEvent e) {
		String text = Launcher.getParsedData().getTodays();
		textArea.setText(text);
	}
	
	private void tomorrowClicked(ActionEvent e) {
		String text = Launcher.getParsedData().getTomorrows();
		textArea.setText(text);
	}
	
	private void thisWeekClicked(ActionEvent e) {
		String text = Launcher.getParsedData().getThisWeeks();
		textArea.setText(text);
	}
	
	private void nextWeekClicked(ActionEvent e){
		String text = Launcher.getParsedData().getNextWeeks();
		textArea.setText(text);
	}

	









































}

package main;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import views.InformationPage;
import views.SelectionPage;

/**
* This program allows you to pick your horoscope and get your readings.
* Available readings are today, tomorrow, this week and next week.
*
* @author  Ricardo Matos
* @version 1.0
* @since   18-06-2017
*/


public class Launcher extends Application {

	
    private static Parser parsedData;
    
	private static FlowPane selectionPane;
	private static BorderPane infoPane;
    private static Scene selectionScene, infoScene;
    private static Stage theStage;
    private static String selectionCSS;
    private static String informationCSS;
    
    public static void main(String args[]) {
    	launch(args);
    }
	
    
	@Override
	public void start(Stage primaryStage) throws Exception {

		this.theStage = primaryStage;
		
		selectionCSS = this.getClass().getResource("/views/SelectionStyle.css").toExternalForm();
		informationCSS = this.getClass().getResource("/views/InformationStyle.css").toExternalForm();
        
        selectionPane = new SelectionPage();
        selectionScene = new Scene(selectionPane, 500, 500);
        selectionScene.getStylesheets().add(selectionCSS);
        
        primaryStage.setTitle("Horoscope Reading");
        primaryStage.setScene(selectionScene);
        primaryStage.setResizable(false);
        primaryStage.show();
	}
	

	public static Parser getParsedData() {
		return parsedData;
	}
	

	/**
	 * Switches scene (page) to the horoscope selection page. 
	 * This is the first page the user sees.
	 *
	 * @since 1.0
	 */
	public static void selectionPage() {
		parsedData = null;
		theStage.setScene(selectionScene);
	}
	
	/**
	 * Initialises and switches scene (page) once user selects horoscope.
	 * Also creates object containing parsed information.
	 *
	 * @param  starSign the star sign the user selected
	 * @since 1.0
	 */
	public static void informationPage(String starSign) {
		parsedData = new Parser(starSign);
		
		infoPane = new InformationPage();
        infoScene = new Scene(infoPane, 500, 270);
        infoScene.getStylesheets().add(informationCSS);
		theStage.setScene(infoScene);
	}
}

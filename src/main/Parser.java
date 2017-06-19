package main;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


//Gets horoscope readings from atrology.com


/**
* Parses horoscope data from astrology.com
*
* @author  Ricardo Matos
* @version 1.0
* @since   18-06-2017
*/

public class Parser {
	

	private static String starSign;
	private static String todays;
	private static String tomorrows;
	private static String thisWeeks;
	private static String nextWeeks;
	
	
	
	public Parser(String starSign) {
		
		this.starSign = starSign;
		
		Document todaysDoc = null;
		Document tomorrowsDoc = null;
		Document thisWeeksDoc = null;
		Document nextWeeksDoc = null;
		
		try {
			todaysDoc = Jsoup.connect("https://www.astrology.com/horoscope/daily/" + starSign + ".html").get();
			tomorrowsDoc = Jsoup.connect("https://www.astrology.com/horoscope/daily/tomorrow/" + starSign + ".html").get();
			thisWeeksDoc = Jsoup.connect("https://www.astrology.com/horoscope/weekly-overview/" + starSign + ".html").get();
			nextWeeksDoc = Jsoup.connect("https://www.astrology.com/horoscope/weekly-overview/next-week/" + starSign + ".html").get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Element todaysText = todaysDoc.select("div.page-horoscope-text").first();
		Element tomorrowsText = tomorrowsDoc.select("div.page-horoscope-text").first();
		Element thisWeeksText = thisWeeksDoc.select("div.page-horoscope-text").first();
		Element nextWeeksText = nextWeeksDoc.select("div.page-horoscope-text").first();
		
		this.todays = todaysText.text();
		this.tomorrows = tomorrowsText.text();
		this.thisWeeks = thisWeeksText.text();
		this.nextWeeks = nextWeeksText.text();
	}
	
	
	public String getStarSign() {
		return starSign;
	}
	
	public String getTodays() {
		return todays;
	}
	
	public String getTomorrows() {
		return tomorrows;
	}
	
	public String getThisWeeks() {
		return thisWeeks;
	}
	
	public String getNextWeeks() {
		return nextWeeks;
	}
	
	

	//String title = doc.title();
	//String body = doc.body().text();
	//String html = Jsoup.connect("https://www.astrology.com/horoscope/daily/aries.html").get().html()
	//System.out.printf("Title: %s%n", title);
    //System.out.printf("Body: %s", body);
    //System.out.println(html);
    //String description = doc.select("meta[name=description]").first().attr("content");
    //System.out.println("Description : " + description);
	//Elements resultLinks = doc.select("h3.r > a"); // direct a after h3	
	
}

package currencyConverter;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class home {

	public static void main(String[] args) {
		
		scraper.nameScraper();
		rateScraper.rateScraper();
		
	}

}

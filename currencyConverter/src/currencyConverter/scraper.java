package currencyConverter;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class scraper {

	public static String[] nameScraper() {
		String[] names = new String[51];
		try {
			Document doc = Jsoup.connect("https://www.x-rates.com/table/?from=USD&amount=1").userAgent("Mozilla/17.0").get();
			
			int i = 0;
			for(Element row:doc.select("table.ratesTable tr")) {
				
				if(row.select("td:nth-of-type(1)").text().equals("")) {
					continue;
				}else {
					final String ticker = row.select("td:nth-of-type(1)").text();
					//System.out.println(ticker);
					i++;
					if(i == 51)
						break;
					names[i] = ticker;
				}	
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return names;
	}
}

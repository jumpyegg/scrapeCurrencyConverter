package currencyConverter;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class rateScraper {

	public static String[] rateScraper() {
		
		String[] rates = new String[51];
		try {
			Document doc = Jsoup.connect("https://www.x-rates.com/table/?from=USD&amount=1").userAgent("Mozilla/17.0").get();
			
			int i = 0;
			for(Element row:doc.select("table.ratesTable tr")) {
				
				if(row.select("td:nth-of-type(2)").text().equals("")) {
					continue;
				}else {
					final String ticker = row.select("td:nth-of-type(2)").text();
					i++;
					if(i == 51)
						break;
					rates[i] = ticker;
				}	
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return rates;
	}
}

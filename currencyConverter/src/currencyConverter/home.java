package currencyConverter;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class home {

	public static void main(String[] args) {
		
		String[] names = scraper.nameScraper();
		String[] rates = rateScraper.rateScraper();
		
		
		double[] ratesDouble = new double[51];
		Map<String, Double> nameRates = new HashMap<>();
		
		
		System.out.println("These are the currencies you can choose from");
		
		for(int i = 1; i < 51; i++) {
			ratesDouble[i-1] = Double.parseDouble(rates[i]);
			nameRates.put(names[i], ratesDouble[i-1]);
			System.out.println(names[i]);
		}
		
		
		System.out.println("please type in the name exactly when selecting currencies");
		Scanner sc= new Scanner(System.in);
		
		System.out.println("please input a begining currency");
		String begining= sc.nextLine();
		
		System.out.println("please input the amount you would like to convert of the begining currency");
		String beginingAmount= sc.nextLine();
		
		System.out.println("please input a ending currency");
		String ending= sc.nextLine();
	
		
		double endingAmount = Double.parseDouble(beginingAmount) * (nameRates.get(ending)/nameRates.get(begining));
		
		System.out.println(beginingAmount+" "+begining+" is equal to "+endingAmount+" "+ending);
		
	}

}

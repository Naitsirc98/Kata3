package kata3;

import java.util.Random;

public class Kata3 {

	public static void main(String[] args) {
		
		String[] emails = {"ulpgc.es", "gmail.com","hotmail.com","origin.com"};
		
		Histogram<String> histogram = new Histogram<>();
		
		Random rand = new Random(System.currentTimeMillis());
		
		for(String email : emails) {
			histogram.increment(email, rand.nextInt(100));
		}
		
		HistogramDisplay display = new HistogramDisplay(histogram);
		
		display.execute();

	}

}



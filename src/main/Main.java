package main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String word = "may";
//		SimpleSyllableCounter counter = new SimpleSyllableCounter();
		OOSyllableCounter counter = new OOSyllableCounter();
		URL url = new URL("http://se.cpe.ku.ac.th/dictionary.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
		String line = "";
		int sum = 0;
		
		int numberOfWord = 0;
//		while((line = reader.readLine()) != null) {
//			numberOfWord++;
//			sum += counter.countSyllables(line);
//		}
//		System.out.println(sum);
//		System.out.println(numberOfWord);
		System.out.println(counter.countSyllables(word));
	}

}

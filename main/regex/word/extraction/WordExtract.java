package regex.word.extraction;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.*;

public class WordExtract {
	public static void main(String[] args) {
		BufferedReader bReader = null;

		try {

			String s;
			File file = new File("/Users/hyunjongmoon/Downloads/little_prince_en.txt");
			bReader = new BufferedReader(new FileReader(file));

			while ((s = bReader.readLine()) != null) {
				Pattern p = Pattern.compile("\\b\\w+\\b");
				Matcher m = p.matcher(s);
				while(m.find())
				{
					System.out.printf("%s ",m.group());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bReader != null)
					bReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}




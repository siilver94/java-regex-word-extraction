package Hash;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class InOut {
	public static void main(String[] args) {
		BufferedReader bReader = null;
		
		try {
			
			String s;
			File file = new File("D:\\Little1.txt"); 
			bReader = new BufferedReader(new FileReader(file));

			while ((s = bReader.readLine()) != null) {
				Pattern p = Pattern.compile(“\b\w+\b");
				Matcher m = p.matcher(s);			
				while(m.find()) 
				{
					System.out.printf(m.group());
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




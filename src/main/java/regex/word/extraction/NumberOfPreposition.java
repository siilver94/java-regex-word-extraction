import java.util.*;
import java.io.*;
import java.util.regex.*;

public class NumberOfPreposition {
	public static void main(String[] args) {

		BufferedReader bReader = null;
		HashMap hashMap = new HashMap();
		try {

			String readStr;
			File file = new File("D:\\Little.txt");
			bReader = new BufferedReader(new FileReader(file));

			while ((readStr = bReader.readLine()) != null) {
				Pattern pattern = Pattern.compile("\\b(to|in|with|of|by|about|at|on|for|out|off|over|up)\\b");
				Matcher regexStr = pattern.matcher(readStr);
				while (regexStr.find()) {
					String[] regexArray = { regexStr.group() };
					for (int i = 0; i < regexArray.length; i++) {
						if (hashMap.containsKey(regexArray[i])) {
							Integer value = (Integer) hashMap.get(regexArray[i]);
							hashMap.put(regexArray[i], value + 1);
						} else {
							hashMap.put(regexArray[i], 1);
						}
					}

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
		Iterator iterator = hashMap.entrySet().iterator();

		while (iterator.hasNext()) {
			Map.Entry entry = (Map.Entry) iterator.next();
			int value = ((Integer) entry.getValue()).intValue();
			System.out.println(entry.getKey() + " : " + value);
		}
		System.out.println("전치사의  갯수 : " + hashMap.size());
	}
}

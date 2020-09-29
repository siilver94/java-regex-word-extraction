import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TotalWordNumber {
	public static void main(String[] args) {

		BufferedReader bReader = null;
		HashMap hashMap = new HashMap();
		try {

			String readStr;
			// ‘//디렉토리/파일.csv
			File file = new File("");
			bReader = new BufferedReader(new FileReader(file));

			while ((readStr = bReader.readLine()) != null) {
				Pattern pattern = Pattern.compile("\\b\\w+\\b");
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
		System.out.println("총 단어 수 : " + hashMap.size());
	}
}

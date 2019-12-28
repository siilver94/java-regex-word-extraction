package RegExp;

import java.util.*;
import java.io.*;
import java.util.regex.*;

public class RegExpKoVer {
	public static void main(String[] args) {

		BufferedReader bReader = null;
		HashMap map = new HashMap();
		try {

			String s;
			File file = new File("D:\\little_prince_ko.txt");
			bReader = new BufferedReader(new FileReader(file));

			while ((s = bReader.readLine()) != null) {
				Pattern p = Pattern.compile("[가-힣]{3,5}");
				Matcher m = p.matcher(s);
				while (m.find()) {
					String[] data = { m.group() };
					for (int i = 0; i < data.length; i++) {
						if (map.containsKey(data[i])) {
							Integer value = (Integer) map.get(data[i]);
							map.put(data[i], value + 1);			
						} else {
							map.put(data[i], 1);
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

        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int comparision = (o1.getValue() - o2.getValue()) * -1;
                return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
            }
        });
        
        Map<String, Integer> sortedMap = new LinkedHashMap<>(); 
        for(Iterator<Map.Entry<String, Integer>> iter = list.iterator(); iter.hasNext();){
            Map.Entry<String, Integer> entry = iter.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        
        System.out.println(sortedMap);
        System.out.println("한글 3~5자리 상위 5%의 갯수 : "+Math.round(map.size()*0.05));
        
     
	}
}





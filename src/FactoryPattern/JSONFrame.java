package FactoryPattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * This class defines a constructor that will load the JSONFrame
 * @author Angel Gascon and Marc Roigé
 * @version 8/1/2022
 */
public class JSONFrame extends DataFrame {
	/**
	 * Constructor that load the JSONFrame
	 * @param fileName name of the file that will be load
	 */
	public JSONFrame(String fileName) {
		super();
		Map<String, List<String>> frameInfo = new HashMap<>();
		int rows = 0, labels = 0;
		ArrayList<String> keys = new ArrayList<>();

		try {

			JSONParser parser = new JSONParser();
			JSONArray tmpArr = (JSONArray) parser.parse(new FileReader(fileName));
			JSONObject jsonObject = (JSONObject) tmpArr.iterator().next();
			for (int i = 0; i<jsonObject.keySet().toArray().length; i++){ keys.add((String) jsonObject.keySet().toArray()[i]); }

			for (Object obj : tmpArr) {

				JSONObject object = (JSONObject) obj;

				ArrayList<String> currentInfo = new ArrayList<>();
				for (String key : keys) {
					currentInfo.add(object.get(key).toString());
				}
				labels = currentInfo.size();

				if (rows == 0){
					int i = 0;
					for (String ignored : currentInfo) {
						List<String> frames = new LinkedList<>();
						frameInfo.put(keys.get(i), frames);
						i++;
					}
				}
				for (int index = 0; index < currentInfo.size(); index++) {
					frameInfo.get(keys.get(index)).add(currentInfo.get(index));
				}
				rows++;
			}
			super.takeRef(frameInfo, rows, labels, keys);
		} catch(IOException | ParseException e){
			e.printStackTrace();
		}
	}
}


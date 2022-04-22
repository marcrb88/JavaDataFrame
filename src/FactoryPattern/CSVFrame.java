package FactoryPattern;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * This class defines the load of CSVFrame
 * @author Angel Gascon and Marc Roigé
 * @version 8/1/2022
 */
public class CSVFrame extends DataFrame {

	/**
	 * //Constructor that load CSVFrame in a HashMap
	 * @param fileName contains the name of the file that we will load
	 */
	public CSVFrame(String fileName) {
		super();
		File file = new File(fileName);
		Scanner fileScanner;
		String fileString;

		int rows=-1, labels=0;
		Map<String, List<String>> frameInfo = new HashMap<>();
		ArrayList<String> header = new ArrayList<>();

		try {
			fileScanner = new Scanner(file);
			while(fileScanner.hasNextLine()) {

				fileString = fileScanner.nextLine();
				fileString = fileString.replace(" \"", "").replace("\"", "");
				String[] aux = fileString.split(",");

				if (rows == -1) {//labels
					labels = aux.length;
					//header = currentInfo.clone();
					for (String o : aux) {
						List<String> frames = new LinkedList<>();
						frameInfo.put(o, frames);
						header.add(o);
					}
				}else{
					for (int i = 0; i < aux.length; i++) {
						frameInfo.get(header.get(i)).add(aux[i]);
					}
				}
				rows++;
			}
			super.takeRef(frameInfo, rows, labels, header);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

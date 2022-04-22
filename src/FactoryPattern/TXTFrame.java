package FactoryPattern;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/**
 * This class defines a constructor that will load the TXTFrame
 * @author Angel Gascon and Marc Roigé
 * @version 8/1/2022
 */
public class TXTFrame extends DataFrame{

	/**
	 * Constructor that will load the TXTFrame
	 * @param fileName name of the txt file
	 * @param separator separator of the content
	 */
	public TXTFrame(String fileName, String separator) {
		super();
		int rows = -1, labels = 0;
		final Map<String, List<String>> frameInfo = new HashMap<>();
		ArrayList<String> header = new ArrayList<>();

		File file = new File(fileName);
		Scanner fileScanner;
		String fileString;

		try {
			fileScanner = new Scanner(file);
			while(fileScanner.hasNextLine()) {

				fileString = fileScanner.nextLine();
				fileString = fileString.replace(" \"", "").replace("\"", "");
				String[] aux = fileString.split(separator);

				if (rows == -1) {//labels
					labels = aux.length;
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

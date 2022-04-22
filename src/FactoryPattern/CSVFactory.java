package FactoryPattern;

/**
 * This class defines a constructor that will return a new IDataFrame object
 * @author Angel Gascon and Marc Roigé
 * @version 8/1/2022
 */
public class CSVFactory implements IFactory{

	/**
	 * Constructor that allows creating a CSVFrame
	 * @param fileName defines the name of the csv file
	 * @param separator determines the separator of the file's content
	 * @return a IDataFrame object
	 */
	public IDataFrame createDataFrame(String fileName, String separator){
		return new CSVFrame(fileName);
	}
}
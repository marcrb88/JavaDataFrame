package FactoryPattern;

/**
 * @author Angel Gascon and Marc Roige
 * 
 * Interface that defines the initialization of the dataframes.
 * We use an interface because attributes and methods already implemented.
 *
 */
public interface IFactory {
	/**
	 * Method that create the specific dataFrame
	 * @param fileName name of the file we want to load
	 * @param separator separator of the content
	 * @return specific DataFrame
	 */
	IDataFrame createDataFrame(String fileName, String separator);
}
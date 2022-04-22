package FactoryPattern;
/**
 * This class defines a constructor that will return a new IDataFrame object
 * @author Angel Gascon and Marc Roigé
 * @version 8/1/2022
 */
public class TXTFactory implements IFactory{
	
	public IDataFrame createDataFrame(String fileName, String separator){
		return new TXTFrame(fileName, separator);
	}
	
}

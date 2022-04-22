package FactoryPattern;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/**
 * @author Angel Gascon and Marc Roige
 *
 * Defines the dataFrame functions
 *
 */
public interface IDataFrame {

    /**
     * return the value of a single item (row) and column label (name).
     * @param fil defines the row we want to look at (0,1,2,3,etc.)
     * @param col defines the column we want to look at (A,B,C,D,etc.)
     * @return String that contains the information at the position (fil, col)
     */
    String at(int fil, String col);

    /**
     * access a single value for a row and column by integer position
     * @param fil defines the row we want to look at (0,1,2,3,etc.)
     * @param col defines the column we want to look at (0,1,2,3,etc.)
     * @return String that contains the information at the position (fil, col)
     */
    String iat(int fil, int col);

    /**
     * return number of labels
     * @return int number of columns
     */
    int columns();

    /**
     * return number of items (rows)
     * @return int number of rows
     */
    int size();

    /**
     * return the values of a column in the DataFrame following a certain order
     * @param column index of a column
     * @param comp comparator
     * @return values of a collum in a certain order
     */
    List<String> sort(String column, Comparator<String> comp);

    /**
     * return query of the dataframe
     * @param keySelector label of the dataframe
     * @param valuePredicate query expression
     * @return query
     */
    Map<String, List<String>> query(String keySelector, Predicate<String> valuePredicate);

    /**
     * Iterates over the dataframe labels
     * @return iterator
     */
    Iterator iterator();
}
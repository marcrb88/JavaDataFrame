package Visitor;

import Comparators.intAscending;
import Composite.CompositeDataFrame;
/**
 * Visitor that returns minimum value of a certain label
 */
public class VisitorMinimum implements IVisitor{
    /**
     * visit method for CompositeDataframe
     * @param cDataFrame DataFrame ref
     * @param label ref
     * @return Object visited
     */
    @Override
    public Integer visit(CompositeDataFrame cDataFrame, String label) {
        try{
            return Integer.parseInt(cDataFrame.sort(label, new intAscending()).get(0));
        }catch (ClassCastException e){
            return null;
        }
    }
}
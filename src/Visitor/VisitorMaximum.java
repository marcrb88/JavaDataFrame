package Visitor;

import Comparators.intDescending;
import Composite.CompositeDataFrame;
/**
 * Visitor that returns maximum value of a certain label
 */
public class VisitorMaximum implements IVisitor{
    /**
     * visit method for CompositeDataframe
     * @param cDataFrame DataFrame ref
     * @param label ref
     * @return Object visited
     */
    @Override
    public Integer visit(CompositeDataFrame cDataFrame, String label) {
        try{
            return Integer.parseInt(cDataFrame.sort(label, new intDescending()).get(0));
        }catch (ClassCastException e){
            return null;
        }
    }
}

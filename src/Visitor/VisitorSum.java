package Visitor;

import Comparators.intDescending;
import Composite.CompositeDataFrame;
import java.util.List;
/**
 * Visitor that returns sum of values from a certain label
 */
public class VisitorSum implements IVisitor{
    /**
     * visit method for CompositeDataframe
     * @param cDataFrame DataFrame ref
     * @param label ref
     * @return Object visited
     */
    @Override
    public Integer visit(CompositeDataFrame cDataFrame, String label) {
        try {
            List<String> result = cDataFrame.sort(label, new intDescending());
            int res = 0;
            for (String o: result) {
                res = res + Integer.parseInt(o);
            }
            return res;
        }catch (ClassCastException e){
            return null;
        }
    }
}

package Visitor;

import Comparators.intAscending;
import Composite.CompositeDataFrame;
import java.util.List;

/**
 * Visitor that returns average value of a certain label
 */
public class VisitorAverage implements IVisitor{
    /**
     * visit method for CompositeDataframe
     * @param cDataFrame DataFrame ref
     * @param label ref
     * @return Object visited
     */
    @Override
    public Integer visit(CompositeDataFrame cDataFrame, String label) {
        try {
            List<String> result = cDataFrame.sort(label, new intAscending());
            int res = 0;
            for (String o: result) {
                res = res + Integer.parseInt(o);
            }
            res = res / cDataFrame.size();
            return res;
        }catch (ClassCastException e){
            return null;
        }
    }
}

package Visitor;

import Composite.CompositeDataFrame;

/**
 * Interface for visitor
 */
public interface IVisitor {
    /**
     * visit method for CompositeDataframe
     * @param cDataFrame DataFrame ref
     * @param label ref
     * @return Object visited
     */
    Integer visit(CompositeDataFrame cDataFrame, String label);
}

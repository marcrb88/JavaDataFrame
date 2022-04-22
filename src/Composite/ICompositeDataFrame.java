package Composite;

import FactoryPattern.IDataFrame;
import Visitor.IVisitor;

/**
 * Interface del composite
 */
public interface ICompositeDataFrame {
    /**
     * adds children to composite pattern
     * @param child IDataFrame child
     */
    void addChildren(IDataFrame child);

    /**
     * accepts visitor
     * @param v IVisitor reference
     * @param label label reference
     * @return Object
     */
    Object accept(IVisitor v, String label);
}

package UnitTests;

import Comparators.intAscending;
import Composite.CompositeDataFrame;
import FactoryPattern.*;

import static org.junit.Assert.*;

import Visitor.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * This class tests the DataFrame methods in the Composite and visitor pattern

 * @author Angel Gascon and Marc Roigé

 * @version 8/1/2022

 */
class CompositeDataFrameTest  {

    @Test
    void testingDemo(){
        IDataFrame ff = new JSONFrame("cities.json");
        System.out.println(ff.query("LonM", entry -> Integer.parseInt(entry) < 40));
    }
    @SuppressWarnings("all")
    @Test
    void at() {
        CompositeDataFrame comp = loadComposite();
        assertEquals("46;;46;46;", comp.at(2,"LatD"));
        assertEquals("48;;48;48;", comp.at(3,"LonM"));
    }
    @SuppressWarnings("all")
    @Test
    void iat() {

        CompositeDataFrame comp = loadComposite();

        assertEquals("120;;30;120;",comp.iat(2,4));
        assertEquals("71;;48;71;",comp.iat(3,4));
    }
    @SuppressWarnings("all")
    @Test
    void columns() {
        CompositeDataFrame comp = loadComposite();
        assertEquals(30,comp.columns());
    }
    @SuppressWarnings("all")
    @Test
    void size() {
        CompositeDataFrame comp = loadComposite();
        assertEquals(12,comp.size());
    }
    @SuppressWarnings("all")
    @Test
     void sort() {
         CompositeDataFrame comp = loadComposite();
         assertEquals(Arrays.asList("41", "41", "41", "42", "42", "42", "42", "42", "42", "46", "46", "46"),
                 comp.sort("LatD", new intAscending()));
     }
    @SuppressWarnings("all")
    @Test
    void query() {
        CompositeDataFrame comp = loadCompositeQuery();
        //assertEquals(Collections.emptyMap(),comp.query("LonM", entry -> Integer.parseInt(entry) < 20));
        assertTrue(comp.query("LatS", entry -> Integer.parseInt(entry) > 30).containsValue(Arrays.asList("Youngstown", "Yankton", "Yakima", "Youngstown", "Yankton", "Yakima")));
    }
    @SuppressWarnings("all")
    @Test
    void accept() {
        CompositeDataFrame comp = loadComposite();
        IVisitor visavg = new VisitorAverage();
        IVisitor vismax = new VisitorMaximum();
        IVisitor vismin = new VisitorMinimum();
        IVisitor vissum = new VisitorSum();
        assertEquals(35,comp.accept(visavg,"LonM"));
        assertEquals(46,comp.accept(vismax,"LatD"));
        assertEquals(12,comp.accept(vismin,"LatS"));
        assertEquals(177,comp.accept(vissum,"LonS"));
    }

    static CompositeDataFrame loadComposite(){

        JSONFactory fac = new JSONFactory();
        CSVFactory fac2 = new CSVFactory();
        TXTFactory fac3 = new TXTFactory();
        IDataFrame df = fac.createDataFrame("cities.json", null);
        IDataFrame df2 = fac2.createDataFrame("cities.csv", ",");
        IDataFrame df3 = fac3.createDataFrame("cities.txt", ";");

        CompositeDataFrame comp = new CompositeDataFrame();
        CompositeDataFrame comp1 = new CompositeDataFrame();
        comp.addChildren(comp1);
        comp1.addChildren(df2);
        comp.addChildren(df);
        comp.addChildren(df3);
        return comp;
    }

    static CompositeDataFrame loadCompositeQuery(){

        CSVFactory fac2 = new CSVFactory();
        IDataFrame df2 = fac2.createDataFrame("cities.csv", null);

        CompositeDataFrame comp = new CompositeDataFrame();
        CompositeDataFrame comp1 = new CompositeDataFrame();
        comp.addChildren(comp1);
        comp1.addChildren(df2);
        comp.addChildren(df2);
        return comp;
    }
}
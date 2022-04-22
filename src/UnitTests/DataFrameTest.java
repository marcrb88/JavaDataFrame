package UnitTests;

import Comparators.intAscending;
import Comparators.intDescending;
import FactoryPattern.CSVFactory;
import FactoryPattern.IDataFrame;
import FactoryPattern.JSONFactory;
import FactoryPattern.TXTFactory;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * This class tests the DataFrame methods in the Factory pattern

 * @author Angel Gascon and Marc Roigé

 * @version 8/1/2022

 */



class DataFrameTest {
    JSONFactory fac = new JSONFactory();
    CSVFactory fac2 = new CSVFactory();
    TXTFactory fac3 = new TXTFactory();
    IDataFrame df = fac.createDataFrame("cities.json", null);
    IDataFrame df2 = fac2.createDataFrame("cities.csv",",");
    IDataFrame df3 = fac3.createDataFrame("cities.txt", ";");


    @SuppressWarnings("all")
    @Test
    void at() {
        assertEquals("Youngstown",df.at(0,"City"));
        assertEquals("ERROR: Non existent info", df2.at(10,"LonD"));
        assertEquals("16", df3.at(3,"LatM"));
        assertEquals("ERROR: Non existent info", df3.at(11,"LatM"));
    }

    @SuppressWarnings("all")
    @Test
    void iat() {
        assertEquals("ERROR: Non existent info",df.iat(4, 10));
        assertEquals("23",df.iat(1, 8));
        assertEquals("ERROR: Non existent info",df.iat(129, 5));

        assertEquals("ERROR: Non existent info",df2.iat(4, 10));
        assertEquals("Youngstown",df2.iat(0, 8));
        assertEquals("ERROR: Non existent info",df2.iat(129, 5));

        assertEquals("ERROR: Non existent info",df3.iat(5, 10));
        assertEquals("48", df3.iat(3, 5));
        assertEquals("ERROR: Non existent info",df3.iat(129, 5));
    }

    @SuppressWarnings("all")
    @Test
    void columns() {
        assertEquals(10,df.columns());
        assertEquals(10,df2.columns());
        assertEquals(10,df3.columns());
    }

    @SuppressWarnings("all")
    @Test
    void size() {
        assertEquals(4,df.size());
        assertEquals(4,df2.size());
        assertEquals(4,df3.size());
    }

    @SuppressWarnings("all")
    @Test
    void sort() {

        assertEquals(asList("23", "30", "39", "48"), df.sort("LonM", new intAscending()));

        assertEquals(asList("120", "97", "80", "71"), df2.sort("LonD", new intDescending()));
        assertEquals(asList("0", "0", "23", "36"), df2.sort("LonS", new intAscending()));

        assertEquals(asList("52", "35", "16", "5"), df3.sort("LatM", new intDescending()));
        assertEquals(asList("12", "48", "59", "59"), df3.sort("LatS", new intAscending()));
    }

    @SuppressWarnings("all")
    @Test
    void query() {
        assertTrue(df.query("LatS", entry -> Integer.parseInt(entry) > 58).containsValue(Arrays.asList("59","59")));
        assertTrue(df.query("LonM", entry -> Integer.parseInt(entry) == 30).containsValue(Arrays.asList("WA")));
        assertTrue(df.query("LatS", entry -> Integer.parseInt(entry) > 58).containsValue(Arrays.asList("Youngstown","Yakima")));

        assertTrue(df2.query("City", entry -> entry.equals("Youngstown")).containsValue(Arrays.asList("Youngstown")));
        assertEquals(Collections.emptyMap(), df2.query("LatD", entry -> Integer.parseInt(entry) < 40));
        assertTrue(df2.query("LatS", entry -> Integer.parseInt(entry) > 30).containsValue(Arrays.asList("80","97","120")));

        assertTrue(df3.query("City", entry -> entry.equals("Yankton")).containsValue(Arrays.asList("Yankton")));
        assertTrue(df3.query("State", entry -> entry.equals("OH")).containsValue(Arrays.asList("OH")));
        assertTrue(df3.query( "LatD", entry -> Integer.parseInt(entry) == 42).containsValue(Arrays.asList("42","42")));
    }
}
package UnitTests;

import Comparators.intAscending;
import Comparators.intDescending;
import FactoryPattern.CSVFactory;
import FactoryPattern.IDataFrame;
import FactoryPattern.JSONFactory;
import FactoryPattern.TXTFactory;
import Observer.*;
import Proxy.LoggingHandler;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

class LoggingHandlerTest {

    JSONFactory fac = new JSONFactory();
    CSVFactory fac2 = new CSVFactory();
    TXTFactory fac3 = new TXTFactory();
    IDataFrame df = fac.createDataFrame("cities.json", null);
    IDataFrame df2 = fac2.createDataFrame("cities.csv", ",");
    IDataFrame df3 = fac3.createDataFrame("cities.txt", ";");
    LoggingHandler logged = new LoggingHandler(df);

    @Test
    void QueryObserverTest() {
        Observer obs1 = new QueryObserver();
        Observer obs2 = new QueryObserver();
        logged.addObserver(obs1);
        logged.addObserver(obs2);
        df = (IDataFrame) Proxy.newProxyInstance(IDataFrame.class.getClassLoader(),
                new Class<?>[] {IDataFrame.class},
                logged);

        df.iat(1, 2);
        df.at(3, "LatD");
        df.query("LatS", entry -> Integer.parseInt(entry) > 30);
        df.query("LatS", entry -> Integer.parseInt(entry) > 10);
        System.out.println(obs1+"\n"+obs2);
    }

    @Test
    void LogObserverTest() {
        Observer obs1 = new LogObserver();
        Observer obs2 = new LogObserver();
        logged.addObserver(obs1);
        logged.addObserver(obs2);
        df2 = (IDataFrame) Proxy.newProxyInstance(IDataFrame.class.getClassLoader(),
                new Class<?>[] {IDataFrame.class},
                logged);

        df2.iat(1, 2);
        df2.at(3, "LatD");
        df2.sort("LatD", new intAscending());
        df2.sort("LatD", new intDescending());
        df2.at(3, "LatD");
        df2.query("LatS", entry -> Integer.parseInt(entry) > 30);
        df2.query("LatS", entry -> Integer.parseInt(entry) > 10);
        System.out.println(obs1+"\n"+obs2);
    }

    @Test
    void LogObserverTestDataFrame3() {
        Observer obs1 = new LogObserver();
        Observer obs2 = new LogObserver();
        logged.addObserver(obs1);
        logged.addObserver(obs2);
        df3 = (IDataFrame) Proxy.newProxyInstance(IDataFrame.class.getClassLoader(),
                new Class<?>[] {IDataFrame.class},
                logged);

        df3.iat(1, 2);
        df3.at(3, "LatD");
        df3.sort("LatD", new intAscending());
        df3.sort("LatD", new intDescending());
        df3.at(3, "LatD");
        df3.query("LatS", entry -> Integer.parseInt(entry) > 30);
        df3.query("LatS", entry -> Integer.parseInt(entry) > 10);
        System.out.println(obs1+"\n"+obs2);
    }

}
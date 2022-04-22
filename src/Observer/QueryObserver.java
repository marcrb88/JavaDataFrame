package Observer;

import java.util.ArrayList;
import java.util.List;
/**
 * This class defines the QueryObserver

 * @author Angel Gascon and Marc Roigé

 * @version 8/1/2022

 */
public class QueryObserver extends Observer {

    List<String> lis = new ArrayList<>();

    /**
     * the refresh method
     * @param name of the executed method
     */
    @Override
    public void update(String name) {
        if(name.compareTo("query") == 0) lis.add(name);
    }

    /**
     * toString()
     * @return String of information
     */
    @Override
    public String toString() {
        return "QueryObserver{" +
                "lis=" + lis +
                '}';
    }
}
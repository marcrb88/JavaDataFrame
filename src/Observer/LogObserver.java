package Observer;

import java.util.ArrayList;
import java.util.List;
/**
 * This class defines the LogObserver

 * @author Angel Gascon and Marc Roigé

 * @version 8/1/2022

 */
public class LogObserver extends Observer {

    List<String> lis = new ArrayList<>();

    /**
     * The method to refresh the observers
     * @param name of the executed method
     */
    @Override
    public void update(String name) {
        lis.add(name);
    }

    /**
     * toString()
     * @return String of information
     */
    @Override
    public String toString() {
        return "LogObserver{" +
                "lis=" + lis +
                '}';
    }
}

package Comparators;

import java.util.Comparator;

/**
 * This class implements the comparator of intDescending
 * @author Angel Gascon and Marc Roigé
 * @version 8/1/2022
 */

public class intDescending implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        Integer castO1 = Integer.parseInt(o1);
        Integer castO2 = Integer.parseInt(o2);
        return -(castO1.compareTo(castO2));
    }
}

package Proxy;

import Observer.*;
/**
 * This interface that defines the Subject's methods

 * @author Angel Gascon and Marc Roigé

 * @version 8/1/2022

 */
public interface ISubject {
    /**
     * Header of the method that will add an Observer to the list
     * @param observer to put in the list
     */
    void addObserver(Observer observer);

    /**
     * Header of the method that will notify Observers that has been a new update
     * @param name of the executed method
     */
    void notifyObservers(String name);
}

package Proxy;

import Observer.Observer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.*;
/**
 * This class defines the Proxy pattern

 * @author Angel Gascon and Marc Roigé

 * @version 8/1/2022

 */
public class LoggingHandler implements InvocationHandler, ISubject {

    private final Object target;
    List<Observer> obs = new ArrayList<>();

    /**
     * Constructor that initializes the target
     * @param target attribute that contains the DataFrame
     */
    public LoggingHandler(Object target){
        this.target = target;
    }

    /**
     * Invoke method
     * @param proxy proxy object
     * @param method executed method
     * @param args arguments
     * @return an Object
     * @throws Throwable if exception
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name = method.getName();
        this.notifyObservers(name);
        return method.invoke(target, args);//invokes target and args offset
    }

    /**
     * toString()
     * @return String information
     */
    @Override
    public String toString() {
        return "LoggingHandler{" +
                "obs=" + obs +
                '}';
    }

    /**
     * Add a new Observer to the list
     * @param observer observer to put in the list
     */
    @Override
    public void addObserver(Observer observer) {
        obs.add(observer);
    }

    /**
     * Notify Observers of a new update
     * @param name name of the executed method
     */
    @Override
    public void notifyObservers(String name) {
        for (Observer o: obs) {
            o.update(name);
        }
    }
}
package javalab2;

/**
 * Created with IntelliJ IDEA.
 * User: Nasibulin
 * Date: 26.09.18
 * Time: 14:29
 * To change this template use File | Settings | File Templates.
 */
public interface State {

    public void on();
    public void off();
    public void coin();
    public void printMenu();
    public void printState();
    public void choice();
    public void check();
    public void cancel();
    public void cook();
    public void finish();

}

package javalab2;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Nasibulin
 * Date: 25.09.18
 * Time: 14:19
 * To change this template use File | Settings | File Templates.
 */
public class Automata {
    private int cash;
    private String[] menu;
    private int[] prices;
    private STATES state;

    public Automata(String[] menu, int[] prices) {

        this.menu = menu;
        this.prices = prices;
        this.state = STATES.OFF;

    }

    public static void main(String[] args) {
        Automata automat = new Automata(new String[]{"Coca-cola", "Tea", "Coffee"}, new int[]{12, 10, 18});
        automat.printState();
        automat.on();
        automat.printMenu();
        automat.printState();
        automat.finish();
        automat.printState();


    }

/*    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("\nJava Demo Drink Automata, Inc.");
        result.append("\nJava-enabled Standing Model #2018\n");
        result.append("Inventory: " + cash + " dollars");

        result.append("\nMachine is ");
        switch (state) {
            case OFF:
                result.append("Power down");
            case WAIT:
                result.append("Waiting for customer command...");
            case ACCEPT:
                result.append("Waiting for money...");
            case CHECK:
                result.append("Now checking money...");
        }
        result.append("\n");
        return result.toString();
    }*/

    public void on() {
        state = STATES.WAIT;
    }

    public void off() {
        state = STATES.OFF;
    }

    public void coin() {

    }

    public void printMenu() {
        System.out.println(Arrays.toString(menu));
        System.out.println(Arrays.toString(prices));
    }

    public void printState() {
        StringBuffer result = new StringBuffer();
        result.append("\nThe BEST Drink Automata, Inc.");
        result.append("\nJava-enabled Standing Model #2018\n");
        result.append("Inventory: " + cash + " dollars");

        result.append("\nMachine is ");
        switch (state) {
            case OFF:
                result.append("Power Off"); break;
            case WAIT:
                result.append("Waiting for customer command..."); break;
            case ACCEPT:
                result.append("Waiting for money...");break;
            case CHECK:
                result.append("Now checking money...");break;
            case COOK:
                result.append("Now cooking...");break;
        }
        result.append("\n");
        System.out.println(result.toString());
    }

    public void choice() {

    }

    public void check() {

    }

    public void cancel() {

    }

    public void cook() {

    }

    public void finish() {
        switch (state) {
            case OFF:
                break;
            case WAIT:
                state=STATES.WAIT; break;
            case ACCEPT:
                break;
            case CHECK:
                break;
            case COOK:
                break;
        }
    }

}

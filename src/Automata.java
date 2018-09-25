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
        Automata a = new Automata(new String[]{"Coca-cola", "Tea", "Coffee"}, new int[]{12, 10, 18});

    }

    public void on() {
        state = STATES.WAIT;
    }

    public void off() {
        state = STATES.OFF;
    }

    public void coin() {

    }

    public void printMenu() {

    }

    public void printState() {

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

    }

}

package javatemp;

/**
 * Created with IntelliJ IDEA.
 * User: Konstantin
 * Date: 29.09.18
 * Time: 12:14
 * To change this template use File | Settings | File Templates.
 */
public class Automata {
    private int cash;
    private int moneyback;
    private int[] prices;
    private int choice;
    private String[] menu;
    private STATES state = STATES.OFF;
    private final String TOO_LITTLE_MONEY = "Too little money for your choice...";

    public Automata(String[] menu, int[] prices) {
        this.cash = 0;
        this.menu = menu;
        this.prices = prices;
    }

    public void on() {
        switch (state) {
            case OFF:
                state = STATES.WAIT;
                break;
            case WAIT:
                break;
            case ACCEPT:
                break;
            case CHECK:
                break;
            case COOK:
                break;
        }

    }

    public void off() {
        switch (state) {
            case OFF:
                break;
            case WAIT:
                state = STATES.OFF;
                break;
            case ACCEPT:
                break;
            case CHECK:
                break;
            case COOK:
                break;
        }
    }

    public void coin(int cash) {
        switch (state) {
            case OFF:
                break;
            case WAIT:
                this.cash += cash;
                state = STATES.ACCEPT;
                break;
            case ACCEPT:
                this.cash += cash;
                break;
            case CHECK:
                break;
            case COOK:
                break;
        }
    }

    public String[][] printMenu() {
        String[][] menu = new String[this.menu.length][2];
        for (int i = 0; i < this.menu.length; i++) {
            menu[i][0] = this.menu[i];
            menu[i][1] = String.valueOf(this.prices[i]);
        }
        return menu;
    }

    public String printState() {
        return (this.state.equals(STATES.OFF)) ? "..." : String.valueOf(this.state) + ". You have " + cash + " rubles on your account.";
    }

    public String choice(int choice) {
        this.choice = choice;
        String result = TOO_LITTLE_MONEY;
        switch (state) {
            case OFF:
                break;
            case WAIT:
                break;
            case ACCEPT:
                if (check()) {
                    state = STATES.CHECK;
                    result = (menu[choice]);
                }
                break;
            case CHECK:
                break;
            case COOK:
                break;
        }
        return result;
    }

    public boolean check() {
        return (cash >= prices[choice]);
    }

    public int cancel() {
        switch (state) {
            case OFF:
                break;
            case WAIT:
                break;
            case ACCEPT:
                state = STATES.WAIT;
                moneyback = cash;
                cash = 0;
                break;
            case CHECK:
                state = STATES.WAIT;
                moneyback = cash;
                cash = 0;
                break;
            case COOK:
                break;
        }
        return moneyback;
    }

    public void cook() {
        switch (state) {
            case OFF:
                break;
            case WAIT:
                break;
            case ACCEPT:
                break;
            case CHECK:
                state = STATES.COOK;
                break;
            case COOK:
                break;
        }
    }

    public void finish() {
        switch (state) {
            case OFF:
                break;
            case WAIT:
                break;
            case ACCEPT:
                break;
            case CHECK:
                break;
            case COOK:
                state = STATES.WAIT;
                break;
        }

    }


}

package javatemp;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Konstantin
 * Date: 29.09.18
 * Time: 12:14
 * To change this template use File | Settings | File Templates.
 */
public class Automata {
    private int cash;
    private String[] menu;
    private int[] prices;
    private STATES state=STATES.OFF;
    private String choice="";

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
                System.out.println("You just added "+cash+" roubles. Your balance is "+this.cash+" roubles.");
                break;
            case ACCEPT:
                this.cash += cash;
                System.out.println("You just added "+cash+" roubles. Your balance is "+this.cash+" roubles.");
                break;
            case CHECK:
                break;
            case COOK:
                break;
        }
    }

    public void printMenu() {
    for (int i=0;i<menu.length;i++){
        System.out.println(i+1+"."+menu[i]+"\t"+prices[i]);
    }
    }

    public void printState() {
        switch (state) {
            case OFF:break;
            case WAIT:;
            case ACCEPT:;
            case CHECK:;
            case COOK:System.out.println("Automat is in "+state+" state\nYour balance is "+cash+"\n");
                break;
        }
    }

    public void choice(String choice) {
        this.choice=choice;
        switch (state) {
            case OFF:
                break;
            case WAIT:
                break;
            case ACCEPT:
                if (check()) {state = STATES.CHECK;
                    System.out.println("Your select is "+choice+"\nRight? Please push COOK button...");}
                else
                    System.out.println("Wrong select. Repeate please...");
                break;
            case CHECK:
                break;
            case COOK:
                break;
    }
    }

    public boolean check() {
        return  (cash >= prices[Arrays.asList(menu).indexOf(choice)]);
    }

    public void cancel() {
        switch (state) {
            case OFF:
                break;
            case WAIT:
                break;
            case ACCEPT:
                state = STATES.WAIT;
                break;
            case CHECK:
                state = STATES.WAIT;
                break;
            case COOK:
                break;
        }
    }

    public void cook() throws InterruptedException {
        switch (state) {
            case OFF:
                break;
            case WAIT:
                break;
            case ACCEPT:
                break;
            case CHECK:
                state = STATES.COOK;
                System.out.print("Cooking");
                for (int i=0;i<10;i++){Thread.sleep(500);System.out.print('.');}
                cash-=prices[Arrays.asList(menu).indexOf(choice)];
                System.out.println("\nReady. Enjoy your drink...");
                finish();
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

    public static void main(String[] args) throws InterruptedException {
        Automata a=new Automata(new String[]{"Coca-cola","Tea","Coffee"},new int[]{12,10,15});
        a.printState();
        a.on();
        a.printState();
        a.printMenu();
        a.coin(10);
        a.choice("Coca-cola");
        a.printState();
        a.choice("Tea");
        a.cook();
        a.printState();
        a.coin(10);
        a.printState();
    }

}

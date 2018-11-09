package javalab6;

public class PingPong {
private String last = "pong";

    private void Action(String message){

        while (true) {
            if (last.equals(message)){
                try {
                    synchronized (this){
                    wait();}
                } catch (InterruptedException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
         else {
                System.out.println(message);
                last=message;
                synchronized (this){notifyAll();}
            }
        }

    }
    public static void main (String[] args){

        PingPong pingPong = new PingPong();
        new Thread(()->pingPong.Action("ping")).start();
        new Thread(()->pingPong.Action("pong")).start();
        new Thread(()->pingPong.Action("ball")).start();
        new Thread(()->pingPong.Action("balaball")).start();
    }


}

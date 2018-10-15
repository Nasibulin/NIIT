package test;

/**
 * Created with IntelliJ IDEA.
 * User: Nasibulin
 * Date: 04.10.18
 * Time: 15:35
 * To change this template use File | Settings | File Templates.
 */
public class X {
    static int k = 0;
    //static {k=10/0;
    //  }

    public static void main(String[] args) {

        short s = Short.MAX_VALUE; char c = (char) s; System.out.println( c == Short.MAX_VALUE);

    }
}

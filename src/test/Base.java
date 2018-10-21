package test;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 21.10.18
 * Time: 21:38
 * To change this template use File | Settings | File Templates.
 */
public class Base {

    public String data = null;

    public Base()
    {
        data = "default";
        System.out.println("Base()");
    }

    public Base(String arg1) {
        data = arg1;
        System.out.println("Base("+arg1+")");
    }

    public Base(String arg1, String arg2) {
        data = arg2;
        System.out.println("Base("+arg2+")");
    }

}

package test;

/**
 * Created with IntelliJ IDEA.
 * User: Nasibulin
 * Date: 03.10.18
 * Time: 13:00
 * To change this template use File | Settings | File Templates.
 */
import java.util.regex.*;
public class Count{
    public static void main(String args[]){
        Pattern pt=Pattern.compile("Sun Certified Java Programmer");
        Matcher mt=pt.matcher("Certified");
        mt.find();
        System.out.print(mt.group());
    }
}


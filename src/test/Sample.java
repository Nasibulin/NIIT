package test;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Nasibulin
 * Date: 08.10.18
 * Time: 17:34
 * To change this template use File | Settings | File Templates.
 */
public class Sample {

    public static void main(String[] args) {



    List<String>[] arrayOfStringList = new List[] {
            Arrays.asList("qwe", "wer", "ert"),
            Arrays.asList("asd", "sdf", "dfg"),
            Arrays.asList("zxc", "xcv", "cvb")
    };
    System.out.println(Arrays.toString(arrayOfStringList));

    }
}

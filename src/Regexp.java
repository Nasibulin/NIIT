/**
 * Created with IntelliJ IDEA.
 * User: Konstantin
 * Date: 17.09.18
 * Time: 20:56
 * To change this template use File | Settings | File Templates.
 */
public class Regexp {

    public static void main(String[] args) {
        String s = "1,2,3,4-12,14,17,19-23,25";
        String r = s.replaceAll("\\,{1}\\d+\\-{1}","AAA");
        System.out.println(r);

    }

}

/**
 * Created with IntelliJ IDEA.
 * User: Nasibulin
 * Date: 17.09.18
 * Time: 16:16
 * To change this template use File | Settings | File Templates.
 */
public class ExpandRange {

    public static void main(String[] args) {
        StringBuilder s = new StringBuilder(args[0]);
        int startIndex=0;
        while (s.indexOf("-",startIndex)!=-1)
        {
            System.out.println(s.indexOf("-",startIndex));
            startIndex=s.indexOf("-",startIndex)+1;
        }

    }


}

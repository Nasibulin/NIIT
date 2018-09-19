import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: Nasibulin
 * Date: 18.09.18
 * Time: 16:46
 * To change this template use File | Settings | File Templates.
 */
public class CollapseRange {
    public static void main(String args[]) {
        // String to be scanned to find the pattern.
        String line = "1,2,3,4,5,6,7,8,9,10,11,12,14,17,19,20,21,22,23,25,26,30,35,41";
        String pattern = "(\\d+)(,{1})";

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = r.matcher(line);
        Matcher n = r.matcher(line);
        Matcher o = r.matcher(line);
        StringBuffer result = new StringBuffer();

        while (m.find() & n.find() & o.find()) {
            int i = Integer.parseInt(m.group(1));
            int j = Integer.parseInt(n.group(1));
            int k = Integer.parseInt(o.group(1));
            String s = "";
            //System.out.println(m.end());
            //System.out.println("k="+k);
            //System.out.println("k=" + k);
            if (o.find(n.end())& n.find(m.end())) {
                System.out.println(i + "\t" + j + "\t " + k);
                if ((j == i + 1)&(k == j + 1)) m.appendReplacement(result, "");
                else {
                    m.appendReplacement(result, j + ",");
                }
            }
            //System.out.println(result.toString());

        }
        //System.out.println(result.toString());
        m.appendTail(result);
        System.out.println(result.toString());

    }
}

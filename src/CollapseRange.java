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
    public static void main( String args[] ) {
        // String to be scanned to find the pattern.
        String line = "1,2,3,4,5,6,7,8,9,10,11,12,14,17,19,20,21,22,23,25,26,30,35,41";
        String pattern = "(\\d+)(,{1})(\\d+)";

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = r.matcher(line);
        StringBuffer result = new StringBuffer();
        String s="";
        while (m.find()) {
            int k = Integer.parseInt(m.group(1));
            int j = Integer.parseInt(m.group(3));

            if (j==k+1)
            {
              s="";
            }
            else
            {s+=k+",";}
            m.appendReplacement(result,s+"-"+j);
        }
        //System.out.println(result.toString());
        m.appendTail(result);
        System.out.println(result.toString());

    }
}

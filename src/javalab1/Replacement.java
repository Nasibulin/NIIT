package javalab1;

/**
 * Created with IntelliJ IDEA.
 * User: Konstantin
 * Date: 17.09.18
 * Time: 21:21
 * To change this template use File | Settings | File Templates.
 */
class Replacement
{
    public static void main(String args[])
    {
        String Main = "5 * x^3 - 6 * x^1 + 1";
        String replaced = Main.replaceAll("(?m)(:?\\d+) \\* x\\^(:?\\d+)", "$1x<sup>$2</sup>");
        System.out.println(replaced);
    }
}

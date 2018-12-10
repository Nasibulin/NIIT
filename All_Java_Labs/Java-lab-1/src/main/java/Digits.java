
/**
 * Created with IntelliJ IDEA.
 * User: Nasibulin
 * Date: 21.09.18
 * Time: 8:46
 * To change this template use File | Settings | File Templates.
 */
public class Digits {
    static final int DIG_HEIGHT = 8;
    static final int DIG_WIDTH = 7;
    static String[] digitArray = new String[8];

    static {
        digitArray[0] = "  ***     *     ***    ***      *   *****    **   *****   ***    ***  ";
        digitArray[1] = " *   *   **    *   *  *   *    **   *       *     *   *  *   *  *   * ";
        digitArray[2] = " *  **    *        *      *    **   *      *          *  *   *  *   * ";
        digitArray[3] = " * * *    *       *     **    * *   ****   ****       *   ***   *   * ";
        digitArray[4] = " **  *    *      *        *   * *       *  *   *     *   *   *   **** ";
        digitArray[5] = " *   *    *     *         *  *****      *  *   *     *   *   *      * ";
        digitArray[6] = " *   *    *    *      *   *     *   *   *  *   *    *    *   *     *  ";
        digitArray[7] = "  ***     *    *****   ***     ***   ***    ***     *     ***    **   ";
    }


    public static void main(String[] args) {

        System.out.println(main("27092018"));

    }

    public static String main(String line) {
        String result = "";
        char[] charArray = line.toCharArray();

        for (int row = 0; row < DIG_HEIGHT; row++) {
            for (int column = 0; column < line.length(); column++) {
                int k = Character.getNumericValue(charArray[column]);
                result += digitArray[row].substring(k * DIG_WIDTH, k * DIG_WIDTH + DIG_WIDTH);
            }
            result += "\n";
        }
        return result;
    }

}

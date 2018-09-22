import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Nasibulin
 * Date: 21.09.18
 * Time: 8:46
 * To change this template use File | Settings | File Templates.
 */
public class Digits {
    static final int DIG_HEIGHT = 10;
    static final int DIG_WIDTH = 8;
    static final int DIG_QTY = 10;

    static byte[][] digits = new byte[10][90];

    public static void main(String[] args) throws IOException {
        byte[] byteArray = args[0].getBytes();
        byte sym;
        FileToArray();
       // System.out.println(Arrays.toString(byteArray));
        for (int row = 0; row < DIG_HEIGHT; row++) {
            //for (int column=0; column < byteArray.length; column++) {
            for (int column = 0; column < DIG_QTY; column++) {
                for (int pos = 0; pos < DIG_WIDTH; pos++) {
                    sym = digits[column][pos+row + row * DIG_WIDTH];
                    if (sym != 10 & sym != 13) {System.out.print((char) sym);}
//                    else if (sym == 10 || sym == 13) System.out.print((char)32);
//System.out.println(row+" "+column+" "+pos);

                }
            }
            System.out.println();
        }
    }

    static void FileToArray() throws IOException {
        // getBytes from anyWhere
        // I'm getting byte array from File
        for (int i = 0; i < 10; i++) {
            File file = null;
            FileInputStream fileStream = new FileInputStream(file = new File("C:\\Users\\Konstantin\\IdeaProjects\\NIIT\\src\\" + i));

            // Instantiate array
            byte[] arr = new byte[(int) file.length()];

            // read All bytes of File stream
            fileStream.read(arr, 0, arr.length);
            System.arraycopy(arr, 0, digits[i], 0, arr.length);

//            for (byte X : arr) {
//                System.out.print((char) X);
//            }
//            System.out.println("");
        }

    }

}

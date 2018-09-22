import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Nasibulin
 * Date: 21.09.18
 * Time: 8:46
 * To change this template use File | Settings | File Templates.
 */
public class Digits {
    static byte[][] digits = new byte[10][70];

    public static void main(String[] args) throws IOException {

        FileToArray();
        System.out.println(Arrays.deepToString(digits));

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

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Konstantin
 * Date: 22.09.18
 * Time: 7:27
 * To change this template use File | Settings | File Templates.
 */
class ReadBytesFromFile {
    public static void main(String args[]) throws Exception {
        // getBytes from anyWhere
        // I'm getting byte array from File
        byte[][] digit = new byte[10][70];
        for (int i = 0; i < 10; i++) {
            File file = null;
            FileInputStream fileStream = new FileInputStream(file = new File("C:\\Users\\Konstantin\\IdeaProjects\\NIIT\\src\\" + i));

            // Instantiate array
            byte[] arr = new byte[(int) file.length()];

            // read All bytes of File stream
            fileStream.read(arr, 0, arr.length);
            System.arraycopy(arr, 0, digit[i], 0, arr.length);
            System.out.println(Arrays.toString(digit[i]));

//            for (byte X : arr) {
//                System.out.print((char) X);
//            }
//            System.out.println("");
        }

    }
}

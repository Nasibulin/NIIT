import java.io.*;

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
        File file = null;
        FileInputStream fileStream = new FileInputStream(file = new File("C:\\Users\\Konstantin\\IdeaProjects\\NIIT\\src\\0"));

        // Instantiate array
        byte[] arr = new byte[(int) file.length()];

        // read All bytes of File stream
        fileStream.read(arr, 0, arr.length);

        for (int X : arr) {
            System.out.print((char) X);
        }
    }
}

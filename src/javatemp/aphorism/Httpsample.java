package javatemp.aphorism;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created with IntelliJ IDEA.
 * User: Nasibulin
 * Date: 12.11.18
 * Time: 9:43
 * To change this template use File | Settings | File Templates.
 */
public class Httpsample {

    public static void main(String[] args) throws Exception {
        URLConnection connection = new URL("https://api.forismatic.com/api/1.0/?method=getQuote&format=json&key=764214&lang=ru").openConnection();
        //URLConnection connection = new URL("http://api.openweathermap.org/data/2.5/weather?q=London,uk&units=metric&appid=241de9349721df959d8800c12ca4f1f3").openConnection();
        connection.addRequestProperty("User-Agent",
                                                     "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
        InputStream is = connection.getInputStream();
        InputStreamReader reader = new InputStreamReader(is);
        char[] buffer = new char[256];
        int rc;

        StringBuilder sb = new StringBuilder();

        while ((rc = reader.read(buffer)) != -1)
            sb.append(buffer, 0, rc);

        reader.close();

        System.out.println(sb);
    }

}

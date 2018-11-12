package javatemp.aphorism;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class URLReader {
    public static void main(String[] args) throws Exception {

        URL oracle = new URL("https://api.forismatic.com/api/1.0/?method=getQuote&format=json&key=764214&lang=ru");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));

        String inputLine;
        StringBuilder sb = new StringBuilder();
        while ((inputLine = in.readLine()) != null)
            sb.append(inputLine);
        in.close();
        System.out.println(sb);
    }
}

package javatemp.aphorism;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Sample {
private static final String QUOTE_FILE = "db/quotes.txt";

    public static void main(String[] args) {
        Forismatic.Quote quote;
        try (Writer file = new FileWriter(QUOTE_FILE)) {
        for(int i = 0; i < 100; i++) {
                quote = new Forismatic(Forismatic.RUSSIAN).getQuote();
            try {
                file.write(quote.getQuoteText()+"\u00A9 "+quote.getQuoteAuthor()+"\r\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

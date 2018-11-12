package javatemp.aphorism;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private static final String QUOTE_FILE = "db/quotes.txt";
    private static List<String> quote = new ArrayList<>();

    public static void main(String[] args) {
        loadQuotesFile();
        loadQuotesArray();
        System.out.println(quote.get(0));
        Collections.shuffle(quote);
        System.out.println(quote.get(0));
    }

    private static void loadQuotesFile() {
        Forismatic.Quote quote;
        try (Writer file = new FileWriter(QUOTE_FILE)) {
            for (int i = 0; i < 100; i++) {
                quote = new Forismatic(Forismatic.RUSSIAN).getQuote();
                try {
                    file.write(quote.getQuoteText() + "\u00A9 " + quote.getQuoteAuthor() + "\r\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadQuotesArray() {
        File file = new File(QUOTE_FILE);
        try (FileReader reader = new FileReader(file);
             BufferedReader breader = new BufferedReader(reader)) {
            String line;
            while ((line = breader.readLine()) != null) {
                quote.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

package javatemp.aphorism;


public class Example
{
    public static void main(String[] args)
    {
        Quote test = new QuoteBuilder().getQuote();
        System.out.println(test.quoteText + " Author:" + test.quoteAuthor);
    }
}
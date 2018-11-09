package exchange;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CurrencyServer {

    private static final String CBR_API_URL = "https://www.cbr.ru/scripts/XML_daily.asp";
    private static List<Currency> currencyList = new ArrayList<Currency>();

    public static void main(String[] args) {
        getCurrencyList().forEach(item->{System.out.println(item.getNumCode()+"\t"+item.getName()+"\t"+item.getValue());});
    }


    public static List<Currency> getCurrencyList() {

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new URL(CBR_API_URL).openStream());

            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("Valute");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;
                    currencyList.add(new Currency(
                            eElement.getAttribute("ID"),
                            eElement.getElementsByTagName("NumCode").item(0).getTextContent(),
                            eElement.getElementsByTagName("CharCode").item(0).getTextContent(),
                            eElement.getElementsByTagName("Nominal").item(0).getTextContent(),
                            eElement.getElementsByTagName("Name").item(0).getTextContent(),
                            NumberFormat.getInstance(Locale.FRANCE).parse(
                                    eElement.getElementsByTagName("Value").item(0).getTextContent()).doubleValue()
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return currencyList;
    }
}

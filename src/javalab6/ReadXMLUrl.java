package javalab6;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;

public class ReadXMLUrl {

    public static void main(String argv[]) {

        try {

            String url = "https://www.cbr.ru/scripts/XML_daily.asp";
            //File fXmlFile = new File("/Users/mkyong/staff.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new URL(url).openStream());

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName()+" "+doc.getDocumentElement().getAttribute("Date"));

            NodeList nList = doc.getElementsByTagName("Valute");

            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    System.out.println("Valute ID : " + eElement.getAttribute("ID"));
                    System.out.println("NumCode : " + eElement.getElementsByTagName("NumCode").item(0).getTextContent());
                    System.out.println("CharCode : " + eElement.getElementsByTagName("CharCode").item(0).getTextContent());
                    System.out.println("Nominal : " + eElement.getElementsByTagName("Nominal").item(0).getTextContent());
                    System.out.println("Name : " + eElement.getElementsByTagName("Name").item(0).getTextContent());
                    System.out.println("Value : " + eElement.getElementsByTagName("Value").item(0).getTextContent());

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

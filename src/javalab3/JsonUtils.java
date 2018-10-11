package javalab3;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

public class JsonUtils {

    /**
     * Метод для получения данных по указанной ссылке
     *
     * @param url - ссылка в виде объекта URL (Uniform Resource Locator)
     * @return содержимое страницы на указанной ссылке в @param url
     */
    public static String parseUrl(URL url) {
        if (url == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        // открываем соедиение к указанному URL
        // помощью конструкции try-with-resources
        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {

            String inputLine;
            // построчно считываем результат в объект StringBuilder
            while ((inputLine = in.readLine()) != null) {
                stringBuilder.append(inputLine);
                //System.out.println(inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }


    // парсим некоторые данные о студенте
    public static void parseCurrentStudentJson(String resultJson) {
        try {

            JSONObject studentJsonObject = (JSONObject) JSONValue.parseWithException(resultJson);
            JSONArray studentArray = (JSONArray) studentJsonObject.get("Students");
            JSONObject studentData = (JSONObject) studentArray.get(0);

            System.out.println("ID: " + studentData.get("ID"));
            System.out.println("Student: " + studentData.get("STUDENT"));
            System.out.println("Group: " + studentData.get("GROUP"));

            Object objs = studentData.get("MARK");
            if (objs instanceof JSONArray) {
                JSONArray obj = (JSONArray) studentData.get("MARK");
                Iterator objIter = obj.iterator();
                System.out.println("Mark: ");
                while (objIter.hasNext()) {
                    //i++;
                    System.out.print(objIter.next() + " ");
                }
            } else {
                System.out.println("Mark: " + studentData.get("MARK"));

            }


        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    // формируем новый JSON объект из нужных нам погодных данных
    public static String buildStudentJson() {
        // для простоты примера просто хардкодим нужные данные в методе
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Лондон");
        jsonObject.put("main", "Солнечно");
        jsonObject.put("description", "Мороз трескучий, На небе ни единой тучи");

        return jsonObject.toJSONString();
    }

    // создаем объект URL из указанной в параметре строки
    public static URL createUrl(String link) {
        try {
            return new URL(link);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
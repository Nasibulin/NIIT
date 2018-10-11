package javalab3;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

public class Main {
    /**
     * Для простоты и удобства используем уже сформированную строку
     * с запросом погоды в Лондоне на данный момент
     * <p>
     * другие примеры запросов можете глянуть здесь
     * {@see <a href="http://openweathermap.org/current">openweathermap</a>}
     * также Вам понадобится свой API ключ
     */
    public static final String DB_FILE = "Students.json";
    public static final String DB_PATH = System.getProperty("user.dir") + "\\db\\" + DB_FILE;

    //public static String WEATHER_URL = Paths.get(DB_URL).toUri().toURL()
            //"http://api.openweathermap.org/data/2.5/weather?q=Moscow,ru" +
            //        "&units=metric&appid=241de9349721df959d8800c12ca4f1f3";

    public static void main(String[] args) throws MalformedURLException {
        // создаем URL из строки
        URL url = JsonUtils.createUrl (Paths.get(DB_PATH).toUri().toURL().toString());
        //System.out.println(url.toString());
        // загружаем Json в виде Java строки
        String resultJson = JsonUtils.parseUrl(url);
        //System.out.println("Полученный JSON:\n" + resultJson);

        // парсим полученный JSON и печатаем его на экран
        JsonUtils.parseCurrentStudentJson(resultJson);

        // формируем новый JSON объект из нужных нам погодных данных
        //String json = JsonUtils.buildStudentJson();
        //System.out.println("Созданный нами JSON:\n" + json);
    }
}
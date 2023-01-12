package ImprovedQuestion.utils;

import ImprovedQuestion.projo.city;
import ImprovedQuestion.projo.weather;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

public class Information {
    //获取城市信息用于存储
    public static city getCityInfo(String location){
        String jsonString = Information.requestCity(location);
        JSONObject json = JSON.parseObject(jsonString);
        JSONArray locationInfo = json.getJSONArray("location");
        JSONObject jsonObject = locationInfo.getJSONObject(0);
        String s = JSON.toJSONString(jsonObject);
        city city = JSON.parseObject(s, city.class);
        return city;
    }
    //获取天气信息用于存储
    public static List<weather> getWeatherInfo(int id){
        String jsonString = Information.requestWeather(id);
        JSONObject json = JSON.parseObject(jsonString);
        JSONArray daily = json.getJSONArray("daily");
        List<weather> weathers = new ArrayList<weather>();
        for (int x = 0 ; x < daily.size() ; x++){
            JSONObject jsonObject = daily.getJSONObject(x);

            String s = JSON.toJSONString(jsonObject);
            weather weather = JSON.parseObject(s, weather.class);
            weather.setId(id);
            weathers.add(weather);
        }
        return weathers;
    }
    public static String requestCity(String location) {
        String httpUrl = "https://geoapi.qweather.com/v2/city/lookup?key=d4cab218ab5648ac813b0d7d2a59ae01&location=";
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        try {
            httpUrl = httpUrl + URLEncoder.encode(location,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            // 填入apikey到HTTP header
            connection.setRequestProperty("apikey",  "d4cab218ab5648ac813b0d7d2a59ae01");
            connection.connect();

            InputStream is = connection.getInputStream();
            GZIPInputStream gzipInputStream = new GZIPInputStream(is);
            reader = new BufferedReader(new InputStreamReader(gzipInputStream, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    //查询天气信息 以字符串返回 为json类型
    public static String requestWeather(int id) {
        String httpUrl = "https://devapi.qweather.com/v7/weather/3d?key=d4cab218ab5648ac813b0d7d2a59ae01&location=";
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        httpUrl = httpUrl + id;

        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            // 填入apikey到HTTP header
            connection.setRequestProperty("apikey",  "d4cab218ab5648ac813b0d7d2a59ae01");
            connection.connect();

            InputStream is = connection.getInputStream();
            GZIPInputStream gzipInputStream = new GZIPInputStream(is);
            reader = new BufferedReader(new InputStreamReader(gzipInputStream, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

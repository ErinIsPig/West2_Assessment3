package ImprovedQuestion;

import ImprovedQuestion.projo.city;
import ImprovedQuestion.projo.weather;
import ImprovedQuestion.utils.Information;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FastJsonTest {
    @Test
    public void test1(){
        String jsonString = Information.requestCity("福州");
        JSONObject json = JSON.parseObject(jsonString);
        JSONArray location = json.getJSONArray("location");
        JSONObject jsonObject = location.getJSONObject(0);
        String s = JSON.toJSONString(jsonObject);
        city city = JSON.parseObject(s, city.class);
        System.out.println(city);
    }
    @Test
    public void test2(){
        String jsonString = Information.requestWeather(101230101);
        JSONObject json = JSON.parseObject(jsonString);
        JSONArray daily = json.getJSONArray("daily");
        List<weather> weathers = new ArrayList<weather>();
        for (int x = 0 ; x < daily.size() ; x++){
            JSONObject jsonObject = daily.getJSONObject(x);

            String s = JSON.toJSONString(jsonObject);
            weather weather = JSON.parseObject(s, weather.class);
            weather.setId(101230101);
            weathers.add(weather);
        }
        for (weather w:weathers){
            System.out.println(w);
        }
    }
}

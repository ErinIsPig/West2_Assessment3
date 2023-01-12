package ImprovedQuestion.utils;

import ImprovedQuestion.mapper.Mapper;
import ImprovedQuestion.projo.city;
import ImprovedQuestion.projo.weather;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class DataOperator {
    /*
    插入城市信息
     */
    public static int insertCity(String name){
        city city = Information.getCityInfo(name);
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        return mapper.insertCityInfo(city);
    }
    /*
    插入城市天气信息
    如果某个城市天气信息已存在，每次查询都需要根据时间更新，所以要先删除该城市的天气信息
     */
    public static int insertWeather(String name){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        int cityId = mapper.getCityId(name);
        List<Integer> ids = mapper.getIdFromWeather();
        for (Integer id : ids){
            if(id == cityId){
                mapper.deleteWeatherById(cityId);
            }
        }
        List<weather> weathers = Information.getWeatherInfo(cityId);
        for (weather weather : weathers){
            mapper.insertWeather(weather);
        }
       return weathers.size();
    }
}

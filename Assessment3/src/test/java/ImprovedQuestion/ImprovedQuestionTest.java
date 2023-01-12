package ImprovedQuestion;

import ImprovedQuestion.mapper.Mapper;
import ImprovedQuestion.projo.city;
import ImprovedQuestion.projo.weather;
import ImprovedQuestion.utils.DataOperator;
import ImprovedQuestion.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class ImprovedQuestionTest {
    @Test
    //插入北京 上海 福州的城市信息 与 天气信息
    public void testInsert(){
        DataOperator.insertCity("北京");
        DataOperator.insertCity("上海");
        DataOperator.insertCity("福州");
        DataOperator.insertWeather("北京");
        DataOperator.insertWeather("上海");
        DataOperator.insertWeather("福州");
    }
    @Test
    //清空两个表
    public void testDelete(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        mapper.deleteWeather();
        mapper.deleteCity();
    }
    @Test
    public void testSelectByName(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        city FZ = mapper.getCityInfo("福州");
        List<weather> weathers = mapper.getWeatherInfo("福州");
        System.out.println(FZ);
        for (weather weather : weathers){
            System.out.println(weather);
        }
    }
    @Test
    public void testGetAllInfo(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        List<weather> weathers = mapper.getAllWeather();
        List<city> cities = mapper.getAllCity();
        for (city city : cities){
            System.out.println(city);
        }
        for (weather weather:weathers){
            System.out.println(weather);
        }
    }
    @Test
    public void testDeleteByName(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        Mapper mapper = sqlSession.getMapper(Mapper.class);

        mapper.deleteWeatherByName("福州");
        mapper.deleteCityByName("福州");
    }
}

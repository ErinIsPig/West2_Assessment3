package ImprovedQuestion.mapper;

import ImprovedQuestion.projo.city;
import ImprovedQuestion.projo.weather;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Mapper {
    /*
     插入城市信息
     */
    int insertCityInfo(city city);

    /*
     插入天气信息
     */
    int insertWeather(weather weather);

    /*
     根据城市名查询城市ID
     */
    int getCityId(@Param("name") String name);

    /*
        一般不会知道城市id，所以只要通过城市名查询城市信息与城市天气信息
     */
    city getCityInfo(@Param("name") String name);
    List<weather> getWeatherInfo(@Param("name") String name);

    /*
     清空城市信息
     */
    int deleteCity();
    /*
    清空天气信息
     */
    int deleteWeather();

    /*
     从天气表中返回Id
     */
    List<Integer> getIdFromWeather();
    /*
     根据id删除天气信息
     */
    int deleteWeatherById(@Param("id") int id);
    /*
    查询所有城市信息
     */
    List<city> getAllCity();
    /*
    查询所有城市
     */
    List<weather> getAllWeather();
    /*
    根据城市名删除城市信息 天气信息
     */
    int deleteCityByName(@Param("name") String name);
    int deleteWeatherByName(@Param("name") String name);



}

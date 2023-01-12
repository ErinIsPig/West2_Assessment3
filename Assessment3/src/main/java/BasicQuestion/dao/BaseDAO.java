package BasicQuestion.dao;

import BasicQuestion.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.util.List;

public class BaseDAO {
    private QueryRunner queryRunner = new QueryRunner();
    //增删改
    public int update(String sql, Object... args) {
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            return queryRunner.update(connection, sql, args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection);
        }
        return -1;
    }
    //查询一个学生信息
    public <T> T queryForOne(Class<T> type, String sql, Object... args) {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            return queryRunner.query(conn,sql,new BeanHandler<>(type),args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn);
        }
        return null;
    }
    //查询多个学生信息
    public <T> List<T>  queryForList(Class<T> type, String sql, Object... args){
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            return queryRunner.query(conn,sql,new BeanListHandler<>(type),args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn);
        }
        return null;
    }

    public Object selectForOneValue(String sql ,Object... args){
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            return queryRunner.query(conn,sql,new ScalarHandler<>(),args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn);
        }
        return null;
    }

}

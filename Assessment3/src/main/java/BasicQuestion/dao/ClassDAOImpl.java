package BasicQuestion.dao;

import BasicQuestion.projo.Student;
import BasicQuestion.projo.StudentClass;

import java.sql.Timestamp;
import java.util.List;

public class ClassDAOImpl extends BaseDAO implements ClassDAO{
    /*
    学生表作为主表，班级表作为从表，修改和删除操作为级联操作
    修改删除学生信息只需要对主表进行操作，添加学生需要对两个表都进行操作
     */
    @Override
    public int addInformation(int classId, int studentId, Timestamp arrivalTime) {
        String sql = "insert into classes(classId,studentId,arrivalTime)values(?,?,?)";
        return update(sql,classId,studentId,arrivalTime);
    }

    @Override
    public int updateTime(int studentId, Timestamp arrivalTime) {
        String sql = "update classes set arrivalTime = ? where studentId = ?";
        return update(sql,arrivalTime,studentId);
    }

    @Override
    public int updateClassId(int studentId, int classId) {
        String sql = "update classes set classId = ? where studentId = ?";
        return update(sql,classId,studentId);
    }

    @Override
    public StudentClass querForInfoByStudentId(int studentId) {
        String sql = "select distinct classId,studentId,arrivalTime from classes where studentId = ?";

        return queryForOne(StudentClass.class,sql,studentId);
    }

    @Override
    public List<StudentClass> querForAllInfo() {
        String sql = "select classId,studentId,arrivalTime from classes";
        return queryForList(StudentClass.class,sql);
    }

    @Override
    public int deleteByStudentId(int studentId) {
        String sql = "delete from classes where studentId = ?";
        return update(sql,studentId);
    }

    @Override
    public int deleteAllInfo() {
        String sql = "delete from students";
        return update(sql);
    }
}

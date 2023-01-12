package BasicQuestion.dao;

import BasicQuestion.projo.Student;

import java.sql.Timestamp;
import java.util.List;

public class StudentDAOImpl extends BaseDAO implements StudentDAO{
    /*
    学生表作为主表，班级表作为从表，修改和删除操作为级联操作
    修改删除学生信息只需要对主表进行操作，添加学生需要对两个表都进行操作
     */
    private static  ClassDAOImpl info = new ClassDAOImpl();
    @Override
    public int addStudent(Student student) {
        String sql = "insert into students(studentId,`name`,gender)values(?,?,?)";
        return update(sql,student.getStudentId(),student.getName(),student.getGender());
    }

    @Override
    public int deleteStudent(int studentId) {
        String sql = "delete from students where studentId = ?";
        return update(sql,studentId);
    }

    @Override
    public int updateStudentName(int studentId,String name) {
        String sql = "update students set `name` = ? where studentId = ?";
        return update(sql,name,studentId) ;
    }

    @Override
    public int updateStudentGender(int studentId, String gender) {
        String sql = "update students set gender = ? where studentId = ?";
        return update(sql,gender,studentId);
    }

    @Override
    public int updateStudentId(int studentId, String name) {
        String sql = "update students set studentId = ? where name = ?";
        return update(sql,studentId,name);
    }

    @Override
    public Student queryForStudentById(int studentId) {
        String sql = "select studentId,`name`,gender from students where studentId = ?";
        return queryForOne(Student.class,sql,studentId);
    }

    @Override
    public List<Student> queryForAllStudents() {
        String sql = "select studentId,`name`,gender from students";
        return queryForList(Student.class,sql);
    }

    @Override
    public int queryForStudentsNumber() {
        String sql = "select count(*) from students";
        Number count = (Number) selectForOneValue(sql);
        return count.intValue();
    }

    @Override
    public int deleteAllStudents() {
        String sql = "delete from students";
        return update(sql);
    }
}

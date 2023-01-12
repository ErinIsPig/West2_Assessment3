package BasicQuestion.dao;

import BasicQuestion.projo.Student;

import java.sql.Timestamp;
import java.util.List;

public interface StudentDAO {

    public int addStudent(Student student);//添加学生
    public int deleteStudent(int studentId);//删除学生
    public int updateStudentName(int studentId,String name);//通过学号修改学生姓名
    public int updateStudentGender(int studentId,String gender);//通过学号修改学生性别
    public int updateStudentId(int studentId,String name);//通过学生姓名修改学生学号
    public Student queryForStudentById(int studentId);//通过学号查询学生信息
    public List<Student> queryForAllStudents();//查询所有学生信息
    public int queryForStudentsNumber();//查询学生数量

    public int deleteAllStudents();

}

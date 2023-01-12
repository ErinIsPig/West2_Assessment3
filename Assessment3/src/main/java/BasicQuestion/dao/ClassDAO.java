package BasicQuestion.dao;

import BasicQuestion.projo.Student;
import BasicQuestion.projo.StudentClass;

import java.sql.Timestamp;
import java.util.List;

public interface ClassDAO {
    //添加学生信息
    public int addInformation(int classId, int studentId, Timestamp arrivalTime);
    //通过学号修改到班时间
    public int updateTime(int studentId,Timestamp arrivalTime);
    //通过学号修改班级编号
    public int updateClassId(int studentId,int classId);

    public StudentClass querForInfoByStudentId(int studentId);

    public List<StudentClass> querForAllInfo();

    public int deleteByStudentId(int studentId);
    public int deleteAllInfo();
}

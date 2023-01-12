package BasicQuestion;

import BasicQuestion.dao.ClassDAOImpl;
import BasicQuestion.dao.StudentDAOImpl;
import BasicQuestion.projo.Student;
import BasicQuestion.projo.StudentClass;

import java.sql.Timestamp;
import java.util.List;

public class StudentTest {
    public static void main(String[] args) {
        StudentDAOImpl student = new StudentDAOImpl();

        Student s1 = new Student(1001,"Erin","F");
        student.addStudent(s1);

        Student s2 = new Student(1002,"Harry","M");
        student.addStudent(s2);

        Student s3 = new Student(1003,"Henry","F");
        student.addStudent(s3);
        student.updateStudentGender(1003,"M");
        List<Student> students = student.queryForAllStudents();
        for (Student ss : students){
            System.out.println(ss);
        }

        ClassDAOImpl Class1 = new ClassDAOImpl();

        Class1.addInformation(002,1001,new Timestamp(123,1,9,9,30,30,0));
        Class1.addInformation(002,1002,new Timestamp(123,1,9,10,30,30,0));
        Class1.addInformation(001,1003,new Timestamp(123,1,10,15,20,30,20));
        Class1.updateClassId(1002,001);
//        Class1.deleteAllInfo();
        List<StudentClass> classes = Class1.querForAllInfo();
        for(StudentClass c: classes){
            System.out.println(c);
        }

    }
}

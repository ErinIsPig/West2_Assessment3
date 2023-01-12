package BasicQuestion.projo;

import java.sql.Timestamp;

public class StudentClass {
    private int classId;
    private int studentId;
    private Timestamp arrivalTime;

    public StudentClass() {
    }

    public StudentClass(int classId, int studentId, Timestamp arrivalTime) {
        this.classId = classId;
        this.studentId = studentId;
        this.arrivalTime = arrivalTime;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Timestamp arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return "Class{" +
                "classId=" + classId +
                ", studentId=" + studentId +
                ", arrivalTime=" + arrivalTime +
                '}';
    }
}

package BasicQuestion.projo;

public class Student {
    private int studentId;
    private String name;
    private String gender;

    public Student() {
    }

    public Student(int studentId, String name, String gender) {
        this.studentId = studentId;
        this.name = name;
        if(gender.matches("(F|M)")  ){
            this.gender = gender;
        }else{
            System.out.println("Invalid input");
        }

    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if(gender.matches("(F|M)")  ){
            this.gender = gender;
        }else{
            System.out.println("Invalid input");
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }
}

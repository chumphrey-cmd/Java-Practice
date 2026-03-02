import java.util.ArrayList;
import java.util.Collections;

public class ArrayListStudentSortByAge {


    /// NOTE: Here we are using ArrayList to sort Class Objects...
    /// See the Student2.java Class to determine the criteria that we are comparing against!
    public static void main (String[] args){

        ArrayList<Student2> student = new ArrayList<>();

        Student2 stu1 = new Student2(18, 2.3);
        Student2 stu2 = new Student2(23, 2.5);
        Student2 stu3 = new Student2(13, 3.3);
        Student2 stu4 = new Student2(25, 3.9);

        student.add(stu1);
        student.add(stu2);
        student.add(stu3);
        student.add(stu4);

        Collections.sort(student);
        for (Student2 i : student){
            System.out.println("Ordered List by GPA: " + i);
        }

    }

}

/// COMPARABLE here is used to allow you to compare...
/// THIS IS REQUIRED IF YOU WANT TO USE ARRAY LIST TO COMPARE AGAINST OTHER CLASS OBJECTS!

public class Student2 implements Comparable<Student2> {
    private int age;
    private double gpa;

    public Student2(int age, double gpa) {
        this.age = age;
        this.gpa = gpa;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", gpa=" + gpa +
                '}';
    }


    ///  Here we are specifying WHAT we want to compare against!
    /// If we want to compare for AGE!
//    @Override
//    public int compareTo(Student2 obj) {
//        return this.age - obj.age;
//    }

    /// If we want to compare against the GPA!
    @Override
    public int compareTo(Student2 obj){
        if (this.gpa < obj.gpa){
            return 1; // 1: means sort from large to small
        }
        else
            return -1; // -1: means sort from small to large; 0: means that there is no difference
    }
}


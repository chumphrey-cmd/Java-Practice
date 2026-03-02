/// Here is an example of the static creation of a Student array with required age + GPA parameters passed (required by out Student class)

public class Main {

    public static void main(String[] args) {

        // Statically generated Array List with required Student parameters passed to sort and search through...

        Student[] students = new Student[5];
        students[0] = new Student(20,2.2);
        students[1] = new Student(18,2.8);
        students[2] = new Student(25,2.5);
        students[3] = new Student(17,2.7);
        students[4] = new Student(19,2.9);

        int num = 18;

        /// Calling the functions we created from below...
        /// Here we are passing in the student list container age and gpa (this can easily be modified to accept user input)
        sortStudents(students);
        searchStudents(students, num);

    }

    ///  Sorting based on AGE or GPA via getters...
    public static void sortStudents(Student[] students){
        int size = students.length;

        for(int i=0; i < size-1; i++)
            for(int j=0 ; j < size-i-1 ; j++)

            /// Here we are using the getters to obtain the age values from our Student Class
                if (students[j].getAge() > students[j+1].getAge()){
                    Student temp = students[j];
                    students[j] = students[j+1];
                    students[j+1] = temp ;
                }

        for(Student i : students)
            System.out.println("Here is the list of Students sorted by Age: " + i);

    }

    /// Binary Search student by age using getters...
    public static void searchStudents(Student[] students, int num){

        int lower =0;
        int upper = students.length-1 ;

        while(lower <= upper){
            int mid = lower + (upper-lower)/2 ;
            if(students[mid].getAge() == num){
                System.out.println("Found the age you were looking for: " + num);
                return ;
            }

            if(students[mid].getAge() > num)
                upper = mid - 1 ;
            else
                lower = mid + 1;

        }

        System.out.println("Could not find the age, try using another age.");

    }

}

///  Basic Student Class used by Main.java
public class Student {
    private int age;
    private double gpa;

    public Student(int age, double gpa) {
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
}
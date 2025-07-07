class Student {
    String name;
    static String school;
    public static void changeSchool () {
        school = "New School";
    }
}
public class OOPS {
    public static void main (String [] args) {
        Student.school = "ABC";
        Student student1 = new Student();
        student1.name = "Flower";
        System.out.println(student1.school);


    }
}
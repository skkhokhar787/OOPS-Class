class Student {
    String name;
    int age;

    Student () {
        System.out.println("This is constructor.");
    }

}

public class OOPS {
    public static void main (String [] args) {
        Pen pen1 = new Pen();
        pen1.color = "Red";
        pen1.type = "gel";

        pen1.write();

    }
}
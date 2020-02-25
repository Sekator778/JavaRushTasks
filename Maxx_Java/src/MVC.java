public class MVC {
    public static void main(String[] args) {
        Controler controler = new Controler();
        controler.execute();
    }

}
class Student {
    String name = "Alex";
    int age = 41;

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
}
interface ModelLayer {
    Student getStudent();
}

class DBLayer implements ModelLayer {

    @Override
    public Student getStudent() {
        return new Student();
    }
}
interface View {
    void ShowStudent (Student student);
}
class ConcoleView implements View {

    @Override
    public void ShowStudent(Student student) {
        System.out.println("Student name: " + student.getName() + " age: " + student.getAge());
    }
}
class Controler {
    ModelLayer modelLayer = new DBLayer();
    View view = new ConcoleView();
    void execute() {
        Student student = modelLayer.getStudent();
        view.ShowStudent(student);
    }
}
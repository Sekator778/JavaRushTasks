import java.util.ArrayList;
import java.util.List;
interface Observer {
    void event(List<String> strings);
}
class University {
    private List<Observer> observers = new ArrayList<Observer>();
    private List<String> students = new ArrayList<String>();
    public void addStudent(String name) {
        students.add(name);
        notifyObservers();
    }
    public void removeStudent(String name) {
        students.remove(name);
        notifyObservers();
    }
    public void addObserver(Observer observer){
        observers.add(observer);
    }
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    public void notifyObservers(){
        for (Observer observer : observers) {
            observer.event(students);
        }
    }
}
class Director implements Observer {
    public void event(List<String> strings) {
        System.out.println("The list of students has changed: " + strings);
    }
}

public class ObserverTest {//тест
    public static void main(String[] args) {
        University university = new University();
        Director director = new Director();
        university.addStudent("Vaska");
        university.addObserver(director);
        university.addStudent("Anna");
        university.removeStudent("Vaska");
    }
}

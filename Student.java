
public class Student {
    MyLinkedList<Course> courses;
    int id;

    Student(int id) {
        this.id = id;
        courses = new MyLinkedList<Course>();
    }
}


public class Course {
    MyLinkedList<Student> students;

    int id;

    Course(int id) {
        this.id = id;
        students = new MyLinkedList<Student>();
    }
}


public class Student {
    CourseLinkedList courses;
    int id;
    String name;

    Student(int id) {
        this.id = id;
        courses = new CourseLinkedList();
    }
}

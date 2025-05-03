
public class Course {
    StudentLinkedList students;

    int id;
    String title;

    Course(int id) {
        this.id = id;
        students = new StudentLinkedList();
    }
}

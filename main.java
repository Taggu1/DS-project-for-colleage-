public class main {
    // Linked Lists for all students and all courses
    static MyLinkedList<Student> allStudnets;
    static MyLinkedList<Course> allCourses;

    public static void main(String[] args) {

    }

    // This function adds a student to the list
    public static void addStudent(int studentId) {
        Student newStudnet = new Student(studentId);
        allStudnets.add(newStudnet);
    }

    // This function adds a Course to the list
    public static void addCourse(int courseId) {
        Course newCourse = new Course(courseId);
        allCourses.add(newCourse);
    }

    // rest of fuctions to be added .....
}
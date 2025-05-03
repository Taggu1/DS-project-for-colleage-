import java.util.Stack;

public class ManagmentSystem {
    // Linked Lists for all students and all courses
    private StudentLinkedList allStudnets = new StudentLinkedList();
    public CourseLinkedList allCourses = new CourseLinkedList();

    private Stack<Action> undoStack = new Stack<Action>();
    private Stack<Action> redoStack = new Stack<Action>();

    // hanna
    public void addStudent(int studentId) {
        Student newStudnet = new Student(studentId);
        allStudnets.add(newStudnet);
        undoStack.push(new Action("add student", studentId, 0));

    }

    // marwa
    public void addCourse(int courseId) {
        Course newCourse = new Course(courseId);
        allCourses.add(newCourse);
        undoStack.push(new Action("add course", 0, courseId));

    }

    // hanna
    public void removeStudent(int studentId) {
        Student student = allStudnets.getById(studentId);

        if (student != null) {
            allStudnets.remove(student);
            allCourses.removeStudentFromCourses(student);
            undoStack.push(new Action("remove student", studentId, 0));
        }

    }

    // marwa
    public void removeCourse(int courseId) {
        Course course = allCourses.getById(courseId);

        if (course != null) {
            allCourses.remove(course);
            allStudnets.removeCourse(course);
            undoStack.push(new Action("remove course", 0, courseId));
        }

    }

    // hanna
    public int getLastStudentAdded() {
        return allStudnets.top().id;
    }

    // marwa
    public int getLastCourseAdded() {
        return allCourses.top().id;
    }

    // MOHAB
    public void enrollStudent(int studentId, int courseId) {
        Student student = allStudnets.getById(studentId);
        Course course = allCourses.getById(courseId);

        if (student == null || course == null) {
            return;
        }

        course.students.add(student);
        student.courses.add(course);
        undoStack.push(new Action("enroll", studentId, courseId));

    }

    // MOHAAB
    public void removeEnrolment(int studentId, int courseId) {
        Student student = allStudnets.getById(studentId);
        Course course = allCourses.getById(courseId);

        if (student == null || course == null) {
            return;
        }

        course.students.remove(student);
        student.courses.remove(course);
        undoStack.push(new Action("remove", studentId, courseId));

    }

    // hisham
    public void listCoursesByStudent(int studentId) {
        Student student = allStudnets.getById(studentId);

        if (student == null) {
            System.out.println("Student not found");
            return;
        }

        student.courses.printList();
    }

    // mostfa
    public void listStudentsByCourse(int courseId) {
        Course course = allCourses.getById(courseId);

        if (course == null) {
            System.out.println("Course not found");
            return;

        }

        course.students.printList();
    }

    // hisham
    public void sortStudentsByID(int courseId) {
        Course course = allCourses.getById(courseId);

        if (course != null)
            course.students.sortById();
    }

    // mostfa
    public void sortCoursedById(int studentId) {
        Student student = allStudnets.getById(studentId);
        if (student != null)
            student.courses.sortById();
    }

    // MOHAB
    public boolean isFullCourse(int courseId) {
        Course course = allCourses.getById(courseId);
        return course != null ? course.students.count() >= 30 : false;
    }

    // hisham
    public boolean isNormalStudent(int studentId) {
        Student student = allStudnets.getById(studentId);
        System.out.println(student.courses.count());

        return student != null ? student.courses.count() >= 2 && student.courses.count() <= 7 : false;
    }

    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo.");
            return;
        }

        Action act = undoStack.pop();
        if (act.type.equals("enroll")) {
            removeEnrolment(act.studentID, act.courseID);
        } else if (act.type.equals("remove")) {
            enrollStudent(act.studentID, act.courseID);
        } else if (act.type.equals("add student")) {
            removeStudent(act.studentID);
        } else if (act.type.equals("remove student")) {
            addStudent(act.studentID);
        } else if (act.type.equals("add course")) {
            removeCourse(act.courseID);
        } else if (act.type.equals("remove course")) {
            addCourse(act.courseID);
        }
        redoStack.push(new Action(act.type, act.studentID, act.courseID));
    }

    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("Nothing to redo.");
            return;
        }

        Action act = redoStack.pop();
        if (act.type.equals("enroll")) {
            enrollStudent(act.studentID, act.courseID);
        } else if (act.type.equals("remove")) {
            removeEnrolment(act.studentID, act.courseID);
        } else if (act.type.equals("add student")) {
            addStudent(act.studentID);
        } else if (act.type.equals("remove student")) {
            removeStudent(act.studentID);
        } else if (act.type.equals("add course")) {
            addCourse(act.courseID);
        } else if (act.type.equals("remove course")) {
            removeCourse(act.courseID);
        }

        undoStack.push(new Action(act.type, act.studentID, act.courseID));

    }
}
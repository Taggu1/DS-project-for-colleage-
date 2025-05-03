public class Main {
    public static void main(String[] args) {
        ManagmentSystem ms = new ManagmentSystem();

        // Test addStudent and getLastStudentAdded
        System.out.println("Testing addStudent...");
        ms.addStudent(1);
        System.out.println("Last student added: " + ms.getLastStudentAdded() + " (Expected: 1)");

        // Test addCourse and getLastCourseAdded
        System.out.println("\nTesting addCourse...");
        ms.addCourse(101);
        System.out.println("Last course added: " + ms.getLastCourseAdded() + " (Expected: 101)");

        // Test enrollStudent
        System.out.println("\nTesting enrollStudent...");
        ms.enrollStudent(1, 101);
        System.out.println("Courses for student 1:");
        ms.listCoursesByStudent(1);
        System.out.println("Students in course 101:");
        ms.listStudentsByCourse(101);

        // Test removeEnrolment
        System.out.println("\nTesting removeEnrolment...");
        ms.removeEnrolment(1, 101);
        System.out.println("Courses for student 1 after removal:");
        ms.listCoursesByStudent(1);
        System.out.println("Students in course 101 after removal:");
        ms.listStudentsByCourse(101);

        // Test sortStudentsByID
        System.out.println("\nTesting sortStudentsByID...");
        ms.addStudent(3);
        ms.addStudent(2);
        ms.enrollStudent(2, 101);
        ms.enrollStudent(3, 101);

        System.out.println("Students in course 101 before sorting:");
        ms.listStudentsByCourse(101);
        ms.sortStudentsByID(101);
        System.out.println("Students in course 101 after sorting:");
        ms.listStudentsByCourse(101);

        // Test sortCoursedById
        System.out.println("\nTesting sortCoursedById...");
        ms.addCourse(102);
        ms.addCourse(100);
        ms.enrollStudent(1, 100);
        ms.enrollStudent(1, 102);

        System.out.println("Courses for student 1 before sorting:");
        ms.listCoursesByStudent(1);
        ms.sortCoursedById(1);
        System.out.println("Courses for student 1 after sorting:");
        ms.listCoursesByStudent(1);

        // Test isFullCourse
        System.out.println("\nTesting isFullCourse...");
        System.out.println("Is course 101 full? " + ms.isFullCourse(101) + " (Expected: false)");
        // Enroll 30 students in course 101
        for (int i = 3; i <= 30; i++) {
            ms.addStudent(i);
            ms.enrollStudent(i, 101);
        }
        System.out
                .println("Is course 101 full after adding 30 students? " + ms.isFullCourse(101) + " (Expected: true)");

        // Test isNormalStudent
        System.out.println("\nTesting isNormalStudent...");
        System.out.println("Is student 1 normal? " + ms.isNormalStudent(1) + " (Expected: true)");
        // Enroll student 1 in more courses
        for (int i = 103; i <= 108; i++) {
            ms.addCourse(i);
            ms.enrollStudent(1, i);
        }
        System.out.println(
                "Is student 1 normal after enrolling in 9 courses? " + ms.isNormalStudent(1) + " (Expected: false)");

        // Test undo
        System.out.println("\nTesting undo...");
        ms.undo(); // Undo last enrollment (course 108)

        System.out.println("After undo, is student 1 normal? " + ms.isNormalStudent(1) + " (Expected: true)");

        // Test redo
        System.out.println("\nTesting redo...");
        ms.redo(); // Redo the enrollment

        System.out.println("After redo, is student 1 normal? " + ms.isNormalStudent(1) + " (Expected: false)");

        // Test removeStudent
        System.out.println("\nTesting removeStudent...");
        ms.removeStudent(1);
        System.out.println("Courses for student 1 after removal:");
        try {
            ms.listCoursesByStudent(1);
        } catch (Exception e) {
            System.out.println("Student not found (Expected)");
        }

        // Test removeCourse
        System.out.println("\nTesting removeCourse...");
        ms.removeCourse(101);

        System.out.println("Students in course 101 after removal:");
        try {
            ms.listStudentsByCourse(101);
        } catch (Exception e) {
            System.out.println("Course not found (Expected)");
        }
    }
}

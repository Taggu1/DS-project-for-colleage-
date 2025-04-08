
// Core DS of the project, it's generic to be able to make two versions one for students and one for courses
// Java generics: https://www.baeldung.com/java-generics
// Also generics in general: https://en.wikipedia.org/wiki/Generic_programming
public class MyLinkedList<T> {

    // Node for the list, it's also generic
    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // head node, hold data of the head of the list
    // private so no one can edit it from outside
    private Node head;

    // default instructor for the linked list, makes the head null
    public MyLinkedList() {
        this.head = null;
    }

    // adds a new node to the list, this function also uses the gneric type 'T', so
    // it can accept
    // whatever type the class accepts
    public void add(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public T top() {
        return head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    // prints all items of the lists, for debugging :)
    public void printList() {
        Node current = head;
        while (current != null) {

            // checks if the data is a student or a course
            if (current.data instanceof Student) {

                // Casting the data-generice type to A student type to be able to access it's
                // fields
                Student currentStudent = (Student) current.data;

                System.out.println("Student " + "Id: " + currentStudent.id);

            } else if (current.data instanceof Course) {

                // Casting the data-generice type to A course type to be able to access it's
                // fields
                Course currentCourse = (Course) current.data;

                System.out.println("Course " + "Id: " + currentCourse.id);
            }
            current = current.next;
        }
        System.out.println();
    }
}

public class CourseLinkedList {

    private static class Node {
        Course data;
        Node next;

        Node(Course data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    // Constructor: initialize empty list
    public CourseLinkedList() {
        this.head = null;
        this.size = 0;

    }

    // Add a Course to the end of the list
    public void add(Course data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void removeStudentFromCourses(Student studentId) {
        Node current = head;
        while (current.next != null) {
            current.data.students.remove(studentId);
            current = current.next;
        }
    }

    // Remove first occurrence of the given Course
    // Returns true if removed, false otherwise
    public boolean remove(Course data) {
        if (head == null) {
            return false;
        }
        if (head.data.equals(data)) {
            head = head.next;
            size--;

            return true;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data.equals(data)) {
                current.next = current.next.next;
                size--;

                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Remove and return the first Course in the list
    // Throws NoSuchElementException if empty
    public Course removeFirst() {
        if (head == null) {
            throw new java.util.NoSuchElementException("List is empty");
        }
        Course value = head.data;
        head = head.next;
        size--;

        return value;
    }

    // Peek at the first Course without removing
    public Course top() {
        if (head == null) {
            throw new java.util.NoSuchElementException("List is empty");
        }
        return head.data;
    }

    public int count() {
        return size;
    }

    public Course getById(int id) {
        Node current = head;
        while (current != null) {
            if (current.data.id == id) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    // Check if the list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Print all courses in the list
    public void printList() {
        Node current = head;
        while (current != null) {
            Course c = current.data;
            System.out.println("Course Id: " + c.id + ", Title: " + c.title);
            current = current.next;
        }
        System.out.println();
    }

    // Sort the linked list by student ID in ascending order
    public void sortById() {
        if (head == null || head.next == null)
            return;
        Node sorted = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            sorted = sortedInsert(sorted, current);
            current = next;
        }
        head = sorted;
    }

    // Helper for insertion into sorted list
    private Node sortedInsert(Node sorted, Node newNode) {
        if (sorted == null || newNode.data.id < sorted.data.id) {
            newNode.next = sorted;
            return newNode;
        } else {
            Node curr = sorted;
            while (curr.next != null && curr.next.data.id < newNode.data.id) {
                curr = curr.next;
            }
            newNode.next = curr.next;
            curr.next = newNode;
            return sorted;
        }
    }
}
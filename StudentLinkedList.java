public class StudentLinkedList {

    private static class Node {
        Student data;
        Node next;

        Node(Student data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public void removeCourse(Course course) {
        Node current = head;
        while (current.next != null) {
            current.data.courses.remove(course);
            current = current.next;
        }
    }

    // Constructor: initialize empty list
    public StudentLinkedList() {
        this.head = null;
        this.size = 0;

    }

    // Add a Student to the end of the list
    public void add(Student data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    // Remove first occurrence of the given Student
    // Returns true if removed, false otherwise
    public boolean remove(Student data) {
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

    // Remove and return the first Student in the list
    // Throws NoSuchElementException if empty
    public Student removeFirst() {
        if (head == null) {
            throw new java.util.NoSuchElementException("List is empty");
        }
        Student value = head.data;
        head = head.next;
        size--;

        return value;
    }

    public int count() {
        return size;
    }

    // Peek at the first Student without removing
    public Student top() {
        if (head == null) {
            throw new java.util.NoSuchElementException("List is empty");
        }
        return head.data;
    }

    // Check if the list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Print all students in the list
    public void printList() {
        Node current = head;
        while (current != null) {
            Student s = current.data;
            System.out.println("Student Id: " + s.id + ", Name: " + s.name);
            current = current.next;
        }
        System.out.println();
    }

    public Student getById(int id) {
        Node current = head;
        while (current != null) {
            if (current.data.id == id) {
                return current.data;
            }
            current = current.next;
        }
        return null;
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

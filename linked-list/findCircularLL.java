import java.util.Random;
import java.util.Scanner;

public class findCircularLL {
    public static class Node {

        int data;
        Node next = null;
    }

    // Function to create a random loop in the linked list
    static void createRandomLoop(Node head, int n) {
        if (head == null || n < 2)
            return;

        Random rand = new Random();

        int loopPos = rand.nextInt(n); // random position (0 to n-1)

        Node temp = head;
        Node loopNode = null;

        // Traverse the list and remember loop target node
        for (int i = 1; i < n - 1; i++) {
            if (i == loopPos)
                loopNode = temp;
            temp = temp.next;
        }

        // Avoid null edge case
        if (loopNode == null)
            loopNode = head;

        temp.next = loopNode; // create the loop
        System.out.println("\nLoop created at position: " + loopPos);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        Node head = null, temp = null;

        System.out.println("Enter " + n + " node values:");
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            Node curr = new Node();
            curr.data = val;

            if (head == null) {
                head = curr;
                temp = curr;
            } else {
                temp.next = curr;
                temp = curr;
            }
        }

        createRandomLoop(head, n);
        System.out.println("***************************OUTPUT*******************************");
        Node Joint = checkCircular(head);
        if (Joint != null) {
            System.out.println("Circular");

            Node Point = findPoint(head, Joint);
            System.out.println("point" + Point.data);

            removeCircularLoop(head, Point, Joint);

            System.out.println("***remove Circular***");
            System.out.println("***re-Check***");
            Joint = checkCircular(head);
            if (Joint != null) {
                System.out.println("Circular");
            } else {
                System.out.println("Linear");
            }
        } else {
            System.out.println("Linear");
        }
    }

    public static Node checkCircular(Node head) {
        if (head == null || head.next == null)
            return null;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) // meeting point found
                return slow;
        }

        return null; // no loop
    }

    public static Node findPoint(Node head, Node Joint) {
        while (head != Joint) {
            head = head.next;
            Joint = Joint.next;
        }
        return Joint;
    }

    public static void removeCircularLoop(Node head, Node Point, Node Joint) {

        while (Joint.next != Point) {
            Joint = Joint.next;
        }
        Joint.next = null;
    }
}

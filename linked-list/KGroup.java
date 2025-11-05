
import java.util.Scanner;

public class KGroup {

    public static class Node {

        int data;
        Node next = null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Node head = new Node();
        Node temp = head;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                head.data = sc.nextInt();
            } else {
                Node curr = new Node();
                curr.data = sc.nextInt();
                temp.next = curr;
                temp = curr;
            }
        }

        head = KGroupReversNode(head, k);
        temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static Node KGroupReversNode(Node head, int k) {
        if (head == null) {
            return null;
        }
        
        int count = 0;
        Node pervNode = null;
        Node tempNode = head;
        Node nextNode = null;
        while (tempNode != null && count < k) {
            nextNode = tempNode.next;
            tempNode.next = pervNode;
            pervNode = tempNode;
            tempNode = nextNode;
            count++;
        }
        if (nextNode != null) {
            head.next = KGroupReversNode(nextNode, k);
        }
        return pervNode;
    }
}

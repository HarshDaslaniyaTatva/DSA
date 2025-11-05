
public class ReverseLinkedList {

    public static class Node {

        int data;
        Node tail = null;
    }

    public static void main(String[] args) {
        int[] testData = {1, 2, 3, 4, 5};
        Node head = new Node();
        Node temp = new Node();
        for (int i = 0; i < testData.length; i++) {
            if (i == 0) {
                temp.data = testData[i];
                head = temp;
            } else {
                Node newNode = new Node();
                temp.tail = newNode;
                newNode.data = testData[i];
                temp = newNode;
            }
        }

        temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.tail;
        }
        System.out.println("");

        // head = reverse(head);
        // head = recursionReverse(null, head);
        head = recursionReverse2(head);

        temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.tail;
        }

    }

    public static Node reverse(Node head) {
        Node pervNode = null;
        Node tempNode = head;
        Node nextNode;
        while (tempNode != null) {
            nextNode = tempNode.tail;
            tempNode.tail = pervNode;
            pervNode = tempNode;
            tempNode = nextNode;
        }
        return pervNode;
    }

    public static Node recursionReverse(Node pervNode, Node currNode) {
        if (currNode.tail == null) {
            currNode.tail = pervNode;
            return currNode;

        }
        Node head = recursionReverse(currNode, currNode.tail);
        currNode.tail = pervNode;

        return head;
    }

    public static Node recursionReverse2(Node head) {
        if (head == null || head.tail == null) {
            return head;
        }
        Node lastHead = recursionReverse2(head.tail);
        head.tail.tail = head;
        head.tail = null;
        return lastHead;
    }
}

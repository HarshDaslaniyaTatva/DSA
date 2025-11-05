
public class FindMid {

    public static class Node {

        int data;
        Node tail = null;
    }

    public static void main(String[] args) {
        int[] testData = {1, 2, 3};
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

        int mid = findMid(head);

        System.out.print(mid);

    }

    public static int findMid(Node head) {
        if (head.tail.tail == null) {
            return head.data;
        }
        Node slowNode = head;
        Node fastNode = head.tail;
        while (fastNode != null && fastNode.tail != null) {

            slowNode = slowNode.tail;

            fastNode = fastNode.tail.tail;
        }
        return slowNode.data;
    }

}

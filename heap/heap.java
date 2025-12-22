
import java.util.Scanner;

public class heap {

    static int[] arr = new int[100];
    static int size = 0;

    public static void swap(int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public static void printer() {
        for (int i = 1; i <= size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    public static void insertion(int data) {
        size += 1;
        int child = size;
        arr[child] = data;
        while (child > 1) {
            int parent = child / 2;
            if (arr[parent] < arr[child]) {
                swap(child, parent);
                child = parent;
            } else
                return;
        }
    }

    public static void deletion() {
        if (size == 0)
            return;
        arr[1] = arr[size];
        size -= 1;
        int index = 1;
        while (index < size) {
            int left = index * 2;
            int right = (index * 2) + 1;
            if (left < size && arr[index] < arr[left]) {
                swap(index, left);
                index = left;

            } else if (right < size && arr[index] < arr[right]) {
                swap(index, right);
                index = right;
            } else
                return;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            insertion(sc.nextInt());
        }
        printer();
        deletion();
        printer();
    }

}


import java.util.Scanner;

public class heap {

    static int[] arr = new int[100];
    static int size = 0;

    public static void swap(int[] array, int idx1, int idx2) {
        int temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }

    public static void printer(int[] array, int n) {
        for (int i = 1; i < n; i++) {
            System.out.print(array[i] + " ");
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
                swap(arr, child, parent);
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
                swap(arr, index, left);
                index = left;

            } else if (right < size && arr[index] < arr[right]) {
                swap(arr, index, right);
                index = right;
            } else
                return;
        }
    }

    public static void heapify(int[] array, int n, int i) {
        int largest = i;
        int left = i * 2;
        int right = (i * 2) + 1;

        if (left <= n && array[left] > array[largest]) {
            largest = left;
        }

        if (right <= n && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(array, i, largest);
            heapify(array, n, largest);
        }
    }

    public static void heapSort(int[] array, int n) {
        while (n >= 1) {
            swap(array, n, 1);
            n -= 1;
            int pSize = n / 2;
            while (pSize > 0) {
                heapify(array, n, pSize--);
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        n += 1;
        int[] array = new int[n];
        for (int i = 1; i < n; i++) {
            int x = sc.nextInt();
            insertion(x);
            array[i] = x;
        }

        // deletion();
        printer(arr, size);

        System.out.println("heapify this");
        printer(array, n);
        System.out.println("to this");
        int pSize = (n - 1) / 2;
        while (pSize > 0) {
            heapify(array, n - 1, pSize--);
        }
        printer(array, n);

        System.out.println("heap sort this");
        printer(array, n);
        System.out.println("to this");
        heapSort(array, n - 1);
        printer(array, n);

    }

}

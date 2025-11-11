import java.util.Scanner;

public class QuickSort {
    public static void quickSort(int[] arr, int s, int e) {
        if (s >= e)
            return;

        int p = partition(arr, s, e);

        quickSort(arr, s, p - 1);
        quickSort(arr, p + 1, e);
    }

    public static int partition(int[] array, int low, int high) {
        // Choose the last element as pivot
        int pivot = array[high];
        // Pointer for the greater element
        int i = low - 1;

        // Traverse through all elements
        // If element is smaller than or equal to pivot, swap it
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                // Swap elements at i and j
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // Swap the pivot element with the element at i+1
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        // Return the partition index
        return i + 1;
    }

    // public static int partition(int[] arr, int s, int e) {
    // int pivot = arr[s];
    // int count = 0;
    // for (int k = s + 1; k <= e; k++) {
    // if (arr[k] < pivot)
    // count++;
    // }
    // // swap
    // int pivotIndex = s + count;
    // arr[s] = arr[pivotIndex];
    // arr[pivotIndex] = pivot;

    // int i = s, j = e;

    // while (i < pivotIndex && j > pivotIndex) {

    // while (arr[i] < pivot) {
    // i++;
    // }
    // while (arr[j] > pivot) {
    // j--;
    // }

    // if (i < pivotIndex && j > pivotIndex) {
    // int temp = arr[i];
    // arr[i] = arr[j];
    // arr[j] = temp;
    // }

    // }
    // return pivotIndex;
    // }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}

import java.util.Scanner;

public class MergeSort {
    public static void mergeSort(int[] arr, int s, int e) {
        if (s >= e)
            return;

        int m = s + (e - s) / 2;
        mergeSort(arr, s, m);
        mergeSort(arr, m + 1, e);

        merge(arr, s, m, e);
    }

    public static void merge(int[] arr, int s, int m, int e) {
        int leftLength = m - s + 1;
        int rightLength = e - m;

        int[] leftArr = new int[leftLength];
        int[] rightArr = new int[rightLength];

        for (int i = 0; i < leftLength; i++)
            leftArr[i] = arr[s + i];
        for (int j = 0; j < rightLength; j++)
            rightArr[j] = arr[m + 1 + j];

        int i = 0, j = 0, k = s;

        while (i < leftLength && j < rightLength) {
            if (leftArr[i] <= rightArr[j])
                arr[k++] = leftArr[i++];
            else
                arr[k++] = rightArr[j++];
        }

        while (i < leftLength) {
            arr[k++] = leftArr[i++];
        }
        while (j < rightLength) {
            arr[k++] = rightArr[j++];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        mergeSort(arr, 0, arr.length - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}
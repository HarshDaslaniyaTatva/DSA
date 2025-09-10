// Merge two sorted arrays into one sorted array
//input 5 4
// 1 3 5 7 9
// 2 4 6 8

//output 1 2 3 4 5 6 7 8 9 
import java.util.Scanner;

public class MergeTwoSortArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }
        int[] ans = MergeArray(arr1, n, arr2, m);
        for (int i = 0; i < n + m; i++) {
            System.out.print(ans[i] + " ");
        }
        sc.close();
    }

    public static int[] MergeArray(int[] arr1, int n, int[] arr2, int m) {
        int index = 0, i = 0, j = 0;
        int[] merged = new int[n + m];
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                merged[index++] = arr1[i++];
            } else {
                merged[index++] = arr2[j++];
            }
        }
        while (i < n) {
            merged[index++] = arr1[i++];
        }
        while (j < m) {
            merged[index++] = arr2[j++];
        }
        return merged;
    }
}

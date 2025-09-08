//Find any element in sorted array that shift circularly
//arr =8,9,11,1,2
//input = 5 11
//8,9,11,1,2
// output = 3

import java.util.Scanner;

public class problem5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int ele = sc.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        int pivot = FindPivotElement(arr, len);
        int ans = arr[0] > ele ? BinarySearch(arr, len, ele, pivot, len - 1)
                : BinarySearch(arr, len, ele, 0, pivot - 1);
        System.out.println(ans);

    }

    public static int FindPivotElement(int[] arr, int len) {
        int s = 0;
        int e = len - 1;
        int m = s + (e - s) / 2;
        while (s < e) {
            m = s + (e - s) / 2;
            if (arr[0] < arr[m]) {
                s = m + 1;
            } else {
                e = m;
            }
        }
        return s;
    }

    public static int BinarySearch(int[] arr, int len, int ele, int s, int e) {
        int m = s + (e - s) / 2;
        while (s <= e) {
            m = s + (e - s) / 2;
            if (ele == arr[m]) {
                return m + 1;
            }
            if (ele > arr[m]) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return -1;
    }
}
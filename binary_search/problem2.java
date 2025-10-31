//Find total occurrence of element in sorted array that have repeated element value
//arr = 1,2,3,3,3,3,4,5
//input = 8 , 3 
// 1,2,3,3,3,3,4,5 
// output = 4

import java.util.Scanner;

public class problem2 {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int len = sc.nextInt();
            int ele = sc.nextInt();
            int[] arr = new int[len];
            for (int i = 0; i < len; i++) {
                arr[i] = sc.nextInt();
            }
            int firstOccurrence = firstOccurrence(arr, ele, len);
            int lastOccurrence = lastOccurrence(arr, ele, len);

            System.out.println(lastOccurrence - firstOccurrence + 1);
        }

    }

    public static int firstOccurrence(int[] arr, int ele, int len) {
        int ans = -1;
        int s = 0;
        int e = len - 1;
        int m;
        while (s <= e) {
            m = s + (e - s) / 2;
            if (arr[m] == ele) {
                ans = m;
                e = m - 1;
            }
            else if (arr[m] < ele) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return ans + 1;
    }

    public static int lastOccurrence(int[] arr, int ele, int len) {
        int ans = -1;
        int s = 0;
        int e = len - 1;
        int m;
        while (s <= e) {
            m = s + (e - s) / 2;
            if (arr[m] == ele) {
                ans = m;
                s = m + 1;
            }
            else if (arr[m] < ele) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return ans + 1;
    }
}
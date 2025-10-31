//Find peak element point in mountain array.
//arr = 1,2,3,5,8,9,11,7,5
//input = 9
// 1,2,3,5,8,9,11,7,5
// output = 11

import java.util.Scanner;

public class problem3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        int ans = FinderPeakPoint(arr, len);

        System.out.println(ans);

    }

    public static int FinderPeakPoint(int[] arr, int len) {
        int s = 0;
        int e = len - 1;
        int m;
        while (s < e) {
            m = s + (e - s) / 2;
           if (arr[m] < arr[m + 1]) {
                s = m + 1;
            } else {
                e = m;
            }
        }
        return arr[s];
    }
}
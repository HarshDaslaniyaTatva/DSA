//Find pivot element(element from array start or end) in sorted array that shift circularly
//arr =8,9,11,1,2
//input = 5
//8,9,11,1,2
// output = 1

import java.util.Scanner;

public class problem4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        int ans = FindPivotElement(arr, len);

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
        return arr[s];
    }
}
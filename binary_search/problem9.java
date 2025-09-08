//We have arr of n which denotes the position of stalls in x axis and we have to place k cows in such a way that the minimum distance between two cows is the maximum.

//arr =1 2 3
//input = 3 2
//1 2 3
// output = 2

import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.Arrays;

public class problem9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int cows = sc.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = FindMinimumDistance(arr, len, cows);

        System.out.println(ans);

    }

    public static int FindMinimumDistance(int[] arr, int len, int cows) {
        Arrays.sort(arr);
        int s = 0;
        int e = IntStream.of(arr).max().getAsInt();
        int m = s + (e - s) / 2;
        int ans = -1;
        while (s <= e) {
            m = s + (e - s) / 2;
            if (isPossible(arr, len, cows, m)) {
                ans = m;
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return ans;
    }

    public static boolean isPossible(int[] arr, int len, int cows, int ans) {
        int count = 1;
        int lastPosition = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - lastPosition >= ans) {
                count++;
                if (count == cows) {
                    return true;
                }
                lastPosition = arr[i];
            }
        }
        return false;
    }
}
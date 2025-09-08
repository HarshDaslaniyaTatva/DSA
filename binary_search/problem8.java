//There are list of boards of different length, and we have to paint all the boards. There are k painters available and each painter takes 1 unit time to paint 1 unit of board. The problem is to find the minimum time to get this job done under the constraints that any painter will only paint contiguous sections of boards.

//arr =2 1 5 6 2 3
//input = 6 2  2 1 5 6 2 3
// output = 11
import java.util.Scanner;
import java.util.Arrays;

public class problem8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int painter = sc.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }

        int s = 0;
        int e = Arrays.stream(arr).sum();
        int m = 0;
        int ans = -1;
        while (s < e) {
            m = s + (e - s) / 2;
            Boolean res = paintPartition(arr, painter, len, m);
            if (res) {
                ans = m;
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        System.out.print(ans);
    }

    public static Boolean paintPartition(int[] arr, int painter, int len, int ans) {
        int count = 1;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            if (sum + arr[i] <= ans) {
                sum += arr[i];
            } else {
                count++;
                if (count > painter || arr[i] > ans)
                    return false;
                sum = arr[i];
            }
        }
        return true;
    }
}
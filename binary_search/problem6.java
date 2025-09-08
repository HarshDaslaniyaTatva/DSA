//Find square root of element that without need decimal value
//arr =8,9,11,1,2
//input = 5
//8,9,11,1,2
// output = 1

import java.util.Scanner;
import java.util.stream.IntStream;

public class problem6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ele = sc.nextInt();

        int ans = FindSquareRoot(ele);

        System.out.println(ans);

    }

    public static int FindSquareRoot(int ele) {
        int[] arr = IntStream.rangeClosed(1, ele).toArray();

        int s = 0;
        int e = ele - 1;
        int m = 0;
        while (s <= e) {
            m = s + (e - s) / 2;
            if (arr[m] * arr[m] == ele) {
                return arr[m];
            } else if (arr[m] * arr[m] < ele) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return arr[e];
    }
}
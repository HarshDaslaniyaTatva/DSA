
import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int target = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(binarySearch(arr, 0, arr.length - 1, target));
    }

    public static boolean binarySearch(int[] arr, int s, int e, int target) {
        if (s > e) {
            return false;
        }

        int m = s + (e - s) / 2;
        if (arr[m] == target) {
            return true;
        } else if (arr[m] > target) {
            return binarySearch(arr, s, m - 1, target);
        } else {
            return binarySearch(arr, m + 1, e, target);
        }
    }
}

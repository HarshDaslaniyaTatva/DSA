// Write a program to reverse an array without using any extra space.
//input 6 
// 1 2 3 4 5 6

//output 6 5 4 3 2 1 
import java.util.Scanner;

public class ReverseArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        ReverseArray(arr, n);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }

    public static void ReverseArray(int[] arr, int n) {
        for (int i = 0; i < n / 2; i++) {
            arr[i] = arr[i] + arr[n - i - 1];
            arr[n - i - 1] = arr[i] - arr[n - i - 1];
            arr[i] = arr[i] - arr[n - i - 1];
        }
    }
}

// you have array that contains some zeroes, you have to move all the zeroes to the end of the array and without changeing the order of non-zero elements.
//input 10
// 0 5 6 0 0 7 0 9 0 10

//output 5 6 7 9 10 0 0 0 0 0 
import java.util.Scanner;

public class MoveZero {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        moveZero(arr, n);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }

    public static void moveZero(int[] arr, int n) {
        int i = 0, j = 0;
        while (j < n) {
            if (arr[j] != 0) {
                arr[i] = arr[j];
                i++;
            }
            j++;
        }
        while (i < n) {
            arr[i] = 0;
            i++;
        }
    }
}

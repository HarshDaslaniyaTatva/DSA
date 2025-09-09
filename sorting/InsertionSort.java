
// take second element and compare with before elements and swap if smaller
//its feel like we are sorting cards in our hand  and sort element side by side as we move forward
// best when already sort array is given
//input 5        
// 4 2 5 3 1
//output 1 2 3 4 5
import java.util.Scanner;

public class InsertionSort {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    insertionSort(arr, n);
    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }
    sc.close();
  }

  public static void insertionSort(int[] arr, int n) {
    for (int i = 1; i < n; i++) {
      int key = arr[i];
      int j = i - 1;
      while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = key;
    }
  }
}

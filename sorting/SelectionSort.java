
// take element and compare with rest of the elements and swap if smaller
// sort start from first element to last element
//input 5        
// 4 2 5 3 1
//output 1 2 3 4 5
import java.util.Scanner;

public class SelectionSort {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    selectionSort(arr, n);
    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }
    sc.close();
  }

  public static void selectionSort(int[] arr, int n) {
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (arr[i] > arr[j]) {
          int temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
        }
      }
    }
  }
}
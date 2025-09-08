//A person has to complete M chapters in N days. He can complete only continuous chapters in a day.
//He wants to complete the chapters in such a way that the maximum number of pages he has to read in a day is minimum.

//arr =30 20 10 40 5 40
//input = 6 3  30 20 10 40 5 40
// output = 50

import java.util.Arrays;
import java.util.Scanner;

public class problem7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int day = sc.nextInt();
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
            Boolean res = dayAllocations(arr, day, len, m);
            if (res) {
                ans = m;
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        System.out.print(ans);
    }

    public static Boolean dayAllocation(int[] arr, int day, int len, int ans) {
        int d = 0;
        int i = 0;
        int[] allot = new int[day];
        int min = -1;
        outer: while (d < day) {
            int count = 0;
            while (i < len) {
                if (arr[i] > ans)
                    break outer;
                if (count + arr[i] <= ans) {
                    count = count + arr[i];
                    i++;
                } else {
                    break;
                }
            }
            if (count != 0 && count < min)
                min = count;
            allot[d] = count;
            // if(count == 0) return false;
            d++;
        }
        for (int j = 0; j < day; j++) {
            System.out.print(allot[j] + " ");
        }
        System.out.println(" ");
        if (d == day && i == len)
            return true;
        return false;
    }

    public static Boolean dayAllocations(int[] arr, int day, int len, int ans) {
        int count = 1;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            if (sum + arr[i] <= ans) {
                sum += arr[i];
            } else {
                count++;
                if (count > day || arr[i] > ans)
                    return false;
                sum = arr[i];
            }
        }
        return true;
    }
}

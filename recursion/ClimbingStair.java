//here we have to find all possible ways to climb the stairs such that we can take 1 step , 2 step  to climb n steps of stairs
//input = 3
// 2-1 , 1-1-1 ,  1-2
// output = 3

import java.util.Scanner;

public class ClimbingStair {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.err.println(climbStairs(n));
    }
    
    public static int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}

//Print Digit in word format
//input = 321
// output = three two one

import java.util.Scanner;

public class PrintDigit {

    private static final String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printDigit(n);
    }

    public static int printDigit(int n) {
        if (n == 0) {
            return 0;
        }
        int digit = n % 10;
        printDigit(n / 10);
        System.out.print(words[digit] + " "); //Heading Processing
        return 0;
    }
}

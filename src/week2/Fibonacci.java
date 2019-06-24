package week2;

import java.util.Scanner;

public class Fibonacci {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		System.out.println(calc_fib(n));
	}

	private static long calc_fib(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}
		long fib1 = 0;
		long fib2 = 1;
		long fib = 1;
		for (int i = 2; i <= n; i++) {
			fib = fib1 + fib2;
			fib1 = fib2;
			fib2 = fib;
		}
		return fib;
	}
}

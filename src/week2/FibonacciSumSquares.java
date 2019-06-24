package week2;

import java.util.Scanner;

public class FibonacciSumSquares {
	private static long getFibonacciSumNaive(long n) {
		if (n <= 1) {
			return n;
		}
		long previous = 0;
		long current = 1;
		long remainder = n % 60;

		long res = remainder;

		for (int i = 1; i < remainder; i++) {
			res = (previous + current) % 10;
			previous = current;
			current = res;
		}
		return (res) % 10;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();
		long s1 = getFibonacciSumNaive(n);
		long s2 = getFibonacciSumNaive(n + 1);
		// System.out.println(s1);
		// System.out.println(s2);
		System.out.println((s1 * s2) % 10);
	}
}

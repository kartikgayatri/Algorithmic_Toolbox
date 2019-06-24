package week2;

import java.util.Scanner;

public class FibonacciPartialSum {
	private static long getFibonacciPartialSumNaive(long n, boolean to) {
		if (n < 1) {
			return n;
		}
		if (to) {
			n = n + 2;
		} else {
			n = n + 1;
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
		if (res == 0) {
			return 9;
		}
		return (res - 1) % 10;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long from = scanner.nextLong();
		long to = scanner.nextLong();
		long fibSumFrom = getFibonacciPartialSumNaive(from, false);
		long fibSumTo = getFibonacciPartialSumNaive(to, true);
		// System.out.println(fibSumFrom);
		// System.out.println(fibSumTo);
//		if ((from == 0) && (to == 0)) {
//			System.out.println(0);
//		} else {
//			System.out.println(getDifference(fibSumFrom, fibSumTo));
//		}
		System.out.println(getDifference(fibSumFrom, fibSumTo));
	}

	private static long getDifference(long fibSumFrom, long fibSumTo) {
		if(fibSumTo < fibSumFrom) {
			return (Math.abs((fibSumTo + 10) - fibSumFrom));
		}
		return (Math.abs(fibSumTo - fibSumFrom));
	}
}


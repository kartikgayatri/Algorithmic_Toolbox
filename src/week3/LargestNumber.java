package week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LargestNumber {
	private static String largestNumber(String[] a) {
		// write your code here
		String result = "";
		StringBuilder builder = new StringBuilder();
		ArrayList<String> b = new ArrayList<>(Arrays.asList(a));
		while (!b.isEmpty()) {
			int maxDigit = 0;
			for (String digit : b) {
				if (isGreaterOrEqual(digit, maxDigit + "")) {
					maxDigit = Integer.parseInt(digit);
				}
			}
			builder.append(maxDigit);
			b.remove(maxDigit + "");
		}
		result = builder.toString();
		return result;
	}

	private static boolean isGreaterOrEqual(String digit, String maxDigit) {
		StringBuilder builder = new StringBuilder();
		builder.append(digit);
		builder.append(maxDigit);
		String a = builder.toString();
		StringBuilder builder1 = new StringBuilder();
		builder1.append(maxDigit);
		builder1.append(digit);
		String b = builder1.toString();
		if (a.compareTo(b) < 0) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String[] a = new String[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.next();
		}
		System.out.println(largestNumber(a));
	}
}


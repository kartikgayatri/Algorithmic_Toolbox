package week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DifferentSummands {
	private static List<Integer> optimalSummands(int n) {

		List<Integer> summands = new ArrayList<>();
		for (int pair = 1, sum = n; sum > 0; pair++) {
			if (sum <= (2 * pair)) {
				summands.add(sum);
				sum -= sum;
			} else {
				summands.add(pair);
				sum -= pair;
			}
		}

		return summands;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		List<Integer> summands = optimalSummands(n);
		System.out.println(summands.size());
		for (Integer summand : summands) {
			System.out.print(summand + " ");
		}
	}
}


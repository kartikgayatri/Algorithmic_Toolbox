package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxPairwiseProduct {
	static long getMaxPairwiseProduct(int[] numbers) {
		long max_product = 0;
		int n = numbers.length;

		int index = 0;
		for (int i = 1; i < n; i++) {
			if (numbers[index] < numbers[i]) {
				index = i;
			}
		}
		int max = numbers[index];
		numbers[index] = numbers[n - 1];
		numbers[n - 1] = max;
		index = 1;
		for (int i = 1; i < (n - 1); i++) {
			if (numbers[index] < numbers[i]) {
				index = i;
			}
		}
		max = numbers[index];
		numbers[index] = numbers[n - 2];
		numbers[n - 2] = max;

		max_product = (long) numbers[n - 1] * (long) numbers[n - 2];

		return max_product;
	}

	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = scanner.nextInt();
		}
		System.out.println(getMaxPairwiseProduct(numbers));
	}

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner(InputStream stream) {
			try {
				this.br = new BufferedReader(new InputStreamReader(stream));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		String next() {
			while ((this.st == null) || !this.st.hasMoreTokens()) {
				try {
					this.st = new StringTokenizer(this.br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return this.st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}

}
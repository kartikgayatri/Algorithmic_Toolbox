package week3;

import java.util.Arrays;
import java.util.Scanner;

public class FractionalKnapsack {
	private static double getOptimalValue(int capacity, int[] values, int[] weights, ValueWeight[] valueWeights) {
		if (capacity == 0) {
			return 0;
		}
		double value = 0d;
		double amount = 0;
		Arrays.sort(valueWeights, (o1, o2) -> o2.cost.compareTo(o1.cost));
//		for (int i = 0; i < valueWeights.length; i++) {
//			System.out.println(i + ":" + valueWeights[i].cost);
//		}
		for (ValueWeight valueWeight : valueWeights) {
			if (capacity == 0) {
				return value;
			}
			amount = Math.min(capacity, valueWeight.weight);
			value += valueWeight.cost * amount;
			capacity -= amount;
		}

		return value;
	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int capacity = scanner.nextInt();
		int[] values = new int[n];
		int[] weights = new int[n];
		ValueWeight[] valueWeights = new ValueWeight[n];
		for (int i = 0; i < n; i++) {
			values[i] = scanner.nextInt();
			weights[i] = scanner.nextInt();
			valueWeights[i] = new ValueWeight(weights[i], values[i], i);
		}
		// System.out.println(getOptimalValue(capacity, values, weights, valueWeights));
		System.out.format("%.4f", getOptimalValue(capacity, values, weights, valueWeights));
	}

	static class ValueWeight {
		Double cost;
		double weight, value, index;

		public ValueWeight(int weight, int value, int index) {
			this.weight = weight;
			this.value = value;
			this.index = index;
			this.cost = new Double((double) value / weight);
		}
	}
}

package week3;

import java.util.Arrays;
import java.util.Scanner;

public class CarFueling {
	static int computeMinRefills(int dist, int tank, int[] stops) {
		Arrays.sort(stops);
		int current = 0;
		int numStops = 0;
		int n = stops.length - 2;
		while (current <= n) {
			int lastStop = current;
			while ((current <= n) && ((stops[current + 1] - stops[lastStop]) <= tank)) {
				current += 1;
			}
			if (current == lastStop) {
				return -1;
			}
			if (current <= n) {
				numStops += 1;
			}
		}

		return numStops;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int dist = scanner.nextInt();
		int tank = scanner.nextInt();
		int n = scanner.nextInt();
		int stops[] = new int[n + 2];
		stops[0] = 0;
		for (int i = 1; i <= n; i++) {
			stops[i] = scanner.nextInt();
		}
		stops[n + 1] = dist;
		System.out.println(computeMinRefills(dist, tank, stops));
	}
}

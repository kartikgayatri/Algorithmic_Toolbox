package week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CoveringSegments {

	private static ArrayList<Integer> optimalPoints(Segment[] segments) {
		// write your code here

		Arrays.sort(segments, (segment1, segment2) -> segment1.end - segment2.end);
		ArrayList<Integer> pointsList = new ArrayList<>();
		int i = 0;
		int length = segments.length;
		while (i < length) {
			int rightEnd = segments[i].end;
			pointsList.add(rightEnd);
			while ((i < length) && (rightEnd >= segments[i].start) && (rightEnd <= segments[i].end)) {
				i++;
			}
		}
		return pointsList;
	}

	private static class Segment {
		int start, end;

		Segment(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Segment[] segments = new Segment[n];
		for (int i = 0; i < n; i++) {
			int start, end;
			start = scanner.nextInt();
			end = scanner.nextInt();
			segments[i] = new Segment(start, end);
		}
		ArrayList<Integer> points = optimalPoints(segments);
		System.out.println(points.size());
		for (Integer point : points) {
			System.out.print(point + " ");
		}
	}
}
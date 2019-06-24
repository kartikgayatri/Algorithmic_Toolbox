package week3;

import java.util.Scanner;

public class Change {
	private static int getChange(int m) {
		int x = m / 10;
		int rem = m % 10;
		int y = rem / 5;
		int z = rem % 5;
		return (x + y + z);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		System.out.println(getChange(m));

	}
}
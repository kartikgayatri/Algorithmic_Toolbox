package week2;

import java.util.Scanner;;

public class FibonacciHuge {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();
		long m = scanner.nextLong();
		System.out.println(get_fibonacci_huge(n, m));
	}

	static long get_pisano_period(long m) {
		long a = 0, b = 1, c = a + b;
        for (int i = 0; i < (m * m); i++) {
            c = (a + b) % m;
            a = b;
            b = c;
            if ((a == 0) && (b == 1)) {
				return i + 1;
			}
        }
		return m;
    }

	static long get_fibonacci_huge(long n, long m) {
		if (n <= 1) {
			return n;
		}
		long previous = 0;
		long current = 1;
		long remainder = n % get_pisano_period(m);

		long res = remainder;

        for (int i = 1; i < remainder; i++) {
			res = (previous + current) % m;
			previous = current;
			current = res;
        }

        return res % m;
    }
}


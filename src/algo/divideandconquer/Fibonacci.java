package algo.divideandconquer;

public class Fibonacci {

	public int solution(int n) {

		if (n == 1 || n == 2) {
			return n - 1;
		}

		return solution(n - 1) + solution(n - 2);
	}

	public static void main(String[] args) {
		Fibonacci fab = new Fibonacci();
		
		fab.solution(5);
	}

}

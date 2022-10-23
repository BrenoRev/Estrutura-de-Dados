import java.util.*;

class Main {

	public static int weight, items;
	public static int[] weights, value;
	public static int[][] memo;

	public static void main(String[] args) {
	// Coded by
	// Breno
		Scanner in = new Scanner(System.in);
		weight = in.nextInt();
		items = in.nextInt();
		weights = new int[items];
		value = new int[items];
		memo = new int[items + 2][weight + 2];

		for (int[] row : memo) {
			Arrays.fill(row, -1);
		}

		for (int i = 0; i < items; i++) {
			weights[i] = in.nextInt();
			value[i] = in.nextInt();
		}

		System.out.print(val(0, weight));
	}

	public static int val(int id, int remainingWeight) {
		if (remainingWeight == 0 || id == items) {
			return 0;
		} 

		if (memo[id][remainingWeight] != -1) {
			return memo[id][remainingWeight];
		}

		if (weights[id] > remainingWeight) {
			return val(id + 1, remainingWeight);
		}

		memo[id][remainingWeight] = Math.max(val(id + 1, remainingWeight), value[id] + val(id + 1, remainingWeight - weights[id]));
		return memo[id][remainingWeight];
	}
}
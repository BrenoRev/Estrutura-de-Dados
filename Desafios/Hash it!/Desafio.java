import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Desafio {

	public static void main(String[] args) {

		// Codded By
		// Breno Silva

		FastReader reader = new FastReader();

		int numberOfTestCases = reader.nextInt();

		while (numberOfTestCases-- > 0) {

			String[] hashTable = new String[101];
			int elementsCount = 0;
			int numberOfOperations = reader.nextInt();

			while (numberOfOperations-- > 0) {

				String operation = reader.next();
				String value = operation.substring(4);
				int hashValue = hash(value);

				if (operation.charAt(0) == 'A') {

					boolean isDuplicate = false;

					for (int i = 0; i < hashTable.length; i++) {
						if (hashTable[i] != null && hashTable[i].equals(value)) {
							isDuplicate = true;
						}
					}

					if (isDuplicate)
						continue;

					int tries = 0;
					while (tries < 20) {
						int newHashValue = (int) (hashValue + Math.pow(tries, 2) + 23 * tries) % 101;
						if (hashTable[newHashValue] == null || hashTable[newHashValue].equals(value)) {

							if (hashTable[newHashValue] == null)
								elementsCount++;

							hashTable[newHashValue] = value;
							break;
						}
						tries++;
					}

				} else {

					int tries = 0;
					while (tries < 20) {
						int newHashValue = (int) (hashValue + Math.pow(tries, 2) + 23 * tries) % 101;
						if (hashTable[newHashValue] != null && hashTable[newHashValue].equals(value)) {
							elementsCount--;
							hashTable[newHashValue] = null;
							break;
						}
						tries++;
					}
				}
			}

			System.out.println(elementsCount);

			for (int i = 0; i < hashTable.length; i++) {
				if (hashTable[i] != null)
					System.out.println(i + ":" + hashTable[i]);
			}
		}
	}

	static int hash(String key) {
		return h(key) % 101;
	}

	static int h(String key) {
		int h = 0;

		for (int i = 0; i < key.length(); i++)
			h += key.charAt(i) * (i + 1);

		return 19 * h;
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				if (st.hasMoreTokens()) {
					str = st.nextToken("\n");
				} else {
					str = br.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
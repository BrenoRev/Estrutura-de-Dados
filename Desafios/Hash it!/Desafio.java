import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Desafio {

	public static void main(String[] args) {
		
        // Codded By
        // Breno Silva

        FastReader reader = new FastReader();
		
		int nCases = reader.nextInt();
		
		while(nCases-- > 0) {
			
			String[] table = new String[101];
			int count = 0;
			int nOperations = reader.nextInt();
			
			while(nOperations-- > 0) {
				
				String op = reader.next();
				String val = op.substring(4);
				int hash = hash(val);
				
				if(op.charAt(0) == 'A') {
					
					boolean duplicate = false;
					
					for(int i = 0 ; i < table.length ; i++)
						if(table[i] != null && table[i].equals(val)) {
							duplicate = true;
						}
					
					if(duplicate)
						continue;
					
					int tries = 0;
					while(tries < 20) {
						int newHash = (int)(hash + Math.pow(tries, 2) + 23*tries) % 101;
						if(table[newHash] == null || table[newHash].equals(val)) {
							
							if(table[newHash] == null)
								count++;
							
							table[newHash] = val;
							break;
						}
						tries++;
					}
					
				}else{
					
					int tries = 0;
					while(tries < 20) {
						int newHash = (int)(hash + Math.pow(tries, 2) + 23*tries) % 101;
						if(table[newHash] != null && table[newHash].equals(val)) {
							count--;
							table[newHash] = null;
							break;
						}
						tries++;
					}
				}
			}
			
			System.out.println(count);
			
			for(int i = 0 ; i < table.length ; i++)
				if(table[i] != null)
					System.out.println(i+":"+table[i]);
		}
	}
	
	static int hash(String key) {
		return h(key) % 101;
	}
	
	static int h(String key) {
		int h = 0;
		
		for(int i = 0 ; i < key.length() ; i++)
			h+=key.charAt(i)*(i+1);
		
		return 19*h;
	}

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
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
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Coded by
        // Breno Silva

        try (Scanner scanner = new Scanner(System.in)) {
            StringBuilder stringBuilder = new StringBuilder();

            while (true) {
                int m = scanner.nextInt();

                if (m == 0) {
                    break;
                }

                int[] perm = new int[m - 1];
                for (int i = 0; i < m - 1; i++) {
                    perm[i] = scanner.nextInt();
                }

                Dictionary dict = new Dictionary(m, perm);

                int n = scanner.nextInt();
                while (n-- > 0) {
                    String op = scanner.next();
                    int key = scanner.nextInt();

                    if (op.equals("add")) {
                        int value = scanner.nextInt();
                        dict.add(key, value);
                    } else if (op.equals("find")) {
                        int idx = dict.find(key);
                        stringBuilder.append(idx).append("\n");
                    }
                }
            }

            if (stringBuilder.length() > 0) {
                int lastNewlineIndex = stringBuilder.lastIndexOf("\n");
                stringBuilder.delete(lastNewlineIndex, stringBuilder.length());
            }

            System.out.println(stringBuilder);
        }
    }

    static class Dictionary {
        private Entry[] table;
        private int m;
        private int[] perm;
        private int count;

        public Dictionary(int size, int[] perm) {
            this.m = size;
            this.table = new Entry[size];
            this.perm = perm;
            this.count = 0;
        }

        private int h(int key) {
            int temp = (int) Math.floor((double) key / (double) m);
            return (key - (m * temp));
        }

        public void add(int key, int value) {
            int idx = findIndex(key);
            if (idx != -1 && table[idx] == null) {
                table[idx] = new Entry(key, value);
                count++;
            }
        }

        public int find(int key) {
            int idx = findIndex(key);
            if (idx != -1 && table[idx] != null) {
                return idx;
            }
            return -1;
        }

        private int findIndex(int key) {
            int tentativas = 0;
            int idx = h(key);
            int initialIdx = idx;
            int i = 0;
            while (table[idx] != null) {
                if (tentativas > m) {
                    return -1;
                }
                if (table[idx].key == key) {
                    return idx;
                }

                idx = h(initialIdx + perm[i]);
                i = (i + 1) % (m - 1);
                tentativas++;
            }

            if (count == m) {
                return -1;
            }

            return idx;
        }
    }

    static class Entry {
        int key;
        int value;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

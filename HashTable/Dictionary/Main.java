package HashTable.Dictionary;

public class Main {
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

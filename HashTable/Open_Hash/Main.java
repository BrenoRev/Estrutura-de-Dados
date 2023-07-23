package HashTable.Open_Hash;

class Main {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.put(1, "breno");
        hashTable.put(1, "asdf");
        hashTable.put(2, "eliane");
        System.out.println(hashTable.get(1));
    }
}
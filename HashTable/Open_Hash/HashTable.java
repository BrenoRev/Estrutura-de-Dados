package HashTable.Open_Hash;

public class HashTable {

	private int max = 1000;

	private HashTableNode[] vector = new HashTableNode[max];

	class HashTableNode {

		public int key;
		public String value;

		HashTableNode(int key, String value) {
			this.value = value;
			this.key = key;
		}
	}

	void HashTableOpenAddressing() {

		for (int i = 0; i < max; i++) {

			this.vector[i] = null;
		}
	}

	public void put(int key, String value) {

		int hashcode = this.hashFunction(key);

		if (this.vector[hashcode] != null) {
			while (this.vector[hashcode] != null) {
				hashcode = (hashcode + 1) % max;
			}
			this.put(hashcode, value);
		} else {
			this.vector[hashcode] = new HashTableNode(key, value);
		}
	}

	public String get(int key) {

		int hashcode = this.hashFunction(key);

		if ((this.vector[hashcode] != null) && (this.vector[hashcode].key == key)) {
			return this.vector[hashcode].value;
		}

		System.out.println("Key " + key + " not found in hash table.");
		return null;

	}

	public void remove(int key) {

		String i = this.get(key);

		if (!(i.isEmpty())) {
			int hashcode = this.hashFunction(key);
			System.out.println("The key " + key + " was removed from hash table.");
			this.vector[hashcode] = null;
		} else {
			System.out.println("The key " + key + " was not removed, because it does not exists in hash table.");
		}
	}

	public int hashFunction(int key) {
		return key % 10;
	}

	public String toString() {

		String description = "Hash table: [ ";

		for (int i = 0; i < this.max; i++) {

			if (this.vector[i] == null) {

				description += "__  ";
			} else {

				description += String.format("%2d  ", this.vector[i].key);
			}
		}

		description += "]";

		return description;
	}
}
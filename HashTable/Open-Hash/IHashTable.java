import java.util.Hashtable;

public interface IHashTable<K,V> {
    void put(K key, V value);
    V get(K key);
    int getSize();
    V remove(K key);
    boolean isEmpty();
    int hashFunction(K key);
}

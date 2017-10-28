
class EntrySet<K, V> {
	K key;
	V value;
}

public class MyMap<K, V> {

	int size = 0;
	EntrySet<K, V>[] storage;
	int currentSize = 0;// Can be used for rehashing

	public MyMap() {
		size = 7;// a prime number
		storage = (EntrySet<K, V>[]) new Object[size];
	}

	//
	public V get(K key) {
		return storage[0].value;
	}

	public void put(K key, V value) {
		storage[0].key = key;
		storage[0].value = value;
	}
}

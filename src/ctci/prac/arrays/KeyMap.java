package ctci.prac.arrays;

import java.util.ArrayList;
import java.util.List;

public class KeyMap<V> {

	private int size;
	private List<List<DataObject>> list;
	private static int ARRAY_LIST_SIZE = 10;

	private class DataObject {
		String key;
		V data;

		public DataObject(String key, V data) {
			super();
			this.key = key;
			this.data = data;
		}

	}

	public KeyMap() {
		size = 0;
		list = new ArrayList<List<DataObject>>();
		for (int iter = 0; iter < ARRAY_LIST_SIZE; iter++) {
			list.add(new ArrayList<DataObject>());
		}
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean containsKey(String key) {

		return false;
	}

	public V get(String key) {
		int position = getPosition(key);
		List<DataObject> location = list.get(position);
		for (DataObject temp : location) {
			if (temp.key.equals(key)) {
				return temp.data;
			}
		}
		return null;
	}

	public V put(String key, V value) {
		int position = getPosition(key);
		List<DataObject> location = list.get(position);
		for (DataObject temp : location) {
			if (temp.key.equals(key)) {
				temp.data = value;
				return value;
			}
		}
		size += 1;
		location.add(new DataObject(key, value));
		return value;
	}

	public V remove(String key) {
		int position = getPosition(key);
		List<DataObject> location = list.get(position);
		int index = 0;
		for (DataObject temp : location) {
			if (temp.key.equals(key)) {
				location.remove(index);
				size -= 1;
				return temp.data;
			}
			index += 1;
		}
		return null;
	}

	private int calculateHash(String key) {
		int hash = 0;
		char input[] = key.toCharArray();
		for (char temp : input) {
			hash += temp;
		}
		return hash;
	}

	private int getPosition(String key) {
		int hash = calculateHash(key);
		return hash % ARRAY_LIST_SIZE;
	}

}

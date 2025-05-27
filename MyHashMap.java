  import java.util.LinkedList;

  class MyHashMap<K, V> {
    // Bucket array
    private LinkedList<Entry<K, V>>[] buckets;
    private int size;
    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    // Constructor
    public MyHashMap() {
        buckets = new LinkedList[INITIAL_CAPACITY];
        size = 0;
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    // Entry class to store key-value pairs
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Hash function to compute the bucket index
    private int hash(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    // Put method to add key-value pair
    public void put(K key, V value) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        // Check if key already exists, update value
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;  // Update value
                return;
            }
        }

        // If not found, add a new entry
        bucket.add(new Entry<>(key, value));
        size++;

        // Resize if load factor is exceeded
        if (size > buckets.length * LOAD_FACTOR) {
            resize();
        }
    }

    // Get method to retrieve value by key
    public V get(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;  // If key doesn't exist
    }

    // Remove method to delete a key-value pair
    public void remove(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                bucket.remove(entry);
                size--;
                return;
            }
        }
    }

    // Resize method to increase capacity when load factor exceeds threshold
    private void resize() {
        LinkedList<Entry<K, V>>[] oldBuckets = buckets;
        buckets = new LinkedList[oldBuckets.length * 2];
        size = 0;

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }

        // Rehash all entries to new buckets
        for (LinkedList<Entry<K, V>> bucket : oldBuckets) {
            for (Entry<K, V> entry : bucket) {
                put(entry.key, entry.value);
            }
        }
    }

    // Size method to get the number of key-value pairs in the map
    public int size() {
        return size;
    }
}

public class Main {
    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
  
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("grape", 3);
  
        System.out.println("Size: " + map.size());  // Output: 3
        System.out.println("Value for 'apple': " + map.get("apple"));  // Output: 1
  
        map.remove("banana");
        System.out.println("Size after removal: " + map.size());  // Output: 2
        System.out.println("Value for 'banana': " + map.get("banana"));  // Output: null
    }
}

package main.java.inte;

public interface Map<K,V> {
    V get(K key);

    void put(K k, V v);

    int size();

    interface Entry<K,V>{
        K getKey();
        V getValue();
    }
}

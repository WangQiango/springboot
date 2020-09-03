package main.java;

import main.java.inte.Map;

/**
 * 手写HashMap原理
 */
public class HashMap01<K,V> implements Map {

    private Entry[] table = null;
    private int size = 0;
    private int capacity = 16;
    private int threshold;
    public HashMap01() {
        this.table = new Entry[capacity];
        threshold = capacity;
    }

    @Override
    public Object get(Object key) {
        if (size == 0) {
            return null;
        }
        int index = hash(key);
        if (table[index] == null){
            return null;
        }
        Entry entry = findValue(key, table[index]);
        return entry.getValue();
    }

    private Entry findValue(Object key, Entry entry) {
        if (entry.getKey().equals(key) || entry.getKey() == key) {
            return entry;
        } else {
            if (entry.next != null) {
                findValue(key, entry.next);
            }
        }
        return null;
    }

    /***
     *
     * @param key
     * @param value
     * 根据key的hashcode进行hash()方法计算出下标值
     * 在table数组中查询下标值的位置是否有数据，没有直接添加
     *
     * @return
     */
    @Override
    public void put(Object key, Object value) {
        int hash = hash(key);
        Entry entry = table[hash];
        if (entry == null) {
            table[hash] = new Entry(key, value, hash, null);
            size++;
        } else {
            //key的唯一性保证
            if (putValue(key,value, entry)){
                return;
            }
            table[hash] = new Entry(key, value, hash, entry);
            size++;
        }
    }

    private void resize(int threshold) {

    }

    private boolean putValue(Object key,Object value , Entry next) {
        if (next != null){
            if (next.getKey().equals(key) || next.getKey() == key){
                next.v = value;
                return true;
            }else {
                putValue(key, value,next.next);
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    class Entry<K, V> implements Map.Entry<K, V> {
        K k;
        V v;
        int hash;
        Entry next;

        public Entry(K k, V v, int hash, Entry next) {
            this.k = k;
            this.v = v;
            this.hash = hash;
            this.next = next;
        }

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }
    }

    //取模16 取绝对值
    private int hash(Object key) {
        return Math.abs(key.hashCode() % 16);
    }
}

<<<<<<< HEAD
=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
>>>>>>> 5cdcefb9ddb0176baf54b5dd787c6f3f2063f567
package mp6.map;

import asdv.ListASDV;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
<<<<<<< HEAD
=======
import java.util.LinkedList;
>>>>>>> 5cdcefb9ddb0176baf54b5dd787c6f3f2063f567
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;//needed in putAll

public class MapASDV<K, V> implements Map<K, V>, Cloneable {

<<<<<<< HEAD
=======
    private int size = 0; // I added this
>>>>>>> 5cdcefb9ddb0176baf54b5dd787c6f3f2063f567
    private int capacity = 4;
    private double loadFactor = 0.75;
    private ArrayList<ListASDV<EntryASDV<K, V>>> map = new ArrayList<ListASDV<EntryASDV<K, V>>>();

    private Set<K> sharedKeySet = new SharedSet<K>();
    private Set<Entry<K, V>> sharedEntrySet = new SharedSet<Entry<K, V>>();
    private Collection<V> sharedValuesCollection = new SharedCollection<V>();
<<<<<<< HEAD

    private class SharedCollection<V> extends ArrayList<V> {

        public boolean addValue(V v) {
            return this.add(v);
        }

        @Override
        public boolean remove(Object o) {

            //> The parameter is key not entry if we are here
            //>>remove value) and key) from the map
            return MapASDV.this.removeFirstValue(o);

            //>>remove key from shared values set
            //return super.remove(o);
        }

        /**
         * Removes one value from the collection. This method is meant to be
         * called from out class. The overridden remove(Object o) of this inner
         * class, calls the remove of the outer class(MapASDV), and the remove
         * of the outer class, calls remove(V v, boolean callFromOuterClass)
         * instead of remove(Object o) to avoid Stack Overflow when remover of
         * inner calls remove of outer and vice versa.
         *
         * @param o - the key
         * @param callFromOuterClass - dummy variable.
         * @return true if the key was removed from the Set
         */
        public boolean remove(V v, boolean callFromOuterClass) {
            //remove key from shared keys set
            boolean b = super.remove(v);
            return b;

        }

        @Override
        public Object clone() {
            return super.clone();
        }

        @Override
        public void clear() {
            super.clear();
        }
=======
    private static int MAXIMUM_CAPACITY = 1 << 30;

    private class SharedCollection<V> extends ArrayList<V> {
>>>>>>> 5cdcefb9ddb0176baf54b5dd787c6f3f2063f567
    }

    private class SharedSet<E> extends HashSet<E> {

        @Override
        public boolean add(E e) {
            throw new UnsupportedOperationException("Not supported....");
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            throw new UnsupportedOperationException("Not supported....");
        }

        /**
<<<<<<< HEAD
         * Adds an EntryASDV to the set. It is private and cannot be used by the
         * user of the Set. It is used from the MapASDV to add EntriesASDV to
         * the SharedSet. Without this method we wouldn't be able to create a
         * Set of keys or a Set of entries to give to the user via methods
         * keySet() and entrySet() of this Map
=======
         * Adds an EntryASDV to the set. It is private and cannot be used by the user of the Set. It
         * is used from the MapASDV to add EntriesASDV to the SharedSet. Without this method we
         * wouldn't be able to create a Set of keys or a Set of entries to give to the user via
         * methods keySet() and entrySet() of this Map
>>>>>>> 5cdcefb9ddb0176baf54b5dd787c6f3f2063f567
         *
         * @param e EntryASDV
         * @return true if the entry was added false otherwise
         */
        private boolean addEntry(E e) {
            return super.add(e);
        }

        @Override
        public boolean remove(Object o) {

            //>if parameter oo is EntryASDV call auxiliary method removeEntry
            if (o instanceof EntryASDV) {
                return removeEntry((EntryASDV) o);
            }

            //> The parameter is key not entry if we are here
            //>>remove key from the map
            MapASDV.this.remove(o);
            //>>remove key from shared keys set
            return super.remove(o);
        }

        /**
         * Removes the entry for the shared set
         *
         * @param entry the entry to be removed
         * @return true if the entry was removed, false otherwise
         */
        private boolean removeEntry(EntryASDV<K, V> entry) {

            MapASDV.this.remove(entry.getKey());
            return super.remove(entry);
        }

        /**
<<<<<<< HEAD
         * Removes the key from the set. This method is meant to be called from
         * out class. The overridden remove(Object o) of this inner class calls
         * the remove of the out class, and the remove of the outer class calls
         * remove(K o, boolean callFromOuterClass) instead of remove(Object o)
         * to avoid Stack Overflow when remover of inner calls remove of outer
         * and vice versa.
=======
         * Removes the key from the set. This method is meant to be called from out class. The
         * overridden remove(Object o) of this inner class calls the remove of the out class, and
         * the remove of the outer class calls remove(K o, boolean callFromOuterClass) instead of
         * remove(Object o) to avoid Stack Overflow when remover of inner calls remove of outer and
         * vice versa.
>>>>>>> 5cdcefb9ddb0176baf54b5dd787c6f3f2063f567
         *
         * @param o - the key
         * @param callFromOuterClass - dummy variable.
         * @return true if the key was removed from the Set
         */
        public boolean remove(E o, boolean callFromOuterClass) {

            //remove key from shared keys set
            return super.remove(o);
        }

        @Override
        public Object clone() {
            return super.clone();
        }

        @Override
        public void clear() {
            super.clear();
        }

    }

    public MapASDV() {
        for (int i = 0; i < capacity; ++i) {
            map.add(new ListASDV<EntryASDV<K, V>>());
        }
    }

<<<<<<< HEAD
    /**
     * Double the size of the Map and rehashes the entries of the Map
     */
    private void doubleTheSizeOfTheMapAndRehash() {
        capacity *= 2;
        //>create a new arrayList of ListsASDV
        ArrayList<ListASDV<EntryASDV<K, V>>> newMap = new ArrayList<ListASDV<EntryASDV<K, V>>>();

        //>Add at every enetry of the arrayList a new ASDVList
        for (int i = 0; i < capacity; ++i) {
            newMap.add(new ListASDV<EntryASDV<K, V>>());
        }

        //>for the size of the OLD arrayList
        for (int i = 0; i < map.size(); ++i)//array list
        {
            //>> get The ASDVlist at i
            ListASDV<EntryASDV<K, V>> list = map.get(i);

            //>>for the size() of the ASDVlist
            for (int j = 0; j < list.size(); ++j) {
                ///>>>hash and put in the the new array   
                int index = hash(list.get(j).getKey().hashCode());
                newMap.get(index).add(list.get(j));
            }
        }
        map = newMap;
    }

=======
>>>>>>> 5cdcefb9ddb0176baf54b5dd787c6f3f2063f567
    class EntryASDV<K, V> implements Entry<K, V>, Comparable<K> {

        K key;
        V value;

        public EntryASDV(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override
        public String toString() {
            return "EntryASDV{" + "key=" + key + ", value=" + value + '}';
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
<<<<<<< HEAD
            final EntryASDV<?, ?> other = (EntryASDV<?, ?>) obj;
=======

            final EntryASDV<?, ?> other = (EntryASDV<?, ?>) obj;

>>>>>>> 5cdcefb9ddb0176baf54b5dd787c6f3f2063f567
            if (!Objects.equals(this.key, other.key)) {
                return false;
            }
            return true;
        }

        /**
         *
         * @param o
         * @return throws IllegalArgumentException if parameter class is not K
         */
        @Override
        public int compareTo(K o) {
            if (getClass() != o.getClass()) {
<<<<<<< HEAD
                throw new IllegalArgumentException("ellegal parameter " + o);
=======
                throw new IllegalArgumentException("illegal parameter " + o);
>>>>>>> 5cdcefb9ddb0176baf54b5dd787c6f3f2063f567
            }
            return ((Comparable) key).compareTo(o);
        }

    }

<<<<<<< HEAD
    @Override
    public int size() {
        return this.keySet().size();
=======
    /**
     * Double the size of the Map and rehashes the entries of the Map
     */
    private void doubleTheSizeOfTheMapAndRehash() {
    }

    @Override
    public int size() {
        return size;
>>>>>>> 5cdcefb9ddb0176baf54b5dd787c6f3f2063f567
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported....");
<<<<<<< HEAD

=======
>>>>>>> 5cdcefb9ddb0176baf54b5dd787c6f3f2063f567
    }

    @Override
    public boolean containsKey(Object key) {
<<<<<<< HEAD
        throw new UnsupportedOperationException("Not supported yet....");

=======
        throw new UnsupportedOperationException("Not supported....");
>>>>>>> 5cdcefb9ddb0176baf54b5dd787c6f3f2063f567
    }

    /**
     * Return an entry of the map
     *
     * @param key the key of the entry to be returned
     * @return the entry, or null if the key is not in the map
     */
    private EntryASDV<K, V> getEntryForKey(Object key) {
        for (ListASDV<EntryASDV<K, V>> list : map) {
            Iterator<EntryASDV<K, V>> it = list.iterator();
            while (it.hasNext()) {
                EntryASDV<K, V> entry = it.next();
                if (key.equals(entry.getKey())) {
                    return entry;
                }
            }
        }
        return null;
    }

    /**
     * Returns the index of the given key
     *
     * @param key a key of the map
     * @return the index of a key in the map or -1, if the key is not in the map
     */
    private int getIndexForKey(Object key) {
        for (int i = 0; i < map.size(); ++i) {
            Iterator<EntryASDV<K, V>> it = map.get(i).iterator();
            while (it.hasNext()) {
                EntryASDV<K, V> entry = it.next();
                if (key.equals(entry.getKey())) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
<<<<<<< HEAD
     * Returns true if this map maps one or more keys to the specified value.
     * More formally, returns true if and only if this map contains at least one
     * mapping to a value v such that (value==null ? v==null : value.equals(v)).
     * This operation will probably require time linear in the map size for most
     * implementations of the Map interface.
     *
     * Parameters: value - value whose presence in this map is to be tested
     * Returns: true if this map maps one or more keys to the specified value
     * Throws: ClassCastException - if the value is of an inappropriate type for
     * this map (optional) NullPointerException - if the specified value is null
     * and this map does not permit null values (optional)
     *
     * @param value - value whose presence in this map is to be tested
     * @return true if this map maps one or more keys to the specified value
     * @throws NullPointerException - if the specified value is null and this
     * map does not permit null values (optional)
     */
    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet....");

    }

    /**
     * Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     *
     * More formally, if this map contains a mapping from a key k to a value v
     * such that (key==null ? k==null : key.equals(k)), then this method returns
     * v; otherwise it returns null. (There can be at most one such mapping.)
     *
     * If this map permits null values, then a return value of null does not
     * necessarily indicate that the map contains no mapping for the key; it's
     * also possible that the map explicitly maps the key to null. The
     * containsKey operation may be used to distinguish these two cases.
     *
     * @param key - the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key
     * @throws NullPointerException - if the specified key is null and this map
     * does not permit null keys (optional)
     */
    @Override
    public V get(Object key) {
        throw new UnsupportedOperationException("Not supported yet....");

    }

    /**
     * Associates the specified value with the specified key in this map
     * (optional operation). If the map previously contained a mapping for the
     * key, the old value is replaced by the specified value. (A map m is said
     * to contain a mapping for a key k if and only if m.containsKey(k) would
     * return true.)
     *
     * @param key - key with which the specified value is to be associated
     * @param value - value to be associated with the specified key
     * @return the previous value associated with key, or null if there was no
     * mapping for key. (A null return can also indicate that the map previously
     * associated null with key, if the implementation supports null values.)
     * @throws NullPointerException - if specified key or value is null and this
     * map does not permit null keys
     */
    @Override
    public V put(K key, V value) {

        if (key == null || value == null) {
            throw new NullPointerException("parm(s) null");
        }

        //>if contains the key, replace the key's value 
        EntryASDV<K, V> entry = getEntryForKey(key);
        if (entry != null) {
            V oldValue = entry.value;
            entry.value = value;

            return oldValue;
        }
        ///>>hash and put in the array  
        int code = this.hash(key.hashCode());
        int index = hash(code);

        ListASDV<EntryASDV<K, V>> list = map.get(index);
        EntryASDV e = new EntryASDV(key, value);
        list.add(e);

        //>>add the key to the shared keys-set
        ((SharedSet<K>) this.sharedKeySet).addEntry(key);
        ((SharedSet<Entry<K, V>>) this.sharedEntrySet).addEntry(e);

        //>>get the value of this entry
        V v = list.get(list.size() - 1).getValue();

        //>> add value to the value collection
        ((SharedCollection<V>) this.sharedValuesCollection).addValue(v);

        //>> if reach 75% capacity double the size
        if ((double) this.size() / capacity >= 0.75) {
            this.doubleTheSizeOfTheMapAndRehash();
        }

        //>>return the value of Entry  just added
        return v;
=======
     * Returns true if this map maps one or more keys to the specified value. More formally, returns
     * true if and only if this map contains at least one mapping to a value v such that
     * (value==null ? v==null : value.equals(v)). This operation will probably require time linear
     * in the map size for most implementations of the Map interface.
     *
     * Parameters: value - value whose presence in this map is to be tested Returns: true if this
     * map maps one or more keys to the specified value Throws: ClassCastException - if the value is
     * of an inappropriate type for this map (optional) NullPointerException - if the specified
     * value is null and this map does not permit null values (optional)
     *
     * @param value - value whose presence in this map is to be tested
     * @return true if this map maps one or more keys to the specified value
     * @throws NullPointerException - if the specified value is null and this map does not permit
     * null values (optional)
     */
    @Override
    public boolean containsValue(Object value) {
        for (int i = 0; i < capacity; i++) {
            if (map.get(i) != null) {
                ListASDV<EntryASDV<K, V>> bucket = map.get(i);
                for (Entry<K, V> entry : bucket) {
                    if (entry.getValue().equals(value)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this map contains no
     * mapping for the key.
     *
     * More formally, if this map contains a mapping from a key k to a value v such that (key==null
     * ? k==null : key.equals(k)), then this method returns v; otherwise it returns null. (There can
     * be at most one such mapping.)
     *
     * If this map permits null values, then a return value of null does not necessarily indicate
     * that the map contains no mapping for the key; it's also possible that the map explicitly maps
     * the key to null. The containsKey operation may be used to distinguish these two cases.
     *
     * @param key - the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or null if this map contains no
     * mapping for the key
     * @throws NullPointerException - if the specified key is null and this map does not permit null
     * keys (optional)
     */
    @Override
    public V get(Object key) {
//        throw new UnsupportedOperationException("Not supported yet....");
        return null;
    }

    /**
     * Associates the specified value with the specified key in this map (optional operation). If
     * the map previously contained a mapping for the key, the old value is replaced by the
     * specified value. (A map m is said to contain a mapping for a key k if and only if
     * m.containsKey(k) would return true.)
     *
     * @param key - key with which the specified value is to be associated
     * @param value - value to be associated with the specified key
     * @return the previous value associated with key, or null if there was no mapping for key. (A
     * null return can also indicate that the map previously associated null with key, if the
     * implementation supports null values.)
     * @throws NullPointerException - if specified key or value is null and this map does not permit
     * null keys
     */
    @Override

    public V put(K key, V value) {
        if (get(key) != null) { // The key is already in the map
            int bucketIndex = hash(key.hashCode());
            ListASDV<EntryASDV<K, V>> bucket = map.get(bucketIndex);

            for (Entry<K, V> entry : bucket) {
                if (entry.getKey().equals(key)) {

                    V oldValue = entry.getValue();

                    // Replace old value with new value
                    entry = (Entry<K, V>) value;

                    // Return the old value for the key
                    return oldValue;
                }
            }
        }
        // Check load factor
        if (size >= capacity * loadFactor) {
            if (capacity == MAXIMUM_CAPACITY) {
                throw new RuntimeException("Exceeding maximum capacity");
            }
            // rehash();
        }
        int bucketIndex = hash(key.hashCode());
        // Create a linked list for the bucket if it is not created
        if (map.get(bucketIndex) == null) {
            map.set(bucketIndex, new ListASDV<EntryASDV<K, V>>());
        }
        // Add a new entry (key, value) to hashTable[index]
        size++; // Increase size
        return value;
>>>>>>> 5cdcefb9ddb0176baf54b5dd787c6f3f2063f567
    }

    int hash(int keyHashCode) {
        int h = hashHash(keyHashCode);
        return Math.abs(h % capacity - 1);
    }

    /**
     * Removes the first entry with the given values.
     *
     * @param value - the value to be removed
     * @return true if removed, false otherwise
     * @throws NullPointerException if the value is null
     */
    private boolean removeFirstValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet....");

    }

    /**
     * Ensure hash code is evenly distributed
     *
     * @param h - hash code
     * @return evenly distributed hash code
     */
    private static int hashHash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    /**
<<<<<<< HEAD
     * Removes the mapping for a key from this map if it is present (optional
     * operation). More formally, if this map contains a mapping from key k to
     * value v such that (key==null ? k==null : key.equals(k)), that mapping is
     * removed. (The map can contain at most one such mapping.)
     *
     * @param key - key whose mapping is to be removed from the map
     * @return the previous value associated with key, or null if there was no
     * mapping for key.
     * @throws NullPointerException - if the specified key is null and this map
     * does not permit null keys
=======
     * Removes the mapping for a key from this map if it is present (optional operation). More
     * formally, if this map contains a mapping from key k to value v such that (key==null ? k==null
     * : key.equals(k)), that mapping is removed. (The map can contain at most one such mapping.)
     *
     * @param key - key whose mapping is to be removed from the map
     * @return the previous value associated with key, or null if there was no mapping for key.
     * @throws NullPointerException - if the specified key is null and this map does not permit null
     * keys
>>>>>>> 5cdcefb9ddb0176baf54b5dd787c6f3f2063f567
     */
    @Override
    public V remove(Object key) {
        throw new UnsupportedOperationException("Not supported yet....");

    }

    /**
<<<<<<< HEAD
     * Copies all of the mappings from the specified map to this map (optional
     * operation). The effect of this call is equivalent to that of calling
     * put(k, v) on this map once for each mapping from key k to value v in the
     * specified map. The behavior of this operation is undefined if the
     * specified map is modified while the operation is in progress.
     *
     * @param m - mappings to be stored in this map
     * @throws NullPointerException - if the specified map is null, or if this
     * map does not permit null keys or values, and the specified map contains
     * null keys
     */
    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        if (m == null) {
            throw new NullPointerException("null parameter");
        }

        BiConsumer consumeEachEntry = new BiConsumer<K, V>() {
            MapASDV<K, V> mapForConsumer = MapASDV.this;

            @Override
            public void accept(K k, V v) {
                mapForConsumer.put(k, v);
            }
        };

        m.forEach(consumeEachEntry);
    }

    /**
     * Removes all of the mappings from this map (optional operation). The map
     * will be empty after this call returns. Any shared sets are also cleared.
=======
     * Copies all of the mappings from the specified map to this map (optional operation). The
     * effect of this call is equivalent to that of calling put(k, v) on this map once for each
     * mapping from key k to value v in the specified map. The behavior of this operation is
     * undefined if the specified map is modified while the operation is in progress.
     *
     * @param m - mappings to be stored in this map
     * @throws NullPointerException - if the specified map is null, or if this map does not permit
     * null keys or values, and the specified map contains null keys
     */
    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        throw new UnsupportedOperationException("Not supported yet....");

    }

    /**
     * Removes all of the mappings from this map (optional operation). The map will be empty after
     * this call returns. Any shared sets are also cleared.
>>>>>>> 5cdcefb9ddb0176baf54b5dd787c6f3f2063f567
     */
    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet....");

    }

    /**
<<<<<<< HEAD
     * Returns a Set view of the keys contained in this map. The set is backed
     * by the map, so changes to the map are reflected in the set, and
     * vice-versa. If the map is modified while an iteration over the set is in
     * progress (except through the iterator's own remove operation), the
     * results of the iteration are undefined. The set supports element removal,
     * which removes the corresponding mapping from the map, via the
     * Iterator.remove, Set.remove, removeAll, retainAll, and clear operations.
     * It does not support the add or addAll operations.
=======
     * Returns a Set view of the keys contained in this map. The set is backed by the map, so
     * changes to the map are reflected in the set, and vice-versa. If the map is modified while an
     * iteration over the set is in progress (except through the iterator's own remove operation),
     * the results of the iteration are undefined. The set supports element removal, which removes
     * the corresponding mapping from the map, via the Iterator.remove, Set.remove, removeAll,
     * retainAll, and clear operations. It does not support the add or addAll operations.
>>>>>>> 5cdcefb9ddb0176baf54b5dd787c6f3f2063f567
     *
     * @return a set view of the keys contained in this map
     */
    @Override
    public Set<K> keySet() {

        return this.sharedKeySet;
    }

    /**
<<<<<<< HEAD
     * Returns a Collection view of the values contained in this map. The
     * collection is backed by the map, so changes to the map are reflected in
     * the collection, and vice-versa. If the map is modified while an iteration
     * over the collection is in progress (except through the iterator's own
     * remove operation), the results of the iteration are undefined. The
     * collection supports element removal, which removes the corresponding
     * mapping from the map, via the Iterator.remove, Collection.remove,
     * removeAll, retainAll and clear operations. It does not support the add or
     * addAll operations.
=======
     * Returns a Collection view of the values contained in this map. The collection is backed by
     * the map, so changes to the map are reflected in the collection, and vice-versa. If the map is
     * modified while an iteration over the collection is in progress (except through the iterator's
     * own remove operation), the results of the iteration are undefined. The collection supports
     * element removal, which removes the corresponding mapping from the map, via the
     * Iterator.remove, Collection.remove, removeAll, retainAll and clear operations. It does not
     * support the add or addAll operations.
>>>>>>> 5cdcefb9ddb0176baf54b5dd787c6f3f2063f567
     *
     * @return
     */
    @Override
    public Collection<V> values() {
        return sharedValuesCollection;
    }

    /**
<<<<<<< HEAD
     * Returns a Set view of the mappings contained in this map. The set is
     * backed by the map, so changes to the map are reflected in the set, and
     * vice-versa. If the map is modified while an iteration over the set is in
     * progress (except through the iterator's own remove operation, or through
     * the setValue operation on a map entry returned by the iterator) the
     * results of the iteration are undefined. The set supports element removal,
     * which removes the corresponding mapping from the map, via the
     * Iterator.remove, Set.remove, removeAll, retainAll and clear operations.
     * It does not support the add or addAll operations.
=======
     * Returns a Set view of the mappings contained in this map. The set is backed by the map, so
     * changes to the map are reflected in the set, and vice-versa. If the map is modified while an
     * iteration over the set is in progress (except through the iterator's own remove operation, or
     * through the setValue operation on a map entry returned by the iterator) the results of the
     * iteration are undefined. The set supports element removal, which removes the corresponding
     * mapping from the map, via the Iterator.remove, Set.remove, removeAll, retainAll and clear
     * operations. It does not support the add or addAll operations.
>>>>>>> 5cdcefb9ddb0176baf54b5dd787c6f3f2063f567
     *
     *
     * @return a set view of the mappings contained in this map
     */
    @Override
    public Set<Entry<K, V>> entrySet() {
        return this.sharedEntrySet;
    }

    @Override
    public String toString() {
        String s = "[ ";
        for (int i = 0; i < capacity; ++i) {
            s += map.get(i).toString() + "\n";
        }
        s += " ]";

        return s;
    }

    /**
     * Created a deep copy of the MapASDV
     *
     * @return the deep copy of the map
     */
    @Override
    public Object clone() {
<<<<<<< HEAD
        /*
        MapASDV<K, V> clonedMap = new MapASDV<K, V>();

        //clonedMap.putAll(this);
       
        for (ListASDV< EntryASDV<K, V>> list : this.map)
          {
            ListASDV< EntryASDV<K, V>>  l =  (ListASDV< EntryASDV<K, V>>) list.clone();
            clonedMap.map.add(l);      
          }
        return clonedMap;
         */

        MapASDV<K, V> clonedMap = new MapASDV<K, V>();
        clonedMap.putAll(this);
        return clonedMap;
=======
//        throw new UnsupportedOperationException("Not supported yet....");
        return null;

>>>>>>> 5cdcefb9ddb0176baf54b5dd787c6f3f2063f567
    }

    public static void main(String[] args) {

        MapASDV<String, Integer> map = new MapASDV();
        System.out.println("---------------------------testing put(K, V)");
        map.put("ann", 20);
        map.put("coco", 25);
        System.out.println(map);
<<<<<<< HEAD

        System.out.println("---------------------------testing clone");
        System.out.println(map);
        MapASDV<String, Integer> clonedMap = (MapASDV<String, Integer>) map.clone();
        System.out.println(clonedMap);
        /*
        System.out.println("\n\n---------------------------testing double-the-size-and-rehash by reaching 0.75 load factor with another put(K, V)");
        map.put("Jonathan", 30);
        System.out.println(map);
        map.put("Jonhathan", 45);
        System.out.println(map);
        map.put("Alexander", 33);
        System.out.println(map);

        System.out.println("\n\n---------------------------testing putAll(Map<K,V>)");
        Map<String, Integer> anotherJavaMap = new HashMap();
        anotherJavaMap.put("lion king", 45);
        anotherJavaMap.put("HYENA", 6);
        map.putAll(anotherJavaMap);
        System.out.println(map);

        System.out.println("\n\n---------------------------testing containsKey");
        System.out.println(map.containsKey("Alexander"));
        System.out.println(map.containsKey("alexander"));

        System.out.println("\n\n---------------------------testing containsValue");
        System.out.println(map.containsValue(33));
        System.out.println(map.containsValue(34));

        System.out.println("\n\n---------------------------testing getEntryForKey");
        Entry<String, Integer> e = map.getEntryForKey("Alexander");
        System.out.println(map.getEntryForKey("Alexander"));
        System.out.println(map.getEntryForKey("Alex"));

        System.out.println("\n\n---------------------------testing get");
        System.out.println(map.get("Alexander"));
        System.out.println(map.get("Alex"));
        try
          {
            map.get(null);
          }
        catch (NullPointerException ex)
          {
            System.out.println(ex.getMessage());
          }

        System.out.println("\n\n---------------------------testing getIndexForKey");
        System.out.println(map.getIndexForKey("Alexander"));
        System.out.println(map.getIndexForKey("Alex"));

        System.out.println("\n\n---------------------------testing isEmpty");
        System.out.println(map.isEmpty());

        System.out.println("\n\n---------------------------testing size");
        System.out.println(map.size());
        System.out.println(map);

        System.out.println("\n\n---------------------------testing entrySet()");
        Set<Entry<String, Integer>> entries = map.entrySet();
        System.out.println(entries);

        System.out.println("\n\n---------------------------testing keySet()");
        Set<String> keys = map.keySet();
        System.out.println(keys);

        System.out.println("\n\n---------------------------testing values()");
        Collection<Integer> values = map.values();
        System.out.println(values);

        System.out.println("\n\n---------------------------testing remove( K) coco 25");
        map.remove("coco");
        System.out.println(map);
        System.out.println(entries);
        System.out.println(keys);
        System.out.println(values);

        System.out.println("\n\n---------------------------testing Entry-Collection remove  ");
        entries.remove(e);
        System.out.println(map);
        System.out.println(entries);
        System.out.println(keys);
        System.out.println(values);

        System.out.println("\n\n---------------------------testing Set Keys remove  ");
        keys.remove("ann");
        System.out.println(map);
        System.out.println(entries);
        System.out.println(keys);
        System.out.println(values);

        System.out.println("\n\n---------------------------testing Set Values remove  ");
        values.remove(45);
        System.out.println(map);
        System.out.println(entries);
        System.out.println(keys);
        System.out.println(values);

        System.out.println("\n\n---------------------------testing clear  ");
        map.clear();
        System.out.println(map);
        System.out.println(entries);
        System.out.println(keys);

        System.out.println("\n\n---------------------------testing add of sets and collections  ");
        try
          {
            keys.add("a");
          }
        catch (Exception ex)
          {
            System.out.println(ex.getMessage());
          }
        try
          {
            values.add(33);
          }
        catch (Exception ex)
          {
            System.out.println(ex.getMessage());
          }
        try
          {
            entries.add(e);
          }
        catch (Exception ex)
          {
            System.out.println(ex.getMessage());
          }

        System.out.println("\n\n---------------------------testing clone");
        System.out.println(clonedMap);

        System.out.println("---------------------------testing put(K, V) AGAIN");
        map.put("Nicholas", 100);
        map.put("a", 200);
        map.put("b", -20);
        System.out.println(map);
         */
=======
        MapASDV<String, Integer> clonedMap = (MapASDV<String, Integer>) map.clone();
//
//        System.out.println("\n\n---------------------------testing double-the-size-and-rehash by reaching 0.75 load factor with another put(K, V)");
//        map.put("Jonathan", 30);
//        System.out.println(map);
//        map.put("Jonhathan", 45);
//        System.out.println(map);
//        map.put("Alexander", 33);
//        System.out.println(map);
//
//        System.out.println("\n\n---------------------------testing putAll(Map<K,V>)");
//        Map<String, Integer> anotherJavaMap = new HashMap();
//        anotherJavaMap.put("lion king", 45);
//        anotherJavaMap.put("HYENA", 6);
//        map.putAll(anotherJavaMap);
//        System.out.println(map);
//
//        System.out.println("\n\n---------------------------testing containsKey");
//        System.out.println(map.containsKey("Alexander"));
//        System.out.println(map.containsKey("alexander"));
//
//        System.out.println("\n\n---------------------------testing containsValue");
//        System.out.println(map.containsValue(33));
//        System.out.println(map.containsValue(34));
//
//        System.out.println("\n\n---------------------------testing getEntryForKey");
//        Entry<String, Integer> e = map.getEntryForKey("Alexander");
//        System.out.println(map.getEntryForKey("Alexander"));
//        System.out.println(map.getEntryForKey("Alex"));
//
//        System.out.println("\n\n---------------------------testing get");
//        System.out.println(map.get("Alexander"));
//        System.out.println(map.get("Alex"));
//        try {
//            map.get(null);
//        } catch (NullPointerException ex) {
//            System.out.println(ex.getMessage());
//        }
//
//        System.out.println("\n\n---------------------------testing getIndexForKey");
//        System.out.println(map.getIndexForKey("Alexander"));
//        System.out.println(map.getIndexForKey("Alex"));
//
//        System.out.println("\n\n---------------------------testing isEmpty");
//        System.out.println(map.isEmpty());
//
//        System.out.println("\n\n---------------------------testing size");
//        System.out.println(map.size());
//        System.out.println(map);
//
//        System.out.println("\n\n---------------------------testing entrySet()");
//        Set<Entry<String, Integer>> entries = map.entrySet();
//        System.out.println(entries);
//
//        System.out.println("\n\n---------------------------testing keySet()");
//        Set<String> keys = map.keySet();
//        System.out.println(keys);
//
//        System.out.println("\n\n---------------------------testing values()");
//        Collection<Integer> values = map.values();
//        System.out.println(values);
//
//        System.out.println("\n\n---------------------------testing remove( K) coco 25");
//        map.remove("coco");
//        System.out.println(map);
//        System.out.println(entries);
//        System.out.println(keys);
//        System.out.println(values);
//
//        System.out.println("\n\n---------------------------testing Entry-Collection remove  ");
//        entries.remove(e);
//        System.out.println(map);
//        System.out.println(entries);
//        System.out.println(keys);
//        System.out.println(values);
//
//        System.out.println("\n\n---------------------------testing Set Keys remove  ");
//        keys.remove("ann");
//        System.out.println(map);
//        System.out.println(entries);
//        System.out.println(keys);
//        System.out.println(values);
//
//        System.out.println("\n\n---------------------------testing Set Values remove  ");
//        values.remove(45);
//        System.out.println(map);
//        System.out.println(entries);
//        System.out.println(keys);
//        System.out.println(values);
//
//        System.out.println("\n\n---------------------------testing clear  ");
//        map.clear();
//        System.out.println(map);
//        System.out.println(entries);
//        System.out.println(keys);
//
//        System.out.println("\n\n---------------------------testing add of sets and collections  ");
//        try {
//            keys.add("a");
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//        try {
//            values.add(33);
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//        try {
//            entries.add(e);
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//
//        System.out.println("\n\n---------------------------testing clone");
//        System.out.println(clonedMap);
//
//        System.out.println("---------------------------testing put(K, V) AGAIN");
//        map.put("Nicholas", 100);
//        map.put("a", 200);
//        map.put("b", -20);
//        System.out.println(map);

>>>>>>> 5cdcefb9ddb0176baf54b5dd787c6f3f2063f567
    }

}

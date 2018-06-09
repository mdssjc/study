package com.github.mdssjc.algorithms.introcs.chapter4.section44;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeMap;

/**
 * ST.
 * <p>
 * Compilation:  javac ST.java
 * Execution:    java ST
 * Dependencies: StdIn.java StdOut.java
 * <p>
 * Sorted symbol table implementation using a java.util.TreeMap.
 * Does not allow duplicates.
 * <p>
 * % java ST
 *
 * @author Marcelo dos Santos
 */

/**
 * The {@code ST} class represents an ordered symbol table of generic
 * key-value pairs.
 * It supports the usual <em>put</em>, <em>get</em>, <em>contains</em>,
 * <em>remove</em>, <em>size</em>, and <em>is-empty</em> methods.
 * It also provides ordered methods for finding the <em>minimum</em>,
 * <em>maximum</em>, <em>floor</em>, and <em>ceiling</em>.
 * It also provides a <em>keys</em> method for iterating over all of the keys.
 * A symbol table implements the <em>associative array</em> abstraction:
 * when associating a value with a key that is already in the symbol table,
 * the convention is to replace the old value with the new value.
 * Unlike {@link java.util.Map}, this class uses the convention that
 * values cannot be {@code null}—setting the
 * value associated with a key to {@code null} is equivalent to deleting the
 * key
 * from the symbol table.
 * <p>
 * This implementation uses a balanced binary search tree. It requires that
 * the key type implements the {@code Comparable} interface and calls the
 * {@code compareTo()} and method to compare two keys. It does not call either
 * {@code equals()} or {@code hashCode()}.
 * The <em>put</em>, <em>contains</em>, <em>remove</em>, <em>minimum</em>,
 * <em>maximum</em>, <em>ceiling</em>, and <em>floor</em> operations each take
 * logarithmic time in the worst case.
 * The <em>size</em>, and <em>is-empty</em> operations take constant time.
 * Construction takes constant time.
 * <p>
 * For additional documentation, see <a href="https://introcs.cs.princeton.edu/44st">Section
 * 4.4</a> of
 * <i>Introduction to Programming in Java: An Interdisciplinary Approach</i> by
 * Robert Sedgewick and Kevin Wayne.
 *
 * @param <Key>
 *     the generic type of keys in this symbol table
 * @param <Value>
 *     the generic type of values in this symbol table
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
@TestDrive(input = "tobe.txt", inputFile = true)
public class ST<Key extends Comparable<Key>, Value> implements Iterable<Key> {

  private final TreeMap<Key, Value> st;

  /**
   * Initializes an empty symbol table.
   */
  public ST() {
    this.st = new TreeMap<>();
  }

  /**
   * Returns the value associated with the given key in this symbol table.
   *
   * @param key
   *     the key
   *
   * @return the value associated with the given key if the key is in this symbol table;
   * {@code null} if the key is not in this symbol table
   *
   * @throws IllegalArgumentException
   *     if {@code key} is {@code null}
   */
  public Value get(final Key key) {
    if (key == null) {
      throw new IllegalArgumentException("called get() with null key");
    }
    return this.st.get(key);
  }

  /**
   * Inserts the specified key-value pair into the symbol table, overwriting the
   * old
   * value with the new value if the symbol table already contains the specified
   * key.
   * Removes the specified key (and its associated value) from this symbol
   * table
   * if the specified value is {@code null}.
   *
   * @param key
   *     the key
   * @param val
   *     the value
   *
   * @throws IllegalArgumentException
   *     if {@code key} is {@code null}
   */
  public void put(final Key key, final Value val) {
    if (key == null) {
      throw new IllegalArgumentException("called put() with null key");
    }
    if (val == null) {
      this.st.remove(key);
    } else {
      this.st.put(key, val);
    }
  }

  /**
   * Removes the specified key and its associated value from this symbol table
   * (if the key is in this symbol table).
   *
   * @param key
   *     the key
   *
   * @throws IllegalArgumentException
   *     if {@code key} is {@code null}
   * @deprecated Replaced by {@link #remove(Comparable key)}.
   */
  @Deprecated
  public void delete(final Key key) {
    if (key == null) {
      throw new IllegalArgumentException("called delete() with null key");
    }
    this.st.remove(key);
  }

  /**
   * Removes the specified key and its associated value from this symbol table
   * (if the key is in this symbol table).
   *
   * @param key
   *     the key
   *
   * @throws IllegalArgumentException
   *     if {@code key} is {@code null}
   */
  public void remove(final Key key) {
    if (key == null) {
      throw new IllegalArgumentException("called remove() with null key");
    }
    this.st.remove(key);
  }

  /**
   * Returns true if this symbol table contain the given key.
   *
   * @param key
   *     the key
   *
   * @return {@code true} if this symbol table contains {@code key} and
   * {@code false} otherwise
   *
   * @throws IllegalArgumentException
   *     if {@code key} is {@code null}
   */
  public boolean contains(final Key key) {
    if (key == null) {
      throw new IllegalArgumentException("called contains() with null key");
    }
    return this.st.containsKey(key);
  }

  /**
   * Returns the number of key-value pairs in this symbol table.
   *
   * @return the number of key-value pairs in this symbol table
   */
  public int size() {
    return this.st.size();
  }

  /**
   * Returns true if this symbol table is empty.
   *
   * @return {@code true} if this symbol table is empty and {@code false} otherwise
   */
  public boolean isEmpty() {
    return size() == 0;
  }

  /**
   * Returns all keys in this symbol table.
   * <p>
   * To iterate over all of the keys in the symbol table named {@code st},
   * use the foreach notation: {@code for (Key key : st.keys())}.
   *
   * @return all keys in this symbol table
   */
  public Iterable<Key> keys() {
    return this.st.keySet();
  }

  /**
   * Returns all of the keys in this symbol table.
   * To iterate over all of the keys in a symbol table named {@code st}, use the
   * foreach notation: {@code for (Key key : st)}.
   *
   * @return an iterator to all of the keys in this symbol table
   *
   * @deprecated Replaced by {@link #keys()}.
   */
  @Override
  @Deprecated
  public Iterator<Key> iterator() {
    return this.st.keySet()
                  .iterator();
  }

  /**
   * Returns the smallest key in this symbol table.
   *
   * @return the smallest key in this symbol table
   *
   * @throws NoSuchElementException
   *     if this symbol table is empty
   */
  public Key min() {
    if (isEmpty()) {
      throw new NoSuchElementException("called min() with empty symbol table");
    }
    return this.st.firstKey();
  }

  /**
   * Returns the largest key in this symbol table.
   *
   * @return the largest key in this symbol table
   *
   * @throws NoSuchElementException
   *     if this symbol table is empty
   */
  public Key max() {
    if (isEmpty()) {
      throw new NoSuchElementException("called max() with empty symbol table");
    }
    return this.st.lastKey();
  }

  /**
   * Returns the smallest key in this symbol table greater than or equal to
   * {@code key}.
   *
   * @param key
   *     the key
   *
   * @return the smallest key in this symbol table greater than or equal to {@code key}
   *
   * @throws NoSuchElementException
   *     if there is no such key
   * @throws IllegalArgumentException
   *     if {@code key} is {@code null}
   */
  public Key ceiling(final Key key) {
    if (key == null) {
      throw new IllegalArgumentException("called ceiling() with null key");
    }
    final var k = this.st.ceilingKey(key);
    if (k == null) {
      throw new NoSuchElementException("all keys are less than " + key);
    }
    return k;
  }

  /**
   * Returns the largest key in this symbol table less than or equal to {@code
   * key}.
   *
   * @param key
   *     the key
   *
   * @return the largest key in this symbol table less than or equal to {@code key}
   *
   * @throws NoSuchElementException
   *     if there is no such key
   * @throws IllegalArgumentException
   *     if {@code key} is {@code null}
   */
  public Key floor(final Key key) {
    if (key == null) {
      throw new IllegalArgumentException("called floor() with null key");
    }
    final var k = this.st.floorKey(key);
    if (k == null) {
      throw new NoSuchElementException("all keys are greater than " + key);
    }
    return k;
  }

  /**
   * Unit tests the {@code ST} data type.
   */
  public static void main(final String[] args) {
    Executor.execute(ST.class, args);

    final ST<String, Integer> st = new ST<>();
    for (var i = 0; !StdIn.isEmpty(); i++) {
      final var key = StdIn.readString();
      st.put(key, i);
    }
    for (final var s : st.keys()) {
      StdOut.println(s + " " + st.get(s));
    }
  }
}



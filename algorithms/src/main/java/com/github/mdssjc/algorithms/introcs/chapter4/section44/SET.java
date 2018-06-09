package com.github.mdssjc.algorithms.introcs.chapter4.section44;

/**
 * SET.
 * <p>
 * Compilation:  javac SET.java
 * Execution:    java SET
 * Dependencies: StdOut.java
 * <p>
 * Set implementation using Java's TreeSet library.
 * Does not allow duplicates.
 * <p>
 * % java SET
 * 128.112.136.11
 * 208.216.181.15
 * null
 *
 * @author Marcelo dos Santos
 *
 */
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeSet;

/**
 * The {@code SET} class represents an ordered set of comparable keys.
 * It supports the usual <em>add</em>, <em>contains</em>, and <em>delete</em>
 * methods. It also provides ordered methods for finding the <em>minimum</em>,
 * <em>maximum</em>, <em>floor</em>, and <em>ceiling</em> and set methods
 * for <em>union</em>, <em>intersection</em>, and <em>equality</em>.
 * <p>
 * Even though this implementation include the method {@code equals()}, it
 * does not support the method {@code hashCode()} because sets are mutable.
 * <p>
 * This implementation uses a balanced binary search tree. It requires that
 * the key type implements the {@code Comparable} interface and calls the
 * {@code compareTo()} and method to compare two keys. It does not call either
 * {@code equals()} or {@code hashCode()}.
 * The <em>add</em>, <em>contains</em>, <em>delete</em>, <em>minimum</em>,
 * <em>maximum</em>, <em>ceiling</em>, and <em>floor</em> methods take
 * logarithmic time in the worst case.
 * The <em>size</em>, and <em>is-empty</em> operations take constant time.
 * Construction takes constant time.
 * <p>
 * This implementation uses a balanced binary search tree. It requires that
 * For additional documentation, see <a href="https://introcs.cs.princeton.edu/44st">Section
 * 4.4</a> of
 * <i>Introduction to Programming in Java: An Interdisciplinary Approach</i> by
 * Robert Sedgewick and Kevin Wayne.
 *
 * @param <Key>
 *     the generic type of a key in this set
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
@TestDrive
public class SET<Key extends Comparable<Key>> implements Iterable<Key> {

  private final TreeSet<Key> set;

  /**
   * Initializes an empty set.
   */
  public SET() {
    this.set = new TreeSet<>();
  }

  /**
   * Initializes a new set that is an independent copy of the specified set.
   */
  public SET(final SET<Key> x) {
    this.set = new TreeSet<>(x.set);
  }

  /**
   * Adds the key to this set (if it is not already present).
   *
   * @param key
   *     the key to add
   *
   * @throws IllegalArgumentException
   *     if {@code key} is {@code null}
   */
  public void add(final Key key) {
    if (key == null) {
      throw new IllegalArgumentException("called add() with a null key");
    }
    this.set.add(key);
  }

  /**
   * Returns true if this set contains the given key.
   *
   * @param key
   *     the key
   *
   * @return {@code true} if this set contains {@code key};
   * {@code false} otherwise
   *
   * @throws IllegalArgumentException
   *     if {@code key} is {@code null}
   */
  public boolean contains(final Key key) {
    if (key == null) {
      throw new IllegalArgumentException("called contains() with a null key");
    }
    return this.set.contains(key);
  }

  /**
   * Removes the specified key from this set (if the set contains the specified
   * key).
   *
   * @param key
   *     the key
   *
   * @throws IllegalArgumentException
   *     if {@code key} is {@code null}
   */
  public void delete(final Key key) {
    if (key == null) {
      throw new IllegalArgumentException("called delete() with a null key");
    }
    this.set.remove(key);
  }

  /**
   * Returns the number of keys in this set.
   *
   * @return the number of keys in this set
   */
  public int size() {
    return this.set.size();
  }

  /**
   * Returns true if this set is empty.
   *
   * @return {@code true} if this set is empty;
   * {@code false} otherwise
   */
  public boolean isEmpty() {
    return size() == 0;
  }

  /**
   * Returns all of the keys in this set, as an iterator.
   * To iterate over all of the keys in a set named {@code set}, use the
   * foreach notation: {@code for (Key key : set)}.
   *
   * @return an iterator to all of the keys in this set
   */
  @Override
  public Iterator<Key> iterator() {
    return this.set.iterator();
  }

  /**
   * Returns the largest key in this set.
   *
   * @return the largest key in this set
   *
   * @throws NoSuchElementException
   *     if this set is empty
   */
  public Key max() {
    if (isEmpty()) {
      throw new NoSuchElementException("called max() with empty set");
    }
    return this.set.last();
  }

  /**
   * Returns the smallest key in this set.
   *
   * @return the smallest key in this set
   *
   * @throws NoSuchElementException
   *     if this set is empty
   */
  public Key min() {
    if (isEmpty()) {
      throw new NoSuchElementException("called min() with empty set");
    }
    return this.set.first();
  }

  /**
   * Returns the smallest key in this set greater than or equal to {@code key}.
   *
   * @param key
   *     the key
   *
   * @return the smallest key in this set greater than or equal to {@code key}
   *
   * @throws IllegalArgumentException
   *     if {@code key} is {@code null}
   * @throws NoSuchElementException
   *     if there is no such key
   */
  public Key ceiling(final Key key) {
    if (key == null) {
      throw new IllegalArgumentException("called ceiling() with a null key");
    }
    final var k = this.set.ceiling(key);
    if (k == null) {
      throw new NoSuchElementException("all keys are less than " + key);
    }
    return k;
  }

  /**
   * Returns the largest key in this set less than or equal to {@code key}.
   *
   * @param key
   *     the key
   *
   * @return the largest key in this set table less than or equal to {@code key}
   *
   * @throws IllegalArgumentException
   *     if {@code key} is {@code null}
   * @throws NoSuchElementException
   *     if there is no such key
   */
  public Key floor(final Key key) {
    if (key == null) {
      throw new IllegalArgumentException("called floor() with a null key");
    }
    final var k = this.set.floor(key);
    if (k == null) {
      throw new NoSuchElementException("all keys are greater than " + key);
    }
    return k;
  }

  /**
   * Returns the union of this set and that set.
   *
   * @param that
   *     the other set
   *
   * @return the union of this set and that set
   *
   * @throws IllegalArgumentException
   *     if {@code that} is {@code null}
   */
  public SET<Key> union(final SET<Key> that) {
    if (that == null) {
      throw new IllegalArgumentException("called union() with a null argument");
    }
    final SET<Key> c = new SET<>();
    for (final var x : this) {
      c.add(x);
    }
    for (final var x : that) {
      c.add(x);
    }
    return c;
  }

  /**
   * Returns the intersection of this set and that set.
   *
   * @param that
   *     the other set
   *
   * @return the intersection of this set and that set
   *
   * @throws IllegalArgumentException
   *     if {@code that} is {@code null}
   */
  public SET<Key> intersects(final SET<Key> that) {
    if (that == null) {
      throw new IllegalArgumentException("called intersects() with a null argument");
    }
    final SET<Key> c = new SET<>();
    if (this.size() < that.size()) {
      for (final var x : this) {
        if (that.contains(x)) {
          c.add(x);
        }
      }
    } else {
      for (final var x : that) {
        if (this.contains(x)) {
          c.add(x);
        }
      }
    }
    return c;
  }

  /**
   * Compares this set to the specified set.
   * <p>
   * Note that this method declares two empty sets to be equal
   * even if they are parameterized by different generic types.
   * This is consistent with the behavior of {@code equals()}
   * within Java's Collections framework.
   *
   * @param other
   *     the other set
   *
   * @return {@code true} if this set equals {@code other};
   * {@code false} otherwise
   */
  @SuppressWarnings("rawtypes")
  @Override
  public boolean equals(final Object other) {
    if (other == this) {
      return true;
    }
    if (other == null) {
      return false;
    }
    if (other.getClass() != this.getClass()) {
      return false;
    }
    final var that = (SET) other;
    return this.set.equals(that.set);
  }

  /**
   * This operation is not supported because sets are mutable.
   *
   * @return does not return a value
   *
   * @throws UnsupportedOperationException
   *     if called
   */
  @Override
  public int hashCode() {
    throw new UnsupportedOperationException(
        "hashCode() is not supported because sets are mutable");
  }

  /**
   * Returns a string representation of this set.
   *
   * @return a string representation of this set, enclosed in curly braces,
   * with adjacent keys separated by a comma and a space
   */
  @Override
  public String toString() {
    final var s = this.set.toString();
    return "{ " + s.substring(1, s.length() - 1) + " }";
  }

  /**
   * Unit tests the {@code SET} data type.
   */
  public static void main(final String[] args) {
    Executor.execute(SET.class, args);

    final SET<String> set = new SET<>();

    set.add("www.cs.princeton.edu");
    set.add("www.cs.princeton.edu");
    set.add("www.princeton.edu");
    set.add("www.math.princeton.edu");
    set.add("www.yale.edu");
    set.add("www.amazon.com");
    set.add("www.simpsons.com");
    set.add("www.stanford.edu");
    set.add("www.google.com");
    set.add("www.ibm.com");
    set.add("www.apple.com");
    set.add("www.slashdot.com");
    set.add("www.whitehouse.gov");
    set.add("www.espn.com");
    set.add("www.snopes.com");
    set.add("www.movies.com");
    set.add("www.cnn.com");
    set.add("www.iitb.ac.in");

    StdOut.println(set.contains("www.cs.princeton.edu"));
    StdOut.println(!set.contains("www.harvardsucks.com"));
    StdOut.println(set.contains("www.simpsons.com"));
    StdOut.println();

    StdOut.println(
        "ceiling(www.simpsonr.com) = " + set.ceiling("www.simpsonr.com"));
    StdOut.println(
        "ceiling(www.simpsons.com) = " + set.ceiling("www.simpsons.com"));
    StdOut.println(
        "ceiling(www.simpsont.com) = " + set.ceiling("www.simpsont.com"));
    StdOut.println(
        "floor(www.simpsonr.com)   = " + set.floor("www.simpsonr.com"));
    StdOut.println(
        "floor(www.simpsons.com)   = " + set.floor("www.simpsons.com"));
    StdOut.println(
        "floor(www.simpsont.com)   = " + set.floor("www.simpsont.com"));
    StdOut.println();

    for (final var s : set) {
      StdOut.println(s);
    }

    StdOut.println();
    final SET<String> set2 = new SET<>(set);
    StdOut.println(set.equals(set2));
  }
}

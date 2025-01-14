package com.github.mdssjc.algorithms.introcs.chapter4.section44;

import com.github.mdssjc.algorithms.introcs.chapter4.section43.Queue;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

import java.util.NoSuchElementException;

/**
 * Program 4.4.4 Binary search tree.
 * <p>
 * Compilation:  javac BST.java
 * Execution:    java BST
 * Dependencies: StdIn.java StdOut.java Queue.java
 * Data files:   https://introcs.cs.princeton.edu/44st/tinyST.txt
 * <p>
 * A symbol table implemented with a binary search tree.
 * <p>
 * % more tinyST.txt
 * S E A R C H E X A M P L E
 * <p>
 * % java BST < tinyST.txt
 * A 8
 * C 4
 * E 12
 * H 5
 * L 11
 * M 9
 * P 10
 * R 3
 * S 0
 * X 7
 *
 * @author Marcelo dos Santos
 *
 */

/**
 *  The {@code BST} class represents an ordered symbol table of generic
 *  key-value pairs.
 *  It supports the usual <em>put</em>, <em>get</em>, <em>contains</em>,
 *  <em>delete</em>, <em>size</em>, and <em>is-empty</em> methods.
 *  It also provides ordered methods for finding the <em>minimum</em>,
 *  <em>maximum</em>, <em>floor</em>, <em>select</em>, <em>ceiling</em>.
 *  It also provides a <em>keys</em> method for iterating over all of the keys.
 *  A symbol table implements the <em>associative array</em> abstraction:
 *  when associating a value with a key that is already in the symbol table,
 *  the convention is to replace the old value with the new value.
 *  Unlike {@link java.util.Map}, this class uses the convention that
 *  values cannot be {@code null}—setting the
 *  value associated with a key to {@code null} is equivalent to deleting the key
 *  from the symbol table.
 *  <p>
 *  This implementation uses an (unbalanced) binary search tree. It requires that
 *  the key type implements the {@code Comparable} interface and calls the
 *  {@code compareTo()} and method to compare two keys. It does not call either
 *  {@code equals()} or {@code hashCode()}.
 *  The <em>put</em>, <em>contains</em>, <em>remove</em>, <em>minimum</em>,
 *  <em>maximum</em>, <em>ceiling</em>, <em>floor</em>, <em>select</em>, and
 *  <em>rank</em>  operations each take
 *  linear time in the worst case, if the tree becomes unbalanced.
 *  The <em>size</em>, and <em>is-empty</em> operations take constant time.
 *  Construction takes constant time.
 *  <p>
 *  For additional documentation, see <a href="http://algs4.cs.princeton.edu/44st">Section 4.4</a> of
 *  <i>Introdution to Programming in Java</i> by Robert Sedgewick and Kevin Wayne.
 *  For other implementations, see {@link ST}, {@link BinarySearchST},
 *  {@link SequentialSearchST}, and {@link HashST}.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
@TestDrive(input = "tinyST.txt", inputFile = true)
public class BST<Key extends Comparable<Key>, Value> {

  private Node root;

  private class Node {

    private final Key key;
    private Value val;
    private Node left, right;
    private int size;

    public Node(final Key key, final Value val, final int size) {
      this.key = key;
      this.val = val;
      this.size = size;
    }
  }

  /**
   * Initializes an empty symbol table.
   */
  public BST() {
  }

  /**
   * Returns true if this symbol table is empty.
   *
   * @return {@code true} if this symbol table is empty; {@code false} otherwise
   */
  public boolean isEmpty() {
    return size() == 0;
  }

  /**
   * Returns the number of key-value pairs in this symbol table.
   *
   * @return the number of key-value pairs in this symbol table
   */
  public int size() {
    return size(this.root);
  }

  private int size(final Node x) {
    if (x == null) {
      return 0;
    } else {
      return x.size;
    }
  }

  /**
   * Does this symbol table contain the given key?
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
      throw new IllegalArgumentException("argument to contains() is null");
    }
    return get(key) != null;
  }

  /**
   * Returns the value associated with the given key.
   *
   * @param key
   *     the key
   *
   * @return the value associated with the given key if the key is in the symbol table
   * and {@code null} if the key is not in the symbol table
   *
   * @throws IllegalArgumentException
   *     if {@code key} is {@code null}
   */
  public Value get(final Key key) {
    return get(this.root, key);
  }

  private Value get(final Node x, final Key key) {
    if (x == null) {
      return null;
    }
    final var cmp = key.compareTo(x.key);
    if (cmp < 0) {
      return get(x.left, key);
    } else if (cmp > 0) {
      return get(x.right, key);
    } else {
      return x.val;
    }
  }

  /**
   * Inserts the specified key-value pair into the symbol table, overwriting the
   * old
   * value with the new value if the symbol table already contains the specified
   * key.
   * Deletes the specified key (and its associated value) from this symbol
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
      throw new IllegalArgumentException("first argument to put() is null");
    }
    if (val == null) {
      delete(key);
      return;
    }
    this.root = put(this.root, key, val);
    assert check();
  }

  private Node put(final Node x, final Key key, final Value val) {
    if (x == null) {
      return new Node(key, val, 1);
    }
    final var cmp = key.compareTo(x.key);
    if (cmp < 0) {
      x.left = put(x.left, key, val);
    } else if (cmp > 0) {
      x.right = put(x.right, key, val);
    } else {
      x.val = val;
    }
    x.size = 1 + size(x.left) + size(x.right);
    return x;
  }

  /**
   * Removes the smallest key and associated value from the symbol table.
   *
   * @throws NoSuchElementException
   *     if the symbol table is empty
   */
  public void deleteMin() {
    if (isEmpty()) {
      throw new NoSuchElementException("Symbol table underflow");
    }
    this.root = deleteMin(this.root);
    assert check();
  }

  private Node deleteMin(final Node x) {
    if (x.left == null) {
      return x.right;
    }
    x.left = deleteMin(x.left);
    x.size = size(x.left) + size(x.right) + 1;
    return x;
  }

  /**
   * Removes the largest key and associated value from the symbol table.
   *
   * @throws NoSuchElementException
   *     if the symbol table is empty
   */
  public void deleteMax() {
    if (isEmpty()) {
      throw new NoSuchElementException("Symbol table underflow");
    }
    this.root = deleteMax(this.root);
    assert check();
  }

  private Node deleteMax(final Node x) {
    if (x.right == null) {
      return x.left;
    }
    x.right = deleteMax(x.right);
    x.size = size(x.left) + size(x.right) + 1;
    return x;
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
  public void delete(final Key key) {
    if (key == null) {
      throw new IllegalArgumentException("argument to delete() is null");
    }
    this.root = delete(this.root, key);
    assert check();
  }

  private Node delete(Node x, final Key key) {
    if (x == null) {
      return null;
    }

    final var cmp = key.compareTo(x.key);
    if (cmp < 0) {
      x.left = delete(x.left, key);
    } else if (cmp > 0) {
      x.right = delete(x.right, key);
    } else {
      if (x.right == null) {
        return x.left;
      }
      if (x.left == null) {
        return x.right;
      }
      final var t = x;
      x = min(t.right);
      x.right = deleteMin(t.right);
      x.left = t.left;
    }
    x.size = size(x.left) + size(x.right) + 1;
    return x;
  }

  /**
   * Returns the smallest key in the symbol table.
   *
   * @return the smallest key in the symbol table
   *
   * @throws NoSuchElementException
   *     if the symbol table is empty
   */
  public Key min() {
    if (isEmpty()) {
      throw new NoSuchElementException("called min() with empty symbol table");
    }
    return min(this.root).key;
  }

  private Node min(final Node x) {
    if (x.left == null) {
      return x;
    } else {
      return min(x.left);
    }
  }

  /**
   * Returns the largest key in the symbol table.
   *
   * @return the largest key in the symbol table
   *
   * @throws NoSuchElementException
   *     if the symbol table is empty
   */
  public Key max() {
    if (isEmpty()) {
      throw new NoSuchElementException("called max() with empty symbol table");
    }
    return max(this.root).key;
  }

  private Node max(final Node x) {
    if (x.right == null) {
      return x;
    } else {
      return max(x.right);
    }
  }

  /**
   * Returns the largest key in the symbol table less than or equal to {@code
   * key}.
   *
   * @param key
   *     the key
   *
   * @return the largest key in the symbol table less than or equal to {@code key}
   *
   * @throws NoSuchElementException
   *     if there is no such key
   * @throws IllegalArgumentException
   *     if {@code key} is {@code null}
   */
  public Key floor(final Key key) {
    if (key == null) {
      throw new IllegalArgumentException("argument to floor() is null");
    }
    if (isEmpty()) {
      throw new NoSuchElementException("called floor() with empty symbol table");
    }
    final var x = floor(this.root, key);
    if (x == null) {
      return null;
    } else {
      return x.key;
    }
  }

  private Node floor(final Node x, final Key key) {
    if (x == null) {
      return null;
    }
    final var cmp = key.compareTo(x.key);
    if (cmp == 0) {
      return x;
    }
    if (cmp < 0) {
      return floor(x.left, key);
    }
    final var t = floor(x.right, key);
    if (t != null) {
      return t;
    } else {
      return x;
    }
  }

  /**
   * Returns the smallest key in the symbol table greater than or equal to
   * {@code key}.
   *
   * @param key
   *     the key
   *
   * @return the smallest key in the symbol table greater than or equal to {@code key}
   *
   * @throws NoSuchElementException
   *     if there is no such key
   * @throws IllegalArgumentException
   *     if {@code key} is {@code null}
   */
  public Key ceiling(final Key key) {
    if (key == null) {
      throw new IllegalArgumentException("argument to ceiling() is null");
    }
    if (isEmpty()) {
      throw new NoSuchElementException("called ceiling() with empty symbol table");
    }
    final var x = ceiling(this.root, key);
    if (x == null) {
      return null;
    } else {
      return x.key;
    }
  }

  private Node ceiling(final Node x, final Key key) {
    if (x == null) {
      return null;
    }
    final var cmp = key.compareTo(x.key);
    if (cmp == 0) {
      return x;
    }
    if (cmp < 0) {
      final var t = ceiling(x.left, key);
      if (t != null) {
        return t;
      } else {
        return x;
      }
    }
    return ceiling(x.right, key);
  }

  /**
   * Return the kth smallest key in the symbol table.
   *
   * @param k
   *     the order statistic
   *
   * @return the kth smallest key in the symbol table
   *
   * @throws IllegalArgumentException
   *     unless {@code k} is between 0 and
   *     <em>N</em> &minus; 1
   */
  public Key select(final int k) {
    if (k < 0 || k >= size()) {
      throw new IllegalArgumentException();
    }
    final var x = select(this.root, k);
    return x.key;
  }

  private Node select(final Node x, final int k) {
    if (x == null) {
      return null;
    }
    final var t = size(x.left);
    if (t > k) {
      return select(x.left, k);
    } else if (t < k) {
      return select(x.right, k - t - 1);
    } else {
      return x;
    }
  }

  /**
   * Return the number of keys in the symbol table strictly less than {@code
   * key}.
   *
   * @param key
   *     the key
   *
   * @return the number of keys in the symbol table strictly less than {@code key}
   *
   * @throws IllegalArgumentException
   *     if {@code key} is {@code null}
   */
  public int rank(final Key key) {
    if (key == null) {
      throw new IllegalArgumentException("argument to rank() is null");
    }
    return rank(key, this.root);
  }

  private int rank(final Key key, final Node x) {
    if (x == null) {
      return 0;
    }
    final var cmp = key.compareTo(x.key);
    if (cmp < 0) {
      return rank(key, x.left);
    } else if (cmp > 0) {
      return 1 + size(x.left) + rank(key, x.right);
    } else {
      return size(x.left);
    }
  }

  /**
   * Returns all keys in the symbol table as an {@code Iterable}.
   * To iterate over all of the keys in the symbol table named {@code st},
   * use the foreach notation: {@code for (Key key : st.keys())}.
   *
   * @return all keys in the symbol table
   */
  public Iterable<Key> keys() {
    return rangeSearch(min(), max());
  }

  /**
   * Returns all keys in the symbol table in the given range,
   * as an {@code Iterable}.
   *
   * @return all keys in the sybol table between {@code lo}
   * (inclusive) and {@code hi} (exclusive)
   *
   * @throws IllegalArgumentException
   *     if either {@code lo} or {@code hi}
   *     is {@code null}
   */
  public Iterable<Key> rangeSearch(final Key lo, final Key hi) {
    if (lo == null) {
      throw new IllegalArgumentException("first argument to keys() is null");
    }
    if (hi == null) {
      throw new IllegalArgumentException("second argument to keys() is null");
    }

    final var queue = new Queue<Key>();
    keys(this.root, queue, lo, hi);
    return queue;
  }

  private void keys(final Node x, final Queue<Key> queue, final Key lo, final Key hi) {
    if (x == null) {
      return;
    }
    final var cmplo = lo.compareTo(x.key);
    final var cmphi = hi.compareTo(x.key);
    if (cmplo < 0) {
      keys(x.left, queue, lo, hi);
    }
    if (cmplo <= 0 && cmphi >= 0) {
      queue.enqueue(x.key);
    }
    if (cmphi > 0) {
      keys(x.right, queue, lo, hi);
    }
  }

  /**
   * Returns the number of keys in the symbol table in the given range.
   *
   * @return the number of keys in the sybol table between {@code lo}
   * (inclusive) and {@code hi} (exclusive)
   *
   * @throws IllegalArgumentException
   *     if either {@code lo} or {@code hi}
   *     is {@code null}
   */
  public int rangeCount(final Key lo, final Key hi) {
    if (lo == null) {
      throw new IllegalArgumentException("first argument to size() is null");
    }
    if (hi == null) {
      throw new IllegalArgumentException("second argument to size() is null");
    }

    if (lo.compareTo(hi) > 0) {
      return 0;
    }
    if (contains(hi)) {
      return rank(hi) - rank(lo) + 1;
    } else {
      return rank(hi) - rank(lo);
    }
  }

  /**
   * Returns the height of the BST (for debugging).
   *
   * @return the height of the BST (a 1-node tree has height 0)
   */
  public int height() {
    return height(this.root);
  }

  private int height(final Node x) {
    if (x == null) {
      return -1;
    }
    return 1 + Math.max(height(x.left), height(x.right));
  }

  /**
   * Returns the keys in the BST in level order (for debugging).
   *
   * @return the keys in the BST in level order traversal
   */
  public Iterable<Key> levelOrder() {
    final var keys = new Queue<Key>();
    final var queue = new Queue<Node>();
    queue.enqueue(this.root);
    while (!queue.isEmpty()) {
      final var x = queue.dequeue();
      if (x == null) {
        continue;
      }
      keys.enqueue(x.key);
      queue.enqueue(x.left);
      queue.enqueue(x.right);
    }
    return keys;
  }

  /*************************************************************************
   *  Check integrity of BST data structure.
   ***************************************************************************/
  private boolean check() {
    if (!isBST()) {
      StdOut.println("Not in symmetric order");
    }
    if (!isSizeConsistent()) {
      StdOut.println("Subtree counts not consistent");
    }
    if (!isRankConsistent()) {
      StdOut.println("Ranks not consistent");
    }
    return isBST() && isSizeConsistent() && isRankConsistent();
  }

  private boolean isBST() {
    return isBST(this.root, null, null);
  }

  private boolean isBST(final Node x, final Key min, final Key max) {
    if (x == null) {
      return true;
    }
    if (min != null && x.key.compareTo(min) <= 0) {
      return false;
    }
    if (max != null && x.key.compareTo(max) >= 0) {
      return false;
    }
    return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
  }

  private boolean isSizeConsistent() {
    return isSizeConsistent(this.root);
  }

  private boolean isSizeConsistent(final Node x) {
    if (x == null) {
      return true;
    }
    if (x.size != size(x.left) + size(x.right) + 1) {
      return false;
    }
    return isSizeConsistent(x.left) && isSizeConsistent(x.right);
  }

  private boolean isRankConsistent() {
    for (var i = 0; i < size(); i++) {
      if (i != rank(select(i))) {
        return false;
      }
    }
    for (final var key : keys()) {
      if (key.compareTo(select(rank(key))) != 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * Unit tests the {@code BST} data type.
   */
  public static void main(final String[] args) {
    Executor.execute(BST.class, args);

    final var st = new BST<String, Integer>();
    for (var i = 0; !StdIn.isEmpty(); i++) {
      final var key = StdIn.readString();
      st.put(key, i);
    }

    for (final var s : st.levelOrder()) {
      StdOut.println(s + " " + st.get(s));
    }

    StdOut.println();

    for (final var s : st.keys()) {
      StdOut.println(s + " " + st.get(s));
    }
  }
}

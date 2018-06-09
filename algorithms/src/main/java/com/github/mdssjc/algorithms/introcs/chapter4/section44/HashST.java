package com.github.mdssjc.algorithms.introcs.chapter4.section44;

/**
 * Program 4.4.3 Hash table.
 * <p>
 * Compilation:  javac HashST.java
 * Execution:    java HashST
 * Dependencies: StdIn.java StdOut.java
 * <p>
 * A symbol table implemented with a separate-chaining hash table.
 *
 * @author Marcelo dos Santos
 *
 */
import com.github.mdssjc.algorithms.introcs.chapter4.section43.Queue;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 *  The {@code HashST} class represents a symbol table of generic
 *  key-value pairs.
 *  It supports the usual <em>put</em>, <em>get</em>, <em>contains</em>,
 *  <em>remove</em>, <em>size</em>, and <em>is-empty</em> methods.
 *  It also provides a <em>keys</em> method for iterating over all of the keys.
 *  A symbol table implements the <em>associative array</em> abstraction:
 *  when associating a value with a key that is already in the symbol table,
 *  the convention is to replace the old value with the new value.
 *  Unlike {@link java.util.Map}, this class uses the convention that
 *  values cannot be {@code null}—setting the
 *  value associated with a key to {@code null} is equivalent to deleting the key
 *  from the symbol table.
 *  <p>
 *  This implementation uses a separate-chaining hash table. It requires that
 *  the key type overrides the {@code equals()} and {@code hashCode()} methods.
 *  The expected time per <em>put</em>, <em>contains</em>, or <em>remove</em>
 *  operation is constant, subject to the uniform hashing assumption.
 *  The <em>size</em>, and <em>is-empty</em> operations take constant time.
 *  Construction takes constant time.
 *  <p>
 *  For additional documentation, see <a href="https://introcs.cs.princeton.edu/44st">Section 4.4</a> of
 *  <i>Introduction to Programming in Java, 2nd edition</i> by Robert Sedgewick and Kevin Wayne.
 *  For other implementations, see {@link ST} and {@link BST}.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
@TestDrive(input = "tobe.txt", inputFile = true)
public class HashST<Key, Value> {

  private static final int INIT_CAPACITY = 4;

  private int n;
  private int m;
  private Node[] st;

  private static class Node {

    private final Object key;
    private Object val;
    private Node next;

    public Node(final Object key, final Object val, final Node next) {
      this.key = key;
      this.val = val;
      this.next = next;
    }
  }

  /**
   * Initializes an empty symbol table.
   */
  public HashST() {
    this(INIT_CAPACITY);
  }

  /**
   * Initializes an empty symbol table with {@code m} chains.
   * @param m the initial number of chains
   */
  public HashST(final int m) {
    this.m = m;
    this.st = new Node[m];
  }

  private void resize(final int chains) {
    final var temp = new HashST<Key, Value>(chains);
    for (var i = 0; i < this.m; i++) {
      for (var x = this.st[i]; x != null; x = x.next) {
        temp.put((Key) x.key, (Value) x.val);
      }
    }

    this.m = temp.m;
    this.n = temp.n;
    this.st = temp.st;
  }

  private int hash(final Key key) {
    return (key.hashCode() & 0x7fffffff) % this.m;
  }

  /**
   * Returns the number of key-value pairs in this symbol table.
   *
   * @return the number of key-value pairs in this symbol table
   */
  public int size() {
    return this.n;
  }

  /**
   * Returns true if this symbol table is empty.
   *
   * @return {@code true} if this symbol table is empty;
   *         {@code false} otherwise
   */
  public boolean isEmpty() {
    return size() == 0;
  }

  /**
   * Returns true if this symbol table contains the specified key.
   *
   * @param  key the key
   * @return {@code true} if this symbol table contains {@code key};
   *         {@code false} otherwise
   * @throws IllegalArgumentException if {@code key} is {@code null}
   */
  public boolean contains(final Key key) {
    if (key == null) {
      throw new IllegalArgumentException("argument to contains() is null");
    }
    return get(key) != null;
  }

  /**
   * Returns the value associated with the specified key in this symbol table.
   *
   * @param  key the key
   * @return the value associated with {@code key} in the symbol table;
   *         {@code null} if no such value
   * @throws IllegalArgumentException if {@code key} is {@code null}
   */
  public Value get(final Key key) {
    if (key == null) {
      throw new IllegalArgumentException("argument to get() is null");
    }
    final var i = hash(key);
    for (var x = this.st[i]; x != null; x = x.next) {
      if (key.equals(x.key)) {
        return (Value) x.val;
      }
    }
    return null;
  }

  /**
   * Inserts the specified key-value pair into the symbol table, overwriting the old
   * value with the new value if the symbol table already contains the specified key.
   * Removes the specified key (and its associated value) from this symbol table
   * if the specified value is {@code null}.
   *
   * @param  key the key
   * @param  val the value
   * @throws IllegalArgumentException if {@code key} is {@code null}
   */
  public void put(final Key key, final Value val) {
    if (key == null) {
      throw new IllegalArgumentException("first argument to put() is null");
    }
    if (val == null) {
      remove(key);
      return;
    }

    if (this.n >= 10 * this.m) {
      resize(2 * this.m);
    }

    final var i = hash(key);
    for (var x = this.st[i]; x != null; x = x.next) {
      if (key.equals(x.key)) {
        x.val = val;
        return;
      }
    }
    this.n++;
    this.st[i] = new Node(key, val, this.st[i]);
  }

  /**
   * Removes the specified key and its associated value from this symbol table
   * (if the key is in this symbol table).
   *
   * @param  key the key
   * @throws IllegalArgumentException if {@code key} is {@code null}
   */
  public void remove(final Key key) {
    if (key == null) {
      throw new IllegalArgumentException("argument to remove() is null");
    }

    final var i = hash(key);
    this.st[i] = remove(this.st[i], key);

    if (this.m > INIT_CAPACITY && this.n <= 2 * this.m) {
      resize(this.m / 2);
    }
  }

  private Node remove(final Node x, final Key key) {
    if (x == null) {
      return null;
    }
    if (key.equals(x.key)) {
      this.n--;
      return x.next;
    }
    x.next = remove(x.next, key);
    return x;
  }

  /**
   * Returns all keys in the symbol table.
   *
   * @return all keys in the symbol table, as in iterable
   */
  public Iterable<Key> keys() {
    final var queue = new Queue<Key>();
    for (var i = 0; i < this.m; i++) {
      for (var x = this.st[i]; x != null; x = x.next) {
        queue.enqueue((Key) x.key);
      }
    }
    return queue;
  }

  /**
   * Unit tests the {@code HashST} data type.
   */
  public static void main(final String[] args) {
    Executor.execute(HashST.class, args);

    final var st = new HashST<String, Integer>();
    for (var i = 0; !StdIn.isEmpty(); i++) {
      final String key = StdIn.readString();
      st.put(key, i);
    }

    for (final var s : st.keys()) {
      StdOut.println(s + " " + st.get(s));
    }
  }
}

package util;

import java.util.Arrays;
import java.util.Objects;

public class SparseArray<T> {

  public static final int INITIAL_SIZE = 1000;
  private int[]           keys         = new int[SparseArray.INITIAL_SIZE];
  private Object[]        values       = new Object[SparseArray.INITIAL_SIZE];
  private final int       size         = 0;

  public void put(final int key, final T value) {
    if (value == null) {
      return;
    }

    final int index = binarySearch(key, this.keys, this.size);
    if (index != -1 && this.keys[index] == key) {
      this.values[index] = value;
    } else {
      insertAfter(key, value, index);
    }
  }

  public int size() {
    return this.size;
  }

  private void insertAfter(final int key, final T value, final int index) {
    final int[] newKeys = new int[SparseArray.INITIAL_SIZE];
    final Object[] newValues = new Object[SparseArray.INITIAL_SIZE];

    copyFromBefore(index, newKeys, newValues);

    final int newIndex = index + 1;
    newKeys[newIndex] = key;
    newValues[newIndex] = value;

    if (this.size - newIndex != 0) {
      copyFromAfter(index, newKeys, newValues);
    }

    this.keys = newKeys;
    this.values = newValues;
  }

  public void checkInvariants() throws InvariantException {
    final long nonNullValues = Arrays.stream(this.values)
                                     .filter(Objects::nonNull)
                                     .count();
    if (nonNullValues != this.size) {
      throw new InvariantException("size " + this.size +
          " does not match value count of " + nonNullValues);
    }
  }

  private void copyFromAfter(final int index, final int[] newKeys,
      final Object[] newValues) {
    final int start = index + 1;
    System.arraycopy(this.keys, start, newKeys, start + 1, this.size - start);
    System.arraycopy(this.values, start, newValues, start + 1,
        this.size - start);
  }

  private void copyFromBefore(final int index, final int[] newKeys,
      final Object[] newValues) {
    System.arraycopy(this.keys, 0, newKeys, 0, index + 1);
    System.arraycopy(this.values, 0, newValues, 0, index + 1);
  }

  @SuppressWarnings("unchecked")
  public T get(final int key) {
    final int index = binarySearch(key, this.keys, this.size);
    if (index != -1 && this.keys[index] == key) {
      return (T) this.values[index];
    }
    return null;
  }

  int binarySearch(final int n, final int[] nums, final int size) {
    int low = 0;
    int high = size - 1;

    while (low <= high) {
      final int midIndex = (low + high) / 2;
      if (n > nums[midIndex]) {
        low = midIndex + 1;
      } else if (n < nums[midIndex]) {
        high = midIndex - 1;
      } else {
        return midIndex;
      }
    }
    return low - 1;
  }
}

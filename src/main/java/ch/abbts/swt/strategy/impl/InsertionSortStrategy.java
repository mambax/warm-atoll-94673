package ch.abbts.swt.strategy.impl;

import ch.abbts.swt.strategy.IntegerSortStrategy;

public class InsertionSortStrategy implements IntegerSortStrategy {

  @Override
  public Integer[] sort(Integer[] toSort) {
    int n = toSort.length;
    for (int i = 1; i < n; ++i) {
      int key = toSort[i];
      int j = i - 1;
      /*
       Move elements of toSort[0..i-1], that are
       greater than key, to one position ahead
       of their current position
      */
      while (j >= 0 && toSort[j] > key) {
        toSort[j + 1] = toSort[j];
        j = j - 1;
      }
      toSort[j + 1] = key;
    }
    return toSort;
  }
}

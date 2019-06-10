package ch.abbts.swt.strategy.impl;

import ch.abbts.swt.strategy.IntegerSortStrategy;

public class BubbleSortStrategy implements IntegerSortStrategy {
  @Override
  public Integer[] sort(Integer[] toSort) {
    int n = toSort.length;
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (toSort[j] > toSort[j + 1]) {
          // swap toSort[j+1] and toSort[i]
          int temp = toSort[j];
          toSort[j] = toSort[j + 1];
          toSort[j + 1] = temp;
        }
      }
    }
    return toSort; // What is wrong here class?
  }
}

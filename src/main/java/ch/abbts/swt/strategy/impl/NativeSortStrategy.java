package ch.abbts.swt.strategy.impl;

import ch.abbts.swt.strategy.IntegerSortStrategy;

import java.util.Arrays;

public class NativeSortStrategy implements IntegerSortStrategy {
  @Override
  public Integer[] sort(Integer[] toSort) {
    Arrays.sort(toSort);
    return toSort;
  }
}

package ch.abbts.swt.strategy;

import ch.abbts.swt.strategy.impl.BubbleSortStrategy;
import ch.abbts.swt.strategy.impl.InsertionSortStrategy;
import ch.abbts.swt.strategy.impl.NativeSortStrategy;

public class IntegerSortStrategyFactory {
  public IntegerSortStrategy createInstance(String factoryStr) {
    switch (factoryStr) {
      case "AUTO":
      case "BEST":
        return new NativeSortStrategy();
      case "INSERTION_SORT":
        return new InsertionSortStrategy();
      case "BUBBLE_SORT":
      default:
        return new BubbleSortStrategy();
    }
  }
}

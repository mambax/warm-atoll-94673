package ch.abbts.swt.strategy;

public class IntegerSortService {

  public void setNumberSortStrategy(IntegerSortStrategy numberSortStrategy) {
    this.numberSortStrategy = numberSortStrategy;
  }

  private IntegerSortStrategy numberSortStrategy;

  public Integer[] sort(Integer[] toSort) {
    return numberSortStrategy.sort(toSort);
  }
}

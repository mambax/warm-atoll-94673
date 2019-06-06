package ch.abbts.swt.strategy;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IntegerSortRequestModel {
  @JsonProperty("numbers")
  public Integer[] getIntegers() {
    return numbers;
  }

  public void setIntegers(Integer[] numbers) {
    this.numbers = numbers;
  }

  public String getSortStrategy() {
    return sortStrategy;
  }

  public void setSortStrategy(String sortStrategy) {
    this.sortStrategy = sortStrategy;
  }

  private Integer[] numbers;
  private String sortStrategy;
}

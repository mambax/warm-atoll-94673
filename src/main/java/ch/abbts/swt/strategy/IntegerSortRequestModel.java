package ch.abbts.swt.strategy;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class IntegerSortRequestModel {
  @JsonProperty("numbers")
  @ApiModelProperty(example = "[4,1,3,2]", value = "List of numbers to sort")
  private Integer[] numbers;
  @ApiModelProperty(example = "BUBBLE_SORT",
      allowableValues = "BUBBLE_SORT,INSERTION_SORT,AUTO,BEST")
  private String sortStrategy;

  public Integer[] getNumbers() {
    return numbers;
  }

  public void setNumbers(Integer[] numbers) {
    this.numbers = numbers;
  }

  public String getSortStrategy() {
    return sortStrategy;
  }

  public void setSortStrategy(String sortStrategy) {
    this.sortStrategy = sortStrategy;
  }

}

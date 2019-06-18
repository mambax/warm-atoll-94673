package ch.abbts.swt.strategy;

import ch.abbts.swt.strategy.impl.BubbleSortStrategy;
import ch.abbts.swt.strategy.impl.InsertionSortStrategy;
import ch.abbts.swt.strategy.impl.NativeSortStrategy;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sort")
public class SortController {
  @ApiOperation("Lets you sort by the numbers.")
  @PostMapping(path = "/numbers",
          consumes = "application/json",
          produces = "application/json")
  public ResponseEntity<IntegerSortResult> sortNumbers(
          @RequestBody IntegerSortRequestModel requestNumberSort) {
    IntegerSortService service = new IntegerSortService();
    service.setNumberSortStrategy(
            new IntegerSortStrategyFactory()
                    .createInstance(requestNumberSort
                            .getSortStrategy()));
    return new ResponseEntity<>(
            new IntegerSortResult(
                    service.sort(
                            requestNumberSort.getNumbers())),
            HttpStatus.OK);
  }
}

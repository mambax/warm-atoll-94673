package ch.abbts.swt.strategy;

import ch.abbts.swt.strategy.impl.BubbleSortStrategy;
import ch.abbts.swt.strategy.impl.InsertionSortStrategy;
import ch.abbts.swt.strategy.impl.NativeSortStrategy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("sort")
public class SortController {
  @PostMapping(path = "/numbers", consumes = "application/json", produces = "application/json")
  public ResponseEntity<IntegerSortResult> sortNumbers(@RequestBody IntegerSortRequestModel requestNumberSort) {
    IntegerSortService service = new IntegerSortService();

    switch (requestNumberSort.getSortStrategy()) {
      case "AUTO":
      case "BEST":
        service.setNumberSortStrategy(new NativeSortStrategy());
        break;
      case "INSERTION_SORT":
        service.setNumberSortStrategy(new InsertionSortStrategy());
        break;
      case "BUBBLE_SORT":
      default:
        service.setNumberSortStrategy(new BubbleSortStrategy());
        break;
    }
    return new ResponseEntity<>(new IntegerSortResult(service.sort(requestNumberSort.getIntegers())), HttpStatus.OK);
  }
}

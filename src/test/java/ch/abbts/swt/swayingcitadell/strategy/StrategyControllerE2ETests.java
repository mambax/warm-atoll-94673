package ch.abbts.swt.swayingcitadell.strategy;

import ch.abbts.swt.strategy.IntegerSortRequestModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StrategyControllerE2ETests {

  @Autowired
  private WebTestClient webClient;

  @Test
  public void testBubbleSort() throws Exception {
    IntegerSortRequestModel rm = new IntegerSortRequestModel();
    rm.setNumbers(new Integer[]{6, 2, 9, 4, 1});
    rm.setSortStrategy("BUBBLE_SORT");
    this.webClient
        .post()
        .uri("/sort/numbers")
        .accept(MediaType.APPLICATION_JSON)
        .body(BodyInserters.fromObject(rm))
        .exchange()
        .expectStatus()
        .isOk()
        .expectBody()
        .json("{result:[1,2,4,6,9]}");
  }

  @Test
  public void testInsertionSort() throws Exception {
    IntegerSortRequestModel rm = new IntegerSortRequestModel();
    rm.setNumbers(new Integer[]{6, 2, 9, 4, 1});
    rm.setSortStrategy("INSERTION_SORT");
    this.webClient
            .post()
            .uri("/sort/numbers")
            .accept(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromObject(rm))
            .exchange()
            .expectStatus()
            .isOk()
            .expectBody()
            .json("{result:[1,2,4,6,9]}");
  }

  @Test
  public void testBestSort() throws Exception {
    IntegerSortRequestModel rm = new IntegerSortRequestModel();
    rm.setNumbers(new Integer[]{6, 2, 9, 4, 1});
    rm.setSortStrategy("BEST");
    this.webClient
            .post()
            .uri("/sort/numbers")
            .accept(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromObject(rm))
            .exchange()
            .expectStatus()
            .isOk()
            .expectBody()
            .json("{result:[1,2,4,6,9]}");
  }
}

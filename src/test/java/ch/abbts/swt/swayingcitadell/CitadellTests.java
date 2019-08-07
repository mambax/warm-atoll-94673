package ch.abbts.swt.swayingcitadell;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CitadellTests {

  @Autowired
  private WebTestClient webClient;

  @Test
  public void testAlert() throws Exception {
    this.webClient
        .get()
        .uri("/alert")
        .exchange()
        .expectStatus()
        .isOk()
        .expectBody(String.class)
        .isEqualTo("An alert has been put to the logs!");
  }
}
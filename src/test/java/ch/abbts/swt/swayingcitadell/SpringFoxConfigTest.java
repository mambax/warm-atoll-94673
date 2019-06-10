package ch.abbts.swt.swayingcitadell;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringFoxConfigTest {

  @Autowired
  private WebTestClient webClient;

  @Test
  public void testDocs() throws Exception {
    this.webClient
        .get()
        .uri("/v2/api-docs")
        .exchange()
        .expectStatus()
        .isOk()
        .expectBody()
        .jsonPath("$.info.description").isEqualTo("Api Documentation")
        .jsonPath("$.info.version").isEqualTo("1.0")
        .jsonPath("$.info.title").isEqualTo("Api Documentation")
        .jsonPath("$.host").exists();
  }

  @Test
  public void testSwaggerUI() throws Exception {
    this.webClient
        .get()
        .uri("/swagger-ui.html")
        .exchange()
        .expectStatus()
        .isOk();
  }
}
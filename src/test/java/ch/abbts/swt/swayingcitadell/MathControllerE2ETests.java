package ch.abbts.swt.swayingcitadell;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MathControllerE2ETests {

    @Autowired
    private WebTestClient webClient;

    @Test
    public void testAdd() throws Exception {
        this.webClient
                .get()
                .uri("/math/add?summand1=2&summand2=2")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(Integer.class)
                .isEqualTo(5);
    }
}

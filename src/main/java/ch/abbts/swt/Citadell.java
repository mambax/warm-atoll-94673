package ch.abbts.swt;

import ch.abbts.swt.amqp.AmqpController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Controller
@SpringBootApplication
@EnableSwagger2
public class Citadell {

  private final Logger logger;

  public Citadell() {
    this.logger = LogManager.getLogger(Citadell.class);
  }

  /**
   * main.
   */
  public static void main(String[] args) {
    SpringApplication.run(Citadell.class, args);
  }

  @RequestMapping("/")
  @ResponseBody
  String home() {
    return "Hello Citadell!";
  }

  @RequestMapping("/alert")
  @ResponseBody
  String alert() {
    this.logger.error("FATAL", new RuntimeException("FATAL"));
    return "An alert has been put to the logs!";
  }
}

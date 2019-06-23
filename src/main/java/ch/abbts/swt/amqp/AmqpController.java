package ch.abbts.swt.amqp;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.nio.charset.StandardCharsets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("mq")
public class AmqpController {
  private final Logger logger;
  private Channel channel;
  private MessageComposer msgSpawn = new RandomMessageComposer();
  private static final String QUEUE_NAME = "nds";

  public AmqpController() {
    logger = LoggerFactory.getLogger(AmqpController.class);
    ConnectionFactory factory = new ConnectionFactory();
    try {
      factory.setUri("amqp://bmoghrti:iHBR6-uzyzFIvcW0C2wRONxWqAlst5VK@clam"
          + ".rmq.cloudamqp.com/bmoghrti");
      Connection connection = factory.newConnection();
      channel = connection.createChannel();
      channel.queueDeclare(QUEUE_NAME, false, false, false, null);
    } catch (Exception e) {
      logger.error(e.toString());
    }
  }

  public AmqpController(Channel c) {
    logger = LoggerFactory.getLogger(AmqpController.class);
    this.channel = c;
  }

  @GetMapping("publish")
  public String publish() {
    String message = this.msgSpawn.compose();
    try {
      if (null != channel) {
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
      } else {
        logger.error("Channel is not defined.");
      }
    } catch (Exception e) {
      logger.error(e.toString());
    }
    logger.info("Sent " + message);
    return message;
  }

  public void setMessageSpawn(MessageComposer r) {
    this.msgSpawn = r;
    // TODO: 2019-06-23 Missing null check
  }
}
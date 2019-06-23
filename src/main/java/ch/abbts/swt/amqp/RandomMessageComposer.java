package ch.abbts.swt.amqp;

import org.apache.commons.lang.RandomStringUtils;

import java.util.Random;

public class RandomMessageComposer implements MessageComposer {

  @Override
  public String compose() {
    String var = RandomStringUtils.randomAlphabetic(24);
    String[] names = new String[]{
        "ABT",
        "GONZALEZ",
        "KISTLER",
        "PETERHANS",
        "BRUNNER",
        "PETER",
        "HABLUETZEL",
    };
    int rnd = new Random().nextInt(names.length);
    return "{" + "\"name\":\"" + names[rnd] + "\", \"message\": \"" + var + "\"}";
  }
}
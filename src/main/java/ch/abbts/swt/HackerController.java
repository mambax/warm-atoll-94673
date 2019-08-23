package ch.abbts.swt;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("security")
public class HackerController {
  @GetMapping("secret")
  public String secret() {
    return "The citadell has three entries, one is always unlocked, the one facing north.";
  }
}

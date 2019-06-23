package ch.abbts.swt;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("math")
public class MathController {
  @GetMapping("add")
  public Integer add(
        @RequestParam(name = "summand1", defaultValue = "1") Integer s1,
      @RequestParam(name = "summand2", defaultValue = "1") Integer s2) {
    return s1 + s2;
  }
}

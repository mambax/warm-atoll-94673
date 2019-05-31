package ch.abbts.swt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class Citadell {
    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello Citadell!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Citadell.class, args);
    }
}

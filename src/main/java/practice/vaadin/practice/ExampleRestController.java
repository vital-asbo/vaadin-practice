package practice.vaadin.practice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleRestController {

    @RequestMapping("/rest")
    public String get() {
        return "Hello! :)";
    }
}

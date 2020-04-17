package io.javabrains.springbootconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GreetingController {

    @Value("${my.greeting: default value}")
    private String greetingMessage;

    @Value("${my.list.values}")
    private List<String> listValues;

    @Value("A static message")
    private String staticMessage;

    // Spring-Boot Expression language
    @Value("#{${dbValues}}")
    private Map<String, String> dbValues;

    @GetMapping("/greeting")
    public String greeting() {
        return greetingMessage + " " + listValues + " " + staticMessage + " " + dbValues;
    }
}

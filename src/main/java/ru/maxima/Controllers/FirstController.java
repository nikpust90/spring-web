package ru.maxima.Controllers;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
    @GetMapping("/myNameData")
    public String index() {
        return "hello-view";
    }
}

package ru.maxima.Controllers;

import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class FirstController {
    @GetMapping("/myNameData")
    public String index() {
        return "hello-view";
    }


    @GetMapping("/Calculator")
    public String calculator(
            @RequestParam(value = "number1", required = false)Integer number1,
            @RequestParam(value = "number2", required = false) Integer number2,
            @RequestParam(value = "operation", required = false) String operation,
            Model model) {

        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        model.addAttribute("operation", operation);


        Integer result;
        String resultMessage = "";
        if (number1 == null || number2 == null || operation == null) {
            resultMessage = "Please provide valid parameters: number1, number2, and operation.";
        } else {
            switch (operation) {
                case "add":
                    result = number1 + number2;
                    resultMessage = String.valueOf(result);
                    break;
                case "sub":
                    result = number1 - number2;
                    resultMessage = String.valueOf(result);
                    break;
                case "mul":
                    result = number1 * number2;
                    resultMessage = String.valueOf(result);
                    break;
                case "div":
                    if (number2 == 0) {
                        resultMessage = "Division by zero";
                    } else {
                        result = number1 / number2;
                        resultMessage = String.valueOf(result);
                    }
                    break;
                default:
                    resultMessage = "Invalid operation";
                    break;


            }
        }

        model.addAttribute("resultMessag", resultMessage);


        return "calculator-view";
    }


}


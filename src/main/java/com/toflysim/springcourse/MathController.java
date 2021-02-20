package com.toflysim.springcourse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new Exception();
        }

        Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
        return sum;
    }
    

    private Double convertToDouble(String number) {
        if (number == null) {
            return 0D;
        }
        String formatted = number.replaceAll(",", ".");

        if (this.isNumeric(number)) {
            return Double.parseDouble(formatted);
        }

        return 0D;
    }

    private boolean isNumeric(String number) {
        if (number == null) {
            return false;
        }
        String formatted = number.replaceAll(",", ".");
        return formatted.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}

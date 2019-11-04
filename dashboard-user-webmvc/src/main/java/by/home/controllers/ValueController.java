package by.home.controllers;

import by.home.pojo.Value;
import by.home.service.AppValueListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/account/device")
public class ValueController {

    private static Logger log = Logger.getLogger(ValueController.class.getName());

    @Autowired
    private
    AppValueListService valueListService;

    @GetMapping
    public String showListValues(@RequestParam("deviceId") Long deviceId, Model model) {
        log.info("Calling showListValue");
        List<Value> values = valueListService.searchAllValues(deviceId);
        model.addAttribute("listValues", values);
        return "device";
    }

}

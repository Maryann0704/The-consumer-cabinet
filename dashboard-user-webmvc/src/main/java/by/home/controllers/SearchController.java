package by.home.controllers;

import by.home.service.DeviceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.logging.Logger;
import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {

    private static Logger log = Logger.getLogger(SearchController.class.getName());

    @Autowired
    private
    DeviceListService deviceListService;

    @GetMapping
    public String searchDevice(@RequestParam("search-str") String type, Model model) {
        List devices = deviceListService.searchByDeviceType(type);
        model.addAttribute("result", devices);
        log.info("searchResult: " + devices);
        return "searchResult";
    }

}

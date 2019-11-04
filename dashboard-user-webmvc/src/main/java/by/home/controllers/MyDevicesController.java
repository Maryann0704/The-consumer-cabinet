package by.home.controllers;

import by.home.pojo.AppUser;
import by.home.pojo.Device;
import by.home.service.DeviceListService;
import by.home.utilities.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/my-devices")
public class MyDevicesController {

    private static Logger log = Logger.getLogger(MyDevicesController.class.getName());

    @Autowired
    private DeviceListService deviceListService;

    @GetMapping
    public String viewMyAccount(Model model) {
        log.info("Call viewMyAccount");
        AppUser appUser = Helper.getAppUser();
        model.addAttribute("appUser", appUser);
        log.info("View account " + appUser.getName());
        List<Device> devices = deviceListService.searchByUserId(appUser.getId());
        model.addAttribute("my-devices", devices);
        log.info(  appUser.getName() + " devices: " + devices);
        return "myDevices";
    }

    @GetMapping("/device/{id}")
    public String showDeviceItem(@PathVariable Long id, Model model) {
        log.info("Call showDeviceItem");
        Device device = deviceListService.findDevice(id);
        model.addAttribute("device", device);
        log.info("View device "+ device);
        return "device";
    }

}

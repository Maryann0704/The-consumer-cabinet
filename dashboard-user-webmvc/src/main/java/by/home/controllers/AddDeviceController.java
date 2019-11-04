package by.home.controllers;

import by.home.pojo.AppUser;
import by.home.pojo.Device;
import by.home.service.DeviceListService;
import by.home.utilities.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

@Controller
@RequestMapping("/add-device")
public class AddDeviceController {

    private static Logger log = Logger.getLogger(AddDeviceController.class.getName());

    @Autowired
    private
    DeviceListService deviceListService;

    @GetMapping
    public ModelAndView showAddDeviceView() {
        log.info("Call showAddDeviceView");
        ModelAndView view = new ModelAndView();
        view.setViewName("addDevice");
        return view;
    }

    @PostMapping
    public String submitAddDeviceForm(
            @ModelAttribute ("device") Device device,
            BindingResult result) {

        AppUser appUser = Helper.getAppUser();
        log.info("Call submitAddDeviceForm: " + device);
        log.info("Principal: " + appUser.getName());

        device.setAppUser(appUser);
        deviceListService.addDevice(device);
        return "myDevices";
    }
}

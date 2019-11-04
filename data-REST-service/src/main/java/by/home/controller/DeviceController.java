package by.home.controller;

import by.home.dto.ValueDto;
import by.home.service.ValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class DeviceController {

    private Logger log = Logger.getLogger(DeviceController.class.getName());

    @Autowired
    private ValueService service;

    @GetMapping("/device/{deviceId}")
    public List<ValueDto> getValues(@RequestParam("deviceId") Long deviceId, int maxCount) {
        if (maxCount < 1) throw new IllegalArgumentException();
        return service.getValueByDeviceId(deviceId, maxCount);
    }

    @GetMapping("/device/{deviceId}/{valueId}")
    public ValueDto getValueById(@RequestParam("deviceId") Long deviceId,
                                 @RequestParam("valueId") Long valueId) {
        if (deviceId < 0 || valueId < 0) throw new IllegalArgumentException();
        return service.getValueById(valueId);
    }

    @PostMapping("/value")
    public void createNewValue(@RequestBody AppValueCmd newAppValueCmd) {
        service.createNewValue(newAppValueCmd);
        log.info("New value: " + newAppValueCmd);
    }

    @PutMapping("/value/{id}")
    public void updateValue(@PathVariable int id,
                            @RequestBody AppValueCmd appValueCmd) {
        log.info("Update value ID=" + id + " " + appValueCmd);
    }

    @DeleteMapping("/value/{id}")
    public void deleteValue(@PathVariable int id) {
        log.info("Delete value ID=" + id);
    }

}
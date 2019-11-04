package by.home.service;

import by.home.pojo.Device;
import by.home.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

@Service
public class DeviceListService {

    private static Logger log = Logger.getLogger(DeviceListService.class.getName());

    @Autowired
    private DeviceRepository deviceRepository;

    @Transactional
    public List getListDevices() {
        return deviceRepository.findAll(10);
    }

    @Transactional
    public Device findDevice(Long id) {
        return deviceRepository.findDeviceById(id);
    }

    @Transactional
    public List<Device> searchByUserId(Long userId) {
        return deviceRepository.findByUserId(userId, 5);
    }

    @Transactional
    public List searchByDeviceType(String type) {
        return deviceRepository.findDeviceByType(type, 5);
    }

    @Transactional
    public boolean addDevice(Device device) {
        if (device.getLocation() == null || device.getType() == null) {
            return false;
        }
        boolean add = deviceRepository.save(device);
        if (add) {
            log.info("Adding device was successful");
        } else
            log.info("Device wasn't added");

        return add;
    }
}

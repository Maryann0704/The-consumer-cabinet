package by.home.service;

import by.home.pojo.Value;
import by.home.pojo.Device;
import by.home.repository.DeviceRepository;
import by.home.repository.ValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AppValueListService {

    @Autowired
    private ValueRepository valueRepository;

    @Autowired
    private DeviceRepository deviceRepository;

    @Transactional
    public Device findDevice(Long id) {
        return deviceRepository.findDeviceById(id);
    }

    @Transactional
    public List<Value> searchAllValues(Long deviceId) {
        return valueRepository.findByDeviceId(deviceId, 10);
    }
}

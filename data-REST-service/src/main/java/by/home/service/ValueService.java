package by.home.service;

import by.home.controller.AppValueCmd;
import by.home.dto.ValueDto;
import by.home.pojo.Value;
import by.home.repo.ValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public
class ValueService {

    @Autowired
    private ValueRepository valueRepository;

    public List<ValueDto> getAllValues(int maxCount) {

        List<ValueDto> valueDtos = new LinkedList<>();

        valueRepository.findAll().forEach(
                value -> {
                    ValueDto dto = new ValueDto(value.getDevice_id(),
                            value.getValue(),
                            value.getDate());
                    if (valueDtos.size() < maxCount) {
                        valueDtos.add(dto);
                    }
                }
        );
        return valueDtos;
    }

    public ValueDto getValueById(Long valueId) {
        Value value = valueRepository.findById(valueId).orElseThrow();
        return new ValueDto(value.getDevice_id(),
                value.getValue(),
                value.getDate());
    }

    public void createNewValue(AppValueCmd newAppValueCmd) {
        Value value = new Value();
        value.setDevice_id(newAppValueCmd.getDevice_id());
        value.setValue(newAppValueCmd.getValue());
        value.setDate(newAppValueCmd.getDate());

        valueRepository.save(value);

    }

    public List<ValueDto> getValueByDeviceId(Long deviceId, int maxCount) {
        List<ValueDto> valueList = new LinkedList<>();
        valueRepository.findAll().forEach(
                value -> {
                    ValueDto dto = new ValueDto(value.getDevice_id(),
                            value.getValue(),
                            value.getDate());
                    if (dto.getDevice_id() == deviceId && valueList.size() <= maxCount) {
                        valueList.add(dto);
                    }
                }
        );
        return valueList;
    }
}

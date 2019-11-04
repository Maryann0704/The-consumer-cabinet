package by.home.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ValueDto {

    private long device_id;
    private int value;
    private Date measure_date;

}

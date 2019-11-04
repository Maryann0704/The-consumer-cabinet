package by.home.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppValueCmd implements Serializable {

    private Long device_id;
    private Integer value;
    private Date date;

    @Override
    public String toString() {
        return "Value {" +
                "device ID = " + device_id +
                ", value = " + value +
                ", measure's date = " + date +
                '}';
    }
}

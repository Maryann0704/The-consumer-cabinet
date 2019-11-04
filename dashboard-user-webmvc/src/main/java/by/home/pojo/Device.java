package by.home.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private long userId;
    private String location;
    private String type;

    @OneToMany(mappedBy = "value")
    private List<Value> values;
}

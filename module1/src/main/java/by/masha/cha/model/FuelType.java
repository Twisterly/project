package by.masha.cha.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_fuel_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FuelType {

    @Id
    @Column(name = "fuel_type_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fuel_type_seq")
    @SequenceGenerator(name = "fuel_type_seq", sequenceName = "t_fuel_type_seq")
    private long id;

    @Column(name="fuel_type_name")
    private String fuelTypeName;

}

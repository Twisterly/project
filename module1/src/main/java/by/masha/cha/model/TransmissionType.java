package by.masha.cha.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_transmission_type")
@Getter
@Setter
public class TransmissionType {

    @Id
    @Column(name = "transmission_type_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transmission_type_seq")
    @SequenceGenerator(name = "transmission_type_seq", sequenceName = "t_transmission_type_seq")
    private long id;

    @Column(name="transmission_type_name")
    private String transmissionTypeName;

    @OneToMany(mappedBy = "transmissionType")
    private List<Car> car;



}

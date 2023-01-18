package by.masha.cha.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_car_photo")
@Getter
@Setter
public class CarPhoto {

    @Id
    @Column(name = "car_photo_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_photo_seq")
    @SequenceGenerator(name = "car_photo_seq", sequenceName = "t_car_photo_seq")
    private long id;

    @Column(name="photo_name")
    private String name;

    @Lob
    @Column(name = "car_photo", columnDefinition = "MEDIUMBLOB NOT NULL")
    private byte[] photo;

    @OneToMany(mappedBy = "carPhoto")
    private List<Car> car;

}

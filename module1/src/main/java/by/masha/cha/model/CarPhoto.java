package by.masha.cha.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_car_photo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarPhoto {

    @Id
    @Column(name = "car_photo_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_photo_seq")
    @SequenceGenerator(name = "car_photo_seq", sequenceName = "t_car_photo_seq")
    private long id;


    @Lob
    @Column(name = "car_photo", columnDefinition = "MEDIUMBLOB NOT NULL")
    private byte[] photo;

    @OneToOne(mappedBy = "carPhoto")
    private Car car;

}

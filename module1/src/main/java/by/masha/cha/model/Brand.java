package by.masha.cha.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_car_brand")
@Getter
@Setter
public class Brand {

    @Id
    @Column(name = "car_brand_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
            "car_brand_seq")
    @SequenceGenerator(name = "car_brand_seq", sequenceName = "t_car_brand_seq")
    private long id;

    @Column(name = "car_brand_name")
    private String brandName;

//    @OneToMany(mappedBy = "brand")
//    private List<Car> car;
//    @OneToMany(mappedBy = "brand")
//    private List<ModelDetail> modelDetails;
}

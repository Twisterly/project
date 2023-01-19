package by.masha.cha.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_model_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModelDetail {

    @Id
    @Column(name = "modeldetail_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "model_seq")
    @SequenceGenerator(name = "model_seq", sequenceName = "t_model_seq")
    private long id;

    @Column(name = "model_name")
    private String modelName;

    //    @OneToMany(mappedBy = "modelDetail")
//    private List<Car> car;
//    @ManyToOne(optional = false)
//    @JoinColumn(name = "car_brand_id")
//    private Brand brand;


}

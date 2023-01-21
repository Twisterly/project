package by.masha.cha.model;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;


@Entity
@Table(name = "t_car")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car {

    @Id
    @Column(name = "car_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_seq")
    @SequenceGenerator(name = "car_seq", sequenceName = "t_car_seq")
    private long id;

    @Column(name = "reg_number")
    private String regNumber;

    @Column(name = "vin_number")
    private String vinNumber;

    @Column(name = "price")
    private double price;

    @Column(name = "year")
    private String year;

    @Column(name = "color")
    private String color;

    @Column(name = "climate_control")
    private boolean climateControl;

    @Column(name = "seats")
    private Integer seats;

    @Column(name = "doors")
    private Integer doors;

    @Column(name = "engine_capacity")
    private double engineCapacity;

    @OneToOne
    @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name="car_photo_id")
    private CarPhoto carPhoto;

    @ManyToOne
 //  @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name="body_type_id")
    private BodyType bodyType;

    @ManyToOne
  //  @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "car_brand_id")
    private Brand brand;

    @ManyToOne
  //  @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name="transmission_type_id")
    private TransmissionType transmissionType;

    @ManyToOne
 //   @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name="fuel_type_id")
    private FuelType fuelType;

    @ManyToOne
//   @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name="modeldetail_id")
    private ModelDetail modelDetail;

//    @ManyToMany(mappedBy = "cars")
//    private List<AppOrder> appOrders;



}

package by.masha.cha.model;

import lombok.*;

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

//    @ManyToOne(optional = false, cascade = CascadeType.ALL)
//    @JoinColumn(name = "modeldetail_id")
//    private ModelDetail modelDetail;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name="car_photo_id")
    private CarPhoto carPhoto;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name="body_type_id")
    private BodyType bodyType;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "car_brand_id")
    private Brand brand;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name="transmission_type_id")
    private TransmissionType transmissionType;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name="fuel_type_id")
    private FuelType fuelType;
    @Column(name="car_is_free")
    private boolean isFree = true;

}

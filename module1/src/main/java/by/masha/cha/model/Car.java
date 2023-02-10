package by.masha.cha.model;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name = "t_car")
@Getter
@Setter
public class Car {

    @Id
    @Column(name = "car_id")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

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

    @OneToOne
    @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "car_photo_id")
    private CarPhoto carPhoto;

    @ManyToOne
    @JoinColumn(name = "body_type_id")
    private BodyType bodyType;

    @ManyToOne
    @JoinColumn(name = "car_brand_id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "transmission_type_id")
    private TransmissionType transmissionType;

    @ManyToOne
    @JoinColumn(name = "fuel_type_id")
    private FuelType fuelType;

    @ManyToOne
    @JoinColumn(name = "modeldetail_id")
    private ModelDetail modelDetail;


}

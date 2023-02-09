package by.masha.cha.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Getter
@Setter
public class CarFilter {

    private String climateControl;


    private String seats;

    private String doors;


    private String bodyType;


    private String brand;


    private String transmissionType;


    private String fuelType;


    private String modelDetail;






}

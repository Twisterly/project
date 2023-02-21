package by.masha.cha.rest;

import by.masha.cha.model.Car;
import by.masha.cha.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/all")
public class CarRestController {

    @Autowired
    CarService carService;

    @GetMapping("")
    public ResponseEntity<List<Car>> getAll() {
        List<Car> cars = carService.getAll();
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            result.add(Car.builder()
                    .id(car.getId())
                    .regNumber(car.getRegNumber())
                    .vinNumber(car.getVinNumber())
                    .price(car.getPrice())
                    .year(car.getYear())
                    .color(car.getColor())
                    .seats(car.getSeats())
                    .doors(car.getDoors())
                    .active(car.getActive())
                    .comment(car.getComment())
                    .brand(car.getBrand())
                    .modelDetail(car.getModelDetail())
                    .bodyType(car.getBodyType())
                    .fuelType(car.getFuelType())
                    .transmissionType(car.getTransmissionType())
                    .build());
        }
        return new ResponseEntity<>(
                result,
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getById(@PathVariable(value = "id") String id) {
        Car car = carService.getById(id);
        Car result = Car.builder()
                .id(car.getId())
                .regNumber(car.getRegNumber())
                .vinNumber(car.getVinNumber())
                .price(car.getPrice())
                .year(car.getYear())
                .color(car.getColor())
                .seats(car.getSeats())
                .doors(car.getDoors())
                .active(car.getActive())
                .comment(car.getComment())
                .brand(car.getBrand())
                .modelDetail(car.getModelDetail())
                .bodyType(car.getBodyType())
                .fuelType(car.getFuelType())
                .transmissionType(car.getTransmissionType())
                .build();

        return new ResponseEntity<>(
                result,
                HttpStatus.OK);
    }
}
